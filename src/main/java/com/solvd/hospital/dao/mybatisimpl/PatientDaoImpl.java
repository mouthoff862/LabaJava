package com.solvd.hospital.dao.mybatisimpl;

import com.solvd.hospital.dao.IBaseDAO;
import com.solvd.hospital.entities.Patient;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.Reader;
import java.util.List;
import java.util.ResourceBundle;

public class PatientDaoImpl implements IBaseDAO<Patient> {

    @Override
    public Patient getById(int id) {
        return null;}

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
