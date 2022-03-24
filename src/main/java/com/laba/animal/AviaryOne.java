package main.java.com.laba.animal;

import main.java.com.laba.exceptions.NumCheckException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AviaryOne {

    private final static Logger LOGGER = LogManager.getLogger(AviaryOne.class);

    private String nameAviary;
    private int maxHeight;
    private int maxWidth;
    private int counterOfAviaries;

    public AviaryOne(String nameAviary) {
        this.nameAviary = nameAviary;
    }

    public AviaryOne(int maxHeight, int maxWidth) {
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
    }

    public static void massiveAviaries(int i, int i1, int i2, int i3) {
    }

    public void setNameAviary(String nameAviary) {
        this.nameAviary = nameAviary;
    }

    public String getNameAviary() {
        return nameAviary;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public int getCounterOfAviaries() {
        return counterOfAviaries;
    }

    public void setCounterOfAviaries(int counterOfAviaries) throws NumCheckException {
        if (counterOfAviaries <= 0 && counterOfAviaries >= 50) {
            throw new NumCheckException("Something went wrong");
        }
        this.counterOfAviaries = counterOfAviaries;
    }

    public void count(int a) {
        try {
            setCounterOfAviaries(counterOfAviaries);
            LOGGER.info("You entered the correct number: " + a);
        } catch (NumCheckException e) {
            LOGGER.info(e.getMessage());
        }
    }
}