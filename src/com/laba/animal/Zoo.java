package com.laba.animal;

public class Zoo {
    private int maxCounterAnimals;
    private String nameZoo;

    public Zoo() {
    }

    public Zoo(int maxCounterAnimals) {
        this.maxCounterAnimals = maxCounterAnimals;
    }

    public Zoo(String nameZoo) {
        this.nameZoo = nameZoo;
    }

    public void setCounter(int maxCounterAnimals) {
        this.maxCounterAnimals = maxCounterAnimals;
    }

    public int getMaxCounterAnimals() {
        return maxCounterAnimals;
    }

    public void setNameZoo(String nameZoo) {
        this.nameZoo = nameZoo;
    }

    public String getNameZoo() {
        return nameZoo;
    }

    public void showDescription(Zoo counterAnimals, Zoo nameOfZoo) {
        int count = counterAnimals.getMaxCounterAnimals();
        String zooName = nameOfZoo.getNameZoo();
        System.out.println("Name of Zoo: " + zooName + ".\n" + "Maximum number of animals in the zoo: " + count);
    }
}
