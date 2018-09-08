# Installation Redhat Server
## Server vorbereiten
- Kein PS2 Keyboard benutzen (error 52)
- Festplatten in Raid1 (Strg+C bei boot)
## Download iso
- https://access.redhat.com/downloads/content/69/ver=/rhel---7/7.5/x86_64/product-software
- Red Hat Enterprise Linux 7.5 Binary DVD
## bootstick
- https://rufus.akeo.ie/
## install
- netzwerk konfigurieren
- root passwort erstellen
- user erstellen

# Installation RED HAT VIRTUALIZATION 4.2
## login
- login via Putty nach Installation möglich (auch root)
## System zu subscription hinzufügen
- subscription-manager register --username <username> --password <password> --auto-attach

## Repos hinzufügen
````bash
subscription-manager repos --disable=*
subscription-manager repos --enable=rhel-7-server-rpms
subscription-manager repos --enable=rhel-7-server-supplementary-rpms
subscription-manager repos --enable=rhel-7-server-rhv-4.2-manager-rpms
subscription-manager repos --enable=rhel-7-server-rhv-4-manager-tools-rpms
subscription-manager repos --enable=rhel-7-server-ansible-2-rpms
subscription-manager repos --enable=jb-eap-7-for-rhel-7-server-rpms
````
## Installation rhevm
- ``yum update; yum install rhevm``
- ``engine-setup`` (alles default)
## Konfiguration rhevm (bei Fehler "The redirection URI for client is not registered")
- https://bugzilla.redhat.com/show_bug.cgi?id=1483544
- Create a new conf file /etc/ovirt-engine/engine.conf.d/99-sso.conf
    - add: `SSO_CALLBACK_PREFIX_CHECK=false`

## login
user: admin
passwort: das aus dem dialog

## install hypervisor
subscription-manager repos --enable=rhel-7-server-rhevh-rpms
yum install rhev-hypervisor7
https://access.redhat.com/documentation/en-US/Red_Hat_Enterprise_Virtualization/3.3/html/Installation_Guide/Installing_the_Self-Hosted_Engine.html
https://access.redhat.com/documentation/en-us/red_hat_virtualization/4.2/pdf/self-hosted_engine_guide/Red_Hat_Virtualization-4.2-Self-Hosted_Engine_Guide-en-US.pdf
https://docs.aws.amazon.com/storagegateway/latest/userguide/CreatingAnNFSFileShare.html
https://aws.amazon.com/de/getting-started/tutorials/create-network-file-system/
http://blog.domb.net/?p=2141
