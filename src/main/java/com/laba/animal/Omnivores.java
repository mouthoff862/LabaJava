package main.java.com.laba.animal;

public abstract class Omnivores extends Animal {

    public Omnivores(String animalType, int age, int maxWeight, String country, int maxSpeed) {
        super(animalType, age, maxWeight, country, maxSpeed);
    }

    public abstract void printName(Animal type);

    public abstract void showAge(Animal age);

}
