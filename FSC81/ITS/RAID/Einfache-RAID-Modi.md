# Einfache RAID-Modi

# Eigenschaften von RAID
## KENNGRÖßEN DER RAID-LEVEL
LEVEL MIN. HDD - MAX. AUSFALL - NETTOKAPAZITÄT - LESEGESCHWIND. - SCHREIBGESCHWIND.
v = Durchschnittliche Geschwindigkeit
## 0 - min 2 - 0 Ausfall - n*kleinste Kapazität - proportional(n*v) - proportional(n*v)
## 1 - min 2 - 1 Ausfall - 1*kleinste Kapazität - proportional(n*v) - 1*v
## 5 - min 3 - 1 Ausfall - (n-1)*kleinste Kapazität - proportional(n*v) - fast proportional((n-1)*v) [1 HDD = nur Paritätsinformationen]
## 6 - min 4 - 2 Ausfall - (n-2)*kleinste Kapazität - proportional(n*v) - fast proportional((n-2)*v) [2 HDD = nur Paritätsinformationen]
## 1+0 - min 2 * 2[nur gerade Anzahl] - 1 Ausfall pro Raid1 Array - (n*kleinste Kapazität)/2 - proportional(n*v) - proportional(n*v)

## RAID FÜR DIE ZENTRALE VERWALTUNG
 n = 8 Festplatten á 500 GiByFallstudien zu RAID
 durchschnittlichen Lese-/Schreibgeschwindigkeit von 100 MiByte/s
 ### raid 1
NETTOKAPAZITÄT (8*500G)/2 = 2TB
LESEGESCHWINDIGKEIT = 8*100MiByte/s
SCHREIBGESCHWINDIGKEIT = 1*100MiByte/s
 ### raid 5
NETTOKAPAZITÄT (8-1)*500 = 3,5T
LESEGESCHWINDIGKEIT = 8*100MiByte = 800MiByte/s
SCHREIBGESCHWINDIGKEIT = (8-1)*100MiByte = 700MiByte/s
 ### raid 6 
NETTOKAPAZITÄT: (8-1)*500 = 3T
LESEGESCHWINDIGKEIT: 8*100MiByte
SCHREIBGESCHWINDIGKEIT = (8-2)*100MiByte = 600MiByte/s

# Fallstudien zu RAID
## RAID IM JAHRE 2017 – MEINE BEISPIELE...
- 4K Video Workstation - 
## „RAID-Dreieck