package com.solvd.hospital.dao.jdbcmysqlimpl;

import com.solvd.hospital.dao.connector.ConnectionPool;
import com.solvd.hospital.dao.interfaces.IPatientServiceDAO;
import com.solvd.hospital.entities.PatientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientServiceDAO implements IPatientServiceDAO {

    private final static Logger LOGGER = LogManager.getLogger(PatientServiceDAO.class);
    private ConnectionPool connectionPool = ConnectionPool.getInstance();
    private Connection conn;
    private ResultSet rs = null;
    private PreparedStatement pr = null;
    PatientService service = new PatientService();

    @Override
    public PatientService getEntityById(int id) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("SELECT * FROM Patient_Services WHERE id = ?");
            pr.setInt(1, id);
            pr.execute();
            rs = pr.getResultSet();
            while (rs.next()) {
                service.setId(rs.getInt("id"));
                service.setServiceName(rs.getString("service_name"));
            }
        } catch (SQLException e) {
            LOGGER.info("There was a problem to get entity by id", e);
        } finally {
            try {
                if (conn != null) connectionPool.releaseConnection(conn);
                if (rs == null) rs.close();
                if (pr == null) pr.close();
            } catch (SQLException e) {
                LOGGER.info("There was a problem in finally block", e);
            }
        }
        return service;
    }

    @Override
    public void createEntity(PatientService patientService) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("INSERT INTO Patient_Services (name) VALUES (?)");
            pr.setString(1, rs.getString("service_name"));
            pr.executeUpdate();
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
    public void updateEntity(PatientService patientService) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("Update Patient_Services SET service_name=? WHERE id=?");
            pr.setString(1, service.getServiceName());
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
            pr = conn.prepareStatement("DELETE FROM Patient_Services WHERE id=?");
            pr.setInt(1, id);
            pr.executeUpdate();
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
    public List<PatientService> showAllPatientServices() {
        List<PatientService> services = new ArrayList<>();
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("SELECT * FROM Cleaners");
            pr.execute();
            rs = pr.getResultSet();
            while (rs.next()) {
                service.setId(rs.getInt("id"));
                service.setServiceName(rs.getString("service_name"));
                services.add(service);
                LOGGER.info("Here is a list of patient services: " + services + " ");
            }
        } catch (SQLException e) {
            LOGGER.info("There was a problem to show a list of patient services", e);
        } finally {
            try {
                if (conn != null) connectionPool.releaseConnection(conn);
                if (rs == null) rs.close();
                if (pr == null) pr.close();
            } catch (SQLException e) {
                LOGGER.info("There was a problem in finally block", e);
            }
        }
        return services;
    }
}
