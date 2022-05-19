package com.solvd.hospital.connector;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static final String DB_URL = "db.url";
    private static final String DB_USERNAME = "db.username";
    private static final String DB_PASSWORD = "db.password";
    private static Connection connection = null;
    private static Properties prop = null;
    private static ConnectionPool instance = null;
    private static BasicDataSource ds = new BasicDataSource();

    private ConnectionPool() {
    }

    static {
        try {
            prop = new Properties();
            prop.load(new FileReader("D:/laba/src/main/resourses/db.properties"));
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        ds.setUrl(DB_URL);
        ds.setUsername(DB_USERNAME);
        ds.setPassword(DB_PASSWORD);
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static ConnectionPool getInstance(){
        if (instance==null)
            instance = new ConnectionPool();
        return instance;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
