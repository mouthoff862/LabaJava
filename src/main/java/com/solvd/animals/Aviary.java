package com.solvd.animals;

import com.solvd.animals.exceptions.NumCheckException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Aviary {

    private static final Logger LOGGER = LogManager.getLogger(Aviary.class);
    private int idAviary;
    private int maxHeight;
    private int maxWidth;
    private int maxLength;

    public Aviary(int idAviary) {
        this.idAviary = idAviary;
    }

    public Aviary(int maxHeight, int maxWidth, int maxLength) {
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
        this.maxLength = maxLength;
    }

    public void setIdAviary(int idAviary) {
        this.idAviary = idAviary;
    }

    public int getIdAviary() {
        return idAviary;
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

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return maxLength;
    }


    public void checkNumberAviary() {
        try {
            if (idAviary == 0) {
                throw new NumCheckException("Number cannot be ZERO!");
            } else {
                LOGGER.info("ID of aviary is: " + getIdAviary());
            }
        } catch (NumCheckException e) {
            LOGGER.info(e.getMessage());
        }
    }

}