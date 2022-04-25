package com.solvd.animals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Food {
    private static final Logger LOGGER = LogManager.getLogger(Food.class);
    private String foodName;
    private int maxWeight;
    private String color;

    public Food(String foodName, int maxWeight, String color) {
        this.foodName = foodName;
        this.maxWeight = maxWeight;
        this.color = color;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public synchronized void run() {
        try {
            Date d = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
            LOGGER.info("Date when the " +
                    getFoodName() + " was arrived : " + ft.format(d));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printName() {
        String food = "Grass";
        LOGGER.info("Meal: " + food);
    }
}
