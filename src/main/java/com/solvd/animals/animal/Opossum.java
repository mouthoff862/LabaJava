package com.solvd.animals.animal;

import com.solvd.animals.interfaces.Runable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Opossum extends Animals implements Runable {

    private static final Logger LOGGER = LogManager.getLogger(Opossum.class);
    private String animalType;

    public Opossum(String animalType, int maxAge, int maxWeight, String country, int maxSpeed) {
        super(maxAge, maxWeight, country, maxSpeed);
        this.animalType = animalType;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    @Override
    public void printAnimalType() {
        LOGGER.info(getAnimalType() + " - description: ");
    }

    @Override
    public void showMaxAge() {
        LOGGER.info("This animal can live up to " + getMaxAge() + " years.");
    }

    @Override
    public String toString() {
        return ("This animal is a " + getAnimalType() + ".\n" + "He is from " + getCountry() + ".\n" +
                "Maximum adult weight can be up to " + getMaxWeight() + " kg.");
    }

    @Override
    public void run() {
        LOGGER.info("Opossum can run!");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Opossum opossum = (Opossum) o;

        return animalType != null ? animalType.equals(opossum.animalType) : opossum.animalType == null;
    }

    @Override
    public int hashCode() {
        return animalType != null ? animalType.hashCode() : 0;
    }
}
