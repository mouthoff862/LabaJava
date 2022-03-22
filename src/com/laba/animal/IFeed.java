package com.laba.animal;

public interface IFeed {

    public default void printDuties() {
        System.out.println("Zookeeper feed");;
    }

}
