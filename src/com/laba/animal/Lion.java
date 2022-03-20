package com.laba.animal;

public final class Lion extends Carnivores {

    private final String LION_NAME = "King Leon";
    private final String FAVOURITE_FOOD = "meat";

    public Lion(String animalType, int age, int maxWeight, String country, int maxSpeed) {
        super(animalType, age, maxWeight, country, maxSpeed);
    }

    public final void lionDescription() {
        System.out.println("Name of animal: " + LION_NAME + ".\n" +
                "His favourite food is " + FAVOURITE_FOOD + ".");
    }

    public String toString() {
        return ("This animal is a " + getAnimalType() + ".\n" + "He is from " + getCountry() + ".\n" +
                "Maximum adult weight can be up to " + getMaxWeight() + " kg.");
    }

}

