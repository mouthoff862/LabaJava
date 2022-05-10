package com.solvd.hospital.jdbcMySqlImpl;

import com.solvd.hospital.connector.ConnectionPool;
import com.solvd.hospital.dao.IBaseDAO;
import com.solvd.hospital.entities.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PatientDAO implements IBaseDAO<Patient> {

    private final static Logger LOGGER = LogManager.getLogger(PatientDAO.class);
    private final static String GET_BY_ID = "SELECT * FROM Patients WHERE id = ?";

    @Override
    public Patient getById(int id) {
        Patient patient = null;
        try (Connection con = ConnectionPool.getConnection()) {
            PreparedStatement pr = con.prepareStatement(GET_BY_ID);
            pr.setInt(id, id);
            ResultSet rs = pr.executeQuery();
            patient = new Patient();
            patient.setId(rs.getInt("id"));
            patient.setName(rs.getString("name"));
            patient.setEmail(rs.getString("email"));
            patient.setAge(rs.getInt("age"));
            return patient;
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return patient;
    }

    @Override
    public void insert(Patient patient) {

    }

    @Override
    public void update(Patient patient) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Patient> selectAll() {
        return null;
    }
}
