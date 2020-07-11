CREATE DATABASE  IF NOT EXISTS `bd_insn` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_insn`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_insn
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `bien`
--

DROP TABLE IF EXISTS `bien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bien` (
  `idBien` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(90) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `tipo` int(11) DEFAULT NULL,
  `fechaRegistro` date DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idBien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bien`
--

LOCK TABLES `bien` WRITE;
/*!40000 ALTER TABLE `bien` DISABLE KEYS */;
/*!40000 ALTER TABLE `bien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `cod_cargo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES (1,'Técnico de Almacén y Distribución'),(2,'Almacenero de Orden de Compra'),(3,'Almacenero de Donación');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo_enlace`
--

DROP TABLE IF EXISTS `cargo_enlace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo_enlace` (
  `idCargo` int(11) NOT NULL,
  `idEnlace` int(11) NOT NULL,
  PRIMARY KEY (`idCargo`,`idEnlace`),
  KEY `fk_CARGO_has_ENLACE_ENLACE1_idx` (`idEnlace`),
  KEY `fk_CARGO_has_ENLACE_CARGO1_idx` (`idCargo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo_enlace`
--

LOCK TABLES `cargo_enlace` WRITE;
/*!40000 ALTER TABLE `cargo_enlace` DISABLE KEYS */;
/*!40000 ALTER TABLE `cargo_enlace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enlace`
--

DROP TABLE IF EXISTS `enlace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enlace` (
  `idEnlace` int(11) NOT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `ruta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEnlace`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enlace`
--

LOCK TABLES `enlace` WRITE;
/*!40000 ALTER TABLE `enlace` DISABLE KEYS */;
INSERT INTO `enlace` VALUES (1,'Mantener Bienes','mantenerBienes.jsp'),(2,'Mantener Donaciones','mantenerDonaciones.jsp'),(3,'Mantener Donadores','mantenerDonadores.jsp'),(4,'Mantener Ordenes De Compra','mantenerOrdenesDeCompra.jsp'),(5,'Mantener Proveedores','mantenerProveedores.jsp'),(6,'Mantener Usuarios','mantenerUsuarios.jsp'),(7,'Registrar Orden de Compra','RegistrarOrdenDeCompra.jsp'),(8,'Registrar Nota de Entrada','RegistrarNotaDeEntrada.jsp'),(9,'Registrar Donacion','RegistrarDonacion.jsp'),(10,'Registrar Donador','RegistrarDonador.jsp'),(11,'Consultar Donante','consultaDonante.jsp'),(12,'Consultar Proveedor','consultaProveedor.jsp');
/*!40000 ALTER TABLE `enlace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidadorganica`
--

DROP TABLE IF EXISTS `unidadorganica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidadorganica` (
  `idUnidad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(90) DEFAULT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `anexo` varchar(5) DEFAULT NULL,
  `jefeEncargado` int(11) DEFAULT NULL,
  `fechaRegistro` date DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUnidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidadorganica`
--

LOCK TABLES `unidadorganica` WRITE;
/*!40000 ALTER TABLE `unidadorganica` DISABLE KEYS */;
/*!40000 ALTER TABLE `unidadorganica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nroDocumento` varchar(8) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `nombres` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `clave` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `fechaRegistro` date DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `idCargo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,NULL,'Ramirez','Juan','juan','juan','juramirez@insn.gob.pe','2017-10-06',1,NULL),(2,NULL,'Carvajal','Luis','luis','luis','lucarvajal@insn.gob.pe','2016-08-09',1,NULL),(3,NULL,'Condezo','David','david','david','dacondezo@insn.gob.pe','2017-04-22',1,NULL),(4,NULL,'Arbulu','Ernesto','ernesto','ernesto','erarbulu@insn.gob.pe','2016-11-12',1,NULL),(5,NULL,'Palomino','Luis','luisito','luisito','lupalomino@insn.gob.p0e','2016-01-12',1,NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bd_insn'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-10 13:24:29
