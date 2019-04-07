#!/usr/bin/env bash

apt update
apt install -y openvpn

mkdir /etc/openvpn/keys

wget -O /etc/openvpn/branch.conf https://raw.githubusercontent.com/OpenVPN/openvpn/master/sample/sample-config-files/client.conf

sed -i 's:^ca.*$:ca /etc/openvpn/keys/ca.crt:' /etc/openvpn/branch.conf
sed -i 's:^cert.*$:cert /etc/openvpn/keys/branch.crt:' /etc/openvpn/branch.conf
sed -i 's:^key.*$:key /etc/openvpn/keys/branch.key:' /etc/openvpn/branch.conf
sed -i 's:^dh.*$:dh /etc/openvpn/keys/dh2048.pem:' /etc/openvpn/branch.conf
# Achtung Ende muss 1 auf client und 0 auf server
sed -i 's:^tls-auth.*$:tls-auth /etc/openvpn/keys/ta.key 1:' /etc/openvpn/branch.conf

sed -i 's:^remote my-server-.*$:remote 10.0.0.4:' /etc/openvpn/branch.conf
# Erlaube dem Branch das Subnetz mit VoiP Server zu errreichen
sed -i 's:^;push "route 192.168.10.0.*$:push "route 192.168.50.0 255.255.255.0":' /etc/openvpn/branch.conf


cp /vagrant/vpn-branch/ca.crt /vagrant/vpn-branch/branch.crt /vagrant/vpn-branch/branch.key /vagrant/vpn-branch/ta.key /vagrant/vpn-branch/dh2048.pem /etc/openvpn/keys/

service openvpn status
service openvpn restart

#Service heißt wie Config file
service openvpn@branch status
service openvpn@branch enable
service openvpn@branch start
service openvpn@branch status

# DHCP für angeschlossene Geräte(also Voip Server) installieren
apt-get install dnsmasq
sed -i 's:^#dhcp-range=192.168.0.50,192.168.0.150,12h.*$:dhcp-range=192.168.40.5,192.168.40.10,12h:' /etc/dnsmasq.conf
sed -i 's:^#,interface=*$:interface=enp0s9:' /etc/dnsmasq.conf
/etc/init.d/dnsmasq restart

# diese VM als Gateway für DHCP Subnetz konfigurieren. Diese VM muss NAT machen da es Pakete für sich und den VoipServer sendet
#iptables-persistent speichert und autoläd iptable einträge
apt-get install -y iptables-persistent

#enable ipv4 forwarding permanently
sed -i 's:^#net.ipv4.ip_forward=1.*$:net.ipv4.ip_forward=1:' /etc/sysctl.conf
sysctl -p

# dieser Schritt scheint nicht 100% automatisch zu gehen. Nach neustart testen ob da is
iptables -N PORTROUTING
iptables -t nat -A POSTROUTING -o enp0s3 -j MASQUERADE

iptables-save > /etc/iptables/rules.v4

