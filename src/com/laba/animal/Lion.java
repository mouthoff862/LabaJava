package com.laba.animal;

public final class Lion extends Carnivores implements Runable {

    private final static String LION_NAME = "King Leon";
    private final static String FAVOURITE_FOOD = "meat";

    public Lion(String animalType, int age, int maxWeight, String country, int maxSpeed) {
        super(animalType, age, maxWeight, country, maxSpeed);
    }

    public final void lionDescription() {
        System.out.println("Name of animal: " + LION_NAME + ".\n" +
                "His favourite food is " + FAVOURITE_FOOD + ".");
    }

    @Override
    public String toString() {
        return ("This animal is a " + getAnimalType() + ".\n" + "He is from " + getCountry() + ".\n" +
                "Maximum adult weight can be up to " + getMaxWeight() + " kg.");
    }

    @Override
    public void printName(Animal type) {
        String lion = type.getAnimalType();
        System.out.println(lion + " - description: ");
    }

    @Override
    public void showAge(Animal age) {
        int old = age.getAge();
        System.out.println("This animal can live up to " + old + " years.");
    }

    @Override
    public void run() {
        System.out.println("Lion can run");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Lion name = (Lion) o;
        if (LION_NAME == null) {
            if (name.LION_NAME != null)
                return false;
        } else if (!LION_NAME.equals(name.LION_NAME)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int hash = 31;
        int result = 1;
        result = result * hash + ((FAVOURITE_FOOD == null) ? 0 : FAVOURITE_FOOD.hashCode());
        return result;
    }

}