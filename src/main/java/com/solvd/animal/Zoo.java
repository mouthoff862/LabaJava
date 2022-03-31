package main.java.com.solvd.animal;

import main.java.com.solvd.animal.exceptions.CounterException;
import main.java.com.solvd.animal.exceptions.EmptyLineException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Zoo {

    private final static Logger LOGGER = LogManager.getLogger(Zoo.class);

    private int maxCounterAnimals;
    private String nameZoo;

    public Zoo() {
    }

    public Zoo(int maxCounterAnimals, String nameZoo) {
        this.maxCounterAnimals = maxCounterAnimals;
        this.nameZoo = nameZoo;
    }

    public int getMaxCounterAnimals() {
        return maxCounterAnimals;
    }


    public String getNameZoo() {
        return nameZoo;
    }

    public void showDescription(Zoo counterAnimals, Zoo nameOfZoo) {
        int count = counterAnimals.getMaxCounterAnimals();
        String zooName = nameOfZoo.getNameZoo();
        LOGGER.info("Name of Zoo: " + zooName + ".\n" + "Maximum number of animals in the zoo: " + count);
    }

    public void setNameZoo(String nameZoo) throws EmptyLineException {
        if (nameZoo == null) {
            try {
                throw new EmptyLineException("Print some words");
            } catch (EmptyLineException e) {
                LOGGER.info(e.getMessage());
            }
        }
        this.nameZoo = nameZoo;
    }

    public void setMaxCounterAnimals(int maxCounterAnimals) throws CounterException {
        if (maxCounterAnimals == 0) {
            try {
                throw new CounterException("It was NaN or zero");
            } catch (CounterException e) {
                LOGGER.info(e.getMessage());
            }
        }
        this.maxCounterAnimals = maxCounterAnimals;
    }

}
