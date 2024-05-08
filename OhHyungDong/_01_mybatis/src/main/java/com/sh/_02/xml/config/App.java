package com.sh._02.xml.config;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class App {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
            SqlSession sqlSession = sqlSessionFactory.openSession(false);

            MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
//            MenuDto menuDto = menuMapper.findByMenuCode(1);

            MenuDto menuDto = menuMapper.findByMenuCode(1);
            System.out.println(menuDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

