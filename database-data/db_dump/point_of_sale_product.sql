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
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` char(36) NOT NULL DEFAULT 'UUID()',
  `name` varchar(45) NOT NULL,
  `weight` decimal(10,2) NOT NULL,
  `unit_type` varchar(20) NOT NULL,
  `department` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('a25ca8da-eca4-11ef-b97f-786697c0fdb4','Coca Cola',1.50,'L','Bevande'),('a25ce836-eca4-11ef-b97f-786697c0fdb4','Pepsi',1.50,'L','Bevande'),('a25ced0e-eca4-11ef-b97f-786697c0fdb4','Fanta',1.50,'L','Bevande'),('a25cee08-eca4-11ef-b97f-786697c0fdb4','Sprite',1.50,'L','Bevande'),('a25cee9e-eca4-11ef-b97f-786697c0fdb4','Red Bull',0.25,'L','Bevande'),('a25cef2a-eca4-11ef-b97f-786697c0fdb4','Patatine Lays',0.30,'Kg','Snack'),('a25cefc0-eca4-11ef-b97f-786697c0fdb4','Popcorn Caramellati',0.20,'Kg','Snack'),('a25cf042-eca4-11ef-b97f-786697c0fdb4','Cioccolato Fondente',0.15,'Kg','Dolci'),('a25cf0e2-eca4-11ef-b97f-786697c0fdb4','Biscotti Oreo',0.25,'Kg','Dolci'),('a25cf164-eca4-11ef-b97f-786697c0fdb4','Latte Intero',1.00,'L','Latticini'),('a25cf1f0-eca4-11ef-b97f-786697c0fdb4','Formaggio Parmigiano',0.50,'Kg','Latticini'),('a25cf27c-eca4-11ef-b97f-786697c0fdb4','Prosciutto Crudo',0.80,'Kg','Salumi'),('a25cf308-eca4-11ef-b97f-786697c0fdb4','Petto di Pollo',1.00,'Kg','Carne'),('a25cf394-eca4-11ef-b97f-786697c0fdb4','Mela Golden',0.20,'Kg','Frutta'),('a25cf420-eca4-11ef-b97f-786697c0fdb4','Banana',0.22,'Kg','Frutta'),('a25cf4a2-eca4-11ef-b97f-786697c0fdb4','Carote',0.50,'Kg','Verdura'),('a25cf542-eca4-11ef-b97f-786697c0fdb4','Pane Integrale',0.40,'Kg','Panetteria'),('a25cf5d8-eca4-11ef-b97f-786697c0fdb4','Riso Basmati',1.00,'Kg','Cereali'),('a25cf65a-eca4-11ef-b97f-786697c0fdb4','Spaghetti Barilla',0.50,'Kg','Pasta'),('a25cf6dc-eca4-11ef-b97f-786697c0fdb4','Olio Extra Vergine',1.00,'L','Condimenti'),('fffbac3e-eca4-11ef-b97f-786697c0fdb4','Acqua Naturale Sant\'Anna',1.50,'L','Bevande'),('fffbb7e2-eca4-11ef-b97f-786697c0fdb4','Acqua Frizzante Levissima',1.50,'L','Bevande'),('fffbb97c-eca4-11ef-b97f-786697c0fdb4','Succo di Arancia Tropicana',1.00,'L','Bevande'),('fffbba58-eca4-11ef-b97f-786697c0fdb4','Tè Freddo Lipton Pesca',1.50,'L','Bevande'),('fffbbc38-eca4-11ef-b97f-786697c0fdb4','Tè Verde Arizona',0.50,'L','Bevande'),('fffbbd14-eca4-11ef-b97f-786697c0fdb4','Caffè Espresso Illy',0.25,'Kg','Bevande'),('fffbbdd2-eca4-11ef-b97f-786697c0fdb4','Latte di Soia Alpro',1.00,'L','Bevande'),('fffbbecc-eca4-11ef-b97f-786697c0fdb4','Crackers Mulino Bianco',0.30,'Kg','Snack'),('fffbc020-eca4-11ef-b97f-786697c0fdb4','Gallette di Riso Scotti',0.20,'Kg','Snack'),('fffbc0d4-eca4-11ef-b97f-786697c0fdb4','Nutella Ferrero',0.75,'Kg','Dolci'),('fffbc188-eca4-11ef-b97f-786697c0fdb4','Miele di Acacia Rigoni',0.50,'Kg','Dolci'),('fffbc232-eca4-11ef-b97f-786697c0fdb4','Caramelle Haribo Gommose',0.30,'Kg','Dolci'),('fffbc2d2-eca4-11ef-b97f-786697c0fdb4','Cioccolato Kinder Bueno',0.40,'Kg','Dolci'),('fffbc37c-eca4-11ef-b97f-786697c0fdb4','Mozzarella di Bufala',0.25,'Kg','Latticini'),('fffbc43a-eca4-11ef-b97f-786697c0fdb4','Yogurt Magro Müller',0.50,'L','Latticini'),('fffbc4e4-eca4-11ef-b97f-786697c0fdb4','Burro Lurpak',0.25,'Kg','Latticini'),('fffbc5f2-eca4-11ef-b97f-786697c0fdb4','Latte di Capra Granarolo',1.00,'L','Latticini'),('fffbc69c-eca4-11ef-b97f-786697c0fdb4','Filetto di Manzo',0.50,'Kg','Carne'),('fffbc746-eca4-11ef-b97f-786697c0fdb4','Salmone Affumicato',0.20,'Kg','Pesce'),('fffbc7f0-eca4-11ef-b97f-786697c0fdb4','Tonno Fresco',0.30,'Kg','Pesce'),('fffbc89a-eca4-11ef-b97f-786697c0fdb4','Pollo Intero',1.20,'Kg','Carne'),('fffbc944-eca4-11ef-b97f-786697c0fdb4','Bresaola della Valtellina',0.15,'Kg','Salumi'),('fffbc9ee-eca4-11ef-b97f-786697c0fdb4','Fragole Fresche',0.25,'Kg','Frutta'),('fffbcaa2-eca4-11ef-b97f-786697c0fdb4','Uva Bianca',0.50,'Kg','Frutta'),('fffbcb42-eca4-11ef-b97f-786697c0fdb4','Zucchine Verdi',0.40,'Kg','Verdura'),('fffbcc00-eca4-11ef-b97f-786697c0fdb4','Melanzane Viola',0.60,'Kg','Verdura'),('fffbccaa-eca4-11ef-b97f-786697c0fdb4','Peperoni Rossi',0.50,'Kg','Verdura'),('fffbcd54-eca4-11ef-b97f-786697c0fdb4','Cipolle Dorate',0.40,'Kg','Verdura'),('fffbcdfe-eca4-11ef-b97f-786697c0fdb4','Penne Rigate Barilla',0.50,'Kg','Pasta'),('fffbced0-eca4-11ef-b97f-786697c0fdb4','Fusilli Integrali De Cecco',0.50,'Kg','Pasta'),('fffbcf84-eca4-11ef-b97f-786697c0fdb4','Farro Decorticato',1.00,'Kg','Cereali'),('fffbd038-eca4-11ef-b97f-786697c0fdb4','Quinoa Biologica',0.50,'Kg','Cereali'),('fffbd0e2-eca4-11ef-b97f-786697c0fdb4','Aceto Balsamico di Modena',0.50,'L','Condimenti'),('fffbd196-eca4-11ef-b97f-786697c0fdb4','Salsa di Soia Kikkoman',0.25,'L','Condimenti'),('fffbd240-eca4-11ef-b97f-786697c0fdb4','Sale Marino Fino',1.00,'Kg','Condimenti'),('fffbd2e0-eca4-11ef-b97f-786697c0fdb4','Pepe Nero in Grani',0.10,'Kg','Condimenti');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-22  2:58:26
