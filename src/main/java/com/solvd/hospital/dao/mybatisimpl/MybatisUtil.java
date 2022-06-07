package com.solvd.hospital.dao.mybatisimpl;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static final Logger LOGGER = LogManager.getLogger(MybatisUtil.class);
    private static SqlSessionFactory factory;

    private MybatisUtil() {
    }

    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);

        } catch (IOException e) {
            LOGGER.info("There was some problem with getting resources in MyBatisUtil", e);
        }
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }

}
