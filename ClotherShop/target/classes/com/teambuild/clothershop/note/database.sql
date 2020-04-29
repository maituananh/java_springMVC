-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: clothershop
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cart` (
  `idCart` int(11) NOT NULL AUTO_INCREMENT,
  `idUser` int(11) NOT NULL,
  `totalPrice` double NOT NULL,
  PRIMARY KEY (`idCart`),
  UNIQUE KEY `idCart_UNIQUE` (`idCart`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartdetails`
--

DROP TABLE IF EXISTS `cartdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cartdetails` (
  `idCart_CD` int(11) NOT NULL,
  `idProduct_CD` int(11) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`idCart_CD`,`idProduct_CD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartdetails`
--

LOCK TABLES `cartdetails` WRITE;
/*!40000 ALTER TABLE `cartdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `cartdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `color`
--

DROP TABLE IF EXISTS `color`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `color` (
  `idColor` int(11) NOT NULL AUTO_INCREMENT,
  `nameColor` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idColor`),
  UNIQUE KEY `idColor_UNIQUE` (`idColor`),
  UNIQUE KEY `name_UNIQUE` (`nameColor`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `color`
--

LOCK TABLES `color` WRITE;
/*!40000 ALTER TABLE `color` DISABLE KEYS */;
INSERT INTO `color` VALUES (3,'BLACK'),(2,'blue'),(15,'ĐỎ ĐÔ'),(14,'ĐỎ TƯƠI'),(5,'GREEN'),(6,'PINK'),(1,'red'),(16,'XANH LAM'),(4,'YELLOW');
/*!40000 ALTER TABLE `color` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gender` (
  `idGender` int(11) NOT NULL AUTO_INCREMENT,
  `nameGender` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idGender`),
  UNIQUE KEY `idGender_UNIQUE` (`idGender`),
  UNIQUE KEY `nameGender_UNIQUE` (`nameGender`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES (2,'Female'),(1,'Male');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `image` (
  `idImage` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idImage`),
  UNIQUE KEY `idImage_UNIQUE` (`idImage`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,'i1.jpg'),(2,'i2.jpg'),(3,'i3.jpg'),(26,'APSU0400.JPEG'),(27,'EMQO4880.JPEG'),(28,'BAVU1890.JPEG'),(29,'AEAW7256.JPEG'),(30,'ALMU8700.JPEG'),(31,'AZDJ2023.JPEG'),(32,'FBIP5220.JPEG'),(33,'IMG_0004.JPG'),(34,'BQZD2669.JPEG'),(35,'HLYT3071.JPEG'),(36,'HLYT3071.JPEG'),(37,'IMG_0072.JPG'),(38,'AZDJ2023.JPEG'),(39,'ALMU8700.JPEG'),(40,'APSU0400.JPEG'),(41,'APSU0400.JPEG'),(42,'ALMU8700.JPEG'),(43,'BVLB3302.JPEG'),(44,'BAVU1890.JPEG'),(45,'BAVU1890.JPEG'),(46,'GUHN3142.JPEG'),(47,'GUHN3142.JPEG'),(48,'APSU0400.JPEG'),(49,'APSU0400.JPEG'),(50,'57319724_593046877858652_3333621188428562432_n.jpg'),(51,'57319724_593046877858652_3333621188428562432_n.jpg'),(52,'57382293_282418936014844_2511140199694598144_n.jpg'),(53,'57382293_282418936014844_2511140199694598144_n.jpg'),(54,'52759697_2096720020613860_6706902628854398976_n.jpg'),(55,'57319724_593046877858652_3333621188428562432_n.jpg'),(56,'57411739_763930054001199_8602622561047543808_n.jpg'),(57,'57319724_593046877858652_3333621188428562432_n.jpg'),(58,'12java_by_valazeroth_d41h268-1482496987555.jpg'),(59,'57382293_282418936014844_2511140199694598144_n.jpg'),(60,'38901047-java-wallpapers.jpg'),(61,'38901047-java-wallpapers.jpg'),(62,'57382293_282418936014844_2511140199694598144_n.jpg'),(63,'AITZ7571.JPEG'),(64,'38901047-java-wallpapers.jpg'),(65,'99710.jpg'),(66,'avatar-cv.jpg'),(67,'avatar-cv.jpg'),(68,'avatar-cv.jpg'),(69,'Free-Download-1920x1080-Photos.jpg'),(70,'avatar-cv.jpg'),(71,'avatar-cv.jpg');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kind`
--

DROP TABLE IF EXISTS `kind`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `kind` (
  `idKind` int(11) NOT NULL AUTO_INCREMENT,
  `nameKind` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idKind`),
  UNIQUE KEY `idKind_UNIQUE` (`idKind`),
  UNIQUE KEY `name_UNIQUE` (`nameKind`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kind`
--

LOCK TABLES `kind` WRITE;
/*!40000 ALTER TABLE `kind` DISABLE KEYS */;
INSERT INTO `kind` VALUES (2,'Shirt'),(1,'T-Shirt');
/*!40000 ALTER TABLE `kind` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producer`
--

DROP TABLE IF EXISTS `producer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `producer` (
  `idProducer` int(11) NOT NULL AUTO_INCREMENT,
  `nameProducer` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idProducer`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producer`
--

LOCK TABLES `producer` WRITE;
/*!40000 ALTER TABLE `producer` DISABLE KEYS */;
INSERT INTO `producer` VALUES (1,'Nike','hà nội'),(14,'adidas','hòa khánh'),(16,'a','b'),(17,'','');
/*!40000 ALTER TABLE `producer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `idProduct` int(11) NOT NULL AUTO_INCREMENT,
  `codesProduct` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `nameProduct` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `describeProduct` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_vietnamese_ci,
  `idProducer_Product` int(11) DEFAULT NULL,
  `idUser_Product` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `updated_date` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_date` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_time` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idProduct`),
  UNIQUE KEY `codesProduct_UNIQUE` (`codesProduct`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'1','áo balo','hân dung khách hàng là mẫu khách hàng lý tưởng để bạn dựa vào đó nhằm phát triển các kế hoạch truyền thông: bạn phát triển sản phẩm cho người đó, muốn bán hàng cho người đó. Anh ta/ cô ta phản ánh đối tượng khách hàng mục tiêu và có tính thực tế hơn là những miêu tả vu vơ thuộc nhân khẩu học. Bạn cần biết chân dung khách hàng một cách rõ ràng nhằm xác định sản phẩm nào sẽ khiến họ hài lòng hoặc đặt dấu hỏi nghi ngờ. sản phẩm nào khiến họ nhấp vào nút “Mua ngay” hoặc do dự trong việc đặt hàng.',1,1,90,NULL,NULL,'1/9/2019',''),(30,'MA01','áo cặp','áo dành cho những cặp đôi',1,NULL,300,NULL,NULL,'2/9/2019',''),(31,'MA019','quần jeans','quần phong cách',1,NULL,300,NULL,NULL,'3/9/2019',''),(32,'MA0112','khăn cổ','dành cho giới nữ phong cách',1,NULL,50,NULL,NULL,'4/9/2019',''),(33,'MA011','giầy thể thao','lksdfhjkashdfjhasldkjfh2304789723984',1,NULL,200,NULL,NULL,'5/9/2019',''),(35,'MA013','áo ngực','dfhlsajdhfskjdfhlkj3740859073459',1,NULL,900,NULL,NULL,'7/9/2019',''),(39,'MA0144','áo ngắn','sdiufasudfui82374982ifudif',1,NULL,900,NULL,NULL,'10/9/2019',NULL),(40,'MA4','áo ngắn tay','àdhasdkjfhasjd123',1,NULL,100,NULL,NULL,'11/9/2019',NULL),(41,'MA07','giày nike','dfasdfaskjdfks123',1,NULL,900,NULL,NULL,'12/9/2019',NULL),(43,'MA2016','áo quần','dùalsdjflajksdflkj27384',14,NULL,900,'0','0','2019-10-01','11:24:34.046'),(45,'MA012','áo quần bò','sdflsdnflasjdfjkasd',14,NULL,900,'0','0','2019-10-01','11:38:56.487'),(50,'MA011212','test áo','dsadFASDFASDFASDF',14,NULL,900,'0','0','2019-11-05','12:10:40.891');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productdetails`
--

DROP TABLE IF EXISTS `productdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `productdetails` (
  `idProductDetails` int(11) NOT NULL AUTO_INCREMENT,
  `idProduct_DT` int(11) DEFAULT NULL,
  `idSize_DT` int(11) NOT NULL,
  `idColor_DT` int(11) NOT NULL,
  `quality` int(11) NOT NULL,
  `idKind_DT` int(11) NOT NULL,
  `idImage_DT` int(11) NOT NULL,
  PRIMARY KEY (`idProductDetails`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productdetails`
--

LOCK TABLES `productdetails` WRITE;
/*!40000 ALTER TABLE `productdetails` DISABLE KEYS */;
INSERT INTO `productdetails` VALUES (1,1,1,1,10,1,1),(2,1,2,2,12,1,2),(3,1,3,2,23,1,3),(23,30,3,2,12,1,26),(24,30,2,1,12,1,27),(25,31,2,2,123,1,28),(26,31,1,1,12,2,29),(27,31,2,2,123,2,30),(28,32,3,1,33,2,31),(29,32,2,2,12,1,32),(30,NULL,2,2,11,2,70),(31,33,3,1,111,2,34),(35,35,2,1,12,2,38),(36,NULL,3,2,132,1,71),(41,39,2,2,12,2,44),(42,39,1,1,12,2,45),(43,40,2,2,131,1,46),(44,40,1,1,131,2,47),(45,41,2,2,11,2,48),(46,41,2,1,11,2,49),(49,43,3,2,123,2,52),(50,43,3,1,123,1,53),(52,45,2,3,123,2,55),(60,50,1,1,123,1,63);
/*!40000 ALTER TABLE `productdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `role` (
  `idRole` int(11) NOT NULL AUTO_INCREMENT,
  `nameRole` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idRole`),
  UNIQUE KEY `idRole_UNIQUE` (`idRole`),
  UNIQUE KEY `nameRole_UNIQUE` (`nameRole`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Admin'),(2,'User');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size`
--

DROP TABLE IF EXISTS `size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `size` (
  `idSize` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`idSize`),
  UNIQUE KEY `idSize_UNIQUE` (`idSize`),
  UNIQUE KEY `number_UNIQUE` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
INSERT INTO `size` VALUES (1,38),(2,39),(3,40),(4,41);
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `slide`
--

DROP TABLE IF EXISTS `slide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `slide` (
  `idUser_Slide` int(11) NOT NULL,
  `idSlide` int(11) NOT NULL,
  `url` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idSlide`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `slide`
--

LOCK TABLES `slide` WRITE;
/*!40000 ALTER TABLE `slide` DISABLE KEYS */;
INSERT INTO `slide` VALUES (1,1,'b1.jpg'),(1,2,'b2.jpg'),(1,3,'b3.jpg'),(1,4,'b2.jpg');
/*!40000 ALTER TABLE `slide` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `userName` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(11) COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(70) COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `hometown` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int(3) NOT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `avatar` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idRole_User` int(11) DEFAULT NULL,
  `idGender_User` int(11) DEFAULT NULL,
  `idVerificationCodes_User` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'mai tuấn anh','admin','admin','0774349901','196 nguyễn thiện kế, sơn trà, đà nẵng','12-6-1998','đà nẵng',22,'maituananh12061998@gmail.com','KLDC5664.JPEG',1,1,1),(88,'Mai Tuấn Anh','maituananh123','maituananh123Mai',NULL,NULL,'09/20/2019',NULL,0,'mait061998@gmail.com',NULL,2,2,89),(89,'Mai Tuấn Anh','maituananh123456','maituananh123A',NULL,NULL,'09/18/2019',NULL,0,'ma1998@gmail.com',NULL,2,2,90),(90,'Mai Tuấn Anh','maituananh123456897','maituananh123A',NULL,NULL,'09/18/2019',NULL,0,'maituananh1206@gmail.com',NULL,2,2,91),(91,'nguyễn văn a','nguyenvanaaa','0774349901Anh',NULL,NULL,'09/19/2019',NULL,0,'maituananh@gmail.com',NULL,2,2,92);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verification`
--

DROP TABLE IF EXISTS `verification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `verification` (
  `idVerificationCodes` int(11) NOT NULL AUTO_INCREMENT,
  `codes` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idVerificationCodes`),
  UNIQUE KEY `idVerificationCodes_UNIQUE` (`idVerificationCodes`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verification`
--

LOCK TABLES `verification` WRITE;
/*!40000 ALTER TABLE `verification` DISABLE KEYS */;
INSERT INTO `verification` VALUES (1,'123');
/*!40000 ALTER TABLE `verification` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-18 19:11:59
