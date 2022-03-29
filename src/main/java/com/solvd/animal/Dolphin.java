package main.java.com.solvd.animal;
import main.java.com.solvd.interfaces.Swimable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Dolphin extends Carnivores implements Swimable {

    private final static Logger LOGGER = LogManager.getLogger(Dolphin.class);

    public Dolphin(String animalType, int age, int maxWeight, String country, int maxSpeed) {
        super(animalType, age, maxWeight, country, maxSpeed);
    }

    @Override
    public void swim() {
        LOGGER.info("Dolphin can swim!");
    }

    @Override
    public void printName() {
        String dolphin = getAnimalType();
        LOGGER.info(dolphin + " - description: ");
    }

    @Override
    public void showAge() {
        int old = getAge();
        LOGGER.info("This animal can live up to " + old + " years.");
    }

    @Override
    public String toString() {
        return ("This animal is a " + getAnimalType() + ".\n" + "He is from " + getCountry() + ".\n" +
                "Maximum adult weight can be up to " + getMaxWeight() + " kg.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dolphin dolphin = (Dolphin) o;

        if (getAge() != dolphin.getAge()) return false;
        if (getMaxWeight() != dolphin.getMaxWeight()) return false;
        if (getMaxSpeed() != dolphin.getMaxSpeed()) return false;
        if (getAnimalType() != null ? !getAnimalType().equals(dolphin.getAnimalType()) : dolphin.getAnimalType() != null)
            return false;
        return getCountry() != null ? getCountry().equals(dolphin.getCountry()) : dolphin.getCountry() == null;
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
