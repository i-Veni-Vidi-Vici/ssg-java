package com.sh._02.xml.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml"; // resources 폴더 하위 경로
        try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource)); // getResourceAsStream ->  mybatis에서 제공하는 inputstream과 같음
            SqlSession sqlSession = sqlSessionFactory.openSession(false);

            MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
            MenuDto menuDto = menuMapper.findByMenuCode(1);
            System.out.println(menuDto);

            sqlSession.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
