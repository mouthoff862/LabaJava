package com.solvd.hospital.dao.connector;

public class ConnectionToDAO {

    private static ConnectionPool connectionPool;

    static {
        connectionPool = ConnectionPool.getInstance();
    }

    public static ConnectionPool getConnectionPool() {
        return connectionPool;
    }

}
