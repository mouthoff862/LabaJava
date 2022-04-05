package com.solvd.animals.animal;

import com.solvd.animals.interfaces.Flyable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sparrow extends Animals implements Flyable {

    private static final Logger LOGGER = LogManager.getLogger(Sparrow.class);
    private String animalType;

    public Sparrow(String animalType, int maxAge, int maxWeight, String country, int maxSpeed) {
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
        String sparrow = getAnimalType();
        LOGGER.info(sparrow + " - description: ");
    }

    @Override
    public void showMaxAge() {
        int maxAge = getMaxAge();
        LOGGER.info("This animal can live up to " + maxAge + " years.");
    }

    @Override
    public String toString() {
        return ("This animal is a " + getAnimalType() + ".\n" + "He is from " + getCountry() + ".\n" +
                "Maximum adult weight can be up to " + getMaxWeight() + " kg.");
    }

    @Override
    public void fly() {
        LOGGER.info("Sparrow can fly!");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sparrow sparrow = (Sparrow) o;

        return animalType != null ? animalType.equals(sparrow.animalType) : sparrow.animalType == null;
    }

    @Override
    public int hashCode() {
        return animalType != null ? animalType.hashCode() : 0;
    }

}
