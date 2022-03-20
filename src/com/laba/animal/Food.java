package com.laba.animal;

public class Food implements FoodDescription {
    private String foodName;
    private int maxWeight;
    private String color;

    public Food(String foodName) {
        this.foodName = foodName;
    }

    public Food(int maxWeight, String color) {
        this.maxWeight = maxWeight;
        this.color = color;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodName() {
        return this.foodName;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return this.maxWeight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    @Override
    public void foodDesc(Food food) {
        String meal = food.getFoodName();
        int kg = food.getMaxWeight();
        String foodColor = food.getColor();
        System.out.println("Food: " + meal + ".\n" +
                "Weight: " + kg + ".\n" +
                "Color: " + foodColor + ".");
    }
}
