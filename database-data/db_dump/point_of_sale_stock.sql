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
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `id` char(36) NOT NULL DEFAULT 'UUID()',
  `product_id` char(36) NOT NULL,
  `date` datetime NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_id_UNIQUE` (`product_id`),
  KEY `fk_stock_product_id_idx` (`product_id`),
  CONSTRAINT `fk_stock_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES ('5df97724-ee55-11ef-b12d-3e72843faead','a25ca8da-eca4-11ef-b97f-786697c0fdb4','2025-02-06 01:06:28',54),('5df987a0-ee55-11ef-b12d-3e72843faead','a25ce836-eca4-11ef-b97f-786697c0fdb4','2025-02-18 01:06:28',82),('5df9898a-ee55-11ef-b12d-3e72843faead','a25ced0e-eca4-11ef-b97f-786697c0fdb4','2025-01-25 01:06:28',87),('5df98a52-ee55-11ef-b12d-3e72843faead','a25cee08-eca4-11ef-b97f-786697c0fdb4','2025-01-29 01:06:28',96),('5df98b10-ee55-11ef-b12d-3e72843faead','a25cee9e-eca4-11ef-b97f-786697c0fdb4','2025-01-30 01:06:28',54),('5df98bce-ee55-11ef-b12d-3e72843faead','a25cef2a-eca4-11ef-b97f-786697c0fdb4','2025-02-06 01:06:28',79),('5df98c78-ee55-11ef-b12d-3e72843faead','a25cefc0-eca4-11ef-b97f-786697c0fdb4','2025-02-05 01:06:28',24),('5df98d18-ee55-11ef-b12d-3e72843faead','a25cf042-eca4-11ef-b97f-786697c0fdb4','2025-02-10 01:06:28',18),('5df98dc2-ee55-11ef-b12d-3e72843faead','a25cf0e2-eca4-11ef-b97f-786697c0fdb4','2025-02-04 01:06:28',40),('5df98e62-ee55-11ef-b12d-3e72843faead','a25cf164-eca4-11ef-b97f-786697c0fdb4','2025-02-16 01:06:28',57),('5df98f2a-ee55-11ef-b12d-3e72843faead','a25cf1f0-eca4-11ef-b97f-786697c0fdb4','2025-02-10 01:06:28',100),('5df98fca-ee55-11ef-b12d-3e72843faead','a25cf27c-eca4-11ef-b97f-786697c0fdb4','2025-02-19 01:06:28',19),('5df99074-ee55-11ef-b12d-3e72843faead','a25cf308-eca4-11ef-b97f-786697c0fdb4','2025-02-05 01:06:28',13),('5df99114-ee55-11ef-b12d-3e72843faead','a25cf394-eca4-11ef-b97f-786697c0fdb4','2025-01-27 01:06:28',89),('5df991aa-ee55-11ef-b12d-3e72843faead','a25cf420-eca4-11ef-b97f-786697c0fdb4','2025-01-22 01:06:28',24),('5df9924a-ee55-11ef-b12d-3e72843faead','a25cf4a2-eca4-11ef-b97f-786697c0fdb4','2025-01-23 01:06:28',22),('5df992f4-ee55-11ef-b12d-3e72843faead','a25cf542-eca4-11ef-b97f-786697c0fdb4','2025-01-23 01:06:28',21),('5df9938a-ee55-11ef-b12d-3e72843faead','a25cf5d8-eca4-11ef-b97f-786697c0fdb4','2025-01-23 01:06:28',28),('5df99434-ee55-11ef-b12d-3e72843faead','a25cf65a-eca4-11ef-b97f-786697c0fdb4','2025-02-11 01:06:28',84),('5df994d4-ee55-11ef-b12d-3e72843faead','a25cf6dc-eca4-11ef-b97f-786697c0fdb4','2025-02-12 01:06:28',75),('5df99574-ee55-11ef-b12d-3e72843faead','fffbac3e-eca4-11ef-b97f-786697c0fdb4','2025-01-25 01:06:28',26),('5df9960a-ee55-11ef-b12d-3e72843faead','fffbb7e2-eca4-11ef-b97f-786697c0fdb4','2025-02-09 01:06:28',20),('5df996aa-ee55-11ef-b12d-3e72843faead','fffbb97c-eca4-11ef-b97f-786697c0fdb4','2025-02-02 01:06:28',58),('5df99740-ee55-11ef-b12d-3e72843faead','fffbba58-eca4-11ef-b97f-786697c0fdb4','2025-01-22 01:06:28',25),('5df99808-ee55-11ef-b12d-3e72843faead','fffbbc38-eca4-11ef-b97f-786697c0fdb4','2025-01-21 01:06:28',42),('5df99902-ee55-11ef-b12d-3e72843faead','fffbbd14-eca4-11ef-b97f-786697c0fdb4','2025-01-25 01:06:28',30),('5df999ac-ee55-11ef-b12d-3e72843faead','fffbbdd2-eca4-11ef-b97f-786697c0fdb4','2025-02-03 01:06:28',22),('5df99a4c-ee55-11ef-b12d-3e72843faead','fffbbecc-eca4-11ef-b97f-786697c0fdb4','2025-02-19 01:06:28',69),('5df99ae2-ee55-11ef-b12d-3e72843faead','fffbc020-eca4-11ef-b97f-786697c0fdb4','2025-02-12 01:06:28',30),('5df99b82-ee55-11ef-b12d-3e72843faead','fffbc0d4-eca4-11ef-b97f-786697c0fdb4','2025-02-07 01:06:28',45),('5df99c18-ee55-11ef-b12d-3e72843faead','fffbc188-eca4-11ef-b97f-786697c0fdb4','2025-01-30 01:06:28',34),('5df99cae-ee55-11ef-b12d-3e72843faead','fffbc232-eca4-11ef-b97f-786697c0fdb4','2025-02-11 01:06:28',63),('5df99d4e-ee55-11ef-b12d-3e72843faead','fffbc2d2-eca4-11ef-b97f-786697c0fdb4','2025-02-16 01:06:28',84),('5df9a122-ee55-11ef-b12d-3e72843faead','fffbc37c-eca4-11ef-b97f-786697c0fdb4','2025-01-28 01:06:28',39),('5df9a208-ee55-11ef-b12d-3e72843faead','fffbc43a-eca4-11ef-b97f-786697c0fdb4','2025-02-09 01:06:28',76),('5df9a320-ee55-11ef-b12d-3e72843faead','fffbc4e4-eca4-11ef-b97f-786697c0fdb4','2025-02-01 01:06:28',93),('5df9a3d4-ee55-11ef-b12d-3e72843faead','fffbc5f2-eca4-11ef-b97f-786697c0fdb4','2025-01-29 01:06:28',85),('5df9a474-ee55-11ef-b12d-3e72843faead','fffbc69c-eca4-11ef-b97f-786697c0fdb4','2025-02-19 01:06:28',60),('5df9a50a-ee55-11ef-b12d-3e72843faead','fffbc746-eca4-11ef-b97f-786697c0fdb4','2025-01-27 01:06:28',24),('5df9a5aa-ee55-11ef-b12d-3e72843faead','fffbc7f0-eca4-11ef-b97f-786697c0fdb4','2025-02-05 01:06:28',98),('5df9a64a-ee55-11ef-b12d-3e72843faead','fffbc89a-eca4-11ef-b97f-786697c0fdb4','2025-02-07 01:06:28',20),('5df9a6e0-ee55-11ef-b12d-3e72843faead','fffbc944-eca4-11ef-b97f-786697c0fdb4','2025-02-09 01:06:28',46),('5df9a776-ee55-11ef-b12d-3e72843faead','fffbc9ee-eca4-11ef-b97f-786697c0fdb4','2025-01-22 01:06:28',61),('5df9a80c-ee55-11ef-b12d-3e72843faead','fffbcaa2-eca4-11ef-b97f-786697c0fdb4','2025-01-21 01:06:28',28),('5df9a8ac-ee55-11ef-b12d-3e72843faead','fffbcb42-eca4-11ef-b97f-786697c0fdb4','2025-02-18 01:06:28',69),('5df9a938-ee55-11ef-b12d-3e72843faead','fffbcc00-eca4-11ef-b97f-786697c0fdb4','2025-02-16 01:06:28',69),('5df9aa32-ee55-11ef-b12d-3e72843faead','fffbccaa-eca4-11ef-b97f-786697c0fdb4','2025-01-24 01:06:28',57),('5df9aad2-ee55-11ef-b12d-3e72843faead','fffbcd54-eca4-11ef-b97f-786697c0fdb4','2025-01-23 01:06:28',17),('5df9ab72-ee55-11ef-b12d-3e72843faead','fffbcdfe-eca4-11ef-b97f-786697c0fdb4','2025-02-01 01:06:28',91),('5df9ac12-ee55-11ef-b12d-3e72843faead','fffbced0-eca4-11ef-b97f-786697c0fdb4','2025-02-02 01:06:28',35),('5df9ae7e-ee55-11ef-b12d-3e72843faead','fffbcf84-eca4-11ef-b97f-786697c0fdb4','2025-02-01 01:06:28',33),('5df9b05e-ee55-11ef-b12d-3e72843faead','fffbd038-eca4-11ef-b97f-786697c0fdb4','2025-02-07 01:06:28',42),('5df9b22a-ee55-11ef-b12d-3e72843faead','fffbd0e2-eca4-11ef-b97f-786697c0fdb4','2025-02-04 01:06:28',54),('5df9b2d4-ee55-11ef-b12d-3e72843faead','fffbd196-eca4-11ef-b97f-786697c0fdb4','2025-01-23 01:06:28',23),('5df9b36a-ee55-11ef-b12d-3e72843faead','fffbd240-eca4-11ef-b97f-786697c0fdb4','2025-01-22 01:06:28',41),('5df9b40a-ee55-11ef-b12d-3e72843faead','fffbd2e0-eca4-11ef-b97f-786697c0fdb4','2025-01-25 01:06:28',35);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-20  0:35:03
