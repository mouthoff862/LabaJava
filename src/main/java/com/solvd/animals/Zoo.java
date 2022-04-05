package com.solvd.animals;

import com.solvd.animals.exceptions.CounterException;
import com.solvd.animals.exceptions.EmptyLineException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Zoo {

    private static final Logger LOGGER = LogManager.getLogger(Zoo.class);

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

    public void setNameZoo(String nameZoo) {
        try {
            if (nameZoo == null)
                throw new EmptyLineException("Print some words");
        } catch (EmptyLineException e) {
            LOGGER.info(e.getMessage());
        }
        this.nameZoo = nameZoo;
    }

    public void setMaxCounterAnimals(int maxCounterAnimals) {
        try {
            if (maxCounterAnimals == 0)
                throw new CounterException("Try to enter number of count of animals");
        } catch (CounterException e) {
            LOGGER.info(e.getMessage());
        }
        this.maxCounterAnimals = maxCounterAnimals;
    }

}


