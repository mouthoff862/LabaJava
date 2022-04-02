package main.java.com.solvd.animals.interfaces;

public interface IFeed {

    default void printDuties() {
        System.out.println("Zookeeper feed");
    }

}
