package com.laba.animal;

public class Zoo implements ZooDescription {
    private int counter;
    private String nameZoo;

    public Zoo() {
    }

    public Zoo(int getCounter) {
        this.counter = getCounter;
    }

    public Zoo(String nameZoo) {
        this.nameZoo = nameZoo;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public void setNameZoo(String nameZoo) {
        this.nameZoo = nameZoo;
    }

    public String getNameZoo() {
        return this.nameZoo;
    }

    @Override
    public void showDescription(Zoo counterAnimals, Zoo nameOfZoo) {
        int count = counterAnimals.getCounter();
        String zooName = nameOfZoo.getNameZoo();
        System.out.println("Name of Zoo: " + zooName + ".\n" + "Maximum number of animals in the zoo: " + count);
    }

}
