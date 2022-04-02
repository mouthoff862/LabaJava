package main.java.com.solvd.animal;

import main.java.com.solvd.animal.exceptions.BooleanException;
import main.java.com.solvd.animal.interfaces.IFeed;
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

    public void move(ZooKeeper zooKeeper, Aviary firstAviary, Aviary secondAviary) {
        String name = zooKeeper.getName();
        String firstAviaryName = firstAviary.getNameAviary();
        String secondAviaryName = secondAviary.getNameAviary();
        LOGGER.info("Zookeeper " + name + " moves animals from " + firstAviaryName + " to " + secondAviaryName);
    }

    public void feeding(Food food, Food meal) {
        String grass = food.getFoodName();
        String meat = meal.getFoodName();
        LOGGER.info(getName() + " feeds all animals twice a day with " + grass + " and " + meat);
    }

    public void setExperience(int experience) {
        if (experience == 0) {
            try {
                throw new BooleanException("Zookeeper doesn't have work experience");
            } catch (BooleanException e) {
                LOGGER.info(e.getMessage());
            }
        }
        this.experience = experience;
    }

}
