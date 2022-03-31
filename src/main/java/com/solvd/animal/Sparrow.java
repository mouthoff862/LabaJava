package main.java.com.solvd.animal;

import main.java.com.solvd.animal.interfaces.Flyable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Sparrow extends Omnivores implements Flyable {

    private final static Logger LOGGER = LogManager.getLogger(Sparrow.class);

    public Sparrow(String animalType, int age, int maxWeight, String country, int maxSpeed) {
        super(animalType, age, maxWeight, country, maxSpeed);
    }

    @Override
    public void printName() {
        String sparrow = getAnimalType();
        LOGGER.info(sparrow + " - description: ");
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
    public void fly() {
        LOGGER.info("Sparrow can fly!");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sparrow sparrow = (Sparrow) o;

        if (getAge() != sparrow.getAge()) return false;
        if (getMaxWeight() != sparrow.getMaxWeight()) return false;
        if (getMaxSpeed() != sparrow.getMaxSpeed()) return false;
        if (getAnimalType() != null ? !getAnimalType().equals(sparrow.getAnimalType()) : sparrow.getAnimalType() != null)
            return false;
        return getCountry() != null ? getCountry().equals(sparrow.getCountry()) : sparrow.getCountry() == null;
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
