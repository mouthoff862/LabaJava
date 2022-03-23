package com.laba.animal;

public class Zebra extends Herbivores implements Runable {

    private static String description;

    public Zebra(String animalType, int age, int maxWeight, String country, int maxSpeed) {
        super(animalType, age, maxWeight, country, maxSpeed);
    }

    static {
        description = "Zebra is from Africa.";
    }

    public static void showDescription() {
        System.out.println(description);
    }

    @Override
    public void printName(Animal type) {
        String zebra = type.getAnimalType();
        System.out.println(zebra + " - description: ");
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
    public void run() {
        System.out.println("Zebra can run!");
    }

}
