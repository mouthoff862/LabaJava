package com.solvd.hospital.dao.jdbcmysqlimpl;

import com.solvd.hospital.connector.ConnectionPool;
import com.solvd.hospital.connector.ConnectionToDAO;
import com.solvd.hospital.dao.interfaces.ICleanerDAO;
import com.solvd.hospital.entities.Cleaner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CleanerDAO extends ConnectionToDAO implements ICleanerDAO {

    private final static Logger LOGGER = LogManager.getLogger(CleanerDAO.class);
    private ConnectionPool connectionPool = getConnectionPool();
    private Connection conn;
    private ResultSet rs = null;
    private PreparedStatement pr = null;
    Cleaner cleaner = new Cleaner();

    @Override
    public Cleaner getEntityById(int id) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("SELECT * FROM Cleaners WHERE id = ?");
            pr.setInt(1, id);
            pr.execute();
            rs = pr.getResultSet();
            while (rs.next()) {
                cleaner.setId(rs.getInt("id"));
                cleaner.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connectionPool.releaseConnection(conn);
            try {
                if (rs == null) rs.close();
                if (pr == null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
            }
        }
        return cleaner;
    }

    @Override
    public void createEntity(Cleaner cleaner) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("INSERT INTO Cleaners (name) VALUES (?)");
            pr.setString(1, rs.getString("name"));
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connectionPool.releaseConnection(conn);
            try {
                if (rs == null) rs.close();
                if (pr == null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
            }
        }
    }

    @Override
    public void updateEntity(Cleaner cleaner) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("UPDATE Cleaners SET name=? WHERE id=?");
            pr.setString(1, cleaner.getName());
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connectionPool.releaseConnection(conn);
            try {
                if (pr == null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
            }
        }
    }

    @Override
    public void removeEntity(int id) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("DELETE FROM Cleaners WHERE id=?");
            pr.setInt(1, rs.getInt("id"));
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connectionPool.releaseConnection(conn);
            try {
                if (pr == null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
            }
        }
    }

    @Override
    public List<Cleaner> showAllCleaners() {
        List<Cleaner> cleaners = new ArrayList<>();
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("SELECT * FROM Cleaners");
            pr.execute();
            rs = pr.getResultSet();
            while (rs.next()) {
                cleaner.setId(rs.getInt("id"));
                cleaner.setName(rs.getString("name"));
                cleaners.add(cleaner);
            }
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            connectionPool.releaseConnection(conn);
            try {
                if (rs == null) rs.close();
                if (pr == null) pr.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
            }
        }
        return cleaners;
    }
}
