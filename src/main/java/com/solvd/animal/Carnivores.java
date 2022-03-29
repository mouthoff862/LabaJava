package main.java.com.solvd.animal;

import java.util.Objects;

public abstract class Carnivores {

    private String animalType;
    private int age;
    private int maxWeight;
    private String country;
    private int maxSpeed;

    public Carnivores(String animalType, int age, int maxWeight, String country, int maxSpeed) {
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

    public abstract void printName();

    public abstract void showAge();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carnivores carnivores = (Carnivores) o;
        return Objects.equals(animalType, carnivores.animalType);
    }

    @Override
    public int hashCode() {
        int result = animalType.hashCode();
        result = 31 * result + age;
        result = 31 * result + maxWeight;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + maxSpeed;
        return result;
    }

    @Override
    public String toString() {
        return "Carnivores{" +
                "animalType='" + animalType + '\'' +
                ", age=" + age +
                ", maxWeight=" + maxWeight +
                ", country='" + country + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

}
