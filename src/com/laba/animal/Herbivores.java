package com.laba.animal;

public abstract class Herbivores extends Animal {

    public Herbivores(String animalType, int age, int maxWeight, String country, int maxSpeed) {
        super(animalType, age, maxWeight, country, maxSpeed);
    }

    public abstract void printName(Animal type);

    public abstract void showAge(Animal age);

}
