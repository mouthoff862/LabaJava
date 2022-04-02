package main.java.com.solvd.animals;

import main.java.com.solvd.animal.interfaces.Runable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Lion extends Animals implements Runable {

    private final static Logger LOGGER = LogManager.getLogger(Lion.class);

    private final static String LION_NAME = "King Leon";
    private final static String FAVOURITE_FOOD = "meat";

    public Lion(String animalType, int maxAge, int maxWeight, String country, int maxSpeed) {
        super(animalType, maxAge, maxWeight, country, maxSpeed);
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
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Lion name = (Lion) o;
        if (LION_NAME == null) {
            if (name.LION_NAME != null) return false;
        } else if (!LION_NAME.equals(name.LION_NAME)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int hash = 31;
        int result = 1;
        result = result * hash + ((FAVOURITE_FOOD == null) ? 0 : FAVOURITE_FOOD.hashCode());
        return result;
    }

}