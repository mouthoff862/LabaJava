package main.java.com.laba.animal;

public abstract class Animal {
    private String animalType;
    private int age;
    private int maxWeight;
    private String country;
    private int maxSpeed;

    public Animal(String animalType, int age, int maxWeight, String country, int maxSpeed) {
        this.animalType = animalType;
        this.age = age;
        this.maxWeight = maxWeight;
        this.country = country;
        this.maxSpeed = maxSpeed;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

}
