package main.java.com.solvd.animal;

import main.java.com.solvd.exceptions.NumCheckException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Aviary {

    private final static Logger LOGGER = LogManager.getLogger(Aviary.class);

    private String nameAviary;
    private int maxHeight;
    private int maxWidth;
    private int counterOfAviaries = 20;

    public Aviary(String nameAviary) {
        this.nameAviary = nameAviary;
    }

    public Aviary(int maxHeight, int maxWidth) {
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
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

    public void setCounterOfAviaries(int counterOfAviaries) {
        if (counterOfAviaries <= 0 && counterOfAviaries >= 50) {
            try {
                throw new NumCheckException("Something went wrong");
            } catch (NumCheckException e) {
                LOGGER.info(e.getMessage());
                this.counterOfAviaries = 20;
            }
        }
        this.counterOfAviaries = counterOfAviaries;
    }

}