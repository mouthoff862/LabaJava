package com.laba.animal;

public class ZooKeeper implements Staff {
    private String name;
    private String surname;
    private int experience;

    public ZooKeeper(String name, String surname, int experience) {
        this.name = name;
        this.surname = surname;
        this.experience = experience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience() {
        return this.experience;
    }

    @Override
    public void printDuties() {
        System.out.println("Zookeepers duties: ");
    }

    public void move(ZooKeeper zooKeeper, AviaryOne firstAviary, AviaryOne secondAviary) {
        String name = zooKeeper.getName();
        String firstAviaryName = firstAviary.getNameAviary();
        String secondAviaryName = secondAviary.getNameAviary();
        System.out.println("Zookeeper " + name + " moves animals from " + firstAviaryName + " to " + secondAviaryName);
    }

    public void feeding(ZooKeeper zooKeeper, Food food, Food meal) {
        String name = zooKeeper.getName();
        String grass = food.getFoodName();
        String meat = meal.getFoodName();
        System.out.println(name + " feeds all animals twice a day with " + grass + " and " + meat);
    }

}
