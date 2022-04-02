package main.java.com.solvd.animals;

import main.java.com.solvd.animals.interfaces.Runable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Opossum extends Animals implements Runable {

    private final static Logger LOGGER = LogManager.getLogger(Opossum.class);

    public Opossum(String animalType, int maxAge, int maxWeight, String country, int maxSpeed) {
        super(animalType, maxAge, maxWeight, country, maxSpeed);
    }

    @Override
    public void printAnimalType() {
        String opossum = getAnimalType();
        LOGGER.info(opossum + " - description: ");
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
    public void run() {
        LOGGER.info("Opossum can run!");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Opossum opossum = (Opossum) o;

        if (getMaxAge() != opossum.getMaxAge()) return false;
        if (getMaxWeight() != opossum.getMaxWeight()) return false;
        if (getMaxSpeed() != opossum.getMaxSpeed()) return false;
        if (getAnimalType() != null ? !getAnimalType().equals(opossum.getAnimalType()) : opossum.getAnimalType() != null)
            return false;
        return getCountry() != null ? getCountry().equals(opossum.getCountry()) : opossum.getCountry() == null;
    }

    @Override
    public int hashCode() {
        int result = getAnimalType() != null ? getAnimalType().hashCode() : 0;
        result = 31 * result + getMaxAge();
        result = 31 * result + getMaxWeight();
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + getMaxSpeed();
        return result;
    }

}
