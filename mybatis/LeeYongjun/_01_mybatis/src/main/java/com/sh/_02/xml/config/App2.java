package com.sh._02.xml.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class App2 {
    public static void main(String[] args) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menuDto = menuMapper.findByMenuCode(1);
        System.out.println(menuDto);

        sqlSession.close();
    }
}
