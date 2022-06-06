package com.solvd.hospital.dao.jdbcmysqlimpl;

import com.solvd.hospital.dao.connector.ConnectionPool;
import com.solvd.hospital.dao.interfaces.IDoctorDAO;
import com.solvd.hospital.entities.Doctor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO implements IDoctorDAO {

    private final static Logger LOGGER = LogManager.getLogger(DoctorDAO.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();
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
                LOGGER.info("Here is the doctor (found by id): " + doc);
            } catch (SQLException e) {
                LOGGER.info("There was a problem with GET ENTITY BY ID", e);
            } finally {
                try {
                    if (conn != null) connectionPool.releaseConnection(conn);
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
                pr.setString(1, doc.getName());
                pr.setString(2, doc.getPosition());
                pr.setInt(3, doc.getAge());
                pr.executeUpdate();
                LOGGER.info("The doctor was created");
            } catch (SQLException e) {
                LOGGER.info("There was a problem to create entity", e);
            } finally {
                try {
                    if (conn != null) connectionPool.releaseConnection(conn);
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
            pr.setString(2, doc.getPosition());
            pr.setInt(3, doc.getAge());
            LOGGER.info("The doctor was updated" + doc);
        } catch (SQLException e) {
            LOGGER.info("There was a problem to update entity", e);
        } finally {
            try {
                if (conn != null) connectionPool.releaseConnection(conn);
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
            pr.setInt(1, id);
            pr.executeUpdate();
            LOGGER.info("The doctor was deleted");
        } catch (SQLException e) {
            LOGGER.info("There was a problem to remove entity", e);
        } finally {
            try {
                if (conn != null) connectionPool.releaseConnection(conn);
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
            try {
                if (conn != null) connectionPool.releaseConnection(conn);
                if (rs == null) rs.close();
                if (pr == null) pr.close();
            } catch (SQLException e) {
                LOGGER.info("There was a problem in finally block", e);
            }
        }
        return doctors;
    }
}
