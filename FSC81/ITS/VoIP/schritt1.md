# SCHRITT 1 – KONZEPT ERSTELLEN

. Erstellen Sie anhand der Informationen eine Übersicht mit den Eckdaten der ⌚45‘
notwendigen Anbindung, soweit Sie diese ohne Vor-Ort-Termin erfassen können.

 Wie viele Teilnehmer sollen gleichzeitig telefonieren?
- 20
 Wie schnell muss die Anbindung an die Zentrale im Up- und Dowload sein?
- 100/60 -> 1,748MByte
 Welche Bandbreite benötigt ein Voice-Over-IP-Gespräch bei „ISDN“-Qualität?
- http://das-asterisk-buch.de/1.6/die-wichtigsten-codecs.html
- https://www.fonial.de/wissen/wie-viel-bandbreite-benoetigt-voip/
min. 64kb/s bei G711 -> x20 -> 160kbyte/s
durchschnitt/maximum: 150kbit/s * 20 -> 3000kbit/s -> 375kbyte/s
 Welchen Overhead müssen Sie bei einer VPN-Verbindung einplanen?
IPsec: ESP - Encapsulating Security Payload
https://hamwan.org/Standards/Network%20Engineering/IPsec.html#common-ipsec-overhead-figures
ESP-AES-128	-> 41Byte
etwa 50byte
openvpn: https://256.insys-icom.de/icom/de/Knowledge-Base/VPN/Overhead
etwa 100Byte

1,748MByte
375kByte
100Byte
-> 2.223MByte/s  gesamt