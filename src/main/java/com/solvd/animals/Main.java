package com.solvd.animals;

import com.solvd.animals.Aviary;
import com.solvd.animals.Food;
import com.solvd.animals.Zoo;
import com.solvd.animals.ZooKeeper;
import com.solvd.animals.animal.Kangaroo;
import com.solvd.animals.animal.Lion;
import com.solvd.animals.animal.Zebra;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;

import java.io.*;
import java.util.*;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        zookeeperDuties();

        // Collections:

        collectionOfAviaries();
        collectionLionHashSet();
        arrayListOfKangaroos();
        collectionOfZebras();
        getListOfHerbivores();

        findUniqueWords();

    }

    private static void zookeeperDuties() {
        ZooKeeper alex = new ZooKeeper("Alex", "Peter", 10);
        Aviary firstAviary = new Aviary(1);
        Aviary secondAviary = new Aviary(10);
        alex.move(firstAviary, secondAviary);

        ZooKeeper petr = new ZooKeeper("Alex", "Peter", 10);
        Food grass = new Food("grass");
        Food meat = new Food("meat");
        petr.feeding(grass, meat);

        Zoo zooName = new Zoo(11, "Zoo");
        zooName.showDescription(zooName, zooName);

        ZooKeeper anton = new ZooKeeper("Anton", "Mors", 20);
        anton.catchANewbie();
    }

    private static void collectionOfAviaries() {
        List<Aviary> numbers = new ArrayList<>();

        numbers.add(new Aviary(90, 20));
        numbers.add(new Aviary(40, 50));
        numbers.add(new Aviary(50, 90));

        LOGGER.info("Count of aviaries: " + numbers.size());

    }

    private static void arrayListOfKangaroos() {
        ArrayList<Kangaroo> arrayOfkangaroos = new ArrayList<>();
        arrayOfkangaroos.add(new Kangaroo("Kangaroo David", 15, 80, "Australia", 40));
        arrayOfkangaroos.add(new Kangaroo("Kangoo", 5, 40, "Australia", 30));

        for (Kangaroo kangaroo : arrayOfkangaroos) {
            LOGGER.info("Kangaroos: " + kangaroo.getAnimalType() + ". Max age:  " + kangaroo.getMaxAge() + ". Max weight: " + kangaroo.getMaxWeight());
        }
    }

    private static void collectionLionHashSet() {
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

    private static void collectionOfZebras() {
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

    private static void findUniqueWords() {
        String filePath = "D:/laba/src/main/java/resourses/lion.txt";
        String s = " ";
        List<String> uniqueWords = new ArrayList<>();
        try (FileReader fileReader = new FileReader(new File(filePath));
             BufferedReader reader = new BufferedReader(fileReader)) {
            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split("[\\s]+");
                for (String word : words) {
                    if (!uniqueWords.contains(word)) {
                        uniqueWords.add(word);
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(uniqueWords);
        LOGGER.info(uniqueWords);
        String[] words = s.split("\\s*(\\s|,|!|\\.)\\s*");
        Set<String> newWords = new HashSet<String>();
        Collections.addAll(uniqueWords);
        File newFile = new File("D:/laba/src/main/java/resourses/lionResult1.txt");

    }

}


