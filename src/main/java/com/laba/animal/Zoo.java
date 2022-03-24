package main.java.com.laba.animal;

import main.java.com.laba.exceptions.CounterException;
import main.java.com.laba.exceptions.EmptyLineException;
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
            throw new EmptyLineException("Print some words");
        }
        this.nameZoo = nameZoo;
    }

    public void setMaxCounterAnimals(int maxCounterAnimals) throws CounterException {
        if (maxCounterAnimals == 0) {
            throw new CounterException("It was NaN or zero");
        }
        this.maxCounterAnimals = maxCounterAnimals;
    }

    public void printCount(int maxCounterAnimals) {
        try {
            setMaxCounterAnimals(maxCounterAnimals);
            LOGGER.info("Max counter animals " + getMaxCounterAnimals());
        } catch (CounterException e) {
            LOGGER.info(e.getMessage());
        }
    }

    public void nameOfZoo(String nameZoo) {
        try {
            setNameZoo(nameZoo);
            LOGGER.info("Name of zoo: " + getNameZoo());
        } catch (EmptyLineException e) {
            LOGGER.info(e.getMessage());
        }
    }

}
