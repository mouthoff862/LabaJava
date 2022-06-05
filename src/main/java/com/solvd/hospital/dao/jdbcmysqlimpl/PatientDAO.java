package com.solvd.hospital.dao.jdbcmysqlimpl;

import com.solvd.hospital.dao.connector.ConnectionPool;
import com.solvd.hospital.dao.interfaces.IPatientDAO;
import com.solvd.hospital.entities.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import static com.solvd.hospital.dao.connector.ConnectionToDAO.getConnectionPool;

public class PatientDAO implements IPatientDAO {

    private final static Logger LOGGER = LogManager.getLogger(PatientDAO.class);
    private ConnectionPool connectionPool = getConnectionPool();
    private Connection conn;
    private ResultSet rs = null;
    private PreparedStatement pr = null;
    Patient patient = new Patient();

    @Override
    public Patient getEntityById(int id) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("SELECT * FROM Patients WHERE id = ?");
            pr.setInt(1, id);
            pr.execute();
            rs = pr.getResultSet();
            while (rs.next()) {
                patient.setId(rs.getInt("id"));
                patient.setName(rs.getString("name"));
                patient.setEmail(rs.getString("email"));
                patient.setAge(rs.getInt("age"));
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
        return patient;
    }

    @Override
    public void createEntity(Patient patient) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("INSERT INTO Patients (name, email, age) VALUES (?, ?, ?)");
            pr.setString(1, rs.getString("name"));
            pr.setString(2, rs.getString("email"));
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
    public void updateEntity(Patient patient) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("UPDATE Patients SET name=? email=? age=? WHERE id=?");
            pr.setString(1, patient.getName());
            pr.setString(2, rs.getString("email"));
            pr.setInt(3, rs.getInt("age"));
        } catch (SQLException e) {
            LOGGER.info("There was a problem to update entity");
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
            pr = conn.prepareStatement("DELETE FROM Patients WHERE id=?");
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
    public List<Patient> showAllPatients() {
        List<Patient> patients = new ArrayList<>();
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("SELECT * FROM Patients");
            pr.execute();
            rs = pr.getResultSet();
            while (rs.next()) {
                patient.setId(rs.getInt("id"));
                patient.setName(rs.getString("name"));
                patient.setEmail(rs.getString("email"));
                patient.setAge(rs.getInt("age"));
                patients.add(patient);
                LOGGER.info("Here is a list of patients: " + patients + " ");
            }
        } catch (SQLException e) {
            LOGGER.info("There was a problem to show a list of patients", e);
        } finally {
            connectionPool.releaseConnection(conn);
            try {
                if (rs == null) rs.close();
                if (pr == null) pr.close();
            } catch (SQLException e) {
                LOGGER.info("There was a problem in finally block", e);
            }
        }
        return patients;
    }
}

