package com.solvd.hospital.dao.mybatisimpl;

import com.solvd.hospital.dao.interfaces.IMedicineDAO;
import com.solvd.hospital.entities.Medicine;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MedicineDAO implements IMedicineDAO {
    private final static Logger LOGGER = LogManager.getLogger(MedicineDAO.class);

    @Override
    public Medicine getEntityById(int id) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IMedicineDAO medicineDAO = sqlSession.getMapper(IMedicineDAO.class);
            LOGGER.info("getMedicineById" + medicineDAO.getEntityById(id));
            return medicineDAO.getEntityById(id);
        }
    }

    @Override
    public void createEntity(Medicine entity) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IMedicineDAO medicineDAO = sqlSession.getMapper(IMedicineDAO.class);
            sqlSession.insert("createMedicine", entity);
            LOGGER.info("The medicine is created : " + entity);
            sqlSession.commit();
        }
    }

    @Override
    public void updateEntity(Medicine entity) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IMedicineDAO medicineDAO = sqlSession.getMapper(IMedicineDAO.class);
            sqlSession.update("updateMedicine", entity);
            LOGGER.info("The medicine is updated:  " + entity);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IMedicineDAO medicineDAO = sqlSession.getMapper(IMedicineDAO.class);
            LOGGER.info("The medicine was deleted :" + medicineDAO.getEntityById(id));
            sqlSession.delete("removeMedicine", id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Medicine> showAllMedicines() {
        List<Medicine> medicines;
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            IMedicineDAO medicineDAO = sqlSession.getMapper(IMedicineDAO.class);
            medicines = sqlSession.selectList("showMedicines");
            medicines.stream().forEach(LOGGER::info);
        }
        return medicines;
    }
}
