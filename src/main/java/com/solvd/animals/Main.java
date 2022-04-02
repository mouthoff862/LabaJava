package main.java.com.solvd.animals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Lion lion = new Lion("Lion", 14, 150, "Africa", 80);
        // lion.printAnimalType(lion);
        // lion.lionDescription();
        //lion.setLionExc();

        Aviary avi = new Aviary("Zoo");
        avi.setCounterOfAviaries(49);

        LOGGER.info(lion.hashCode());

        Zebra.showDescription();

        // Collections:

        getIntOfAviaries();
        getLionHashSet();
        arrayListOfKangaroos();
        getListOfZebras();
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
        petr.feeding(grass, meat);

        Zoo zooName = new Zoo(11, "Zoo");
        zooName.showDescription(zooName, zooName);
    }

    private static void getIntOfAviaries() {
        List<Aviary> numbers = new ArrayList<Aviary>();

        numbers.add(new Aviary(90, 20));
        numbers.add(new Aviary(40, 50));
        numbers.add(new Aviary(50, 90));

        LOGGER.info("Numbers of aviaries: " + numbers.size());
                
    }

    private static void arrayListOfKangaroos() {
        ArrayList<Kangaroo> arrayOfkangaroos = new ArrayList<>();
        arrayOfkangaroos.add(new Kangaroo("Kangaroo David", 15, 80, "Australia", 40));
        arrayOfkangaroos.add(new Kangaroo("Kangoo", 5, 40, "Australia", 30));

        for (Kangaroo kangaroo : arrayOfkangaroos) {
            LOGGER.info("Kangaroos: " + kangaroo.getAnimalType() + ". Max age:  " + kangaroo.getMaxAge() + ". Max weight:  "+ kangaroo.getMaxWeight());
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

    private static void getListOfZebras() {
       LinkedList<Zebra> zebras = new LinkedList<>();

       Zebra zebraLittle = new Zebra("Little Zebra", 12, 200, "Africa", 50);
       Zebra zebraMiddle = new Zebra("Medium Zebra", 14, 250, "Australia", 55);
       Zebra zebraBig = new Zebra("Big zebra", 15, 300, "Africa", 60);

        zebras.add(zebraLittle);
        zebras.add(zebraMiddle);
        zebras.add(zebraBig);

        int i = 240;
        for (Zebra zebra : zebras) {
            if (i < zebra.getMaxWeight()) {
                LOGGER.info(zebra.getMaxWeight());
            }
        }

    }

    private static void getListOfHerbivores() {
        List<Zebra> zebras = new ArrayList<>();

        zebras.add(new Zebra("Zebra Tom", 20, 300, "Africa", 60));
        zebras.add(new Zebra("Zebra Fred", 15, 250, "Belarus", 60));
        zebras.add(new Zebra("Zebra Alex", 12, 270, "New Zealand", 65));

        LOGGER.info("All zebras : " + zebras);

        zebras.sort(Comparator.comparingInt(Zebra::getMaxAge));

        LOGGER.info("Sorted Zebras List by Age : " + zebras);

        Collections.sort(zebras, Comparator.comparing(Zebra::getAnimalType));
        LOGGER.info("Sorted Zebras List by Name : " + zebras);
    }
}


