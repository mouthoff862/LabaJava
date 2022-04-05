package com.solvd.animals.animal;

public abstract class Animals {

    private int maxAge;
    private int maxWeight;
    private String country;
    private int maxSpeed;

    public Animals(int maxAge, int maxWeight, String country, int maxSpeed) {

        this.maxAge = maxAge;
        this.maxWeight = maxWeight;
        this.country = country;
        this.maxSpeed = maxSpeed;
    }

    public void setAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public abstract void printAnimalType();

    public abstract void showMaxAge();

}
