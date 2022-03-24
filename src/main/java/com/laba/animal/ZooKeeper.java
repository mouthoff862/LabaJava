package main.java.com.laba.animal;

import main.java.com.laba.exceptions.BooleanException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ZooKeeper implements IFeed {

    private final static Logger LOGGER = LogManager.getLogger(ZooKeeper.class);

    private String name;
    private String surname;
    private int experience;

    public ZooKeeper(String name, String surname, int experience) {
        this.name = name;
        this.surname = surname;
        this.experience = experience;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }


    public int getExperience() {
        return experience;
    }

    @Override
    public void printDuties() {
        System.out.println("Zookeeper feed");
    }

    public void move(ZooKeeper zooKeeper, AviaryOne firstAviary, AviaryOne secondAviary) {
        String name = zooKeeper.getName();
        String firstAviaryName = firstAviary.getNameAviary();
        String secondAviaryName = secondAviary.getNameAviary();
        LOGGER.info("Zookeeper " + name + " moves animals from " + firstAviaryName + " to " + secondAviaryName);
    }

    public void feeding(ZooKeeper zooKeeper, Food food, Food meal) {
        String name = zooKeeper.getName();
        String grass = food.getFoodName();
        String meat = meal.getFoodName();
        LOGGER.info(name + " feeds all animals twice a day with " + grass + " and " + meat);
    }

    public void setExperience(int experience) throws BooleanException {
        if (experience == 0) {
            throw new BooleanException("Zookeeper doesn't have work experience");
        }
        this.experience = experience;
    }

    public void keeperExperience() {
        try {
            setExperience(20);
            LOGGER.info("Zookeeper's work experience: " + getExperience() );
        } catch (BooleanException e) {
            LOGGER.info(e.getMessage());
        }
    }

}
