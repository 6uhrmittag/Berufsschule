#desktop client
nach dem booten
1. die Netzwerkverbindung 0 eth0 deaktivieren
2. in Netzwerkverbindung 1 eht1 die 
    - default Route auf 192.168.40.4
    - Reiter ipv4 die Route 192.168.40.5 via 192.168.40.4 einstellen
3. Netzwerkverbindung 1 eht1 auf Wiredconnection umstellen

(wird bei reboot von Vagrant resettet)

#voipserver 
# setup

- wichtig: bei 'wie ist ihre Public IP' muss auf "manuell" gestellt werden und die lokale IP eingegeben werden.
    - Also die, die im Webbrowser angezeigt wird(192.168.50.9 - wird aber via DHCP vergeben und kann sich ändern)
- die Webclient Telefonfunktion geht nur mit https!

## nebenstellen
### clients
- client001
    - Client01000
- client002
    - Client02000

pw für nebenstellen
Passwort123!

## admin
You can access the 3CX Management console from this URL: https://oszimttest81.my3cx.de:5001 or via IP: https://192.168.50.9:5001

Username: marvin

Password: Passwort123!

Public IP: 192.168.50.9

FQDN: oszimttest81.my3cx.de

