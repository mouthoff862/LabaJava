package com.solvd.hospital.dao.mybatisimpl;

import com.solvd.hospital.dao.IBaseDAO;
import com.solvd.hospital.entities.Doctor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class DoctorDAO implements IBaseDAO<Doctor> {
    private static final Logger LOGGER = LogManager.getLogger(DoctorDAO.class);
    private IBaseDAO base;
    private static SqlSession sqlSession;
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader = null;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            LOGGER.info("There was some problem to find a file", e);
        }
    }

    @Override
    public Doctor getById(int id) {
        base = sqlSessionFactory.openSession().getMapper(IBaseDAO.class);
        Doctor doctor = (Doctor) base.getById(id);
        return doctor;
    }

    @Override
    public void insert(Doctor doctor) {

    }

    @Override
    public void update(Doctor doctor) {
        IBaseDAO base;
        try {
            Reader reader = Resources.getResourceAsReader(System.getProperty("user.dir") + "/src/main/resources/mybatis/mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            base = sqlSessionFactory.openSession().getMapper(IBaseDAO.class);
            base.update(doctor);
        }catch (IOException e) {
            LOGGER.info("There was some problem to update", e);
        }
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Doctor> selectAll() {
        return null;
    }
}
