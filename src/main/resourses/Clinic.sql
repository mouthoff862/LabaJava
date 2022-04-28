-- MySQL Script generated by MySQL Workbench
-- Thu Apr 28 00:25:38 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Clinic
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Clinic
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Clinic` DEFAULT CHARACTER SET utf8 ;
USE `Clinic` ;

-- -----------------------------------------------------
-- Table `Clinic`.`Doctors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinic`.`Doctors` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `position` VARCHAR(45) NOT NULL,
  `age` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinic`.`Patients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinic`.`Patients` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinic`.`Departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinic`.`Departments` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinic`.`Hospital_Rooms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinic`.`Hospital_Rooms` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` INT NOT NULL,
  `department_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Hospital_rooms_Departments1_idx` (`department_id` ASC) ,
  CONSTRAINT `fk_Hospital_rooms_Departments1`
    FOREIGN KEY (`department_id`)
    REFERENCES `Clinic`.`Departments` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinic`.`Diagnoses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinic`.`Diagnoses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `diagnosis` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinic`.`Patient_Charts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinic`.`Patient_Charts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NOT NULL,
  `doctor_id` INT NULL,
  `diagnose_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Patient_Charts_Patients_idx` (`patient_id` ASC) ,
  INDEX `fk_Patient_Charts_Doctors1_idx` (`doctor_id` ASC) ,
  INDEX `fk_Patient_Charts_Diagnoses1_idx` (`diagnose_id` ASC) ,
  CONSTRAINT `fk_Patient_Charts_Patients`
    FOREIGN KEY (`patient_id`)
    REFERENCES `Clinic`.`Patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Patient_Charts_Doctors1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `Clinic`.`Doctors` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Patient_Charts_Diagnoses1`
    FOREIGN KEY (`diagnose_id`)
    REFERENCES `Clinic`.`Diagnoses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinic`.`Nurses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinic`.`Nurses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinic`.`Patient_Services`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinic`.`Patient_Services` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `service_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinic`.`Price`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinic`.`Price` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price` INT NOT NULL,
  `patient_service_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Price_Patient_Services1_idx` (`patient_service_id` ASC) ,
  CONSTRAINT `fk_Price_Patient_Services1`
    FOREIGN KEY (`patient_service_id`)
    REFERENCES `Clinic`.`Patient_Services` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinic`.`Checks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinic`.`Checks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `price_id` INT NOT NULL,
  `patient_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Price_has_Patients_Patients1_idx` (`patient_id` ASC) ,
  INDEX `fk_Price_has_Patients_Price1_idx` (`price_id` ASC) ,
  CONSTRAINT `fk_Price_has_Patients_Price1`
    FOREIGN KEY (`price_id`)
    REFERENCES `Clinic`.`Price` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Price_has_Patients_Patients1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `Clinic`.`Patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinic`.`Visits`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinic`.`Visits` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NOT NULL,
  `doctor_id` INT NULL,
  `date` DATE NOT NULL,
  INDEX `fk_Patients_has_Doctors_Doctors1_idx` (`doctor_id` ASC) ,
  INDEX `fk_Patients_has_Doctors_Patients1_idx` (`patient_id` ASC) ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Patients_has_Doctors_Patients1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `Clinic`.`Patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Patients_has_Doctors_Doctors1`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `Clinic`.`Doctors` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinic`.`Medicines`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinic`.`Medicines` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `medicine_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinic`.`Therapies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinic`.`Therapies` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL,
  `nurse_id` INT NOT NULL,
  `medicine_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Therapies_Patients1_idx` (`patient_id` ASC) ,
  INDEX `fk_Therapies_Nurses1_idx` (`nurse_id` ASC) ,
  INDEX `fk_Therapies_Medicines1_idx` (`medicine_id` ASC) ,
  CONSTRAINT `fk_Therapies_Patients1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `Clinic`.`Patients` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Therapies_Nurses1`
    FOREIGN KEY (`nurse_id`)
    REFERENCES `Clinic`.`Nurses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Therapies_Medicines1`
    FOREIGN KEY (`medicine_id`)
    REFERENCES `Clinic`.`Medicines` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinic`.`Hospital_Treatment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinic`.`Hospital_Treatment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `patient_id` INT NULL,
  `nurse_id` INT NULL,
  `hospital_room_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Hospital_Treatment_Patients1_idx` (`patient_id` ASC) ,
  INDEX `fk_Hospital_Treatment_Nurses1_idx` (`nurse_id` ASC) ,
  INDEX `fk_Hospital_Treatment_Hospital_rooms1_idx` (`hospital_room_id` ASC) ,
  CONSTRAINT `fk_Hospital_Treatment_Patients1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `Clinic`.`Patients` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Hospital_Treatment_Nurses1`
    FOREIGN KEY (`nurse_id`)
    REFERENCES `Clinic`.`Nurses` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Hospital_Treatment_Hospital_rooms1`
    FOREIGN KEY (`hospital_room_id`)
    REFERENCES `Clinic`.`Hospital_Rooms` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Clinic`.`Cleaners`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Clinic`.`Cleaners` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `department_id` INT NULL,
  `hospital_room_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Cleaners_Hospital_rooms1_idx` (`hospital_room_id` ASC) ,
  INDEX `fk_Cleaners_Departments1_idx` (`department_id` ASC) ,
  CONSTRAINT `fk_Cleaners_Hospital_rooms1`
    FOREIGN KEY (`hospital_room_id`)
    REFERENCES `Clinic`.`Hospital_Rooms` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Cleaners_Departments1`
    FOREIGN KEY (`department_id`)
    REFERENCES `Clinic`.`Departments` (`id`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;