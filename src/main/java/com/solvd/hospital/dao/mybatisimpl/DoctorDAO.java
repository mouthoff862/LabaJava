package com.solvd.hospital.dao.mybatisimpl;

import com.solvd.hospital.dao.interfaces.IDoctorDAO;
import com.solvd.hospital.entities.Doctor;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class DoctorDAO implements IDoctorDAO {
    private static final Logger LOGGER = LogManager.getLogger(DoctorDAO.class);

    @Override
    public Doctor getEntityById(int id) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IDoctorDAO doctorDAO = sqlSession.getMapper(IDoctorDAO.class);
            LOGGER.info("getDoctorById" + doctorDAO.getEntityById(id));
            return doctorDAO.getEntityById(id);
        }
    }

    @Override
    public void createEntity(Doctor entity) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IDoctorDAO doctorDAO = sqlSession.getMapper(IDoctorDAO.class);
            sqlSession.insert("createDoctor", entity);
            LOGGER.info("The doctor is created : " + entity);
            sqlSession.commit();
        }
    }

    @Override
    public void updateEntity(Doctor entity) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IDoctorDAO doctorDAO = sqlSession.getMapper(IDoctorDAO.class);
            sqlSession.update("updateDoctor", entity);
            LOGGER.info("The doctor is updated:  " + entity);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IDoctorDAO doctorDAO = sqlSession.getMapper(IDoctorDAO.class);
            LOGGER.info("The doctor was deleted :" + doctorDAO.getEntityById(id));
            sqlSession.delete("removeDoctor", id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Doctor> showAllDoctors() {
        List<Doctor> doctors;
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IDoctorDAO doctorDAO = sqlSession.getMapper(IDoctorDAO.class);
            doctors = sqlSession.selectList("showDoctors");
            doctors.stream().forEach(LOGGER::info);
        }
        return doctors;
    }
}
