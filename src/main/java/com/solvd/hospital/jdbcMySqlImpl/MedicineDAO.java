package com.solvd.hospital.jdbcmysqlimpl;

import com.solvd.hospital.connector.ConnectionPool;
import com.solvd.hospital.connector.ConnectionToDAO;
import com.solvd.hospital.dao.IBaseDAO;
import com.solvd.hospital.entities.Medicine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAO extends ConnectionToDAO implements IBaseDAO<Medicine> {

    private final static Logger LOGGER = LogManager.getLogger(CleanerDAO.class);
    private ConnectionPool connectionPool = getConnectionPool();
    private Connection conn;
    private ResultSet rs = null;
    private PreparedStatement pr = null;
    Medicine medicine = new Medicine();

    @Override
    public Medicine getById(int id) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("SELECT * FROM Medicines WHERE id = ?");
            pr.setInt(1, id);
            pr.execute();
            rs = pr.getResultSet();
            while (rs.next()) {
                medicine.setId(rs.getInt("id"));
                medicine.setMedicineName(rs.getString("name"));
                medicine.setUsed(rs.getString("used"));
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
        return medicine;
    }

    @Override
    public void insert(Medicine medicine) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("INSERT INTO Medicine (medicine_name, used) VALUES (?, ?)");
            pr.setString(1, rs.getString("medicine_name"));
            pr.setString(2, rs.getString("used"));
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
    public void update(Medicine medicine) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("Update Medicine SET medicine_name=? used=? WHERE id=?");
            pr.setString(1, medicine.getMedicineName());
            pr.setString(2, medicine.getUsed());
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
    public void remove(int id) {
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("DELETE FROM Medicines WHERE id=?");
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
    public List<Medicine> selectAll() {
        List<Medicine> medicines = new ArrayList<>();
        try {
            conn = connectionPool.getConnection();
            pr = conn.prepareStatement("SELECT * FROM Medicines");
            pr.execute();
            rs = pr.getResultSet();
            while (rs.next()) {
                medicine.setId(rs.getInt("id"));
                medicine.setMedicineName(rs.getString("medicine_name"));
                medicine.setUsed(rs.getString("used"));
                medicines.add(medicine);
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
        return medicines;
    }
}

