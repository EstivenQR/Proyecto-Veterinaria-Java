CREATE DATABASE VETERINARIA_MELLO;

USE VETERINARIA_MELLO;

CREATE TABLE `empleados` (
  `Nombre` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `Cedula` int NOT NULL,
  `Edad` int NOT NULL,
  `Salario` double NOT NULL,
  `PuestoLaboral` varchar(50) NOT NULL,
  `Correo` varchar(100) NOT NULL,
  `Telefono` int NOT NULL,
  PRIMARY KEY (`Cedula`)
);

CREATE TABLE `clientes` (
	`Nombre` varchar(50) NOT NULL,
    `Cedula` int NOT NULL,
    `direccion` varchar(50) NOT NULL,
    `Telefono` varchar(15) NOT NULL,
    `Correo` varchar(100) NOT NULL,
    `Mascota` varchar(15) NOT NULL,
    PRIMARY KEY (`Cedula`)
);

CREATE TABLE USERS (
    USERNAME VARCHAR(20) NOT NULL,
    NOMBRE VARCHAR(50) NOT NULL,
    APELLIDOS VARCHAR(50) NOT NULL,
    CEDULA VARCHAR(10),
    CORREO VARCHAR(50),
	PRIMARY KEY(USERNAME)
);

 CREATE TABLE PASSWORDS (
	USERNAME VARCHAR(20) NOT NULL,
    PASSWORD VARCHAR(32) NOT NULL,
    SECURITY_Q VARCHAR(50) NOT NULL,
    SECURITY_A VARCHAR(50) NOT NULL,
	PRIMARY KEY (USERNAME),
    FOREIGN KEY (USERNAME) REFERENCES USERS(USERNAME)
);

create Table Mascotas(
    ID int auto_increment PRIMARY KEY,
    nombre varchar (50) not null,
    edad varchar(10) not null,
    especie varchar(50) not null,
    raza varchar(50) null,
    tamano varchar(50) null,
    fechaNacimiento date not null,
    fechaVisita date not null,
    comentarios varchar(500) null 
);

create Table Ventas(
    ID int auto_increment PRIMARY KEY,
    montoFacturado int not null,
    productos varchar(200) not null,
    metodoPago varchar(100) not null,
    cliente varchar(100) not null,
    vendedor varchar(100) null,
    fechaVenta date not null
);

CREATE TABLE SERVICIOS (
    CODIGO INT NOT NULL AUTO_INCREMENT,
    NOMBRE VARCHAR(20) NOT NULL,
    CATEGORIA VARCHAR(20) NOT NULL,
    DESCRIPCION VARCHAR(50) NOT NULL,
    PRECIO FLOAT NOT NULL,
    PRIMARY KEY (CODIGO)
);