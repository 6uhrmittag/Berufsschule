# BACKUPSTRATEGIEN

- 1:1 image / sektor-sektor
    - kompletter Inhalt wird Sektor für Sektor gesichert
    - Wiederherstellung ergibt 100% Ursprungszustand
    - Benötigt viel Speicher/Zeit
    - 
- vollbackup
    - Sicherung aller Daten - auf Dateiebene
- differenzeielles backup
    - Sicherung der Differenz zum Vollbackup
- inkrementeslles backup
    - Sicherung der Änderung zum letzten (Teil-/Inkrementellen-)Backup


# GENERATIONEN-PRINZIP


# SNAPSHOTS
Inkrementelle Vollsicherung eines Systemes. Speichert den Zustand eines Systemes als read-only und dann jeweils die hinzukommenden Änderungen.

- Schnelles Wiederherstellen/Springen zwischen Zuständen möglich
- Die Snapshots müssen zur Wiederherstellung vorhanden sein
- Snapshots sind Zustands-Sicherung, keine definierten Backups von Datei-Versionen.
    - Zu einem vollen System-Snapshot gehören RAM-Snapshots   

# GA1 Sommer 2015
- 1Gbit/s davon 25% -> 250mbit/s -> mbyte => /8 = 31.25 mbyte/s
- 700GiByte -> 751,619Gbyte
- Gesucht Übertragungszeit

751,619/31.25 => 24051.808s
22400/60 => 400min
6.68105777778h
0.681*60min = 40.8634666668 
6h 41min    