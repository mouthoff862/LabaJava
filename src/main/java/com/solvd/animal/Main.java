package main.java.com.solvd.animal;

import main.java.com.solvd.exceptions.BooleanException;
import main.java.com.solvd.exceptions.CounterException;
import main.java.com.solvd.exceptions.EmptyLineException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws CounterException, BooleanException, EmptyLineException {

        Lion lion = new Lion("Lion", 14, 150, "Africa", 80);
        // lion.printName(lion);
        // lion.lionDescription();
        //lion.setLionExc();

        Aviary avi = new Aviary("Zoo");
        avi.setCounterOfAviaries(49);

        ZooKeeper max = new ZooKeeper("Alex", "Peter", 10);
        //max.printDuties();
        max.setExperience(20);

        Zoo zooOne = new Zoo();
        zooOne.setMaxCounterAnimals(10);

        Zoo zooTwo = new Zoo();
        zooTwo.setNameZoo("");

        LOGGER.info(lion.hashCode());

        Zebra.showDescription();

        // Collections:

        getIntOfAviaries();
        getLionHashSet();
        arrayListOfKangaroos();
        getListOfOmnivores();
        getListOfHerbivores();

    }

    private static void zookeeperDuties() {
        ZooKeeper alex = new ZooKeeper("Alex", "Peter", 10);
        Aviary firstAviary = new Aviary("first aviary");
        Aviary secondAviary = new Aviary("second aviary");
        alex.move(alex, firstAviary, secondAviary);

        ZooKeeper petr = new ZooKeeper("Alex", "Peter", 10);
        Food grass = new Food("grass");
        Food meat = new Food("meat");
        petr.feeding(petr, grass, meat);

        Zoo zooName = new Zoo(11, "Zoo");
        zooName.showDescription(zooName, zooName);
    }

    private static void getIntOfAviaries() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(5);
        numbers.add(6);
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);

        LOGGER.info("Numbers of aviaries: " + numbers);

        Collections.sort(numbers);

        LOGGER.info("Numbers after sorting: " + numbers);
    }

    private static void arrayListOfKangaroos() {
        ArrayList<Kangaroo> arrayOfkangaroos = new ArrayList<>();
        arrayOfkangaroos.add(new Kangaroo("Kangaroo David", 15, 80, "Australia", 40));
        arrayOfkangaroos.add(new Kangaroo("Kangoo", 5, 40, "Australia", 30));

        for (Kangaroo kangaroo : arrayOfkangaroos) {
            LOGGER.info("Kangaroos: " + kangaroo.getAnimalType() + ". Max age:  " + kangaroo.getAge() + ". Max weight:  "+ kangaroo.getMaxWeight());
        }
    }

    private static void getLionHashSet() {
        Lion lionFirst = new Lion("Lion", 14, 150, "Africa", 80);
        Lion lionSecond = new Lion("Tiger", 10, 140, "Africa", 70);

        LOGGER.info(lionFirst.equals(lionSecond));
        LOGGER.info(lionFirst.hashCode());
        LOGGER.info(lionSecond.hashCode());

        Set<Lion> lions = new HashSet<Lion>();
        lions.add(lionFirst);
        lions.add(lionSecond);
        LOGGER.info(lions.size());
    }

    private static void getListOfOmnivores() {
        List<String> omnivores = new ArrayList<>();
        omnivores.add("Dolphins");
        omnivores.add("Pig");
        omnivores.add("Bear");

        LOGGER.info(omnivores.size());
    }

    private static void getListOfHerbivores() {
        List<Zebra> zebras = new ArrayList<>();

        zebras.add(new Zebra("Zebra Tom", 20, 300, "Africa", 60));
        zebras.add(new Zebra("Zebra Fred", 15, 250, "Belarus", 60));
        zebras.add(new Zebra("Zebra Alex", 12, 270, "New Zealand", 65));

        LOGGER.info("All zebras : " + zebras);

        zebras.sort(Comparator.comparingInt(Zebra::getAge));

        LOGGER.info("Sorted Zebras List by Age : " + zebras);

        Collections.sort(zebras, Comparator.comparing(Zebra::getAnimalType));
        LOGGER.info("Sorted Zebras List by Name : " + zebras);

    }
}


