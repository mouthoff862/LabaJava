package com.laba.animal;

public abstract class Carnivores extends Animal {

    public Carnivores(String animalType, int age, int maxWeight, String country, int maxSpeed) {
        super(animalType, age, maxWeight, country, maxSpeed);
    }

    public abstract void printName(Animal type);

    public abstract void showAge(Animal age);

}
