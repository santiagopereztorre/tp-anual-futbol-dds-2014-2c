SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `dds_anual` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `dds_anual` ;


-- -----------------------------------------------------
-- Table `dds_anual`.`Criterios`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dds_anual`.`Criterios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre_criterio` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dds_anual`.`Divisores`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dds_anual`.`Divisores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre_divisor` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dds_anual`.`Partidos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dds_anual`.`Partidos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fecha_partido` DATETIME NULL ,
  `Criterios_id_criterio` INT NOT NULL ,
  `Divisores_id_divisor` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Partidos_Criterios` (`Criterios_id_criterio` ASC) ,
  INDEX `fk_Partidos_Divisores1` (`Divisores_id_divisor` ASC) ,
  CONSTRAINT `fk_Partidos_Criterios`
    FOREIGN KEY (`Criterios_id_criterio` )
    REFERENCES `dds_anual`.`Criterios` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Partidos_Divisores1`
    FOREIGN KEY (`Divisores_id_divisor` )
    REFERENCES `dds_anual`.`Divisores` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dds_anual`.`Jugadores`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dds_anual`.`Jugadores` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre_jugador` VARCHAR(45) NULL ,
  `apodo_jugador` VARCHAR(45) NULL ,
  `handicap_jugador` INT NULL ,
  `mail_jugador` VARCHAR(45) NULL ,
  `fecha_nac_jugador` DATETIME NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dds_anual`.`Jugadores_x_Partidos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dds_anual`.`Jugadores_x_Partidos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `equipo` BIT NOT NULL ,
  `Partidos_id_partido` INT NOT NULL ,
  `Jugadores_id_jugador` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Jugadores_x_Partidos_Jugadores1` (`Jugadores_id_jugador` ASC) ,
  CONSTRAINT `fk_Jugadores_x_Partidos_Partidos1`
    FOREIGN KEY (`Partidos_id_partido` )
    REFERENCES `dds_anual`.`Partidos` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Jugadores_x_Partidos_Jugadores1`
    FOREIGN KEY (`Jugadores_id_jugador` )
    REFERENCES `dds_anual`.`Jugadores` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dds_anual`.`Calificaciones`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dds_anual`.`Calificaciones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `puntaje_calificacion` INT NULL ,
  `critica_calificacion` VARCHAR(45) NULL ,
  `id_partido` INT NOT NULL ,
  `id_calificador` INT NOT NULL ,
  `id_calificado`  INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `fk_id_calificador`
    FOREIGN KEY (`id_calificador` )
    REFERENCES `dds_anual`.`Jugadores` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_calificado`
    FOREIGN KEY (`id_calificado` )
    REFERENCES `dds_anual`.`Jugadores` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_partido`
    FOREIGN KEY (`id_partido` )
    REFERENCES `dds_anual`.`Partidos` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dds_anual`.`Tipos_inscripcion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dds_anual`.`Tipos_inscripcion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre_tipo_inscripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dds_anual`.`Inscripciones`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dds_anual`.`Inscripciones` (
  `Jugadores_id_jugador` INT NOT NULL ,
  `Partidos_id_partido` INT NOT NULL ,
  `condicion_inscripcion` VARCHAR(45) NULL ,
  `Tipos_incripcion_id_tipos_incripcion` INT NOT NULL ,
  PRIMARY KEY (`Jugadores_id_jugador`, `Partidos_id_partido`) ,
  INDEX `fk_Inscripciones_Partidos1` (`Partidos_id_partido` ASC) ,
  INDEX `fk_Inscripciones_Tipos_incripcion1` (`Tipos_incripcion_id_tipos_incripcion` ASC) ,
  CONSTRAINT `fk_Inscripciones_Jugadores1`
    FOREIGN KEY (`Jugadores_id_jugador` )
    REFERENCES `dds_anual`.`Jugadores` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Inscripciones_Partidos1`
    FOREIGN KEY (`Partidos_id_partido` )
    REFERENCES `dds_anual`.`Partidos` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Inscripciones_Tipos_incripcion1`
    FOREIGN KEY (`Tipos_incripcion_id_tipos_incripcion` )
    REFERENCES `dds_anual`.`Tipos_incripcion` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dds_anual`.`Sugerencias`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dds_anual`.`Sugerencias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Jugadores_id_jugador` INT NOT NULL,
  `Partidos_id_partido` INT NOT NULL ,
  `Tipos_incripcion_id_tipos_incripcion` INT NOT NULL ,
  INDEX `fk_Sugerencias_Tipos_incripcion1` (`Tipos_incripcion_id_tipos_incripcion` ASC) ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Sugerencias_Partidos1` (`Partidos_id_partido` ASC) ,
  CONSTRAINT `fk_Sugerencias_Tipos_incripcion1`
    FOREIGN KEY (`Tipos_incripcion_id_tipos_incripcion` )
    REFERENCES `dds_anual`.`Tipos_incripcion` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sugerencias_Jugadores1`
    FOREIGN KEY (`Jugadores_id_jugador` )
    REFERENCES `dds_anual`.`Jugadores` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sugerencias_Partidos1`
    FOREIGN KEY (`Partidos_id_partido` )
    REFERENCES `dds_anual`.`Partidos` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dds_anual`.`Rechazos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dds_anual`.`Rechazos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `motivo` VARCHAR(45) NULL ,
  `Sugerencias_id_sugerencia` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Rechazos_Sugerencias1` (`Sugerencias_id_sugerencia` ASC) ,
  CONSTRAINT `fk_Rechazos_Sugerencias1`
    FOREIGN KEY (`Sugerencias_id_sugerencia` )
    REFERENCES `dds_anual`.`Sugerencias` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dds_anual`.`Amigos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dds_anual`.`Amigos` (
  `Jugadores_id_jugador1` INT NOT NULL ,
  `Jugadores_id_jugador2` INT NOT NULL ,
  PRIMARY KEY (`Jugadores_id_jugador1`, `Jugadores_id_jugador2`) ,
  INDEX `fk_Amigos_Jugadores1` (`Jugadores_id_jugador1` ASC) ,
  INDEX `fk_Amigos_Jugadores2` (`Jugadores_id_jugador2` ASC) ,
  CONSTRAINT `fk_Amigos_Jugadores1`
    FOREIGN KEY (`Jugadores_id_jugador1` )
    REFERENCES `dds_anual`.`Jugadores` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Amigos_Jugadores2`
    FOREIGN KEY (`Jugadores_id_jugador2` )
    REFERENCES `dds_anual`.`Jugadores` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `dds_anual`.`Infracciones`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `dds_anual`.`Infracciones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `motivo_infraccion` VARCHAR(45) NULL ,
  `fecha_infraccion` DATETIME NULL ,
  `Jugadores_id_jugador` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Infracciones_Jugadores1` (`Jugadores_id_jugador` ASC) ,
  CONSTRAINT `fk_Infracciones_Jugadores1`
    FOREIGN KEY (`Jugadores_id_jugador` )
    REFERENCES `dds_anual`.`Jugadores` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



-- Funcion Jugador Malo
DROP FUNCTION IF EXISTS dds_anual.es_malo;
DELIMITER $$
CREATE FUNCTION dds_anual.es_malo(handicap INTEGER)
RETURNS BOOL
BEGIN
  RETURN handicap <= 5;
END;
$$
DELIMITER ;

-- Funcion Jugador Traicionero
DROP FUNCTION IF EXISTS dds_anual.es_traicionero;
DELIMITER $$
CREATE FUNCTION dds_anual.es_traicionero(id_jugador INTEGER)
RETURNS BOOL
BEGIN
	RETURN (SELECT COUNT(*) 
	FROM dds_anual.Infracciones 
	WHERE Jugadores_id_jugador = id_jugador
	AND YEAR(fecha_infraccion) = YEAR(NOW()) 
	AND MONTH(fecha_infraccion) = MONTH(NOW()) ) > 3;
END;
$$
DELIMITER ;


-- Vista de Jugadores Malos
DROP VIEW IF EXISTS dds_anual.JugadoresMalos;
CREATE VIEW dds_anual.JugadoresMalos AS
	SELECT * FROM Jugadores WHERE dds_anual.es_malo(handicap_jugador);


-- Vista de Jugadores Traicionero
DROP VIEW IF EXISTS dds_anual.JugadoresTraicioneros;
CREATE VIEW dds_anual.JugadoresTraicioneros AS
	SELECT * FROM Jugadores WHERE es_traicionero(id);


-- Vista de Jugadores que Pueden Mejorar
DROP VIEW IF EXISTS dds_anual.JugadoresQueMejoraran;
CREATE VIEW dds_anual.JugadoresQueMejoraran AS
	SELECT * 
	FROM JugadoresMalos 
	WHERE (YEAR(fecha_nac_jugador) - YEAR(NOW()) - (DATE_FORMAT(fecha_nac_jugador, '%m%d') < DATE_FORMAT(NOW(), '%m%d'))) < 25;


-- Procedimiento para dar de baja un jugador de un partido
DROP PROCEDURE IF EXISTS dds_anual.dar_de_baja;
DELIMITER $$
CREATE PROCEDURE dar_de_baja(id_jugador INTEGER, id_partido INTEGER, id_jugador_reemplazo INTEGER)
BEGIN
	IF id_jugador_reemplazo < 0
	THEN
		DELETE
		FROM Jugadores_x_Partidos
		WHERE Partidos_id_partido = id_partido AND Jugadores_id_jugador = id_jugador;
	ELSE
		UPDATE Jugadores_x_Partidos
		SET Jugadores_id_jugador = id_jugador_reemplazo
		WHERE Jugadores_id_jugador = id_jugador;
	END IF;
END;
$$
DELIMITER ;

DROP TRIGGER IF EXISTS dds_anual.infracciono_jugador;
DELIMITER $$
CREATE TRIGGER infracciono_jugador
AFTER DELETE ON Jugadores_x_Partidos
FOR EACH ROW
BEGIN
	INSERT INTO Infracciones
	(motivo_infraccion, fecha_infraccion, Jugadores_id_jugador)
	VALUES ('Por darse de baja de un partido sin proponer reemplazante', CURRENT_DATE(), (SELECT d.Jugadores_id_jugador 
																							FROM Deleted d)); 
END;
$$
DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
