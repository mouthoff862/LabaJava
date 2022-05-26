package com.solvd.hospital.connector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static Properties prop = new Properties();
    private static String url;
    private static String user;
    private static String password;
    private static int INITIAL_POOL_SIZE = 10;
    private static List<Connection> connectionPool = new ArrayList<>(INITIAL_POOL_SIZE);
    private List<Connection> usedConnections = new ArrayList<>();
    private static ConnectionPool instance = null;

    static {
        try {
            prop = new Properties();
            prop.load(new FileReader(System.getProperty("user.dir") + "/src/main/resources/db.properties"));
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }

    private ConnectionPool() {
    }

    private ConnectionPool(String url, String user, String password, List<Connection> pool) {
        this.url = url;
        this.user = user;
        this.password = password;
        connectionPool = pool;
    }

    public static ConnectionPool create(String url, String user, String password) {
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        try {
            pool = new ArrayList<>(INITIAL_POOL_SIZE);
            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                pool.add(createConnection(url, user, password));
            }
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return new ConnectionPool(url, user, password, pool);
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = ConnectionPool.create(prop.getProperty("db.url"), prop.getProperty("db.username"), prop.getProperty("db.password"));
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public static List<Connection> getConnectionPool() {
        return connectionPool;
    }

}




