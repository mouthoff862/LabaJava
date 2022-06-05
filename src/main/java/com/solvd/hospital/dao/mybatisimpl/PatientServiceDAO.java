package com.solvd.hospital.dao.mybatisimpl;

import com.solvd.hospital.dao.interfaces.IPatientServiceDAO;
import com.solvd.hospital.entities.PatientService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PatientServiceDAO implements IPatientServiceDAO {
    private final static Logger LOGGER = LogManager.getLogger(PatientServiceDAO.class);

    @Override
    public PatientService getEntityById(int id) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IPatientServiceDAO patientDAO = sqlSession.getMapper(IPatientServiceDAO.class);
            LOGGER.info("getServiceById" + patientDAO.getEntityById(id));
            return patientDAO.getEntityById(id);
        }
    }

    @Override
    public void createEntity(PatientService entity) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IPatientServiceDAO patientDAO = sqlSession.getMapper(IPatientServiceDAO.class);
            sqlSession.insert("createService", entity);
            LOGGER.info("The patient is created : " + entity);
            sqlSession.commit();
        }
    }

    @Override
    public void updateEntity(PatientService entity) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IPatientServiceDAO patientDAO = sqlSession.getMapper(IPatientServiceDAO.class);
            sqlSession.update("updateService", entity);
            LOGGER.info("The patient was updated:  " + entity);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IPatientServiceDAO patientDAO = sqlSession.getMapper(IPatientServiceDAO.class);
            LOGGER.info("The patient was deleted :" + patientDAO.getEntityById(id));
            sqlSession.delete("removeService", id);
            sqlSession.commit();
        }
    }

    @Override
    public List<PatientService> showAllPatientServices() {
        List<PatientService> patientServices;
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IPatientServiceDAO patientDAO = sqlSession.getMapper(IPatientServiceDAO.class);
            patientServices = sqlSession.selectList("showPatientServices");
            patientServices.stream().forEach(LOGGER::info);
        }
        return patientServices;
    }
}
