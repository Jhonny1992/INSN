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
  `cod_bien` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(90) DEFAULT NULL,
  `marca` varchar(45) DEFAULT 'No registra',
  `precio` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `fec_reg` date DEFAULT NULL,
  `estado` varchar(45) NOT NULL DEFAULT 'Habilitado',
  `cod_tipo` int(11) NOT NULL,
  PRIMARY KEY (`cod_bien`,`cod_tipo`),
  KEY `fk_BINES_TIPO_BIEN_idx` (`cod_tipo`),
  CONSTRAINT `fk_BINES_TIPO_BIEN` FOREIGN KEY (`cod_tipo`) REFERENCES `tipo_bien` (`cod_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bien`
--

LOCK TABLES `bien` WRITE;
/*!40000 ALTER TABLE `bien` DISABLE KEYS */;
INSERT INTO `bien` VALUES (1,'Paracetamol 500 mg TAB','Kitadol',0.35,220,'2017-06-29','Habilitado',2),(2,'Electrocardiógrafo','No registra',500,1,'2017-02-20','Habilitado',1),(3,'Maquina de Rayos X','No registra',5000,1,'2016-11-14','Habilitado',1),(4,'Tomografo','No registra',10000,1,'2015-10-18','Habilitado',1),(5,'Saco de Arroz','Paisana',35,30,'2015-09-12','Habilitado',3),(6,'Saco de Lenteja','Tesoro del Campo',70,20,'2015-09-13','Habilitado',3),(7,'Caja de tarros de leche x 24','Gloria',74,10,'2015-09-12','Habilitado',3),(8,'Clotrimazol al 1% Crema','Hongogen',1.5,76,'2017-06-25','Habilitado',2),(9,'Saco de Arroz','Costeño',50,3,'2015-12-17','Habilitado',3);
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
  `cod_cargo` int(11) NOT NULL,
  `idenlace` int(11) NOT NULL,
  PRIMARY KEY (`cod_cargo`,`idenlace`),
  KEY `fk_CARGO_has_ENLACE_ENLACE1_idx` (`idenlace`),
  KEY `fk_CARGO_has_ENLACE_CARGO1_idx` (`cod_cargo`),
  CONSTRAINT `fk_CARGO_has_ENLACE_CARGO1` FOREIGN KEY (`cod_cargo`) REFERENCES `cargo` (`cod_cargo`),
  CONSTRAINT `fk_CARGO_has_ENLACE_ENLACE1` FOREIGN KEY (`idenlace`) REFERENCES `enlace` (`idenlace`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo_enlace`
--

LOCK TABLES `cargo_enlace` WRITE;
/*!40000 ALTER TABLE `cargo_enlace` DISABLE KEYS */;
INSERT INTO `cargo_enlace` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(2,7),(1,8),(3,9),(3,11),(2,12);
/*!40000 ALTER TABLE `cargo_enlace` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo_usuario`
--

DROP TABLE IF EXISTS `cargo_usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo_usuario` (
  `cod_cargo` int(11) NOT NULL,
  `cod_usuario` int(11) NOT NULL,
  PRIMARY KEY (`cod_cargo`,`cod_usuario`),
  KEY `fk_CARGO_has_USUARIO_USUARIO1_idx` (`cod_usuario`),
  KEY `fk_CARGO_has_USUARIO_CARGO1_idx` (`cod_cargo`),
  CONSTRAINT `fk_CARGO_has_USUARIO_CARGO1` FOREIGN KEY (`cod_cargo`) REFERENCES `cargo` (`cod_cargo`),
  CONSTRAINT `fk_CARGO_has_USUARIO_USUARIO1` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo_usuario`
--

LOCK TABLES `cargo_usuario` WRITE;
/*!40000 ALTER TABLE `cargo_usuario` DISABLE KEYS */;
INSERT INTO `cargo_usuario` VALUES (1,1),(2,2),(3,2),(2,3),(2,4),(3,5);
/*!40000 ALTER TABLE `cargo_usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_nota_de_entrada`
--

DROP TABLE IF EXISTS `detalle_nota_de_entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_nota_de_entrada` (
  `num_nota` int(11) NOT NULL,
  `num_orden` int(11) NOT NULL,
  `cod_bien` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`num_nota`,`num_orden`,`cod_bien`),
  KEY `fk_nota_de_entrada_has_bien_nota_de_entrada1_idx` (`num_nota`),
  KEY `fk_nota_de_entrada_has_bien_detalle_orden_compra1_idx` (`num_orden`,`cod_bien`),
  CONSTRAINT `fk_nota_de_entrada_has_bien_detalle_orden_compra1` FOREIGN KEY (`num_orden`, `cod_bien`) REFERENCES `detalle_orden_compra` (`num_orden`, `cod_bien`),
  CONSTRAINT `fk_nota_de_entrada_has_bien_nota_de_entrada1` FOREIGN KEY (`num_nota`) REFERENCES `nota_de_entrada` (`num_nota`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_nota_de_entrada`
--

LOCK TABLES `detalle_nota_de_entrada` WRITE;
/*!40000 ALTER TABLE `detalle_nota_de_entrada` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_nota_de_entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_orden_compra`
--

DROP TABLE IF EXISTS `detalle_orden_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_orden_compra` (
  `num_orden` int(11) NOT NULL,
  `cod_bien` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`num_orden`,`cod_bien`),
  KEY `fk_bien_has_orden_compra_orden_compra1_idx` (`num_orden`),
  KEY `fk_bien_has_orden_compra_bien1_idx` (`cod_bien`),
  CONSTRAINT `fk_bien_has_orden_compra_bien1` FOREIGN KEY (`cod_bien`) REFERENCES `bien` (`cod_bien`),
  CONSTRAINT `fk_bien_has_orden_compra_orden_compra1` FOREIGN KEY (`num_orden`) REFERENCES `orden_compra` (`num_orden`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_orden_compra`
--

LOCK TABLES `detalle_orden_compra` WRITE;
/*!40000 ALTER TABLE `detalle_orden_compra` DISABLE KEYS */;
INSERT INTO `detalle_orden_compra` VALUES (1,5,10),(1,6,5),(2,1,200),(2,8,150),(3,2,10);
/*!40000 ALTER TABLE `detalle_orden_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donacion`
--

DROP TABLE IF EXISTS `donacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donacion` (
  `cod_donacion` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_registro` date DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `observacion` varchar(100) DEFAULT 'No registra',
  `estado` varchar(45) DEFAULT 'Pendiente',
  `cod_usuario` int(11) NOT NULL,
  `cod_donante` int(11) NOT NULL,
  PRIMARY KEY (`cod_donacion`,`cod_usuario`,`cod_donante`),
  KEY `fk_Carta_Donante_usuario1_idx` (`cod_usuario`),
  KEY `fk_Carta_Donante_Donante1_idx` (`cod_donante`),
  CONSTRAINT `fk_Carta_Donante_Donante1` FOREIGN KEY (`cod_donante`) REFERENCES `donante` (`cod_donante`),
  CONSTRAINT `fk_Carta_Donante_usuario1` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`cod_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donacion`
--

LOCK TABLES `donacion` WRITE;
/*!40000 ALTER TABLE `donacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `donacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donante`
--

DROP TABLE IF EXISTS `donante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donante` (
  `cod_donante` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_documento` varchar(10) DEFAULT NULL,
  `numero_documento` varchar(12) DEFAULT NULL,
  `razon_social` varchar(45) DEFAULT 'No registra',
  `nombre` varchar(45) DEFAULT NULL,
  `telefono` char(9) DEFAULT NULL,
  `fec_reg` date DEFAULT NULL,
  `estado` varchar(45) DEFAULT 'Aprobado',
  PRIMARY KEY (`cod_donante`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donante`
--

LOCK TABLES `donante` WRITE;
/*!40000 ALTER TABLE `donante` DISABLE KEYS */;
INSERT INTO `donante` VALUES (1,'DNI','09685804','No registra','Jenny Hidalgo','908360012','2017-06-29','Aprobado'),(2,'RUC','10218199196','Don Gustavo','Martin Gustavo Gamboa','910917610','2017-02-20','Aprobado'),(3,'RUC','10189731486','Agente Marsella','Bastián Uribe Llanos','928223804','2016-11-14','Aprobado'),(4,'DNI','07685104','No registra','Edgar Saravia','918073148','2015-10-18','Aprobado'),(5,'DNI','44531165','No registra','Nelly Esperanza','970895022','2015-09-12','Aprobado');
/*!40000 ALTER TABLE `donante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enlace`
--

DROP TABLE IF EXISTS `enlace`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enlace` (
  `idenlace` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `ruta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idenlace`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
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
-- Table structure for table `nota_de_entrada`
--

DROP TABLE IF EXISTS `nota_de_entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nota_de_entrada` (
  `num_nota` int(11) NOT NULL AUTO_INCREMENT,
  `unidad_organica` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  `observacion` varchar(45) DEFAULT 'No registra',
  `cod_usuario` int(11) NOT NULL,
  PRIMARY KEY (`num_nota`,`cod_usuario`),
  KEY `fk_nota_de_entrada_usuario1_idx` (`cod_usuario`),
  CONSTRAINT `fk_nota_de_entrada_usuario1` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`cod_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nota_de_entrada`
--

LOCK TABLES `nota_de_entrada` WRITE;
/*!40000 ALTER TABLE `nota_de_entrada` DISABLE KEYS */;
/*!40000 ALTER TABLE `nota_de_entrada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden_compra`
--

DROP TABLE IF EXISTS `orden_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden_compra` (
  `num_orden` int(11) NOT NULL AUTO_INCREMENT,
  `unidad_organica` varchar(45) DEFAULT NULL,
  `descripcion` varchar(45) DEFAULT NULL,
  `fec_reg` date DEFAULT NULL,
  `fec_entrega` date DEFAULT NULL,
  `observacion` varchar(45) DEFAULT 'No registra',
  `estado` varchar(45) DEFAULT 'Pendiente',
  `cod_proveedor` int(11) NOT NULL,
  `cod_usuario` int(11) NOT NULL,
  PRIMARY KEY (`num_orden`,`cod_proveedor`,`cod_usuario`),
  KEY `fk_ORDEN_COMPRA_PROVEEDOR1_idx` (`cod_proveedor`),
  KEY `fk_ORDEN_COMPRA_USUARIO1_idx` (`cod_usuario`),
  CONSTRAINT `fk_ORDEN_COMPRA_PROVEEDOR1` FOREIGN KEY (`cod_proveedor`) REFERENCES `proveedor` (`cod_proveedor`),
  CONSTRAINT `fk_ORDEN_COMPRA_USUARIO1` FOREIGN KEY (`cod_usuario`) REFERENCES `usuario` (`cod_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden_compra`
--

LOCK TABLES `orden_compra` WRITE;
/*!40000 ALTER TABLE `orden_compra` DISABLE KEYS */;
INSERT INTO `orden_compra` VALUES (1,'Servicio de Nutrición','Alimentos de abarrotes','2018-03-19','2018-07-02','Puede traer arroz de la marca costeño','Pendiente',2,3),(2,'Servicio de Farmacia','Suministro de Medicamento','2018-02-20','2018-07-02','No registra','Pendiente',3,2),(3,'Departamento de Enfermería','Adquisición de equipos de apoyo','2018-03-21','2018-07-02','No registra','Pendiente',4,4);
/*!40000 ALTER TABLE `orden_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `cod_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `ruc_prov` char(11) DEFAULT NULL,
  `razon_social` varchar(60) DEFAULT NULL,
  `representante` varchar(60) DEFAULT NULL,
  `direc_prov` varchar(45) DEFAULT NULL,
  `telf_prov` char(9) DEFAULT NULL,
  `pagina_web` varchar(50) DEFAULT 'No registra',
  `fec_reg` date DEFAULT NULL,
  `estado` varchar(45) DEFAULT 'Aprobado',
  PRIMARY KEY (`cod_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'10445311656','Los Chapis','Juan Carlos Peralta','Jr. Chala Nº 101','978564321','loschapis.com','2015-08-24','Aprobado'),(2,'10456487905','Juanito al alcance','Juan Vicente Cachay','Av. Las Camelias Nº 405','956780819','juan_al_alcance.com','2015-11-10','Aprobado'),(3,'10480904677','Estela Maris','Jose Ricarte Bignolo','Calle Emancipacion Nº 305','968181960','stellamaris.com.pe','2016-02-24','Aprobado'),(4,'10220784623','Background uderservice','Oscar Ramiro Sanchez','Mz D Bloque 36','976587612','quimicaservice.com','2017-06-15','Aprobado'),(5,'10480904607','Mass','Lucia Hilda Morales','Alcazar Nº 205','997698634','tiendasmass.com.pe','2017-04-18','Aprobado');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_bien`
--

DROP TABLE IF EXISTS `tipo_bien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_bien` (
  `cod_tipo` int(11) NOT NULL AUTO_INCREMENT,
  `nom_tipo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cod_tipo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_bien`
--

LOCK TABLES `tipo_bien` WRITE;
/*!40000 ALTER TABLE `tipo_bien` DISABLE KEYS */;
INSERT INTO `tipo_bien` VALUES (1,'Equipos'),(2,'Medicinas'),(3,'Alimentos');
/*!40000 ALTER TABLE `tipo_bien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `cod_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `ape_usua` varchar(45) DEFAULT NULL,
  `nom_usua` varchar(45) DEFAULT NULL,
  `login` varchar(45) DEFAULT NULL,
  `clave` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `fec_reg` date DEFAULT NULL,
  `estado` bit DEFAULT 0,
  PRIMARY KEY (`cod_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Ramirez','Juan','juan','juan','juramirez@insn.gob.pe','2017-10-06','Habilitado'),(2,'Carvajal','Luis','luis','luis','lucarvajal@insn.gob.pe','2016-08-09','Habilitado'),(3,'Condezo','David','david','david','dacondezo@insn.gob.pe','2017-04-22','Habilitado'),(4,'Arbulu','Ernesto','ernesto','ernesto','erarbulu@insn.gob.pe','2016-11-12','Habilitado'),(5,'Palomino','Luis','luisito','luisito','lupalomino@insn.gob.p0e','2016-01-12','Habilitado');
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

-- Dump completed on 2020-07-08 13:54:15
