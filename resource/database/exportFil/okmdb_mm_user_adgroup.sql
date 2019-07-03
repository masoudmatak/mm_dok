-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: okmdb
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `mm_user_adgroup`
--

DROP TABLE IF EXISTS `mm_user_adgroup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mm_user_adgroup` (
  `ad_id` varchar(40) NOT NULL,
  `personr` varchar(12) NOT NULL,
  `varumarke` varchar(45) NOT NULL,
  `YTA` varchar(45) NOT NULL,
  `texten` varchar(50) DEFAULT NULL,
  `user_string` varchar(20) NOT NULL,
  PRIMARY KEY (`ad_id`,`user_string`),
  CONSTRAINT `adgrpid_fk` FOREIGN KEY (`ad_id`) REFERENCES `mm_ad_group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mm_user_adgroup`
--

LOCK TABLES `mm_user_adgroup` WRITE;
/*!40000 ALTER TABLE `mm_user_adgroup` DISABLE KEYS */;
INSERT INTO `mm_user_adgroup` VALUES ('CPE_FOLKSAM_DJURSKADOR_RW','198009015080','FOLKSAM','DJURSKADOR','Djur-skador','FOGS20'),('CPE_FOLKSAM_EKONOMI_ADMIN','198009015080','FOLKSAM','EKONOMI',NULL,'FGMB21'),('CPE_FOLKSAM_EKONOMI_META','199005014050','FOLKSAM','EKONOMI',NULL,'MNAS33'),('CPE_FOLKSAM_EKONOMI_READ','198001011213','FOLKSAM','EKONOMI',NULL,'AGDX67'),('CPE_FOLKSAM_EKONOMI_RW','197609124567','FOLKSAM','EKONOMI',NULL,'SDAA40'),('CPE_FOLKSAM_LIVSFORSAKRING_RW','198009015080','FOLKSAM','LIVSFÖRSÄKRINGAR','Livs-Försäkringar','BAFG56'),('CPE_FOLKSAM_LPSHANDLINGAR_RW','198009015080','FOLKSAM','LPSHANDLINGAR','Lps-Handlingar','ASMK90'),('CPE_FOLKSAM_RISK_ADMIN','200004132233','FOLKSAM','RISK',NULL,'AAFH66'),('CPE_FOLKSAM_RISK_META','197806013060','FOLKSAM','RISK',NULL,'AZNH10'),('CPE_FOLKSAM_RISK_READ','195404113214','FOLKSAM','RISK',NULL,'KALA70'),('CPE_FOLKSAM_RISK_RW','197810018090','FOLKSAM','RISK',NULL,'BADF16'),('CPE_FOLKSAM_SKADOR_ADMIN','195402211455','FOLKSAM','SKADOR',NULL,'CASK50'),('CPE_FOLKSAM_SKADOR_META','197609101156','FOLKSAM','SKADOR',NULL,'KADG80'),('CPE_FOLKSAM_SKADOR_READ','197807014080','FOLKSAM','SKADOR',NULL,'MNAS33'),('CPE_FOLKSAM_SKADOR_RW','196508174132','FOLKSAM','FOLKSAM',NULL,'PARK80');
/*!40000 ALTER TABLE `mm_user_adgroup` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-18 10:57:41
