package com.solvd.animals;

import com.solvd.animals.animal.Kangaroo;
import com.solvd.animals.animal.Lion;
import com.solvd.animals.animal.Zebra;
import com.solvd.animals.enums.AnimalDesc;
import com.solvd.animals.exceptions.AnimalNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;

import java.util.stream.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
        collectionOfHerbivores();


        findUniqueWords();

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
        List<Kangaroo> arrayOfkangaroos = new ArrayList<>();
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

    private static void collectionOfHerbivores() {
        Zebra zebraLittle = new Zebra("Little Zebra", 12, 200, "Africa", 50);
        Zebra zebraMiddle = new Zebra("Medium Zebra", 14, 250, "Australia", 55);
        Zebra zebraBig = new Zebra("Big zebra", 15, 300, "Africa", 60);
        Map<String, Zebra> zebras = new HashMap<>();

        zebras.put("zebraLittle", zebraLittle);
        zebras.put("zebraMiddle", zebraMiddle);
        zebras.put("zebraBig", zebraBig);

        zebras.entrySet().stream().map(o -> o.getKey() + " " + o.getValue()).forEach(LOGGER::info);
    }

    private static void findUniqueWords()  {
        try {
            File file = new File("D:/laba/src/main/java/resourses/lion.txt");
            String string = StringUtils.lowerCase(FileUtils.readFileToString(file, StandardCharsets.UTF_8))
                    .replaceAll("\\s*(\\s|,|!|\\.)\\s*", " ");
            String[] array = string.split(" ");
            Set<String> hashSet = new HashSet(List.of(array));
            List<String> list = new ArrayList<>();
            for (String str : hashSet) {
                list.add(str + " " + StringUtils.countMatches(string, str));
            }
            FileUtils.writeLines(new File("D:/laba/src/main/java/resourses/lionRESULT1.txt"), list);
        } catch (IOException e) {
            LOGGER.info(e);
        }
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


