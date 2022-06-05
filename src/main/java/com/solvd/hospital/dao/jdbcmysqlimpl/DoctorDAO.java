package com.solvd.hospital.dao.jdbcmysqlimpl;

import com.solvd.hospital.dao.connector.ConnectionPool;
import com.solvd.hospital.dao.interfaces.IDoctorDAO;
import com.solvd.hospital.entities.Doctor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.solvd.hospital.dao.connector.ConnectionToDAO.getConnectionPool;

public class DoctorDAO implements IDoctorDAO {

    private final static Logger LOGGER = LogManager.getLogger(DoctorDAO.class);
    private ConnectionPool connectionPool = getConnectionPool();
    private Connection conn;
    private ResultSet rs = null;
    private PreparedStatement pr = null;
    Doctor doc = new Doctor();

    @Override
    public Doctor getEntityById(int id) {
            try {
                conn = connectionPool.getConnection();
                pr = conn.prepareStatement("SELECT * FROM Doctors WHERE id = ?");
                pr.setInt(1, id);
                pr.execute();
                rs = pr.getResultSet();
                while (rs.next()) {
                    doc.setId(rs.getInt("id"));
                    doc.setName(rs.getString("name"));
                    doc.setPosition(rs.getString("position"));
                    doc.setAge(rs.getInt("age"));
                }
            } catch (SQLException e) {
                LOGGER.info("There was a problem with GET ENTITY BY ID", e);
            } finally {
                connectionPool.releaseConnection(conn);
                try {
                    if (rs == null) rs.close();
                    if (pr == null) pr.close();
                } catch (SQLException e) {
                    LOGGER.info("There was a problem in finally block", e);
                }
            }
            return doc;
    }

    @Override
    public void createEntity(Doctor doc) {
            try {
                conn = connectionPool.getConnection();
                pr = conn.prepareStatement("INSERT INTO Doctors (name, position, age) VALUES (?, ?, ?)");
                pr.setString(1, rs.getString("name"));
                pr.setString(2, rs.getString("position"));
                pr.setInt(3, rs.getInt("age"));
                pr.executeUpdate();
            } catch (SQLException e) {
                LOGGER.info("There was a problem to create entity", e);
            } finally {
                connectionPool.releaseConnection(conn);
                try {
                    if (rs == null) rs.close();
                    if (pr == null) pr.close();
                } catch (SQLException e) {
                    LOGGER.info("There was a problem in finally block", e);
                }
            }
    }

    @Override
    public void updateEntity(Doctor doc) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("UPDATE Doctors SET name=? position=? age=? WHERE id=?");
            pr.setString(1, doc.getName());
            pr.setString(2, rs.getString("position"));
            pr.setInt(3, rs.getInt("age"));
        } catch (SQLException e) {
            LOGGER.info("There was a problem to update entity", e);
        } finally {
            connectionPool.releaseConnection(conn);
            try {
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
            pr = conn.prepareStatement("DELETE FROM Doctors WHERE id=?");
            pr.setInt(1, rs.getInt("id"));
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("There was a problem to remove entity", e);
        } finally {
            connectionPool.releaseConnection(conn);
            try {
                if (pr == null) pr.close();
            } catch (SQLException e) {
                LOGGER.info("There was a problem in finally block", e);
            }
        }
    }

    @Override
    public List<Doctor> showAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("SELECT * FROM Cleaners");
            pr.execute();
            rs = pr.getResultSet();
            while (rs.next()) {
                doc.setId(rs.getInt("id"));
                doc.setName(rs.getString("name"));
                doc.setPosition(rs.getString("position"));
                doc.setAge(rs.getInt("age"));
                doctors.add(doc);
                LOGGER.info("Here is a list of doctors: " + doctors + " ");
            }
        } catch (SQLException e) {
            LOGGER.info("There was a problem to add list", e);
        } finally {
            connectionPool.releaseConnection(conn);
            try {
                if (rs == null) rs.close();
                if (pr == null) pr.close();
            } catch (SQLException e) {
                LOGGER.info("There was a problem in finally block", e);
            }
        }
        return doctors;
    }
}
