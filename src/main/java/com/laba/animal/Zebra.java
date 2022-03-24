package main.java.com.laba.animal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Zebra extends Herbivores implements Runable {

    private final static Logger LOGGER = LogManager.getLogger(Zebra.class);

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

    @Override
    public void printName(Animal type) {
        String zebra = type.getAnimalType();
        LOGGER.info(zebra + " - description: ");
    }

    @Override
    public void showAge(Animal age) {
        int old = age.getAge();
        LOGGER.info("This animal can live up to " + old + " years.");
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

}
