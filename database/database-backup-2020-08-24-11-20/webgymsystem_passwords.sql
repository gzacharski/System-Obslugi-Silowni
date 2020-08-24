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
-- Table structure for table `passwords`
--

DROP TABLE IF EXISTS `passwords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passwords` (
  `password` varchar(80) NOT NULL,
  `users_id` int NOT NULL,
  PRIMARY KEY (`users_id`),
  KEY `fk_passwords_users1_idx` (`users_id`),
  CONSTRAINT `fk_passwords_users_id` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passwords`
--

LOCK TABLES `passwords` WRITE;
/*!40000 ALTER TABLE `passwords` DISABLE KEYS */;
INSERT INTO `passwords` VALUES ('$2a$10$5uvMrvwL5aXT3MNJ00q/y.V1M3Gr7YlClbRHah/iABZrIMPX94ZMe',1),('$2a$10$iXHMg13yFiV3.GsbgwKO6.r4dNbhlP9m4TNUDUTYZw62OxbIgecQK',17),('$2a$10$DxBclHtu/Irjvc.rdccHA.pqh.ycFIoONIMJ5bNQvVTugVYpv.mC2',18),('$2a$10$JrjNWie2seIu39KIatSuKu5H7ZwPsMziXkKApMttVqmvlOqlsf5Ki',19),('$2a$10$ByOgEqKhQubz1Ja0lqX5JOt3ZiVRIbiQBrb755VjzJ/a0PkVe.ora',20),('$2a$10$H.Le4LYg9fwgoU66w90pfe2lNtixvabGyLMKARNLFzVYQaADn7f7q',21),('$2a$10$JBcpmWcBSeYmUuQLx/sVkOawsdKyRz7bUdUuFLcdew16kVA08B/9e',22),('$2a$10$LG8QuqPZ9nwYE8OJd7O7gOGkT6o1exJ0ZKyhT6WIfxb66E2II5nVC',23);
/*!40000 ALTER TABLE `passwords` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-24 11:21:11
