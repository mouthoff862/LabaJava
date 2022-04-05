package main.java.com.solvd.animals;

import main.java.com.solvd.animals.interfaces.Jumpable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Kangaroo extends Animals implements Jumpable {

    private final static Logger LOGGER = LogManager.getLogger(Kangaroo.class);

    public Kangaroo(String animalType, int maxAge, int maxWeight, String country, int maxSpeed) {
        super(animalType, maxAge, maxWeight, country, maxSpeed);
    }

    @Override
    public void printAnimalType() {
        String kangaroo = getAnimalType();
        LOGGER.info(kangaroo + " - description: ");
    }

    @Override
    public void showMaxAge() {
        int old = getMaxAge();
        LOGGER.info("This animal can live up to " + old + " years.");
    }

    @Override
    public String toString() {
        return ("This animal is a " + getAnimalType() + ".\n" + "He is from " + getCountry() + ".\n" +
                "Maximum adult weight can be up to " + getMaxWeight() + " kg.");
    }

    @Override
    public void jump() {
        LOGGER.info("Kangaroo can jump!");
    }
}
