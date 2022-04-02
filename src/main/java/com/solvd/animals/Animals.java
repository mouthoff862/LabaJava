package main.java.com.solvd.animal;

public abstract class Animals {

    private String animalType;
    private int maxAge;
    private int maxWeight;
    private String country;
    private int maxSpeed;

    public Animals(String animalType, int maxAge, int maxWeight, String country, int maxSpeed) {
        this.animalType = animalType;
        this.maxAge = maxAge;
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

    public void setAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getMaxAge() {
        return maxAge;
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

    public abstract void printAnimalType();

    public abstract void showMaxAge();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animals animal = (Animals) o;

        if (maxAge != animal.maxAge) return false;
        if (maxWeight != animal.maxWeight) return false;
        if (maxSpeed != animal.maxSpeed) return false;
        if (animalType != null ? !animalType.equals(animal.animalType) : animal.animalType != null) return false;
        return country != null ? country.equals(animal.country) : animal.country == null;
    }

    @Override
    public int hashCode() {
        int result = animalType != null ? animalType.hashCode() : 0;
        result = 31 * result + maxAge;
        result = 31 * result + maxWeight;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + maxSpeed;
        return result;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalType='" + animalType + '\'' +
                ", age=" + maxAge +
                ", maxWeight=" + maxWeight +
                ", country='" + country + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

}
