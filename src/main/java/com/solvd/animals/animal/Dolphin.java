package com.solvd.animals.animal;

import com.solvd.animals.interfaces.Swimable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Dolphin extends Animals implements Swimable {

    private static final Logger LOGGER = LogManager.getLogger(Dolphin.class);
    private String animalType;

    public Dolphin(String animalType, int maxAge, int maxWeight, String country, int maxSpeed) {
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
    public void showMaxAge() {
        LOGGER.info("This animal can live up to " + getMaxAge() + " years.");
    }

    @Override
    public void swim() {
        LOGGER.info("Dolphin can swim!");
    }

    @Override
    public void printAnimalType() {
        LOGGER.info(getAnimalType() + " - description: ");
    }

    @Override
    public String toString() {
        return ("This animal is a " + getAnimalType() + ".\n" + "He is from " + getCountry() + ".\n" +
                "Maximum adult weight can be up to " + getMaxWeight() + " kg.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dolphin dolphin = (Dolphin) o;

        return animalType != null ? animalType.equals(dolphin.animalType) : dolphin.animalType == null;
    }

    @Override
    public int hashCode() {
        return animalType != null ? animalType.hashCode() : 0;
    }

}
