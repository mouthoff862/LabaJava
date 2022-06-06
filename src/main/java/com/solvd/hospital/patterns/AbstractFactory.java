package com.solvd.hospital.patterns;

public class AbstractFactory {
    private static DaoFactory daoFactory = new DaoFactory();
    private static MyBatisFactory myBatisFactory = new MyBatisFactory();

    public static AbstractFactory getFactory(String factory) {
        switch (factory) {
            case "daoFactory":
                return daoFactory;
            case "mybatisfactory":
                return myBatisFactory;
        }
        return null;
    }
}
