package main.java.com.solvd.interfaces;

public interface IFeed {

    default void printDuties() {
        System.out.println("Zookeeper feed");
    }

}
