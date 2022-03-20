package com.laba.animal;

public class Carnivores extends Animal {

    public Carnivores(String animalType, int age, int maxWeight, String country, int maxSpeed) {
        super(animalType, age, maxWeight, country, maxSpeed);
    }

    @Override
    public void printName(Animal type) {
        String carnivore = type.getAnimalType();
        System.out.println(carnivore + " - description: ");
    }

    @Override
    public void showAge(Animal age) {
        int old = age.getAge();
        System.out.println("This animal can live up to " + old + " years.");
    }

    public String toString() {
        return ("This animal is a " + getAnimalType() + ".\n" + "He is from " + getCountry() + ".\n" +
                "Maximum adult weight can be up to " + getMaxWeight() + " kg.");
    }

}
