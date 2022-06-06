package com.solvd.hospital.dao.jdbcmysqlimpl;

import com.solvd.hospital.dao.connector.ConnectionPool;
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

public class CleanerDAO implements ICleanerDAO {

    private final static Logger LOGGER = LogManager.getLogger(CleanerDAO.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();
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
            LOGGER.info("Here is a cleaner (found by id)" + cleaner);
        } catch (SQLException e) {
            LOGGER.info("There was a problem with GET ENTITY BY ID", e);
        } finally {
            try {
                connectionPool.releaseConnection(conn);
                if (rs == null) rs.close();
                if (pr == null) pr.close();
            } catch (SQLException e) {
                LOGGER.info("There was a problem in finally block", e);
            }
        }
        return cleaner;
    }

    @Override
    public void createEntity(Cleaner cleaner) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("INSERT INTO Cleaners (name) VALUES (?)");
            pr.setString(1, cleaner.getName());
            pr.executeUpdate();
            LOGGER.info("Here is the cleaner (created): " + cleaner);
        } catch (SQLException e) {
            LOGGER.info("There was a problem to create entity");
        } finally {
            try {
                connectionPool.releaseConnection(conn);
                if (rs == null) rs.close();
                if (pr == null) pr.close();
            } catch (SQLException e) {
                LOGGER.info("There was a problem in finally block", e);
            }
        }
    }

    @Override
    public void updateEntity(Cleaner cleaner) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("UPDATE Cleaners SET name=? WHERE id=?");
            pr.setString(1, cleaner.getName());
            LOGGER.info("Here is the cleaner (updated)" + cleaner);
        } catch (SQLException e) {
            LOGGER.info("There was a problem to update entity");
        } finally {
            try {
                connectionPool.releaseConnection(conn);
                if (pr == null) pr.close();
            } catch (SQLException e) {
                LOGGER.info("There was a problem in finally block", e);
            }
        }
    }

    @Override
    public void removeEntity(int id) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("DELETE FROM Cleaners WHERE id=?");
            pr.setInt(1, id);
            pr.executeUpdate();
            LOGGER.info("Cleaner was removed!");
        } catch (SQLException e) {
            LOGGER.info("There was a problem to remove entity", e);
        } finally {
            try {
                connectionPool.releaseConnection(conn);
                if (pr == null) pr.close();
            } catch (SQLException e) {
                LOGGER.info("There was a problem in finally block", e);
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
            LOGGER.info("Here is the list of cleaners:" + cleaners + " ");
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            try {
                connectionPool.releaseConnection(conn);
                if (rs == null) rs.close();
                if (pr == null) pr.close();
            } catch (SQLException e) {
                LOGGER.info("There was a problem in finally block", e);
            }
        }
        return cleaners;
    }
}
