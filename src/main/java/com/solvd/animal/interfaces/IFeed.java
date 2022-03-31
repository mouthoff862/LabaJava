package main.java.com.solvd.animal.interfaces;

public interface IFeed {

    default void printDuties() {
        System.out.println("Zookeeper feed");
    }

}
