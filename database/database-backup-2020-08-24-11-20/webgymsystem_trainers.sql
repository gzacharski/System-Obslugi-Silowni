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
-- Table structure for table `trainers`
--

DROP TABLE IF EXISTS `trainers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trainers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_polish_ci DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_polish_ci DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`,`user_id`),
  KEY `fk_trainers_users1_idx` (`user_id`),
  CONSTRAINT `fk_trainers_users1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trainers`
--

LOCK TABLES `trainers` WRITE;
/*!40000 ALTER TABLE `trainers` DISABLE KEYS */;
INSERT INTO `trainers` VALUES (9,'Aenean in varius libero, nec tristique leo. Aenean luctus arcu eget suscipit vulputate. Fusce leo quam, tristique sed malesuada vitae, ultrices sit amet nunc. Aenean nec condimentum ipsum. Suspendisse vel purus ut nisl dapibus eleifend. Nullam in gravida.','img/PawelCieslak.png',18),(10,'Curabitur aliquam faucibus diam, ac aliquam magna fringilla vulputate. Curabitur at libero ac felis dictum finibus vel quis felis. Quisque tellus orci, porttitor in suscipit id, iaculis quis dolor. Nam a dignissim lectus. Nunc volutpat purus quis quam ex.','img/AdrianPuchacki.png',20),(11,'Donec sit amet sapien sed turpis vulputate pharetra vel viverra nibh. Fusce dictum, turpis in iaculis ornare, felis orci vulputate felis, id feugiat mauris nisl vitae nulla. Curabitur eget fringilla ligula, tempor vestibulum mauris. Etiam finibus vivamus.','img/DzikiTrener2.jpg',21),(12,'Sed mollis tempor mauris, nec vehicula mi convallis eget. Fusce vel est orci. Integer vestibulum, ante vitae rhoncus tincidunt, risus libero tincidunt metus, sed blandit urna massa ac lectus. Nullam varius quam libero, tempus sodales dolor condimentum ac.','img/WieslawPuchacki.jpg',22),(13,'Donec erat lectus, ultrices sit amet efficitur eu, posuere facilisis lacus. Proin imperdiet, tortor quis commodo ornare, orci nisl tincidunt est, eu placerat turpis neque ut est. Fusce sit amet enim urna. Integer ut enim sit amet ligula fringilla posuere.','img/pamelaReif.jpg',18),(14,'Proin quis imperdiet ligula. Mauris luctus odio eget mauris dignissim porttitor. Vivamus tempor tellus risus, ultricies viverra turpis maximus sed. In hac habitasse platea dictumst. Duis aliquam erat purus, id eleifend tortor blandit a. Integer quis cras.','img/czarnyFuriat.jpg',23);
/*!40000 ALTER TABLE `trainers` ENABLE KEYS */;
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
