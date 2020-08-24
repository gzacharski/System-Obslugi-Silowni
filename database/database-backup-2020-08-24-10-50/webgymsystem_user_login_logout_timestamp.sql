-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: webgymsystem
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user_login_logout_timestamp`
--

DROP TABLE IF EXISTS `user_login_logout_timestamp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_login_logout_timestamp` (
  `id` int NOT NULL AUTO_INCREMENT,
  `action` varchar(6) DEFAULT NULL,
  `timestamp` datetime DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_login_lougut_timestamp_users1_idx` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_login_logout_timestamp`
--

LOCK TABLES `user_login_logout_timestamp` WRITE;
/*!40000 ALTER TABLE `user_login_logout_timestamp` DISABLE KEYS */;
INSERT INTO `user_login_logout_timestamp` VALUES (1,'LogIn','2020-08-19 14:51:12',18),(2,'LogIn','2020-08-19 14:51:28',18),(3,'LogIn','2020-08-19 14:52:10',17),(4,'LogOut','2020-08-19 14:52:13',17),(5,'LogIn','2020-08-19 14:59:48',1),(6,'LogOut','2020-08-19 14:59:58',1),(7,'LogIn','2020-08-19 15:50:28',18),(8,'LogOut','2020-08-19 15:51:58',18),(9,'LogIn','2020-08-20 12:01:41',17),(10,'LogOut','2020-08-20 14:17:45',17),(11,'LogIn','2020-08-20 14:17:51',1),(12,'LogOut','2020-08-20 14:17:53',1),(13,'LogIn','2020-08-20 14:18:03',1),(14,'LogOut','2020-08-20 14:18:04',1),(15,'LogIn','2020-08-20 14:20:02',1),(16,'LogOut','2020-08-20 14:20:05',1),(17,'LogIn','2020-08-20 14:20:43',17),(18,'LogOut','2020-08-20 14:20:46',17),(19,'LogIn','2020-08-20 14:21:10',17),(20,'LogOut','2020-08-20 14:21:12',17),(21,'LogIn','2020-08-20 14:23:57',1),(22,'LogOut','2020-08-20 14:23:58',1),(23,'LogIn','2020-08-20 14:24:44',1),(24,'LogOut','2020-08-20 14:24:45',1),(25,'LogIn','2020-08-20 14:26:48',17),(26,'LogOut','2020-08-20 14:26:52',17),(27,'LogIn','2020-08-20 14:33:31',1),(28,'LogOut','2020-08-20 14:33:32',1),(29,'LogIn','2020-08-20 14:36:04',1),(30,'LogOut','2020-08-20 14:36:05',1),(31,'LogIn','2020-08-20 14:58:10',1),(32,'LogOut','2020-08-20 14:58:14',1),(33,'LogIn','2020-08-20 15:04:18',1),(34,'LogOut','2020-08-20 15:04:20',1),(35,'LogIn','2020-08-20 15:05:14',1),(36,'LogOut','2020-08-20 15:05:16',1),(37,'LogIn','2020-08-20 15:06:32',1),(38,'LogOut','2020-08-20 15:06:34',1),(39,'LogIn','2020-08-20 15:10:35',1),(40,'LogIn','2020-08-20 15:11:00',1),(41,'LogOut','2020-08-20 15:11:01',1),(42,'LogIn','2020-08-20 15:12:01',1),(43,'LogOut','2020-08-20 15:12:03',1),(44,'LogIn','2020-08-20 15:17:10',1),(45,'LogIn','2020-08-20 15:22:36',1),(46,'LogOut','2020-08-20 15:22:37',1),(47,'LogIn','2020-08-20 15:35:53',1),(48,'LogOut','2020-08-20 15:35:54',1),(49,'LogIn','2020-08-20 15:40:53',1),(50,'LogOut','2020-08-20 15:40:56',1),(51,'LogIn','2020-08-20 15:41:40',1),(52,'LogIn','2020-08-20 15:46:34',1),(53,'LogIn','2020-08-20 15:48:43',1),(54,'LogOut','2020-08-20 15:48:44',1),(55,'LogIn','2020-08-20 15:54:43',1),(56,'LogOut','2020-08-20 15:54:45',1),(57,'LogIn','2020-08-20 15:55:52',1),(58,'LogOut','2020-08-20 15:55:54',1),(59,'LogIn','2020-08-20 15:56:49',1),(60,'LogOut','2020-08-20 15:56:50',1),(61,'LogIn','2020-08-20 15:57:44',17),(62,'LogIn','2020-08-20 20:40:34',17),(63,'LogOut','2020-08-20 21:01:09',17),(64,'LogIn','2020-08-21 09:24:08',17),(65,'LogOut','2020-08-21 09:47:52',17),(66,'LogIn','2020-08-24 07:22:21',17),(67,'LogIn','2020-08-24 08:16:28',1),(68,'LogOut','2020-08-24 08:16:36',1),(69,'LogIn','2020-08-24 08:16:42',17);
/*!40000 ALTER TABLE `user_login_logout_timestamp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-24 10:49:56
