package com.solvd.hospital.jdbcMySqlImpl;

import com.solvd.hospital.dao.IBaseDAO;
import com.solvd.hospital.entities.Doctor;
import com.solvd.hospital.entities.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DoctorDAO implements IBaseDAO<Doctor> {

    private static final Logger LOGGER = LogManager.getLogger(DoctorDAO.class);
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
    public Doctor getById(int id) {
        Doctor d = new Doctor();
        try {
            conn = DriverManager.getConnection(url, username, password);
            pr = conn.prepareStatement("SELECT * FROM Doctors WHERE id = ?");
            pr.setInt(1, id);
            pr.execute();
            rs = pr.getResultSet();
            while (rs.next()) {
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setPosition(rs.getString("email"));
                d.setAge(rs.getInt("age"));
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
        return d;
    }

    @Override
    public void insert(Doctor doctor) {
        Doctor d = new Doctor();
        try {
            conn = DriverManager.getConnection(url, username, password);
            pr = conn.prepareStatement("INSERT INTO Doctors (name, position, age) VALUES (?, ?, ?)");
            pr.setString(1, rs.getString("name"));
            pr.setString(2, rs.getString("position"));
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
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                LOGGER.info(ex.getMessage());
            }
        }
    }

    @Override
    public void update(Doctor doctor) {
        Doctor d = new Doctor();
        try {
            conn = DriverManager.getConnection(url, username, password);
            pr = conn.prepareStatement("UPDATE Doctors SET name=? position=? age=? WHERE id=?");
            pr.setString(1, doctor.getName());
            pr.setString(2, doctor.getPosition());
            pr.setInt(3, doctor.getAge());
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
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                LOGGER.info(ex.getMessage());
            }
        }
    }

    @Override
    public void remove(int id) {
        Doctor d = new Doctor();
        try {
            conn = DriverManager.getConnection(url, username, password);
            pr = conn.prepareStatement("DELETE FROM Doctors WHERE id=?");
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
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                LOGGER.info(ex.getMessage());
            }
        }

    }

    @Override
    public List<Doctor> selectAll() {
        List<Doctor> doctors = new ArrayList<>();
        Doctor doc = new Doctor();
        try {
            conn = DriverManager.getConnection(url, username, password);
            pr = conn.prepareStatement("SELECT * FROM Doctors");
            pr.execute();
            rs = pr.getResultSet();
            while (rs.next()) {
                doc.setId(rs.getInt("id"));
                doc.setName(rs.getString("name"));
                doc.setPosition(rs.getString("position"));
                doc.setAge(rs.getInt("age"));
                doctors.add(doc);
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
        return doctors;
    }
}
