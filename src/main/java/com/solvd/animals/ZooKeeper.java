package com.solvd.animals;

import com.solvd.animals.exceptions.ExperienceException;
import com.solvd.animals.interfaces.IFeed;
import com.solvd.animals.Aviary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ZooKeeper implements IFeed {

    private static final Logger LOGGER = LogManager.getLogger(ZooKeeper.class);

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

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public void printDuties() {
        LOGGER.info("Zookeeper feed");
    }

    public void move(Aviary firstAviary, Aviary secondAviary) {
        LOGGER.info("Zookeeper " + getName() + " moves animals from " + firstAviary.getIdAviary() + " to " + secondAviary.getIdAviary() + " aviary.");
    }

    public void feeding(Food food, Food meal) {
        LOGGER.info(getName() + " feeds all animals twice a day with " + food.getFoodName() + " and " + meal.getFoodName());
    }

    public void catchANewbie() {
        try {
            if (experience <= 5) {
                throw new ExperienceException("This zookeeper is a newbie. He needs to work more!");
            } else if (experience <= 30) {
                throw new ExperienceException("This man has great work experience!");
            } else {
                LOGGER.info("I think it's time for this guy to retire.");
            }
        } catch (ExperienceException e) {
            LOGGER.info(e.getMessage());
        }
    }

}


