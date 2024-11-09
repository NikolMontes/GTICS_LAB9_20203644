-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_lab9_drinks
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `db_lab9_drinks` ;

-- -----------------------------------------------------
-- Schema db_lab9_drinks
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_lab9_drinks` DEFAULT CHARACTER SET utf8 ;
USE `db_lab9_drinks` ;

-- -----------------------------------------------------
-- Table `db_lab9_drinks`.`drink`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_lab9_drinks`.`drink` ;

CREATE TABLE IF NOT EXISTS `db_lab9_drinks`.`drink` (
  `iddrink` INT NOT NULL AUTO_INCREMENT,
  `strDrink` VARCHAR(45) NOT NULL,
  `strCategory` VARCHAR(45) NULL,
  `strAlcoholic` VARCHAR(45) NULL,
  `strGlass` VARCHAR(45) NULL,
  `strIntructions` VARCHAR(45) NULL,
  `strDrinkThumb` VARCHAR(45) NOT NULL,
  `strisFavorite` TINYINT NOT NULL,
  PRIMARY KEY (`iddrink`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
