package com.laba.animal;

public class Sparrow extends Omnivores implements Flyable {

    public Sparrow(String animalType, int age, int maxWeight, String country, int maxSpeed) {
        super(animalType, age, maxWeight, country, maxSpeed);
    }

    @Override
    public void printName(Animal type) {
        String sparrow = type.getAnimalType();
        System.out.println(sparrow + " - description: ");
    }

    @Override
    public void showAge(Animal age) {
        int old = age.getAge();
        System.out.println("This animal can live up to " + old + " years.");
    }

    @Override
    public String toString() {
        return ("This animal is a " + getAnimalType() + ".\n" + "He is from " + getCountry() + ".\n" +
                "Maximum adult weight can be up to " + getMaxWeight() + " kg.");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow can fly!");
    }
}
