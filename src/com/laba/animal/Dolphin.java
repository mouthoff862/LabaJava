package com.laba.animal;

public class Dolphin extends Carnivores implements Swimable {

    public Dolphin(String animalType, int age, int maxWeight, String country, int maxSpeed) {
        super(animalType, age, maxWeight, country, maxSpeed);
    }

    @Override
    public void swim() {
        System.out.println("Dolphin can swim!");
    }

    @Override
    public void printName(Animal type) {
        String dolphin = type.getAnimalType();
        System.out.println(dolphin + " - description: ");
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

}
