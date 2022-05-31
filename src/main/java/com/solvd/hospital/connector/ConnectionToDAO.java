package com.solvd.hospital.connector;

public class ConnectionToDAO {

    private static ConnectionPool connectionPool;

    static {
        connectionPool = ConnectionPool.getInstance();
    }

    public static ConnectionPool getConnectionPool() {
        return connectionPool;
    }

}
