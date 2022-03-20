package com.laba.animal;

public class Zebra extends Herbivores {

    private static String description;

    public Zebra(String animalType, int age, int maxWeight, String country, int maxSpeed) {
        super(animalType, age, maxWeight, country, maxSpeed);
    }

    static {
        description = "Zebra is from Africa too.";
    }

    public static void showDescription() {
        System.out.println(description);
    }

    public String toString() {
        return ("This animal is a " + getAnimalType() + ".\n" + "He is from " + getCountry() + ".\n" +
                "Maximum adult weight can be up to " + getMaxWeight() + " kg.");
    }

}
