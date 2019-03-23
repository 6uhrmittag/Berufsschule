SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET character_set_client = 'utf8' */;

--
-- Datenbank: `versand`
--
CREATE DATABASE Versand;
USE Versand;

-- --------------------------------------------------------
--
-- Tabellenstruktur für Tabelle `t_kunden`
--

CREATE TABLE IF NOT EXISTS `T_Kunden` (
  `p_kunden_nr` int(10) NOT NULL,
  `status` char(1) DEFAULT NULL,
  `vorname` varchar(30) DEFAULT NULL,
  `nachname` varchar(30) DEFAULT NULL,
  `strasse` varchar(30) DEFAULT NULL,
  `plz` char(5) DEFAULT NULL,
  `ort` varchar(25) DEFAULT NULL,
  `letzteBestellung` datetime DEFAULT NULL,
  `letzteWerbeaktion` datetime DEFAULT NULL,
  `zahlung` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `t_kunden`
--

INSERT INTO T_Kunden (p_kunden_nr, status, vorname, nachname, strasse, plz, ort, letzteBestellung, letzteWerbeaktion, zahlung) VALUES
(100, 'S', 'Hans', 'Voss', 'Kuhdamm 12', '23863', 'Nienwohld', NULL, '2015-12-01 00:00:00', 'N'),
(101, 'S', 'Peter', 'Stein', 'Moordamm 34', '23863', 'Kayhude', '2016-04-28 00:00:00', '2015-12-01 00:00:00', 'B'),
(102, 'W', 'Uwe', 'Berger', 'Allee 12 b', '25813', 'Husum', NULL, '2016-12-01 00:00:00', 'N'),
(103, 'S', 'Nis', 'Randers', 'Am Seeufer 12', '23845', 'Oering', '2016-05-15 00:00:00', NULL, 'B'),
(104, 'G', 'Ute', 'Andresen', 'Am Abhang', '24558', 'Ulzburg', NULL, NULL, 'N'),
(105, 'S', 'Werner', 'Stuff', 'Tarper Weg', '24853', 'Eggebek', '2016-05-12 00:00:00', NULL, 'R'),
(106, 'W', 'Hannes', 'Staack', 'An der Alster 1', '23863', 'Kayhude', NULL, '2015-12-01 00:00:00', 'N');





--
-- Tabellenstruktur für Tabelle `t_girokonten`
--

CREATE TABLE IF NOT EXISTS `T_Girokonten` (
  `pf_kunden_nr` int,
  `kontoinhaber` varchar(30) DEFAULT NULL,
  `bic` char(8) DEFAULT NULL,
  `iban` char(22) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `t_girokonten`
--

INSERT INTO `T_Girokonten` (`pf_kunden_nr`, `kontoinhaber`, `bic`, `iban`) VALUES
(101, 'Peter Stein', 'DEUTDE2H', 'DE21301204000000022851'),
(103, 'Nis Randers', 'COBADEH1', 'DE21301204000000015228');


-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `t_mwstsaetze`
--

CREATE TABLE IF NOT EXISTS `T_Mwstsaetze` (
  `p_mwst_nr` tinyint(3) unsigned NOT NULL,
  `Prozent` decimal(3,2) DEFAULT NULL,
  `Beschreibung` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `t_mwstsaetze`
--

INSERT INTO `T_Mwstsaetze` (`p_mwst_nr`, `Prozent`, `Beschreibung`) VALUES
(0, 0.00000, 'ohne'),
(1, 0.07000, 'halbe'),
(2, 0.19000, 'volle');

--
-- Tabellenstruktur für Tabelle `t_artikel`
--

CREATE TABLE IF NOT EXISTS `T_Artikel` (
  `p_artikel_nr` char(4) NOT NULL,
  `f_mwst` tinyint(3) unsigned DEFAULT NULL,
  `bezeichnung` varchar(20) DEFAULT NULL,
  `listenpreis` decimal(19,4) DEFAULT NULL,
  `bestand` int DEFAULT NULL,
  `mindestbestand` int DEFAULT NULL,
  `verpackung` varchar(20) DEFAULT NULL,
  `lagerplatz` tinyint(3) unsigned DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `t_artikel`
--

INSERT INTO `T_Artikel` (`p_artikel_nr`, `f_mwst`, `bezeichnung`, `listenpreis`, `bestand`, `mindestbestand`, `verpackung`, `lagerplatz`) VALUES
('G001', 2, 'Whisky', '38.5000', 397, 50, '0,7 l', 7),
('G002', 2, 'Portwein', '12.4500', 473, 100, '0,5 l', 7),
('G003', 2, 'Bier', '5.2000', 1250, 250, '6-er Pack', 7),
('K001', 2, 'Schuhe', '98.5000', 120, 25, 'Karton', 2),
('K002', 2, 'Hose', '112.8000', 62, 25, NULL, 2),
('K003', 2, 'Damenhut', '65.7000', 12, 20, 'Karton', 2),
('K004', 1, 'Sonnenbrille', '76.0000', 50, 20, 'Karton', 2),
('L001', 1, 'Ceylon Tee', '6.3500', 356, 100, '125 g', 5),
('L002', 1, 'China Tee', '8.3500', 42, 50, '125 g', 5),
('L003', 1, 'Naturreis', '1.7800', 345, 0, '1 kg', 4),
('L004', 2, 'Schokolade', '0.9800', 2101, 1000, 'Tafel', 2),
('L005', 2, 'Butterkekse', '1.7200', 234, 250, '250 g', 2);

-- --------------------------------------------------------
--
-- Tabellenstruktur für Tabelle `t_bestellungen`
--

CREATE TABLE IF NOT EXISTS `T_Bestellungen` (
  `p_bestell_Nr` int,
  `f_kunden_Nr` int,
  `bestelldatum` datetime,
  `lieferdatum` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `t_bestellungen`
--

INSERT INTO `T_Bestellungen` (`p_bestell_Nr`, `f_kunden_Nr`, `bestelldatum`, `lieferdatum`) VALUES
(960151, 101, '2016-04-28 00:00:00', '2016-05-02 00:00:00'),
(960152, 103, '2016-04-30 00:00:00', '2016-05-02 00:00:00'),
(960153, 105, '2016-05-12 00:00:00', NULL),
(960154, 103, '2016-05-15 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `t_artikelbestellungen`
--

CREATE TABLE IF NOT EXISTS `T_Artikelbestellungen` (
  `pf_bestell_nr` int NOT NULL,
  `pf_artikel_nr` char(4) NOT NULL,
  `bestellmenge` int DEFAULT NULL,
  `liefermenge` int DEFAULT NULL,
  `mwst` decimal(3,2) DEFAULT NULL,
  `kaufpreis` decimal(19,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `t_artikelbestellungen`
--

INSERT INTO `T_Artikelbestellungen` (`pf_bestell_nr`, `pf_artikel_nr`, `bestellmenge`, `liefermenge`, `mwst`, `kaufpreis`) VALUES
(960151, 'G002', 4, 4, 0.19000, '12.4500'),
(960151, 'G003', 3, 3, 0.19000, '5.2000'),
(960151, 'K002', 3, 0, 0.19000, '112.8000'),
(960151, 'K003', 1, 1, 0.19000, '65.7000'),
(960151, 'L002', 10, 5, 0.07000, '8.3500'),
(960152, 'K001', 10, 10, 0.19000, '98.5000'),
(960152, 'K003', 2, 2, 0.19000, '65.7000'),
(960152, 'K004', 12, 12, 0.07000, '76.0000'),
(960153, 'G001', 2, NULL, NULL, NULL),
(960153, 'L002', 6, NULL, NULL, NULL),
(960153, 'L003', 25, NULL, NULL, NULL),
(960153, 'L004', 5, NULL, NULL, NULL),
(960154, 'G001', 4, NULL, NULL, NULL),
(960154, 'G002', 12, NULL, NULL, NULL),
(960154, 'G003', 1, NULL, NULL, NULL);

-- --------------------------------------------------------



--
-- Indizes für die Tabelle `t_artikel`
--
ALTER TABLE `T_Artikel` ADD PRIMARY KEY (p_artikel_nr);

--
-- Indizes für die Tabelle `t_artikelbestellungen`
--
ALTER TABLE `T_Artikelbestellungen` ADD PRIMARY KEY (`pf_bestell_nr`,`pf_artikel_nr`);

--
-- Indizes für die Tabelle `t_bestellungen`
--
ALTER TABLE `T_Bestellungen` ADD PRIMARY KEY (`p_bestell_Nr`);

--
-- Indizes für die Tabelle `t_girokonten`
--
ALTER TABLE `T_Girokonten` ADD PRIMARY KEY (`pf_kunden_nr`);

--
-- Indizes für die Tabelle `t_kunden`
--
ALTER TABLE `T_Kunden` ADD PRIMARY KEY (`p_kunden_nr`);

--
-- Indizes für die Tabelle `t_mwstsaetze`
--
ALTER TABLE `T_Mwstsaetze` ADD PRIMARY KEY (`p_mwst_nr`);

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `t_artikel`
--
ALTER TABLE `T_Artikel`
ADD CONSTRAINT `t_artikel_ibfk_1` FOREIGN KEY (`f_mwst`) REFERENCES `T_Mwstsaetze` (`p_mwst_nr`);

--
-- Constraints der Tabelle `t_artikelbestellungen`
--
ALTER TABLE `T_Artikelbestellungen`
ADD CONSTRAINT `t_artikelbestellungen_ibfk_1` FOREIGN KEY (`pf_bestell_nr`) REFERENCES `T_Bestellungen` (`p_bestell_Nr`),
ADD CONSTRAINT `t_artikelbestellungen_ibfk_2` FOREIGN KEY (`pf_artikel_nr`) REFERENCES `T_Artikel` (`p_artikel_nr`);

--
-- Constraints der Tabelle `t_bestellungen`
--
ALTER TABLE `T_bestellungen`
ADD CONSTRAINT `t_bestellungen_ibfk_1` FOREIGN KEY (`f_kunden_Nr`) REFERENCES `T_Kunden` (`p_kunden_nr`);

--
-- Constraints der Tabelle `t_girokonten`
--
ALTER TABLE `T_Girokonten`
ADD CONSTRAINT `t_girokonten_ibfk_1` FOREIGN KEY (`pf_kunden_nr`) REFERENCES `T_Kunden` (`p_kunden_nr`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
