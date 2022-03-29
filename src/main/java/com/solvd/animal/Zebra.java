package main.java.com.solvd.animal;

import main.java.com.solvd.interfaces.Runable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Zebra extends Herbivores implements Runable {

    private final static Logger LOGGER = LogManager.getLogger(Zebra.class);

    private String typeOfZebra;
    private static String description;

    public Zebra(String animalType, int age, int maxWeight, String country, int maxSpeed) {
        super(animalType, age, maxWeight, country, maxSpeed);
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
    public void printName() {
        String zebra = getAnimalType();
        LOGGER.info(zebra + " - description: ");
    }

    @Override
    public void showAge() {
        int maxAge = getAge();
        LOGGER.info("This animal can live up to " + maxAge + " years.");
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

        if (getAge() != zebra.getAge()) return false;
        if (getMaxWeight() != zebra.getMaxWeight()) return false;
        if (getMaxSpeed() != zebra.getMaxSpeed()) return false;
        if (getAnimalType() != null ? !getAnimalType().equals(zebra.getAnimalType()) : zebra.getAnimalType() != null) return false;
        return getCountry() != null ? getCountry().equals(zebra.getCountry()) : zebra.getCountry() == null;
    }

    @Override
    public int hashCode() {
        int result = getAnimalType() != null ? getAnimalType().hashCode() : 0;
        result = 31 * result + getAge();
        result = 31 * result + getMaxWeight();
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + getMaxSpeed();
        return result;
    }
}
