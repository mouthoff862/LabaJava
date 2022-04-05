package com.solvd.animals.interfaces;

public interface IFeed {

    default void printDuties() {
        System.out.println("Zookeeper feed");
    }

}
