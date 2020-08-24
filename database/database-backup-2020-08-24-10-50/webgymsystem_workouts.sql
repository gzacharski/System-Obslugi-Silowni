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
-- Table structure for table `workouts`
--

DROP TABLE IF EXISTS `workouts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workouts` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type_of_workout` varchar(255) CHARACTER SET utf8 COLLATE utf8_polish_ci DEFAULT NULL,
  `description` varchar(511) CHARACTER SET utf8 COLLATE utf8_polish_ci DEFAULT NULL,
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_polish_ci DEFAULT NULL,
  `duration` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workouts`
--

LOCK TABLES `workouts` WRITE;
/*!40000 ALTER TABLE `workouts` DISABLE KEYS */;
INSERT INTO `workouts` VALUES (13,'Pilates','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec porttitor auctor ligula at pretium. Nunc et ligula purus. Maecenas rutrum, augue sed egestas gravida, ante augue commodo neque, nec tincidunt massa nisi ac nibh. Vivamus feugiat, risus vel vestibulum dapibus, ipsum risus volutpat tellus, at viverra purus odio sed dui. Vestibulum accumsan finibus tellus nec tempor. Praesent porttitor vitae urna nec consequat. Aenean ut pharetra neque, nec elementum quam. Maecenas eu ultricies tellus. ','img/pilates.jpg','00:00:10'),(14,'Rowery','Ut quis ipsum dui. Praesent lobortis nisi vitae est blandit, euismod finibus nunc imperdiet. Vivamus quis turpis vehicula ante tempus feugiat. Proin ultricies ullamcorper odio, ac fringilla felis. Suspendisse nec nisl justo. Mauris sagittis congue metus, id tristique odio blandit sit amet. Pellentesque consequat felis in purus sagittis egestas. In interdum metus nisl, sit amet suscipit erat ultrices quis. Donec nisi ligula, posuere non fermentum vitae, bibendum et urna. Praesent interdum risus nec egestas.','img/rowery.jpg','00:30:10'),(15,'Sztangi','Aliquam erat volutpat. Quisque vulputate nulla et elit viverra, sed sollicitudin ex mattis. Donec rutrum risus id finibus sagittis. Fusce mauris libero, vehicula quis est nec, fermentum convallis odio. Nulla vel sollicitudin augue. Maecenas varius bibendum diam, ac sagittis dui facilisis ut. Suspendisse potenti. Nullam rhoncus sapien vitae egestas dapibus. Aenean vel consequat massa. Cras id ornare elit, vitae lacinia urna. Vivamus euismod porta nibh, nec mollis lacus rhoncus ut. Nam nec libero quis proin.','img/sztangi.jpg','00:10:10'),(16,'Yoga','Vestibulum aliquet dui ac nulla elementum facilisis vitae vitae leo. Aliquam erat volutpat. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris vitae mollis nunc. Praesent et orci ut nisl iaculis vestibulum. Cras finibus posuere nunc vel viverra. Vestibulum imperdiet porttitor nisi, vitae vestibulum urna. Suspendisse egestas lacinia convallis.','img/yoga.jpg','00:10:10'),(17,'Zumba','Nam mattis urna in blandit aliquam. Fusce mattis urna sit amet ante convallis laoreet. Nullam at porta nibh, vel lobortis lectus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eget ornare velit. Quisque mattis purus nisl, aliquet rhoncus nunc laoreet a. Nam pharetra sapien lorem, eget aliquet justo sagittis quis. Phasellus sit amet mi volutpat, lacinia enim vitae, faucibus leo. Mauris a nulla et diam ornare semper. Cras non malesuada velit, vitae luctus sapien. Mauris felis lacus eleifend.','img/zumba.jpg','00:10:10'),(18,'ABS','Nunc tempor nulla nec leo tristique rhoncus. Nam in quam a tellus commodo tempor ut vel ante. Mauris porta vulputate purus eu faucibus. Phasellus magna justo, vestibulum ac fringilla sed, ultricies et libero. Pellentesque habitant morbi tristique senectus','img/absWorkout.jpg','23:30:00');
/*!40000 ALTER TABLE `workouts` ENABLE KEYS */;
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
