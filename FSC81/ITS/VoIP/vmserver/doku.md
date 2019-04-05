# Installaton von OpenVPN-Server + Verbindung von Windows Client
Websites:
- https://github.com/OpenVPN/easy-rsa/blob/master/README.quickstart.md
- https://community.openvpn.net/openvpn/wiki/GettingStartedwithOVPN

Client installieren:
````bash
apt install openvpn easy-rsa
cd /usr/share/easy-rsa
./pkitool --help
````
Ausgabe:
````text
Typical usage for initial PKI setup.  Build myserver, client1, and client2 cert/keys.
Protect client2 key with a password.  Build DH parms.  Generated files in ./keys :
  [edit vars with your site-specific info]
  source ./vars
  ./clean-all
  ./build-dh     -> takes a long time, consider backgrounding
  ./pkitool --initca
  ./pkitool --server myserver
  ./pkitool client1
  ./pkitool --pass client2

````


CA-Daten anpassen:
````bash
vim vars
````
siehe: https://knowledge.digicert.com/solution/SO16317.html

Zeritifikate generieren:
````bash
mv openssl-1.0.0.cnf openssl.cnf
./clean-all
source vars

./pkitool --initca
./pkitool --server myserver #servername
./pkitool client1 #clientname

cd /etc/openvpn/
mkdir /etc/openvpn/keys
mv /usr/share/easy-rsa/keys/* /etc/openvpn/keys
````
von https://raw.githubusercontent.com/OpenVPN/openvpn/master/sample/sample-config-files/server.conf
````bash
vim server.conf
````
**Achtung: Im Produktivsetup sollte bei den Keys sehr genau auf die Dateiberechtigung beschaut werden!**

Pfade anpassen:
````text
ca /etc/openvpn/keys/ca.crt
cert /etc/openvpn/keys/myserver.crt
key /etc/openvpn/keys/myserver.key  # This file should be kept secret

# Diffie hellman parameters.
# Generate your own with:
#   openssl dhparam -out dh2048.pem 2048
dh /etc/openvpn/keys/dh2048.pem

````
````bash
openvpn --genkey --secret ta.key

````
````bash
cd keys
openssl dhparam -out dh2048.pem 2048
````
Client Daten auf Host kopieren:
````bash
cp /etc/openvpn/keys/ca.crt /etc/openvpn/keys/client1.crt /etc/openvpn/keys/client1.key /etc/openvpn/ta.key /etc/openvpn/keys/dh2048.pem /vagrant 
````
Server starten:
````bash
service openvpn status
service openvpn start
 
service openvpn@server status
service openvpn@server start
````

## Client
openvpn installieren: https://openvpn.net/community-downloads/

1. Explorer: `C:\Users\$USERNAME\OpenVPN\config\`
2. Dir erstellen `vm`
3. Vorher kopiere Dateien aus `/vagrant` in `vm` kopieren
4. `C:\Program Files\OpenVPN\sample-config\client.ovpn` nach `C:\Users\$USERNAME\OpenVPN\config\vm` kopieren
5. `C:\Users\$USERNAME\OpenVPN\config\vm\client.ovpn` in Editor öffnen
6. anpassen. IP von VM einfügen:
````text
# The hostname/IP and port of the server.
# You can have multiple remote entries
# to load balance between the servers.
remote 192.168.50.4
;remote my-server-2 1194
````
Dateinamen anpassen oder kopiere Dateien umbenennen:
````text
# SSL/TLS parms.
# See the server config file for more
# description.  It's best to use
# a separate .crt/.key file pair
# for each client.  A single ca
# file can be used for all clients.
ca ca.crt
cert client.crt
key client.key
````
7. OpenVPN Client starten und auf "verbinden" -> sollte verbinden
8. `ping 10.8.0.1`
9. eigene: `Notified TAP-Windows driver to set a DHCP IP/netmask of 10.8.0.6/255.255.255.252 on interface `

## test
Zum Test kann ein nginx mit IP-Sperre genutzt werden.

````bash
apt install nginx
vim /etc/nginx/sites-enabled/default
````
Mit aktivem VPN auf VM:
-  auf Host, via Browser: http://10.8.0.1/ -> nginx default seite
-  auf Host, via Browser: http://192.168.50.4/ -> nginx default seite
-  auf VM
add:
````text
        location / {
                # First attempt to serve request as file, then
                # as directory, then fall back to displaying a 404.
                try_files $uri $uri/ =404;
                
                allow 127.0.0.1;
                deny  all;
        }
````
`service nginx reload`
- auf Host, via Browser: http://10.8.0.1/ -> 403 forbidden
- auf VM ` vim /var/log/nginx/error.log` -> IP von Host: forbidden
- auf VM
add:
````text
        location / {
                # First attempt to serve request as file, then
                # as directory, then fall back to displaying a 404.
                try_files $uri $uri/ =404;
                
                allow 10.8.0.6;
                allow 127.0.0.1;
                deny  all;
        }
````
`service nginx reload`
-  auf Host, via Browser: http://10.8.0.1/ -> nginx default seite
-  auf Host, via Browser: http://192.168.50.4/ -> keine Verbindung möglich

VPN Trennen!
-  auf Host, via Browser: http://10.8.0.1/ -> keine Verbindung möglich
-  auf Host, via Browser: http://192.168.50.4/ -> keine Verbindung möglich

VPN Verbinden!
-  auf Host, via Browser: http://10.8.0.1/ -> Verbindung möglich
-  auf Host, via Browser: http://192.168.50.4/ -> keine Verbindung möglich
