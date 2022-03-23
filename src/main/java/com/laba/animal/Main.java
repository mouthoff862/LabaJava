package com.laba.animal;


public class Main {
    public static void main(String[] args) {

        Lion lion = new Lion("Lion", 14, 150, "Africa", 80);
        // lion.printName(lion);
        // lion.lionDescription();
        System.out.println(lion.equals(lion));

        System.out.println(lion.hashCode());

        Zebra.showDescription();

        ZooKeeper max = new ZooKeeper("Alex", "Peter", 10);
        max.printDuties();

        ZooKeeper alex = new ZooKeeper("Alex", "Peter", 10);
        AviaryOne firstAviary = new AviaryOne("first aviary");
        AviaryOne secondAviary = new AviaryOne("second aviary");
        alex.move(alex, firstAviary, secondAviary);

        ZooKeeper petr = new ZooKeeper("Alex", "Peter", 10);
        Food grass = new Food("grass");
        Food meat = new Food("meat");
        petr.feeding(petr, grass, meat);
    }
}
