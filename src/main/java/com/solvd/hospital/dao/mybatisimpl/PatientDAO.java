package com.solvd.hospital.dao.mybatisimpl;

import com.solvd.hospital.dao.interfaces.IPatientDAO;
import com.solvd.hospital.dao.interfaces.IPatientServiceDAO;
import com.solvd.hospital.entities.Patient;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PatientDAO implements IPatientDAO {
    private final static Logger LOGGER = LogManager.getLogger(PatientDAO.class);

    @Override
    public Patient getEntityById(int id) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IPatientDAO patientDAO = sqlSession.getMapper(IPatientDAO.class);
            LOGGER.info("getPatientById" + patientDAO.getEntityById(id));
            return patientDAO.getEntityById(id);
        }
    }

    @Override
    public void createEntity(Patient patient) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IPatientDAO patientDAO = sqlSession.getMapper(IPatientDAO.class);
            sqlSession.insert("createPatient", patient);
            LOGGER.info("The patient is created : " + patient);
            sqlSession.commit();
        }
    }

    @Override
    public void updateEntity(Patient patient) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IPatientDAO patientDAO = sqlSession.getMapper(IPatientDAO.class);
            sqlSession.update("updatePatient", patient);
            LOGGER.info("The patient was updated:  " + patient);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IPatientDAO patientDAO = sqlSession.getMapper(IPatientDAO.class);
            LOGGER.info("The patient was deleted :" + patientDAO.getEntityById(id));
            sqlSession.delete("removePatient", id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Patient> showAllPatients() {
        List<Patient> patients;
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IPatientServiceDAO patientDAO = sqlSession.getMapper(IPatientServiceDAO.class);
            patients = sqlSession.selectList("showPatients");
            LOGGER.info(patients);
        }
        return patients;
    }
}
