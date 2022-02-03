CREATE DATABASE  IF NOT EXISTS `gestionepresenze` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestionepresenze`;
-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: gestionepresenze
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `contratti`
--

DROP TABLE IF EXISTS `contratti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `contratti` (
  `id_contratto` int(11) NOT NULL AUTO_INCREMENT,
  `data_assunzione` date DEFAULT NULL,
  `data_scadenza` date DEFAULT NULL,
  `tipologia` varchar(45) DEFAULT NULL,
  `id_dipendente_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_contratto`),
  KEY `fk_dip_cont_idx` (`id_dipendente_fk`),
  KEY `tipologie_contratti_idx` (`tipologia`),
  CONSTRAINT `dipendenti_contratti` FOREIGN KEY (`id_dipendente_fk`) REFERENCES `dipendenti` (`id_dipendente`),
  CONSTRAINT `tipologie_contratti` FOREIGN KEY (`tipologia`) REFERENCES `tipologie` (`id_tipologia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contratti`
--

LOCK TABLES `contratti` WRITE;
/*!40000 ALTER TABLE `contratti` DISABLE KEYS */;
/*!40000 ALTER TABLE `contratti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dipendenti`
--

DROP TABLE IF EXISTS `dipendenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dipendenti` (
  `id_dipendente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `cognome` varchar(45) DEFAULT NULL,
  `data_nascita` date DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `ruolo_fk` varchar(45) DEFAULT NULL,
  `contratto_corrente_fk` int(11) DEFAULT NULL COMMENT '\n',
  PRIMARY KEY (`id_dipendente`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `ruoli_dipendenti_idx` (`ruolo_fk`),
  KEY `contratti_dipendenti_idx` (`contratto_corrente_fk`),
  CONSTRAINT `contratti_dipendenti` FOREIGN KEY (`contratto_corrente_fk`) REFERENCES `contratti` (`id_contratto`),
  CONSTRAINT `ruoli_dipendenti` FOREIGN KEY (`ruolo_fk`) REFERENCES `ruoli` (`id_ruolo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dipendenti`
--

LOCK TABLES `dipendenti` WRITE;
/*!40000 ALTER TABLE `dipendenti` DISABLE KEYS */;
/*!40000 ALTER TABLE `dipendenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dipendenti_mesi`
--

DROP TABLE IF EXISTS `dipendenti_mesi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dipendenti_mesi` (
  `id_dipendente_fk` int(11) NOT NULL,
  `id_mese_fk` int(11) NOT NULL,
  `stato` int(11) DEFAULT '0',
  PRIMARY KEY (`id_dipendente_fk`,`id_mese_fk`),
  KEY `dipendenti_dip_mesi_idx` (`id_dipendente_fk`),
  KEY `mesi_dip_mesi_idx` (`id_mese_fk`),
  CONSTRAINT `dipendenti_dip_mesi` FOREIGN KEY (`id_dipendente_fk`) REFERENCES `dipendenti` (`id_dipendente`),
  CONSTRAINT `mesi_dip_mesi` FOREIGN KEY (`id_mese_fk`) REFERENCES `mesi` (`id_mese`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dipendenti_mesi`
--

LOCK TABLES `dipendenti_mesi` WRITE;
/*!40000 ALTER TABLE `dipendenti_mesi` DISABLE KEYS */;
/*!40000 ALTER TABLE `dipendenti_mesi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesi`
--

DROP TABLE IF EXISTS `mesi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mesi` (
  `id_mese` int(11) NOT NULL AUTO_INCREMENT,
  `mese` date DEFAULT NULL,
  `chiuso` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id_mese`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesi`
--

LOCK TABLES `mesi` WRITE;
/*!40000 ALTER TABLE `mesi` DISABLE KEYS */;
/*!40000 ALTER TABLE `mesi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motivazioni`
--

DROP TABLE IF EXISTS `motivazioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `motivazioni` (
  `id_motivazione` varchar(45) NOT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_motivazione`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivazioni`
--

LOCK TABLES `motivazioni` WRITE;
/*!40000 ALTER TABLE `motivazioni` DISABLE KEYS */;
/*!40000 ALTER TABLE `motivazioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `presenze`
--

DROP TABLE IF EXISTS `presenze`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `presenze` (
  `id_presenza` int(11) NOT NULL AUTO_INCREMENT,
  `id_dipendente_fk` int(11) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `ore_lavorate` int(11) DEFAULT '0',
  `ore_assenza` int(11) DEFAULT '0',
  `motivazione_assenza_fk` varchar(45) DEFAULT NULL,
  `id_mese_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_presenza`),
  KEY `presenza_motivazione_idx` (`motivazione_assenza_fk`),
  KEY `dipendenti_presenze_idx` (`id_dipendente_fk`),
  KEY `mesi_presenze_idx` (`id_mese_fk`),
  CONSTRAINT `dipendenti_presenze` FOREIGN KEY (`id_dipendente_fk`) REFERENCES `dipendenti` (`id_dipendente`),
  CONSTRAINT `mesi_presenze` FOREIGN KEY (`id_mese_fk`) REFERENCES `mesi` (`id_mese`),
  CONSTRAINT `motivazioni_presenze` FOREIGN KEY (`motivazione_assenza_fk`) REFERENCES `motivazioni` (`id_motivazione`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `presenze`
--

LOCK TABLES `presenze` WRITE;
/*!40000 ALTER TABLE `presenze` DISABLE KEYS */;
/*!40000 ALTER TABLE `presenze` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruoli`
--

DROP TABLE IF EXISTS `ruoli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ruoli` (
  `id_ruolo` varchar(45) NOT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_ruolo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruoli`
--

LOCK TABLES `ruoli` WRITE;
/*!40000 ALTER TABLE `ruoli` DISABLE KEYS */;
INSERT INTO `ruoli` VALUES ('admin','admin');
/*!40000 ALTER TABLE `ruoli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipologie`
--

DROP TABLE IF EXISTS `tipologie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipologie` (
  `id_tipologia` varchar(45) NOT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipologia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipologie`
--

LOCK TABLES `tipologie` WRITE;
/*!40000 ALTER TABLE `tipologie` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipologie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'gestionepresenze'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-03 11:26:12
