package com.solvd.animals.animal;

import com.solvd.animals.exceptions.AnimalNotFoundException;
import com.solvd.animals.interfaces.Runable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Lion extends Animals implements Runable {

    private static final Logger LOGGER = LogManager.getLogger(Lion.class);
    private String animalType;

    private static final String LION_NAME = "King Leon";
    private static final  String FAVOURITE_FOOD = "meat";

    public Lion(String animalType, int maxAge, int maxWeight, String country, int maxSpeed) {
        super(maxAge, maxWeight, country, maxSpeed);
        this.animalType = animalType;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public final void lionDescription() {
        LOGGER.info("Name of animal: " + LION_NAME + ".\n" + "His favourite food is " + FAVOURITE_FOOD + ".");
    }

    @Override
    public String toString() {
        return ("This animal is a " + getAnimalType() + ".\n" + "He is from " + getCountry() + ".\n" + "Maximum adult weight can be up to " + getMaxWeight() + " kg.");
    }


    @Override
    public void printAnimalType() {
        String lion = getAnimalType();
        LOGGER.info(lion + " - description: ");
    }

    @Override
    public void showMaxAge() {
        int maxAge = getMaxAge();
        LOGGER.info("This animal can live up to " + maxAge + " years.");
    }

    @Override
    public void run() {
        LOGGER.info("Lion can run");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lion lion = (Lion) o;

        return animalType != null ? animalType.equals(lion.animalType) : lion.animalType == null;
    }

    @Override
    public int hashCode() {
        return animalType != null ? animalType.hashCode() : 0;
    }

    public void findAnimal() {
        final String lion = "Lion";
        try {
            if (animalType != lion) {
                throw new AnimalNotFoundException("You should enter only : " + lion);
            }
        } catch (AnimalNotFoundException e) {
            LOGGER.info(e.getMessage());
        }
    }

}