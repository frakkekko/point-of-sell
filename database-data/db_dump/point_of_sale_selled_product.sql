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
-- Table structure for table `selled_product`
--

DROP TABLE IF EXISTS `selled_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `selled_product` (
  `id` char(36) NOT NULL DEFAULT 'UUID()',
  `receipt_id` char(36) NOT NULL,
  `barcode_id` char(36) NOT NULL,
  `quantity` int NOT NULL,
  `total` double(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_receipt_idx` (`receipt_id`),
  KEY `fk_selled_product_barcode_id_idx` (`barcode_id`),
  CONSTRAINT `fk_selled_product_barcode_id` FOREIGN KEY (`barcode_id`) REFERENCES `barcode` (`id`),
  CONSTRAINT `fk_selled_product_receipt_id` FOREIGN KEY (`receipt_id`) REFERENCES `receipt` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `selled_product`
--

LOCK TABLES `selled_product` WRITE;
/*!40000 ALTER TABLE `selled_product` DISABLE KEYS */;
INSERT INTO `selled_product` VALUES ('06f5787b-d699-4904-86b4-58a2bbee2a55','0826e795-67cd-473d-8a09-9e5de5ee7b3f','31b40590-ee54-11ef-b12d-3e72843faead',2,7.94),('10f205a8-6a78-4adb-880e-ca41d2bd8ef1','b8dff357-5aa3-42a6-bc43-8e1f45e3dafe','31b40590-ee54-11ef-b12d-3e72843faead',2,7.94),('14a4f2c9-4b10-4c73-bafc-e8566b9c8614','62174b9b-5857-4c00-af15-542ca4e912eb','31b40590-ee54-11ef-b12d-3e72843faead',2,7.94),('1e8e7e9b-4a40-487b-ab1a-233ef8579d2f','c1392d11-775b-4970-ae4a-7b1b0496bf79','31b40590-ee54-11ef-b12d-3e72843faead',2,7.94),('2eb641ea-b9ab-496e-9494-d6a574dcc27d','62174b9b-5857-4c00-af15-542ca4e912eb','31b40ce8-ee54-11ef-b12d-3e72843faead',5,28.85),('920d691e-e841-409a-94fa-52daea78d9d5','0826e795-67cd-473d-8a09-9e5de5ee7b3f','31b489ca-ee54-11ef-b12d-3e72843faead',3,5.25),('947cd73f-27be-40e9-bb1c-b360d8c00bf2','62174b9b-5857-4c00-af15-542ca4e912eb','31b41350-ee54-11ef-b12d-3e72843faead',1,2.26),('9a8d8140-14c4-43aa-8667-2c0fe11aebef','b8dff357-5aa3-42a6-bc43-8e1f45e3dafe','31b40ce8-ee54-11ef-b12d-3e72843faead',5,28.85),('ad053ef3-b03f-4470-a3eb-8f9feab4b593','c1392d11-775b-4970-ae4a-7b1b0496bf79','31b489ca-ee54-11ef-b12d-3e72843faead',3,5.25),('bc464ee1-e9b4-497b-af3a-3d282203fb05','b8dff357-5aa3-42a6-bc43-8e1f45e3dafe','31b41350-ee54-11ef-b12d-3e72843faead',1,2.26);
/*!40000 ALTER TABLE `selled_product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-20  0:35:04
