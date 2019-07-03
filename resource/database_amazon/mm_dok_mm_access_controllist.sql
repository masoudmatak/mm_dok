-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mm_dok
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
-- Table structure for table `mm_access_controllist`
--

DROP TABLE IF EXISTS `mm_access_controllist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mm_access_controllist` (
  `title` varchar(100) NOT NULL,
  `owner_control` char(1) NOT NULL DEFAULT 'N',
  `modify_content` char(1) NOT NULL DEFAULT 'N',
  `modify_metadata` char(1) NOT NULL DEFAULT 'N',
  `view_content` char(1) NOT NULL DEFAULT 'N',
  `view_metadata` char(1) NOT NULL DEFAULT 'N',
  `publish` char(1) NOT NULL DEFAULT 'N',
  `remove` char(1) NOT NULL DEFAULT 'N',
  `acl_id` int(11) NOT NULL,
  PRIMARY KEY (`acl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mm_access_controllist`
--

LOCK TABLES `mm_access_controllist` WRITE;
/*!40000 ALTER TABLE `mm_access_controllist` DISABLE KEYS */;
INSERT INTO `mm_access_controllist` VALUES ('empolyee','N','N','Y','Y','Y','N','N',1000),('employee minimum','N','N','N','Y','Y','N','N',1001),('employee limited','N','N','N','N','Y','N','N',1002),('full controll','Y','Y','Y','Y','Y','Y','N',2000);
/*!40000 ALTER TABLE `mm_access_controllist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-09 19:35:25
