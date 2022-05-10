package com.solvd.hospital.connector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static final String DB_DRIVER = "db.driver.class.name";
    private static final String DB_URL = "db.url";
    private static final String DB_USERNAME = "db.username";
    private static final String DB_PASSWORD = "db.password";

    private static Connection connection = null;
    private static Properties prop = null;

    static {
        try {
            prop = new Properties();
            prop.load(new FileReader("D:/laba/src/main/resourses/db.properties"));
            Class.forName(prop.getProperty(DB_DRIVER));
            connection = DriverManager.getConnection(prop.getProperty(DB_URL), prop.getProperty(DB_USERNAME), prop.getProperty(DB_PASSWORD));
        } catch (ClassNotFoundException | SQLException | IOException e) {
            LOGGER.info(e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }

}
