package com.solvd.hospital.dao.mybatisimpl;

import com.solvd.hospital.dao.interfaces.ICleanerDAO;
import com.solvd.hospital.entities.Cleaner;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class CleanerDAO implements ICleanerDAO {
    private final static Logger LOGGER = LogManager.getLogger(CleanerDAO.class);

    @Override
    public Cleaner getEntityById(int id) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            ICleanerDAO cleanerDAO = sqlSession.getMapper(ICleanerDAO.class);
            LOGGER.info("getCleanerById" + cleanerDAO.getEntityById(id));
            return cleanerDAO.getEntityById(id);
        }
    }

    @Override
    public void createEntity(Cleaner entity) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            ICleanerDAO cleanerDAO = sqlSession.getMapper(ICleanerDAO.class);
            sqlSession.insert("createCleaner", entity);
            LOGGER.info("The cleaner is created: " + entity);
            sqlSession.commit();
        }
    }

    @Override
    public void updateEntity(Cleaner entity) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            ICleanerDAO cleanerDAO = sqlSession.getMapper(ICleanerDAO.class);
            sqlSession.update("updateCleaner", entity);
            LOGGER.info("The cleaner is updated:  " + entity);
            sqlSession.commit();
        }
    }

    @Override
    public void removeEntity(int id) {
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            ICleanerDAO cleanerDAO = sqlSession.getMapper(ICleanerDAO.class);
            LOGGER.info("The cleaner was deleted :" + cleanerDAO.getEntityById(id));
            sqlSession.delete("removeCleaner", id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Cleaner> showAllCleaners() {
        List<Cleaner> cleaners;
        try (SqlSession sqlSession = MybatisUtil.getSqlSessionFactory().openSession()) {
            ICleanerDAO cleanerDAO = sqlSession.getMapper(ICleanerDAO.class);
            cleaners = sqlSession.selectList("showAllCleaners");
            cleaners.stream().forEach(LOGGER::info);
        }
        return cleaners;
    }
}
