package com.solvd.hospital.connector;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionToDAO {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionToDAO.class);
    private static ConnectionPool connectionPool;

    static {
        connectionPool = ConnectionPool.getInstance();
    }

    public static ConnectionPool getConnectionPool() {
        return connectionPool;
    }

}
