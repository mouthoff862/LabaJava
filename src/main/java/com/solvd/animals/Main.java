package com.solvd.animals;

import com.solvd.animals.animal.Kangaroo;
import com.solvd.animals.animal.Lion;
import com.solvd.animals.animal.Zebra;
import com.solvd.animals.enums.AnimalDesc;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

        try {
            findUniqueWords();
        } catch (IOException e) {
            e.printStackTrace();
        }

        enums();

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

    private static void findUniqueWords() throws IOException {

        String filePath = "D:/laba/src/main/java/resourses/lion.txt";
        String s = " ";

        try {
            s = Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        String[] allWords = s.split("\\s*(\\s|,|!|\\.)\\s*");
        Set<String> uniqueWords = new HashSet<String>();
        for (Object word : uniqueWords) {
            uniqueWords.add(word + ": " + StringUtils.countMatches(s, (CharSequence) word));
        }
        Collections.addAll(uniqueWords, allWords);
        FileUtils.writeLines(new File("D:/laba/src/main/java/resourses/lionResult.txt"), uniqueWords);
    }

    private static void enums() {
        LOGGER.info(AnimalDesc.LION.getMainAnimals().getValue());
        LOGGER.info(AnimalDesc.LION.getSubAnimals().getValue());
        LOGGER.info(AnimalDesc.OPOSSUM.getMainAnimals().getValue());
        LOGGER.info(AnimalDesc.OPOSSUM.getSubAnimals().getValue());
        LOGGER.info(AnimalDesc.ZEBRA.getMainAnimals().getValue());
        LOGGER.info(AnimalDesc.ZEBRA.getSubAnimals().getValue());
        LOGGER.info(AnimalDesc.SPARROW.getMainAnimals().getValue());
        LOGGER.info(AnimalDesc.SPARROW.getSubAnimals().getValue());
        LOGGER.info(AnimalDesc.AFRICA.getMainAnimals().getValue());
        LOGGER.info(AnimalDesc.AFRICA.getSubAnimals().getValue());
        LOGGER.info(AnimalDesc.ITALY.getMainAnimals().getValue());
        LOGGER.info(AnimalDesc.ITALY.getSubAnimals().getValue());
        LOGGER.info(AnimalDesc.FOOD_MEAT.getMainAnimals().getValue());
        LOGGER.info(AnimalDesc.FOOD_MEAT.getSubAnimals().getValue());
        LOGGER.info(AnimalDesc.FOOD_GRASS.getMainAnimals().getValue());
        LOGGER.info(AnimalDesc.FOOD_GRASS.getSubAnimals().getValue());
    }

}


