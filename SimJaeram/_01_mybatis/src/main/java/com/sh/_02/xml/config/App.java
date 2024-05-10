package com.sh._02.xml.config;

import com.sh._01.java.config.MenuMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String resource ="mybatis-config.xml"; // resources 폴더 하위 경로

        try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
            SqlSession session = sqlSessionFactory.openSession(false);
            MenuMapper menuMapper = sqlSessionFactory.getMapper(MenuMapper.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
