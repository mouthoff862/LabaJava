package com.solvd.hospital.dao.jdbcmysqlimpl;

import com.solvd.hospital.connector.ConnectionPool;
import com.solvd.hospital.connector.ConnectionToDAO;
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

public class PatientServiceDAO extends ConnectionToDAO implements IPatientServiceDAO {

    private final static Logger LOGGER = LogManager.getLogger(PatientServiceDAO.class);
    private ConnectionPool connectionPool = getConnectionPool();
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
    public void updateEntity(PatientService patientService) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("Update Patient_Services SET service_name=? WHERE id=?");
            pr.setString(1, service.getServiceName());
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
            pr = conn.prepareStatement("DELETE FROM Patient_Services WHERE id=?");
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
        return services;
    }
}
