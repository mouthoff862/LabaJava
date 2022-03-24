package main.java.com.laba.animal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sparrow extends Omnivores implements Flyable {

    private final static Logger LOGGER = LogManager.getLogger(Sparrow.class);

    public Sparrow(String animalType, int age, int maxWeight, String country, int maxSpeed) {
        super(animalType, age, maxWeight, country, maxSpeed);
    }

    @Override
    public void printName(Animal type) {
        String sparrow = type.getAnimalType();
        LOGGER.info(sparrow + " - description: ");
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
    public void fly() {
        LOGGER.info("Sparrow can fly!");
    }
}
