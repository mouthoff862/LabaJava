package com.solvd.animals;

import com.solvd.animals.animal.Kangaroo;
import com.solvd.animals.animal.Opossum;
import com.solvd.animals.animal.Zebra;
import com.solvd.animals.enums.AnimalDesc;
import com.solvd.animals.functionalinterfaces.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

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

        //Functional Interfaces:

        lambdaFoodAble();
        lambdaICatchNewbie();
        lambdaIPrintID();
        lambdaShowPerimeter();
        lambdaDescriptionable();

        //Reflection:
        reflection();

        //Deadlock:
        deadlock();

    }

    private static void zookeeperDuties() {
        ZooKeeper alex = new ZooKeeper("Alex", "Peter", 10);
        Aviary firstAviary = new Aviary(1);
        Aviary secondAviary = new Aviary(10);
        alex.move(firstAviary, secondAviary);

        ZooKeeper petr = new ZooKeeper("Alex", "Peter", 10);
        Food grass = new Food("grass", 5, "Green");
        Food meat = new Food("meat", 10, "Red");
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
        Kangaroo secondKangoo = new Kangaroo("Kangoo Peter", 5, 40, "Austria", 30);

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
            Set<String> set = new HashSet<String>();
            String s = "Count of words";
            String text = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "src/main/resources/lion.txt"), "UTF-8");
            String[] words = StringUtils.split(text);
            words = StringUtils.stripAll(words, ",.;!$#�?'%&/()=");
            for (int i = 0; i < words.length; i++) {
                set.add(words[i]);
            }
            for (String word : set) {
                s = s + "\n" + word + "-> " + String.valueOf(StringUtils.countMatches(text, word));
            }
            FileUtils.writeStringToFile(new File(System.getProperty("user.dir") + "src/main/resources/lionResult4.txt"), s, "UTF-8");
        } catch (FileNotFoundException ex) {
            LOGGER.info(ex.getMessage());
        } catch (IOException e) {
            LOGGER.info(e);
        }
    }

    private static void enums() {
        for (AnimalDesc a : AnimalDesc.values()) {
            LOGGER.info(a.getMainAnimals().getValue() + " " + a.getSubAnimals().getValue());
        }
    }

    private static void lambdaDescriptionable() {
        Opossum opossumFirst = new Opossum("Opossum JAX", 5, 4, "France", 1);
        Opossum opossumSecond = new Opossum("Opossum Piter", 4, 3, "Poland", 1);

        Descriptionable desc = (x, y) -> {
            if (x.length() > y.length()) {
                return String.valueOf(x);
            } else {
                return String.valueOf(y);
            }
        };

        LOGGER.info("Animal name: " + desc.description(opossumFirst.getAnimalType(), opossumSecond.getAnimalType()));
    }

    private static void lambdaFoodAble() {
        Food firstFood = new Food("Meat", 40, "Red");
        Food secondFood = new Food("Grass", 20, "Green");

        Foodable foodable = (x, y) -> x * y;
        LOGGER.info("All animals eat " + foodable.multiply(firstFood.getMaxWeight(), secondFood.getMaxWeight()) + " kilograms per day");
    }

    private static void lambdaICatchNewbie() {
        ZooKeeper vasiliy = new ZooKeeper("Vasiliy", "Petrov", 10);
        ZooKeeper paul = new ZooKeeper("Paul", "Pavlovskiy", 20);

        ICatchNewbie catchNewbie = (x, y) -> {
            if (x > y)
                return "First Zookeeper has more work experience.";
            else
                return "Second Zookeeper has more work experience.";
        };
        LOGGER.info("Result: " + catchNewbie.get(vasiliy.getExperience(), paul.getExperience()));
    }

    private static void lambdaIPrintID() {
        Aviary aviOne = new Aviary(1);
        Aviary aviSecond = new Aviary(2);
        Aviary aviThird = new Aviary(3);
        Aviary aviFourth = new Aviary(4);
        Aviary aviFifth = new Aviary(5);

        List<Aviary> allAvies = new ArrayList<>();
        allAvies.add(aviOne);
        allAvies.add(aviSecond);
        allAvies.add(aviThird);
        allAvies.add(aviFourth);
        allAvies.add(aviFifth);

        int size = allAvies.size();

        IPrintId ids = x -> {
            if (x != size) {
                return "Size of aviaries is incorrect : ";
            } else {
                return "Size is correct : ";
            }
        };
        LOGGER.info(ids.apply(allAvies.size()) + " " + size);
    }

    private static void lambdaShowPerimeter() {
        Aviary aviary = new Aviary(10, 20, 30);

        IShowPerimeter perimeter = (x, y, l) -> {
            return x * y * l;
        };

        LOGGER.info("Perimeter: " + perimeter.calculate(aviary.getMaxWidth(), aviary.getMaxHeight(), aviary.getMaxLength()) + " m.");
    }

    private static void deadlock() {
        Food food = new Food("Grass", 52, "green");
        Food foodSecond = new Food("Meat", 10, "red");

        new Thread(new Runnable() {
            @Override
            public void run() {
                food.run(foodSecond);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                foodSecond.run(food);
            }
        }).start();
    }

    private static void reflection() {
        Zoo classZoo = new Zoo();
        Class<Zoo> cls = (Class<Zoo>) classZoo.getClass();
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            LOGGER.info("Method name : " + method.getName());
            LOGGER.info("Return type : " +
                    method.getReturnType().getName());

            Class<Zoo>[] params = (Class<Zoo>[]) method.getParameterTypes();
            LOGGER.info("Parameters : ");
            for (Class<Zoo> paramType : params) {
                LOGGER.info(" " + paramType.getName());
            }
        }
    }
}




