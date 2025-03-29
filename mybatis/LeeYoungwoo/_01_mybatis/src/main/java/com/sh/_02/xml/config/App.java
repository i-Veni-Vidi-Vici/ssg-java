package com.sh._02.xml.config;

import com.sh._02.xml.config.MenuDto;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml"; // resources폴더 하위경로
        try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
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
