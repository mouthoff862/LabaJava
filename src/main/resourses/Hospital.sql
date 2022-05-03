-- MySQL Script generated by MySQL Workbench
-- Tue May  3 12:49:11 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Hospital
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Hospital
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Hospital` DEFAULT CHARACTER SET utf8 ;
USE `Hospital` ;

-- -----------------------------------------------------
-- Table `Hospital`.`Doctors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Doctors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `position` VARCHAR(45) NOT NULL,
  `age` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hospital`.`Patients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Patients` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hospital`.`Departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Departments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hospital`.`Hospital_Rooms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Hospital_Rooms` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` INT NOT NULL,
  `department_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Hospital_rooms_Departments1_idx` (`department_id` ASC) VISIBLE,
  CONSTRAINT `fk_Hospital_rooms_Departments1`
    FOREIGN KEY (`department_id`)
    REFERENCES `Hospital`.`Departments` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hospital`.`Diagnoses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Diagnoses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `diagnosis` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hospital`.`Patient_Charts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Patient_Charts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NOT NULL,
  `doctor_id` INT NULL,
  `diagnose_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Patient_Charts_Patients_idx` (`patient_id` ASC) VISIBLE,
  INDEX `fk_Patient_Charts_Doctors1_idx` (`doctor_id` ASC) VISIBLE,
  INDEX `fk_Patient_Charts_Diagnoses1_idx` (`diagnose_id` ASC) VISIBLE,
  CONSTRAINT `fk_Patient_Charts_Patients`
    FOREIGN KEY (`patient_id`)
    REFERENCES `Hospital`.`Patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Patient_Charts_Doctors1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `Hospital`.`Doctors` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Patient_Charts_Diagnoses1`
    FOREIGN KEY (`diagnose_id`)
    REFERENCES `Hospital`.`Diagnoses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hospital`.`Nurses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Nurses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hospital`.`Patient_Services`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Patient_Services` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `service_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hospital`.`Price`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Price` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price` INT NOT NULL,
  `patient_service_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Price_Patient_Services1_idx` (`patient_service_id` ASC) VISIBLE,
  CONSTRAINT `fk_Price_Patient_Services1`
    FOREIGN KEY (`patient_service_id`)
    REFERENCES `Hospital`.`Patient_Services` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hospital`.`Checks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Checks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price_id` INT NOT NULL,
  `patient_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Price_has_Patients_Patients1_idx` (`patient_id` ASC) VISIBLE,
  INDEX `fk_Price_has_Patients_Price1_idx` (`price_id` ASC) VISIBLE,
  CONSTRAINT `fk_Price_has_Patients_Price1`
    FOREIGN KEY (`price_id`)
    REFERENCES `Hospital`.`Price` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Price_has_Patients_Patients1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `Hospital`.`Patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hospital`.`Visits`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Visits` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NOT NULL,
  `doctor_id` INT NULL,
  `date` DATE NOT NULL,
  INDEX `fk_Patients_has_Doctors_Doctors1_idx` (`doctor_id` ASC) VISIBLE,
  INDEX `fk_Patients_has_Doctors_Patients1_idx` (`patient_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Patients_has_Doctors_Patients1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `Hospital`.`Patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Patients_has_Doctors_Doctors1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `Hospital`.`Doctors` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hospital`.`Medicines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Medicines` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `medicine_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hospital`.`Therapies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Therapies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL,
  `nurse_id` INT NOT NULL,
  `medicine_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Therapies_Patients1_idx` (`patient_id` ASC) VISIBLE,
  INDEX `fk_Therapies_Nurses1_idx` (`nurse_id` ASC) VISIBLE,
  INDEX `fk_Therapies_Medicines1_idx` (`medicine_id` ASC) VISIBLE,
  CONSTRAINT `fk_Therapies_Patients1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `Hospital`.`Patients` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Therapies_Nurses1`
    FOREIGN KEY (`nurse_id`)
    REFERENCES `Hospital`.`Nurses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Therapies_Medicines1`
    FOREIGN KEY (`medicine_id`)
    REFERENCES `Hospital`.`Medicines` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hospital`.`Hospital_Treatment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Hospital_Treatment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL,
  `nurse_id` INT NULL,
  `hospital_room_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Hospital_Treatment_Patients1_idx` (`patient_id` ASC) VISIBLE,
  INDEX `fk_Hospital_Treatment_Nurses1_idx` (`nurse_id` ASC) VISIBLE,
  INDEX `fk_Hospital_Treatment_Hospital_rooms1_idx` (`hospital_room_id` ASC) VISIBLE,
  CONSTRAINT `fk_Hospital_Treatment_Patients1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `Hospital`.`Patients` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Hospital_Treatment_Nurses1`
    FOREIGN KEY (`nurse_id`)
    REFERENCES `Hospital`.`Nurses` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Hospital_Treatment_Hospital_rooms1`
    FOREIGN KEY (`hospital_room_id`)
    REFERENCES `Hospital`.`Hospital_Rooms` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hospital`.`Cleaners`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hospital`.`Cleaners` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `department_id` INT NULL,
  `hospital_room_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Cleaners_Hospital_rooms1_idx` (`hospital_room_id` ASC) VISIBLE,
  INDEX `fk_Cleaners_Departments1_idx` (`department_id` ASC) VISIBLE,
  CONSTRAINT `fk_Cleaners_Hospital_rooms1`
    FOREIGN KEY (`hospital_room_id`)
    REFERENCES `Hospital`.`Hospital_Rooms` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cleaners_Departments1`
    FOREIGN KEY (`department_id`)
    REFERENCES `Hospital`.`Departments` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
