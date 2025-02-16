-- MySQL dump 10.13  Distrib 8.0.41, for macos15 (arm64)
--
-- Host: 127.0.0.1    Database: point_of_sale
-- ------------------------------------------------------
-- Server version	9.2.0

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
-- Table structure for table `receipt`
--

DROP TABLE IF EXISTS `receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receipt` (
  `id` char(36) NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt`
--

LOCK TABLES `receipt` WRITE;
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
INSERT INTO `receipt` VALUES ('3fe8cc2a-eca8-11ef-b97f-786697c0fdb4','2024-02-26 00:00:00'),('3fe953d4-eca8-11ef-b97f-786697c0fdb4','2024-02-25 00:00:00'),('3fe989ee-eca8-11ef-b97f-786697c0fdb4','2024-01-26 00:00:00'),('3fe9b3d8-eca8-11ef-b97f-786697c0fdb4','2024-02-13 00:00:00'),('3fe9e470-eca8-11ef-b97f-786697c0fdb4','2024-02-27 00:00:00'),('3fea0900-eca8-11ef-b97f-786697c0fdb4','2024-02-14 00:00:00'),('3fea37ae-eca8-11ef-b97f-786697c0fdb4','2024-02-02 00:00:00'),('3fea627e-eca8-11ef-b97f-786697c0fdb4','2024-01-04 00:00:00'),('3fea8ad8-eca8-11ef-b97f-786697c0fdb4','2024-02-27 00:00:00'),('3feaa518-eca8-11ef-b97f-786697c0fdb4','2024-01-07 00:00:00'),('3feabfb2-eca8-11ef-b97f-786697c0fdb4','2024-02-25 00:00:00'),('3fead970-eca8-11ef-b97f-786697c0fdb4','2024-01-31 00:00:00'),('3feb01c0-eca8-11ef-b97f-786697c0fdb4','2024-01-17 00:00:00'),('3feb290c-eca8-11ef-b97f-786697c0fdb4','2024-01-02 00:00:00'),('3feb4446-eca8-11ef-b97f-786697c0fdb4','2024-01-29 00:00:00'),('3feb58b4-eca8-11ef-b97f-786697c0fdb4','2024-01-26 00:00:00'),('3feb73d0-eca8-11ef-b97f-786697c0fdb4','2024-01-21 00:00:00'),('3feb865e-eca8-11ef-b97f-786697c0fdb4','2024-02-05 00:00:00'),('3feb9536-eca8-11ef-b97f-786697c0fdb4','2024-01-15 00:00:00'),('3feba490-eca8-11ef-b97f-786697c0fdb4','2024-02-27 00:00:00'),('3febb890-eca8-11ef-b97f-786697c0fdb4','2024-01-12 00:00:00'),('3febcf6a-eca8-11ef-b97f-786697c0fdb4','2024-01-21 00:00:00'),('3febe5ae-eca8-11ef-b97f-786697c0fdb4','2024-02-28 00:00:00'),('3febfbde-eca8-11ef-b97f-786697c0fdb4','2024-02-21 00:00:00'),('3fec111e-eca8-11ef-b97f-786697c0fdb4','2024-01-15 00:00:00'),('3fec28f2-eca8-11ef-b97f-786697c0fdb4','2024-01-06 00:00:00'),('3fec48c8-eca8-11ef-b97f-786697c0fdb4','2024-01-26 00:00:00'),('3fec5e58-eca8-11ef-b97f-786697c0fdb4','2024-02-22 00:00:00'),('3fec7406-eca8-11ef-b97f-786697c0fdb4','2024-02-10 00:00:00'),('3fec88d8-eca8-11ef-b97f-786697c0fdb4','2024-02-08 00:00:00'),('3fec9f62-eca8-11ef-b97f-786697c0fdb4','2024-02-17 00:00:00'),('3fecb768-eca8-11ef-b97f-786697c0fdb4','2024-01-19 00:00:00'),('3feccf32-eca8-11ef-b97f-786697c0fdb4','2024-01-14 00:00:00'),('3fece634-eca8-11ef-b97f-786697c0fdb4','2024-01-14 00:00:00'),('3fed0394-eca8-11ef-b97f-786697c0fdb4','2024-01-26 00:00:00'),('3fed133e-eca8-11ef-b97f-786697c0fdb4','2024-02-26 00:00:00'),('3fed20b8-eca8-11ef-b97f-786697c0fdb4','2024-01-16 00:00:00'),('3fed2f36-eca8-11ef-b97f-786697c0fdb4','2024-02-09 00:00:00'),('3fed3b02-eca8-11ef-b97f-786697c0fdb4','2024-02-23 00:00:00'),('3fed47aa-eca8-11ef-b97f-786697c0fdb4','2024-02-05 00:00:00'),('3fed52b8-eca8-11ef-b97f-786697c0fdb4','2024-01-01 00:00:00'),('3fed5f7e-eca8-11ef-b97f-786697c0fdb4','2024-01-17 00:00:00'),('3fed6bd6-eca8-11ef-b97f-786697c0fdb4','2024-01-08 00:00:00'),('3fed8652-eca8-11ef-b97f-786697c0fdb4','2024-02-15 00:00:00'),('3fed95c0-eca8-11ef-b97f-786697c0fdb4','2024-01-24 00:00:00'),('3feda0a6-eca8-11ef-b97f-786697c0fdb4','2024-01-02 00:00:00'),('3fedab6e-eca8-11ef-b97f-786697c0fdb4','2024-02-02 00:00:00'),('3fedb640-eca8-11ef-b97f-786697c0fdb4','2024-01-26 00:00:00'),('3fedc1ee-eca8-11ef-b97f-786697c0fdb4','2024-01-30 00:00:00'),('3fedd062-eca8-11ef-b97f-786697c0fdb4','2024-02-29 00:00:00');
/*!40000 ALTER TABLE `receipt` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-16 22:13:56
