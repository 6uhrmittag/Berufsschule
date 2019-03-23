# UPDATE, DELETE, INSERT

# Aufgabe 1
````sql
INSERT INTO T_Mwstsaetze(`p_mwst_nr`, `Prozent`, `Beschreibung`) VALUES ('3', '0.33', 'Luxus');
INSERT INTO `T_Artikel` (`p_artikel_nr`, `f_mwst`, `bezeichnung`, `listenpreis`, `bestand`, `mindestbestand`, `verpackung`, `lagerplatz`) VALUES ('L006', 3, 'Yacht', '50000', 4, 3, '250 g', 7);
````

# Aufgabe 2
````sql
UPDATE T_Mwstsaetze SET Prozent='0.21' WHERE p_mwst_nr=2;
````

# Aufgabe 3
````sql
UPDATE T_Artikel SET listenpreis=listenpreis*1.1 WHERE bezeichnung LIKE '%Tee%';
````

# Aufgabe 4

UPDATE T_Artikel SET listenpreis=listenpreis*1.1 WHERE -> artikelnr nicht in T_Artikelbestellungen

SELECT bezeichnung
FROM T_Artikel AS t1
WHERE NOT EXISTS
 (
  SELECT 1
  FROM T_Artikelbestellungen AS t2
  WHERE t2.pf_artikel_nur = t1.pf_artikel_nur
 )