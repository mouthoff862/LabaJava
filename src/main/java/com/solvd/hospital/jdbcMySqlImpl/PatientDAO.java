package com.solvd.hospital.jdbcmysqlimpl;

import com.solvd.hospital.dao.IBaseDAO;
import com.solvd.hospital.entities.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PatientDAO implements IBaseDAO<Patient> {

    private final static Logger LOGGER = LogManager.getLogger(PatientDAO.class);
    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pr = null;
    private static Properties properties = new Properties();
    private String url = "db.url";
    private String username = "db.username";
    private String password = "db.password";

    static {
        try {
            FileInputStream file = new FileInputStream("D:/laba/src/main/resourses/db.properties");
            properties.load(file);
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }

    @Override
    public Patient getById(int id) {
        Patient p = new Patient();
        try {
            conn = DriverManager.getConnection(url, username, password);
            pr = conn.prepareStatement("SELECT * FROM Patients WHERE id = ?");
            pr.setInt(1, id);
            pr.execute();
            rs = pr.getResultSet();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setEmail(rs.getString("email"));
                p.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pr != null) {
                    pr.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                LOGGER.info(ex.getMessage());
            }
        }
        return p;
    }

    @Override
    public void insert(Patient patient) {
        Patient p = new Patient();
        try {
            conn = DriverManager.getConnection(url, username, password);
            pr = conn.prepareStatement("INSERT INTO Patients (name, email, age) VALUES (?, ?, ?)");
            pr.setString(1, rs.getString("name"));
            pr.setString(2, rs.getString("email"));
            pr.setInt(3, rs.getInt("age"));
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pr != null) {
                    pr.close();
                }
            } catch (SQLException ex) {
                LOGGER.info(ex.getMessage());
            }
        }
    }

    @Override
    public void update(Patient patient) {
        Patient p = new Patient();
        try {
            conn = DriverManager.getConnection(url, username, password);
            pr = conn.prepareStatement("UPDATE Patients SET name=? email=? age=? WHERE id=?");
            pr.setString(1, patient.getName());
            pr.setString(2, patient.getEmail());
            pr.setInt(3, patient.getAge());
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pr != null) {
                    pr.close();
                }
            } catch (SQLException ex) {
                LOGGER.info(ex.getMessage());
            }
        }
    }

    @Override
    public void remove(int id) {
        Patient p = new Patient();
        try {
            conn = DriverManager.getConnection(url, username, password);
            pr = conn.prepareStatement("DELETE FROM Patients WHERE id=?");
            pr.setInt(1, rs.getInt("id"));
            pr.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pr != null) {
                    pr.close();
                }
            } catch (SQLException ex) {
                LOGGER.info(ex.getMessage());
            }
        }
    }

    @Override
    public List<Patient> selectAll() {
        List<Patient> patients = new ArrayList<>();
        Patient p = new Patient();
        try {
            conn = DriverManager.getConnection(url, username, password);
            pr = conn.prepareStatement("SELECT * FROM Patients");
            pr.execute();
            rs = pr.getResultSet();
            while (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setEmail(rs.getString("email"));
                p.setAge(rs.getInt("age"));
                patients.add(p);
            }
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pr != null) {
                    pr.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                LOGGER.info(ex.getMessage());
            }
        }
        return patients;
    }
}
