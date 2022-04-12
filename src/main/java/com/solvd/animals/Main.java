package com.solvd.animals;

import com.solvd.animals.animal.Kangaroo;
import com.solvd.animals.animal.Opossum;
import com.solvd.animals.animal.Zebra;
import com.solvd.animals.enums.AnimalDesc;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        zookeeperDuties();

        // Collections:

        collectionOfKeepers();
        collectionOpossumHashSet();
        collectionOfKangaroos();
        collectionOfZebras();
        collectionOfZebraMap();

        // Unique words in file:
        findUniqueWords();

        // Enum lesson:
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

    private static void collectionOfKeepers() {
        ZooKeeper david = new ZooKeeper("David", "Peters", 10);
        ZooKeeper paul = new ZooKeeper("Paul", "Austin", 15);
        ZooKeeper tom = new ZooKeeper("Tom", "Drake", 20);

        Set<ZooKeeper> keepers = new LinkedHashSet<>();

        keepers.add(david);
        keepers.add(paul);
        keepers.add(tom);

        keepers.stream().forEach(LOGGER::info);
    }

    private static void collectionOfKangaroos() {
        Kangaroo firstKangoo = new Kangaroo("Kangaroo David", 15, 80, "Australia", 40);
        Kangaroo secondKangoo = new Kangaroo("Kangoo Peter", 5, 40, "Australia", 30);

        List<Kangaroo> kangaroos = new ArrayList<>();

        kangaroos.add(firstKangoo);
        kangaroos.add(secondKangoo);

        kangaroos.stream().forEach(LOGGER::info);
    }

    private static void collectionOpossumHashSet() {
        Opossum opossumFirst = new Opossum("Opossum Jack", 14, 7, "Africa", 1);
        Opossum opossumSecond = new Opossum("Opossum Piter", 10, 5, "Africa", 1);

        LOGGER.info(opossumFirst.equals(opossumSecond));
        LOGGER.info(opossumFirst.hashCode());
        LOGGER.info(opossumSecond.hashCode());

        Set<Opossum> opossums = new HashSet<Opossum>();

        opossums.add(opossumFirst);
        opossums.add(opossumSecond);
        LOGGER.info(opossums.size());
        opossums.stream().forEach(LOGGER::info);
    }

    private static void collectionOfZebras() {
        Zebra zebraLittle = new Zebra("Little Zebra", 12, 200, "Africa", 50);
        Zebra zebraMiddle = new Zebra("Medium Zebra", 14, 250, "Australia", 55);
        Zebra zebraBig = new Zebra("Big zebra", 15, 300, "Africa", 60);

        LinkedList<Zebra> zebras = new LinkedList<>();

        zebras.add(zebraLittle);
        zebras.add(zebraMiddle);
        zebras.add(zebraBig);

        zebras.stream().forEach(LOGGER::info);
    }

    private static void collectionOfZebraMap() {
        Zebra zebraLittle = new Zebra("Little Zebra", 12, 120, "Africa", 60);
        Zebra zebraMiddle = new Zebra("Medium Zebra", 13, 130, "France", 70);
        Zebra zebraBig = new Zebra("Big Zebra", 15, 140, "Australia", 75);

        Map<String, Zebra> zebras = new HashMap<>();

        zebras.put("zebraLittle", zebraLittle);
        zebras.put("zebraMiddle", zebraMiddle);
        zebras.put("zebraBig", zebraBig);

        zebras.entrySet().stream().forEach(LOGGER::info);
    }

    private static void findUniqueWords() {
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


