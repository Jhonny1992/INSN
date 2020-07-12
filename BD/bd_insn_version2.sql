DROP DATABASE IF EXISTS bd_insn;

CREATE DATABASE `bd_insn` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_insn`;

CREATE TABLE `cargo` (
  `codCargo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  constraint pk_cargo PRIMARY KEY (`codCargo`)
);

CREATE TABLE `bien` (
  `codBien` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(90) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `tipo` int(11) NOT NULL,
  `fechaRegistro` date NOT NULL,
  PRIMARY KEY (`codBien`)
);

CREATE TABLE `usuario` (
  `codUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nroDocumento` varchar(8) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `login` varchar(10) NOT NULL,
  `clave` varchar(15) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `fechaRegistro` date NOT NULL,
  `codCargo` int(11) DEFAULT NULL,
  
  constraint pk_usuario PRIMARY KEY (`codUsuario`),
  constraint fk_usuario_cargo foreign key(codCargo) references cargo(codCargo)
);

CREATE TABLE `unidadorganica` (
  `codUnidad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(90) NOT NULL,
  `descripcion` varchar(250) NOT NULL,
  `anexo` varchar(5) NOT NULL,
  `jefeEncargado` int(11) NOT NULL,
  `fechaRegistro` date NOT NULL,
  CONSTRAINT pk_unidadorganica PRIMARY KEY (`codUnidad`),
  CONSTRAINT fk_unidadorganica_usuario foreign key(jefeEncargado) references usuario(codUsuario)
);

DELIMITER $$
CREATE UNIQUE INDEX id_cargo_nombre ON cargo(nombre)
$$

CREATE UNIQUE INDEX idx_usuario_nroDocumento ON usuario(nroDocumento)
$$

CREATE UNIQUE INDEX idx_bien_nombre ON bien(nombre)
$$

CREATE TRIGGER `tgr_usuario_binsert` BEFORE INSERT ON `usuario`
FOR EACH ROW BEGIN
        -- Set the udpate date
    Set new.fechaRegistro = now();
END
$$

CREATE TRIGGER `tgr_bien_binsert` BEFORE INSERT ON `bien`
FOR EACH ROW BEGIN
        -- Set the udpate date
    Set new.fechaRegistro = now();
END
$$

CREATE TRIGGER `tgr_unidadOrganica_binsert` BEFORE INSERT ON `unidadOrganica`
FOR EACH ROW BEGIN
        -- Set the udpate date
    Set new.fechaRegistro = now();
END
$$

INSERT INTO cargo
(nombre)
VALUES
('Administrador'),
('Gestor de cuenta'),
('Asesor');
$$
