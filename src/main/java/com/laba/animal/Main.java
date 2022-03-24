package main.java.com.laba.animal;


import main.java.com.laba.exceptions.CounterException;
import main.java.com.laba.exceptions.AnimalNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Lion lion = new Lion("Lion", 14, 150, "Africa", 80);
        // lion.printName(lion);
        // lion.lionDescription();
        lion.setLionExc();

        AviaryOne avi = new AviaryOne("Zoo");
        avi.count(49);

        ZooKeeper max = new ZooKeeper("Alex", "Peter", 10);
        //max.printDuties();
        max.keeperExperience();

        Zoo zooOne = new Zoo();
        zooOne.printCount(10);

        Zoo zooTwo = new Zoo();
        zooTwo.nameOfZoo("Animal planet");

        LOGGER.info(lion.hashCode());

        Zebra.showDescription();

        ZooKeeper alex = new ZooKeeper("Alex", "Peter", 10);
        AviaryOne firstAviary = new AviaryOne("first aviary");
        AviaryOne secondAviary = new AviaryOne("second aviary");
        alex.move(alex, firstAviary, secondAviary);

        ZooKeeper petr = new ZooKeeper("Alex", "Peter", 10);
        Food grass = new Food("grass");
        Food meat = new Food("meat");
        petr.feeding(petr, grass, meat);

        Zoo zooName = new Zoo(11, "Zoo");
        zooName.showDescription(zooName, zooName);
    }


}
