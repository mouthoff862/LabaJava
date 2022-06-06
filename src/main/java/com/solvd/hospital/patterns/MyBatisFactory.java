package com.solvd.hospital.patterns;

import com.solvd.hospital.dao.interfaces.*;
import com.solvd.hospital.dao.mybatisimpl.*;
import com.solvd.hospital.entities.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Locale;

public class MyBatisFactory extends AbstractFactory {
    private static SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
    private static SqlSession session = sqlSessionFactory.openSession();

    public static IBaseDAO<?> getMyBatis(String mybatis) {
        mybatis = mybatis.toLowerCase();
        switch (mybatis) {
            case "patient":
                return new PatientDAO();
            case "doctor":
                return new DoctorDAO();
            case "medicine":
                return new MedicineDAO();
            case "patientService":
                return new PatientServiceDAO();
            case "cleaner":
                return new CleanerDAO();
         }
         return null;
    }

    public static SqlSession getSession() {
        return session;
    }

    public static void setSession(SqlSession sqlSession) {
        MyBatisFactory.session = session;
    }
}
