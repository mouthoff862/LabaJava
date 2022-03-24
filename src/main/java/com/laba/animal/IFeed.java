package main.java.com.laba.animal;

public interface IFeed {

    default void printDuties() {
        System.out.println("Zookeeper feed");
    }

}
