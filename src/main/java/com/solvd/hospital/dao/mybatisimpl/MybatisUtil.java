package com.solvd.hospital.dao.mybatisimpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory sessionFactory;
    private SqlSession session;

    static {
        String resource = (System.getProperty("user.dir") + "/src/main/resources/mybatis-config.xml");
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSessionFactory getSqlsessionfactory() {
        return sessionFactory;
    }

    public static SqlSession getSession() {
        return sessionFactory.openSession(false);
    }

    public void closeSession(SqlSession session) {
        if (session != null) {
            session.close();
            session = null;
        }
    }
}
