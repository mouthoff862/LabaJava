package main.java.com.laba.animal;


import main.java.com.laba.exceptions.CounterException;
import main.java.com.laba.exceptions.AnimalNotFoundException;

public class Main {
    public static void main(String[] args) {

        Lion lion = new Lion("Lion", 14, 150, "Africa", 80);
        // lion.printName(lion);
        // lion.lionDescription();
        lion.setLionExc();

        AviaryOne avi = new AviaryOne("Zoo");
        avi.count(49);

        Zoo zoo = new Zoo();
        zoo.printCount(10);
        //zoo.nameOfZoo();

        System.out.println(lion.hashCode());

        Zebra.showDescription();

        ZooKeeper max = new ZooKeeper("Alex", "Peter", 10);
        //max.printDuties();
        max.keeperExperience();

        ZooKeeper alex = new ZooKeeper("Alex", "Peter", 10);
        AviaryOne firstAviary = new AviaryOne("first aviary");
        AviaryOne secondAviary = new AviaryOne("second aviary");
        alex.move(alex, firstAviary, secondAviary);

        ZooKeeper petr = new ZooKeeper("Alex", "Peter", 10);
        Food grass = new Food("grass");
        Food meat = new Food("meat");
        petr.feeding(petr, grass, meat);

        Zoo zoo1 = new Zoo(11, "Zoo");
        zoo1.showDescription(zoo1, zoo1);
    }


}
