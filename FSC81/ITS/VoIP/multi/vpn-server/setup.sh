#!/usr/bin/env bash

apt update
apt install -y openvpn easy-rsa
cd /usr/share/easy-rsa
mv /usr/share/easy-rsa/openssl-1.0.0.cnf /usr/share/easy-rsa/openssl.cnf

source vars
./clean-all
./pkitool --initca
./pkitool --server myserver #servername
./pkitool branch #clientname

mkdir /etc/openvpn/keys
mv /usr/share/easy-rsa/keys/* /etc/openvpn/keys

wget -O /etc/openvpn/server.conf https://raw.githubusercontent.com/OpenVPN/openvpn/master/sample/sample-config-files/server.conf

sed -i 's:^ca.*$:ca /etc/openvpn/keys/ca.crt:' /etc/openvpn/server.conf
sed -i 's:^cert.*$:cert /etc/openvpn/keys/myserver.crt:' /etc/openvpn/server.conf
sed -i 's:^key.*$:key /etc/openvpn/keys/myserver.key:' /etc/openvpn/server.conf
sed -i 's:^dh.*$:dh /etc/openvpn/keys/dh2048.pem:' /etc/openvpn/server.conf
sed -i 's:^tls-auth.*$:tls-auth /etc/openvpn/keys/ta.key 0:' /etc/openvpn/server.conf

# Beim verbinden muss der OpenVPN Client das  Standardgateway auf das OpenVPN Interface ändern
sed -i 's:^;push "redirect-gateway def1 bypass-dhcp".*$:push "redirect-gateway def1 bypass-dhcp":' /etc/openvpn/server.conf

# Das SubNetzwerk an Branch muss dem Server bekannt sein
sed -i 's:^;client-config-dir ccd.*$:client-config-dir ccd:' /etc/openvpn/server.conf
sed -i 's:^.;route 192.168.40.128 255.255.255.248*$:route 192.168.40.0 255.255.255.0":' /etc/openvpn/server.conf
# Zusatzdatei ist dafür nötig. Dateiname = Clientname
mkdir /etc/openvpn/ccd
echo 'iroute 192.168.40.0 255.255.255.0' > /etc/openvpn/ccd/branch

openssl dhparam -out /etc/openvpn/keys/dh2048.pem 2048
openvpn --genkey --secret /etc/openvpn/keys/ta.key

cp /etc/openvpn/keys/ca.crt /etc/openvpn/keys/branch.crt /etc/openvpn/keys/branch.key /etc/openvpn/keys/ta.key /etc/openvpn/keys/dh2048.pem /vagrant/vpn-branch

service openvpn status
service openvpn restart

service openvpn@server status
service openvpn@server enable
service openvpn@server start
service openvpn@server status

# DHCP für angeschlossene Geräte(also Voip Server) installieren
apt-get install dnsmasq
sed -i 's:^#dhcp-range=192.168.0.50,192.168.0.150,12h.*$:dhcp-range=192.168.50.5,192.168.50.10,12h:' /etc/dnsmasq.conf
sed -i 's:^#interface=.*$:interface=enp0s9:' /etc/dnsmasq.conf
/etc/init.d/dnsmasq restart


# diese VM als Gateway für DHCP Subnetz konfigurieren. Diese VM muss NAT machen da es Pakete für sich und den VoipServer sendet

#iptables-persistent speichert und autoläd iptable einträge
apt-get install -y iptables-persistent

# dieser Schritt scheint nicht 100% automatisch zu gehen. Nach neustart testen ob da is

#enable ipv4 forwarding permanently
sed -i 's:^#net.ipv4.ip_forward=1.*$:net.ipv4.ip_forward=1:' /etc/sysctl.conf
sysctl -p

# dieser Schritt scheint nicht 100% automatisch zu gehen. Nach neustart testen ob da is
iptables -N PORTROUTING
iptables -t nat -A POSTROUTING -o enp0s3 -j MASQUERADE

iptables-save > /etc/iptables/rules.v4
