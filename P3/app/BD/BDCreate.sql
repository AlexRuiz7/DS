--
-- CREACIÓN DE BASE DE DATOS
--
CREATE DATABASE IF NOT EXISTS DS CHARACTER SET UTF8 COLLATE utf8_spanish_ci;
USE DS;

----

CREATE TABLE IF NOT EXISTS Entidades (
  ID     int NOT NULL AUTO_INCREMENT, 
  titulo varchar(30) NOT NULL,
  imagen varchar(255),
  PRIMARY KEY (ID)
);

----

CREATE TABLE IF NOT EXISTS Usuarios (
  nombre     varchar(30) NOT NULL, 
  correo     varchar(50) NOT NULL UNIQUE, 
  contraseña varchar(255) NOT NULL, 
  PRIMARY KEY (nombre)
);

----

CREATE TABLE IF NOT EXISTS Admins (
  EntidadesID    int NOT NULL, 
  Usuariosnombre varchar(30) NOT NULL, 
  PRIMARY KEY (EntidadesID, Usuariosnombre),
  FOREIGN KEY (EntidadesID)     REFERENCES Entidades(ID),
  FOREIGN KEY (Usuariosnombre)  REFERENCES Usuarios(nombre)
);

----

CREATE TABLE IF NOT EXISTS Superadmins (
  EntidadesID    int NOT NULL, 
  Usuariosnombre varchar(30) NOT NULL UNIQUE, 
  PRIMARY KEY (EntidadesID),
  FOREIGN KEY (EntidadesID)     REFERENCES Entidades(ID),
  FOREIGN KEY (Usuariosnombre)  REFERENCES Usuarios(nombre)
);

----

CREATE TABLE IF NOT EXISTS Valorables (
  EntidadesID int NOT NULL, 
  ID          int NOT NULL AUTO_INCREMENT UNIQUE, 
  titulo      varchar(30) NOT NULL, 
  descripcion varchar(250), 
  imagen      varchar(255),
  PRIMARY KEY (EntidadesID, ID),
  FOREIGN KEY (EntidadesID) REFERENCES Entidades(ID)
);

----

CREATE TABLE IF NOT EXISTS Valoraciones (
  ValorablesEntidadesID int NOT NULL, 
  ValorablesID          int NOT NULL, 
  Usuariosnombre        varchar(30) NOT NULL, 
  puntuacion            tinyint NOT NULL, 
  comentario            varchar(255), 
  fecha                 timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, 
  PRIMARY KEY (ValorablesEntidadesID, ValorablesID, Usuariosnombre),
  FOREIGN KEY (ValorablesEntidadesID, ValorablesID) REFERENCES Valorables(EntidadesID, ID),
  FOREIGN KEY (Usuariosnombre) REFERENCES Usuarios(nombre)
);