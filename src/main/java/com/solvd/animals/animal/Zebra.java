package com.solvd.animals.animal;

import com.solvd.animals.interfaces.Runable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Zebra extends Animals implements Runable {

    private static final Logger LOGGER = LogManager.getLogger(Zebra.class);

    private String typeOfZebra;
    private static String description;
    private String animalType;

    public Zebra(String animalType, int maxAge, int maxWeight, String country, int maxSpeed) {
        super(maxAge, maxWeight, country, maxSpeed);
        this.animalType = animalType;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    static {
        description = "Zebra is from Africa.";
    }

    public static void showDescription() {
        LOGGER.info(description);
    }

    public String getTypeOfZebra() {
        return typeOfZebra;
    }

    public void setTypeOfZebra(String typeOfZebra) {
        this.typeOfZebra = typeOfZebra;
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
        LOGGER.info("Zebra can run!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zebra zebra = (Zebra) o;

        return animalType != null ? animalType.equals(zebra.animalType) : zebra.animalType == null;
    }

    @Override
    public int hashCode() {
        return animalType != null ? animalType.hashCode() : 0;
    }
}
