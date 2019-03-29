# DSL-ZUGÄNGE (Kupfer / Glasfaser)
1. Welche Bedeutung hat die Abkürzung DSL? Was haben alle DSL-Verfahren gemeinsam?
Digital Subscriber Line. Alle DSL Verfahren laufen über Telefonleitungen
2. Anhand welcher Kriterien werden die xDSL-Systeme (ADSL, SDSL, VDSL2) unterschieden?
Die Geschwindigkeit bzw. das Verhältnis der Download-/Uploadgeschwindigkeit
3. Welche Aufgabe hat ein Splitter? Welche grundsätzlichen Komponenten enthält er?
Splitter ist eine Frequenzweiche; Er ermöglicht analoge Telefonnutzung und DSL gleichzeitig. Frequenzen >25kHz werden für DSL verwendet.
4. Wofür steht das Akronym DSLAM? Welche Aufgaben hat ein DSLAM beim Provider?
Digital Subscriber Line Access Multiplexer. Ein DSLAM ist eine DSL Vermittlungsstelle für Wohngebiete/Komplexe. Das DSLAM ist die Gegenstelle für das DSL Modem.
5. Welche Rolle spielt das SNR beim ADSL-System – und wovon hängt es ab?
SNR - Signal to noise ratio. SNR ist Abhängig von der Leitungsquallität, der Leitungslänge und Störquellen. Das SNR bestimmt die Leitungsgeschwindigkeit.
6. Die Deutsche Telekom setzt auf Vectoring die Bitrate von DSL-Anschlüssen noch weiter zu
steigern. Erläutern Sie seine grundsätzliche Funktion und skizzieren Sie die bei der
Umsetzung auftretenden Probleme der Netzzugangsprovider.
Bei Vectoring werden Störungen durch Leitungsübersprechen durch den DSLAM kompensiert. Dazu wird das Leitungssignal analysiert und, bei Störungen, ein Korrektursignal(das invertierte Störungssignal) auf Nachbarleitungen gelegt.
Diese mögliche Korrektur ermöglicht höhere Übertragungsraten über die vorhandenen Kupferleitungen.
Für Vectoring benötigt der DSLAM Kontrolle bzw. Wissen von allen Signalen der Leitungen am DSLAM.
Vectoring kann Providerdiversität am DSLAM verhindern da das DSLAM Kontrolle über alle Leitungen braucht. Unterschiedliche Provider bzw. eingesetzte Techniken verhindern Vectoring damit. Das kann als Druckmittel genutzt werden um andere Provider aus dem DSLAM zu drängen/davon auszuschließen.
7. DSL nutzt auch das PPPoE (Point to Point Protocol over Ethernet), in dem vier Phasenbeim Handshake (Aufbau einer Verbindung) unterschieden werden.
    - a. Welche Aufgaben haben die jeweiligen Phasen?
    Analysieren Sie dazu den bereitgestellten Paket-Dump mit Wireshark
    - b. Wie ordnet sich PPPoE im ISO/OSI-Modell ein? Stellen Sie exemplarisch den Verlauf eines ein TCP-Paket dar, dass die deutsche Google-Startseite anfordert.
8. DSL vs. FTTF/FTTB; Beschreiben Sie den Unterschied zwischen diesen beiden
Technologien. Welches sind die jeweiligen Vor- und Nachteile beider Technologien.
Bei DSL werden Kupferleitungen zur Übertragung benutzt, während bei FTF,FTTB Glasfasteleitungen genutzt werden.
Glasfaser ermöglicht höhere Bandbreite und Übertragungslänge, hat bessere Übertragungsquallität und ist Störungsresitenter.
Da DSL jahrzehnte alte Kupferleitungen nutzt, ist die aktuelle Abdeckung besser. Ein ausgebautes Glasfasternetz ist DSL auf lange Zeit überlegen.

# MOBILE-FUNK-ZUGÄNGE
1. Welche Mobilfunkstandards gibt es heute?
Beschreiben Sie kurz die unterschiedlichen Standards.

GSM: 56kbit/s
EDGE: 150 bis 200 kbit/s
UMTS 
HSPA
HSPA+
LTE:  mehr als 75 MBit/s im Uplink und 300 MBit/s im Downlink
LTE Advanced: mehr als 1 GBit/s
5G:  10 000MBit/s


2. Welche Datenübertragungsstandards gibt es im Mobilfunkbereich?

# Vergleich
## 1
- DSL: Modernes Mehrfamiliengebäude
- Glasfaser: Land, außerhalb Ballungsgebiete, schnelle Übertragungsgeschwindigkeit, in Explosionsgefärdeter Umgebung
- Koax-Kabel: Einfamilienhaus(da Leitungskapazität geteilt)
- Mobilfunktechnologie: Land, außerhalb Ballungsgeiete

## 2
- Breitband-Technik - Downlink in Mbit/s - Uplink - in Mbit/s - Latenz in ms - Anzahl der benötigen Adern - Reichweite vom letzten Verteiler
- DSL - 100MBit/S
- ADSL2+ bis zu 25 Mbit/s  - 
- VDSL2 - 50 bis 100 Mbit/s - 
- VDSL2 Vectoring
- VDSL2 super
- Vectoring
- FTTH - 10Gbit/s
- TV-Kabel - 100 - 
- GSM (max.)  56kbit/s - 
- UMTS (max.)
- LTE (max.)  75 MBit/s - 
- 5G (max.) 10Gbit/s - 
- Satelli