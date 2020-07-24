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
-- Dumping data for table `bien`
--

LOCK TABLES `bien` WRITE;
/*!40000 ALTER TABLE `bien` DISABLE KEYS */;
INSERT INTO `bien` VALUES (1,'ARECOMARA ADULTO','Equipo de extensión que contiene una o más válvulas unidireccionales.',1,'2020-07-23'),(2,'AEROCAMARA LACTANTE','Equipo de aerosol para madres gestantes.',1,'2020-07-23'),(3,'AEROCAMARA PEDIATRICA','Equipo de aerosol para pacientes menores.',1,'2020-07-23'),(4,'APOSITO DE GASA Y ALGODÓN ESTÉRIL','APOSITO DE GASA Y ALGODÓN ESTÉRIL 10cm X 20 cm unidad - SOBRE',1,'2020-07-23'),(5,'CATETER ENDOVENOSO PERIFERICO','CATETER ENDOVENOSO PERIFERICO 20 G X 1 1/4 CON DISPOSITIVO DE SEGURIDAD',1,'2020-07-23'),(6,'EQUIPO DE VENOCLISIS','Dispositivo destinado a ingresar por vía intravenosa, ya sea periférica o central, la infusión continua de fluidos.',1,'2020-07-23'),(7,'EQUIPO MICROGOTERO CON CAMARA GRADUADA DE 100ML.','',1,'2020-07-23'),(8,'ESPARADRAPO HIPOALERGENICO DE TELA','ESPARADRAPO HIPOALERGENICO DE TELA 10 YD (9.1 M APROX.)',1,'2020-07-23'),(9,'LANCETA ESTERIL DESCARTABLE','',1,'2020-07-23'),(10,'LLAVE DE TRIPLE VIA DESCARTABLE','',1,'2020-07-23'),(11,'MASCARA DE OXIGENO DESCARTABLE PARA NEBULIZACION','',1,'2020-07-23'),(12,'SONDA DE ALIMENTACION','',1,'2020-07-23'),(13,'SONDA DE ASPIRACION ENDOTRAQUEAL','',1,'2020-07-23'),(14,'SONDA NASOGASTRICA','',1,'2020-07-23'),(15,'SONDA VESICAL TIPO NELATON','',1,'2020-07-23'),(16,'VENDA ELASTICA','',1,'2020-07-23'),(17,'GORRO DESCARTABLE DE CIRUJANO','',1,'2020-07-23'),(18,'GORRO DESCARTABLE DE ENFERMERA','',1,'2020-07-23'),(19,'MASCARILLA DESCARTABLE QUIRURGICA','',1,'2020-07-23'),(20,'PAPEL CREPADO 120CMX120CM','',1,'2020-07-23'),(21,'AGUJA HIPODERMICA','',1,'2020-07-23'),(22,'ALGODON HIDROFILO','',1,'2020-07-23'),(23,'GUANTE PARA EXAMEN DESCARTABLE TALLA M - PAR','',1,'2020-07-23'),(24,'GUANTE PARA EXAMEN DESCARTABLE TALLA S - PAR','',1,'2020-07-23'),(25,'GUANTE QUIRURGICO DESCARTABLE ESTERIL','',1,'2020-07-23'),(26,'JERINGA DESCARTABLE 1ML CON AGUJA','',1,'2020-07-23'),(27,'JERINGA DESCARTABLE 10ML CON AGUJA	','',1,'2020-07-23'),(28,'MEDICO ESPECIALIZADO EN CIRUGIA CRANEAL','',2,'2020-07-23'),(29,'MEDICO ANESTESIOLOGO','',2,'2020-07-23'),(30,'MEDICO DE TRAUMATOLOGIA','',2,'2020-07-23'),(31,'INTERNET','',2,'2020-07-23'),(32,'TELEFONIA MOVIL','',2,'2020-07-23'),(33,'ALQUILER DE EQUIPO MULTIFUNCIONAL','',2,'2020-07-23'),(34,'CUADERNO DE CARGO EMPASTADO','',1,'2020-07-23'),(35,'PAPEL BOND A4 MILLAR','',1,'2020-07-23'),(36,'CUADERNO ESPIRAL RAYADO','',1,'2020-07-23'),(37,'LIBRO DE ACTAS FOLIO 200','',1,'2020-07-23'),(38,'LIBRO DE ACTAS FOLIO 400','',1,'2020-07-23'),(39,'PAPEL LUSTRE 60CMX50CM','',1,'2020-07-23'),(40,'BOLIGRAFO AZUL','TINTA GEL PUNTA FINA COLOR AZUL',1,'2020-07-23'),(44,'BOLIGRAFO NEGRO','TINTA GEL PUNTA FINA COLOR NEGRO',1,'2020-07-23'),(45,'CORRECTOR','LIQUIDO TIPO LAPICERO',1,'2020-07-23'),(46,'PLUMON PARA PIZARRA','ACRILICA PUNTA GRUESA',1,'2020-07-23'),(47,'BLINDER CLIP','DE 2 IN (51MM)',1,'2020-07-23');
/*!40000 ALTER TABLE `bien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `unidadorganica`
--

LOCK TABLES `unidadorganica` WRITE;
/*!40000 ALTER TABLE `unidadorganica` DISABLE KEYS */;
INSERT INTO `unidadorganica` VALUES (1,'Unidad de Planeamiento y Presupuesto','Se encarga de la administración de la economía de la institución.','2083',3,'2020-07-23'),(2,'Unidad de Administración','Encargada de administrar los recursos de la institución.','2008',4,'2020-07-23'),(3,'Unidad de Asesoría Jurídica','Encargada del asesoramiento legal de la institución.','1001',5,'2020-07-23'),(4,'Unidad de Atención Integral Especializada','Encargada de la atención de pacientes con enfermedades especiales.','9901',6,'2020-07-23'),(5,'Unidad de Desarrollo de Investigación, Tecnología y Docencia','Encargada de la investigación y desarrollo tecnológico de la institución.','3016',7,'2020-07-23'),(6,'Unidad de Donación y Transplante','Encargada de las donaciones y transplantes de órganos a pacientes de la institución.','1015',8,'2020-07-23'),(7,'Unidad de Enfermería','Encargada de administrar el servicio de enfermería de la institución.','2054',9,'2020-07-23'),(8,'Unidad de Soporte al Diagnóstico y Tratamiento','Encargada del manejo de diagnósticos y su posterior tratamiento a los pacientes de la institución.','2003',10,'2020-07-23'),(9,'Unidad de Tecnologías de la Información','Encargada del área de sistemas y flujo de datos de la institución.','2019',11,'2020-07-23');
/*!40000 ALTER TABLE `unidadorganica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'12345678','Admin','Admin','admin','admin','admin@insn.gob.pe','2020-07-23',1),(2,'10007431','JÁUREGUI MIRANDA','JORGE ASDRÚBAL','jjauregui','jjauregui','jjauregui@insn.gob.pe','2020-07-23',1),(3,'07186922','RICRA ALBITES','ALEJANDRO','aricra','aricra','aricra@insn.gob.pe','2020-07-23',2),(4,'25746919','SUNCION ESPINOZA','ORLANDO DARWIN	','osuncion','osuncion','osuncion@insn.gob.pe','2020-07-23',2),(5,'06179502','VEGA HUANCA','ELIZABETH DIANA	','evegah','evegah','evegah@insn.gob.pe','2020-07-23',2),(6,'07539491','MEZA DIAZ','MIGUEL ALBERTO	','mmezad','mmezad','mmezad@insn.gob.pe','2020-07-23',2),(7,'10311172','PADILLA YGREDA','JUSTO ROMULO','jpadilla','jpadilla','jpadilla@insn.gob.pe','2020-07-23',2),(8,'09160143','BENAVIDES LOPEZ','MELVA TEODOCIA','mbenavides','mbenavides','mbenavides@insn.gob.pe','2020-07-23',2),(9,'21801417','LEVANO SANTIAGO','FABIOLA JUDITH','flevano','flevano','flevano@insn.gob.pe','2020-07-23',2),(10,'10082581','PORTELLA MENDOZA','JULIO EDUARDO','jportella','jportella','jportella@insn.gob.pe','2020-07-23',2),(11,'06805394','MONTOYA ARANGO','ALEX JOEL	','amontoya','amontoya','amontoya@insn.gob.pe','2020-07-23',2);
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

-- Dump completed on 2020-07-23 14:53:17
