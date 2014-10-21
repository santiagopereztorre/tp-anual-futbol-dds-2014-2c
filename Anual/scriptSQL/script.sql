SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;


-- -----------------------------------------------------
-- Table `mydb`.`Criterios`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Criterios` (
  `id_criterio` INT NOT NULL AUTO_INCREMENT,
  `nombre_criterio` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_criterio`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Divisores`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Divisores` (
  `id_divisor` INT NOT NULL AUTO_INCREMENT,
  `nombre_divisor` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_divisor`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Partidos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Partidos` (
  `id_partido` INT NOT NULL AUTO_INCREMENT,
  `fecha_partido` DATETIME NULL ,
  `Criterios_id_criterio` INT NOT NULL ,
  `Divisores_id_divisor` INT NOT NULL ,
  PRIMARY KEY (`id_partido`) ,
  INDEX `fk_Partidos_Criterios` (`Criterios_id_criterio` ASC) ,
  INDEX `fk_Partidos_Divisores1` (`Divisores_id_divisor` ASC) ,
  CONSTRAINT `fk_Partidos_Criterios`
    FOREIGN KEY (`Criterios_id_criterio` )
    REFERENCES `mydb`.`Criterios` (`id_criterio` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Partidos_Divisores1`
    FOREIGN KEY (`Divisores_id_divisor` )
    REFERENCES `mydb`.`Divisores` (`id_divisor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Jugadores`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Jugadores` (
  `id_jugador` INT NOT NULL AUTO_INCREMENT,
  `nombre_jugador` VARCHAR(45) NULL ,
  `apodo_jugador` VARCHAR(45) NULL ,
  `handicap_jugador` INT NULL ,
  `mail_jugador` VARCHAR(45) NULL ,
  `fecha_nac_jugador` DATETIME NULL ,
  PRIMARY KEY (`id_jugador`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Jugadores_x_Partidos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Jugadores_x_Partidos` (
  `equipo` BIT NOT NULL ,
  `Partidos_id_partido` INT NOT NULL ,
  `Jugadores_id_jugador` INT NOT NULL ,
  PRIMARY KEY (`Partidos_id_partido`, `Jugadores_id_jugador`) ,
  INDEX `fk_Jugadores_x_Partidos_Jugadores1` (`Jugadores_id_jugador` ASC) ,
  CONSTRAINT `fk_Jugadores_x_Partidos_Partidos1`
    FOREIGN KEY (`Partidos_id_partido` )
    REFERENCES `mydb`.`Partidos` (`id_partido` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Jugadores_x_Partidos_Jugadores1`
    FOREIGN KEY (`Jugadores_id_jugador` )
    REFERENCES `mydb`.`Jugadores` (`id_jugador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Calificaciones`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Calificaciones` (
  `id_calificacion` INT NOT NULL AUTO_INCREMENT,
  `puntaje_calificacion` INT NULL ,
  `critica_calificacion` VARCHAR(45) NULL ,
  `Jugadores_x_Partidos_id_jugador_x_partido` INT NOT NULL ,
  `Jugadores_id_jugador_calificador` INT NOT NULL ,
  PRIMARY KEY (`id_calificacion`) ,
  INDEX `fk_Calificaciones_Jugadores_x_Partidos1` (`Jugadores_x_Partidos_id_jugador_x_partido` ASC) ,
  INDEX `fk_Calificaciones_Jugadores1` (`Jugadores_id_jugador_calificador` ASC) ,
  CONSTRAINT `fk_Calificaciones_Jugadores_x_Partidos1`
    FOREIGN KEY (`Jugadores_x_Partidos_id_jugador_x_partido` )
    REFERENCES `mydb`.`Jugadores_x_Partidos` (`id_jugador_x_partido` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Calificaciones_Jugadores1`
    FOREIGN KEY (`Jugadores_id_jugador_calificador` )
    REFERENCES `mydb`.`Jugadores` (`id_jugador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tipos_incripcion`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Tipos_incripcion` (
  `id_tipos_incripcion` INT NOT NULL AUTO_INCREMENT,
  `nombre_tipo_inscripcion` VARCHAR(45) NULL ,
  PRIMARY KEY (`id_tipos_incripcion`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Inscripciones`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Inscripciones` (
  `Jugadores_id_jugador` INT NOT NULL ,
  `Partidos_id_partido` INT NOT NULL ,
  `condicion_inscripcion` VARCHAR(45) NULL ,
  `Tipos_incripcion_id_tipos_incripcion` INT NOT NULL ,
  PRIMARY KEY (`Jugadores_id_jugador`, `Partidos_id_partido`) ,
  INDEX `fk_Inscripciones_Partidos1` (`Partidos_id_partido` ASC) ,
  INDEX `fk_Inscripciones_Tipos_incripcion1` (`Tipos_incripcion_id_tipos_incripcion` ASC) ,
  CONSTRAINT `fk_Inscripciones_Jugadores1`
    FOREIGN KEY (`Jugadores_id_jugador` )
    REFERENCES `mydb`.`Jugadores` (`id_jugador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Inscripciones_Partidos1`
    FOREIGN KEY (`Partidos_id_partido` )
    REFERENCES `mydb`.`Partidos` (`id_partido` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Inscripciones_Tipos_incripcion1`
    FOREIGN KEY (`Tipos_incripcion_id_tipos_incripcion` )
    REFERENCES `mydb`.`Tipos_incripcion` (`id_tipos_incripcion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Sugerencias`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Sugerencias` (
  `Jugadores_id_jugador` INT NOT NULL AUTO_INCREMENT,
  `Partidos_id_partido` INT NOT NULL ,
  `Tipos_incripcion_id_tipos_incripcion` INT NOT NULL ,
  INDEX `fk_Sugerencias_Tipos_incripcion1` (`Tipos_incripcion_id_tipos_incripcion` ASC) ,
  PRIMARY KEY (`Jugadores_id_jugador`, `Partidos_id_partido`) ,
  INDEX `fk_Sugerencias_Partidos1` (`Partidos_id_partido` ASC) ,
  CONSTRAINT `fk_Sugerencias_Tipos_incripcion1`
    FOREIGN KEY (`Tipos_incripcion_id_tipos_incripcion` )
    REFERENCES `mydb`.`Tipos_incripcion` (`id_tipos_incripcion` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sugerencias_Jugadores1`
    FOREIGN KEY (`Jugadores_id_jugador` )
    REFERENCES `mydb`.`Jugadores` (`id_jugador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sugerencias_Partidos1`
    FOREIGN KEY (`Partidos_id_partido` )
    REFERENCES `mydb`.`Partidos` (`id_partido` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Rechazos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Rechazos` (
  `id_rechazo` INT NOT NULL AUTO_INCREMENT,
  `motivo` VARCHAR(45) NULL ,
  `Sugerencias_id_sugerencia` INT NOT NULL ,
  PRIMARY KEY (`id_rechazo`) ,
  INDEX `fk_Rechazos_Sugerencias1` (`Sugerencias_id_sugerencia` ASC) ,
  CONSTRAINT `fk_Rechazos_Sugerencias1`
    FOREIGN KEY (`Sugerencias_id_sugerencia` )
    REFERENCES `mydb`.`Sugerencias` (`id_sugerencia` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Amigos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Amigos` (
  `Jugadores_id_jugador1` INT NOT NULL ,
  `Jugadores_id_jugador2` INT NOT NULL ,
  PRIMARY KEY (`Jugadores_id_jugador1`, `Jugadores_id_jugador2`) ,
  INDEX `fk_Amigos_Jugadores1` (`Jugadores_id_jugador1` ASC) ,
  INDEX `fk_Amigos_Jugadores2` (`Jugadores_id_jugador2` ASC) ,
  CONSTRAINT `fk_Amigos_Jugadores1`
    FOREIGN KEY (`Jugadores_id_jugador1` )
    REFERENCES `mydb`.`Jugadores` (`id_jugador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Amigos_Jugadores2`
    FOREIGN KEY (`Jugadores_id_jugador2` )
    REFERENCES `mydb`.`Jugadores` (`id_jugador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Infracciones`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`Infracciones` (
  `id_infraccion` INT NOT NULL AUTO_INCREMENT,
  `motivo_infraccion` VARCHAR(45) NULL ,
  `fecha_infraccion` DATETIME NULL ,
  `Jugadores_id_jugador` INT NOT NULL ,
  PRIMARY KEY (`id_infraccion`) ,
  INDEX `fk_Infracciones_Jugadores1` (`Jugadores_id_jugador` ASC) ,
  CONSTRAINT `fk_Infracciones_Jugadores1`
    FOREIGN KEY (`Jugadores_id_jugador` )
    REFERENCES `mydb`.`Jugadores` (`id_jugador` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



-- Funcion Jugador Malo
DROP FUNCTION IF EXISTS mydb.es_malo;
DELIMITER $$
CREATE FUNCTION mydb.es_malo(handicap INTEGER)
RETURNS BOOL
BEGIN
  RETURN handicap <= 5;
END;
$$
DELIMITER ;

-- Funcion Jugador Traicionero
DROP FUNCTION IF EXISTS mydb.es_traicionero;
DELIMITER $$
CREATE FUNCTION mydb.es_traicionero(id_jugador INTEGER)
RETURNS BOOL
BEGIN
	RETURN (SELECT COUNT(*) 
	FROM mydb.Infracciones 
	WHERE Jugadores_id_jugador = id_jugador
	AND YEAR(fecha_infraccion) = YEAR(NOW()) 
	AND MONTH(fecha_infraccion) = MONTH(NOW()) ) > 3;
END;
$$
DELIMITER ;


-- Vista de Jugadores Malos
DROP VIEW IF EXISTS mydb.JugadoresMalos;
CREATE VIEW mydb.JugadoresMalos AS
	SELECT * FROM Jugadores WHERE mydb.es_malo(handicap_jugador);


-- Vista de Jugadores Traicionero
DROP VIEW IF EXISTS mydb.JugadoresTraicioneros;
CREATE VIEW mydb.JugadoresTraicioneros AS
	SELECT * FROM Jugadores WHERE es_traicionero(id_jugador);


-- Vista de Jugadores que Pueden Mejorar
DROP VIEW IF EXISTS mydb.JugadoresQueMejoraran;
CREATE VIEW mydb.JugadoresQueMejoraran AS
	SELECT * 
	FROM JugadoresMalos 
	WHERE (YEAR(fecha_nac_jugador) - YEAR(NOW()) - (DATE_FORMAT(fecha_nac_jugador, '%m%d') < DATE_FORMAT(NOW(), '%m%d'))) < 25;

/*
-- Procedimiento para dar de baja un jugador de un partido
CREATE PROCEDURE dar_de_baja(id_jugador INTEGER, id_partido INTEGER, id_jugador_reemplazo INTEGER)
BEGIN
	IF(id_jugador_reemplazo = -1)
	BEGIN
		DELETE *
		FROM Jugadores_x_Partidos jp
		WHERE jp.Partidos_id_partido = id_partido AND Jugadores_id_jugador = id_jugador
	END
	ELSE
	BEGIN
		UPDATE Jugadores_x_Partidos
		SET Jugadores_id_jugador = id_jugador_reemplazo
		WHERE Jugadores_id_jugador = id_jugador
	END
END

CREATE TRIGGER infracciono_jugador
AFTER DELETE ON Jugadores_x_Partidos
FOR EACH ROW
BEGIN
	INSERT INTO Infracciones
	(motivo_infraccion, fecha_infraccion, Jugadores_id_jugador)
	VALUES ('Por darse de baja de un partido sin proponer reemplazante', CURRENT_DATE(), (SELECT d.Jugadores_id_jugador 
																							FROM Deleted d)) 
END
*/
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
