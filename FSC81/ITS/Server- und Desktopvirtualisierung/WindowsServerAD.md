#server
##user

- name:`Administrator`
- pw:`Imt2018!`

###ad user

- name: `aduser1`
- pw: `Imt2018!`

##Initialkonfiguration
- statische IP einstellen
    - `10.0.2.15`
- Computername ändern
    - powershell: `rename-computer -newname NAME -restart`
##DNS
- Rolle hinzufügen: DNS
    - powershell `Install-WindowsFeature DNS -IncludeManagementTools`
- Forward-Zone erstellen `euhit.demo`
    - _Nicht sichere Updates_ zulassen!!
- Reverse-Zone erstellen    
    - _Nicht sichere Updates_ zulassen!!
    
- > nicht nötig: In Zone "euhit.demo" einen A-Eintrag mit Name "ad" und IP anlegen + PTR-Eintrag
- > nicht nötig:  Auf Client testen mit "nslookup ad.euhit.demo" -> muss IP von AD zurückgeben

##AD
- Rolle hinzufügen: "AD Domänendienste"
    - Wizard folgen
    - NICHT SCHLIEßen! -> Am Ende _Server zu einem Domänencontroller heraufstufen_
- Bereitstellungskonfiguration
    - _Neue Gesamtstruktur hinzufügen_
    - _Name der Stammdomäne_: `euhit.demo`
    - Kennwort eingeben
    - _Anmeldeinformationen zum Erstellen einer Delegierung angeben_ -> Logindaten
    - Wizard folgen -> Installieren

###gruppen
- tools "Active Directory Benutzer und Computer"
    - euhit.demo -> Users -> Neu -> Gruppe
###user
- tools "Active Directory Benutzer und Computer"
    - euhit.demo -> Users -> Neu -> Benutzer
    - ausfüllen
    - zu gruppe hinzufügen


###gruppenrichtlinie
- tools -> Gruppenrichtlinienverwaltung
- Gruppenrichtlinienobjekte -> neu -> anlegen
- Objekt auf die Domäne ziehen um sie zu Verknüpfen
- rechtsklick auf angelegte -> bearbeiten
- Sicherheitsfilterung
    - benötigte gruppen hinzufügen

##Freigabe
- Normale Ordner-Freigabe wie unter Windows

#client
##user

- name: `client`
- pw: `Imt2018!`

## Initialkonfiguration

- statische IP
    - `10.0.2.16`
- Computername ändern
    - powershell: `rename-computer -newname NAME -restart`
- DNS auf Server setzen

## ad beitreten
- powershell: `Add-Computer -DomainName $domainName -Restart`
- mit angelegtem User einloggen
## GPO updaten
- cmd -> `gpupdate`