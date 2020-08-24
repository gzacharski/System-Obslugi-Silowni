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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `surname` varchar(255) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_polish_ci DEFAULT NULL,
  `password` varchar(80) CHARACTER SET utf8 COLLATE utf8_polish_ci NOT NULL,
  `user_details_id` int DEFAULT NULL,
  `user_address_id` int DEFAULT NULL,
  `user_agreements_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`) /*!80000 INVISIBLE */,
  UNIQUE KEY `user_details_id_UNIQUE` (`user_details_id`),
  UNIQUE KEY `user_address_id_UNIQUE` (`user_address_id`),
  UNIQUE KEY `user_agreements_id_UNIQUE` (`user_agreements_id`),
  KEY `fk_clients_clients_details_id_idx` (`user_details_id`) /*!80000 INVISIBLE */,
  KEY `fk_clients_client_address_id_idx` (`user_address_id`) /*!80000 INVISIBLE */,
  KEY `fk_clients_client_agreements_id_idx` (`user_agreements_id`),
  CONSTRAINT `fk_users_user_address_id` FOREIGN KEY (`user_address_id`) REFERENCES `user_address` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_users_user_agreements_id` FOREIGN KEY (`user_agreements_id`) REFERENCES `user_agreements` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_users_user_details_id` FOREIGN KEY (`user_details_id`) REFERENCES `user_details` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Grzegorz','Zacharski','g.zacharski@wp.pl','665762682','$2a$10$5uvMrvwL5aXT3MNJ00q/y.V1M3Gr7YlClbRHah/iABZrIMPX94ZMe',NULL,NULL,NULL),(17,'Wojciech','Zacharski','w.zacharski@wp.pl','665762682','$2a$10$iXHMg13yFiV3.GsbgwKO6.r4dNbhlP9m4TNUDUTYZw62OxbIgecQK',NULL,NULL,NULL),(18,'Pamela','Reif','pamela.reif@mygym.com',NULL,'$2a$10$DxBclHtu/Irjvc.rdccHA.pqh.ycFIoONIMJ5bNQvVTugVYpv.mC2',NULL,NULL,NULL),(19,'Pawel','Cieslak','pawel.cieslak@mygym.com',NULL,'$2a$10$JrjNWie2seIu39KIatSuKu5H7ZwPsMziXkKApMttVqmvlOqlsf5Ki',NULL,NULL,NULL),(20,'Adrian','Puchacki','adrian.puchacki@mygym.com',NULL,'$2a$10$ByOgEqKhQubz1Ja0lqX5JOt3ZiVRIbiQBrb755VjzJ/a0PkVe.ora',NULL,NULL,NULL),(21,'Dziki','Trener','dziki.trener@mygym.com',NULL,'$2a$10$H.Le4LYg9fwgoU66w90pfe2lNtixvabGyLMKARNLFzVYQaADn7f7q',NULL,NULL,NULL),(22,'Wieslaw','Puchacki','wieslaw.puchacki@mygym.com',NULL,'$2a$10$JBcpmWcBSeYmUuQLx/sVkOawsdKyRz7bUdUuFLcdew16kVA08B/9e',NULL,NULL,NULL),(23,'Janek','Kowalski','jan.kowalski@mygym.com',NULL,'$2a$10$LG8QuqPZ9nwYE8OJd7O7gOGkT6o1exJ0ZKyhT6WIfxb66E2II5nVC',NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-24 10:49:57
