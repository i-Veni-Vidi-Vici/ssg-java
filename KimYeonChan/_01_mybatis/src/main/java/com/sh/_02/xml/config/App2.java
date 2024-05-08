package com.sh._02.xml.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;

/**
 *  <pre>
 *
 *  </pre>
 */
public class App2 {
    public static void main(String[] args) {
        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menuDto = menuMapper.findByMenuCode(1); // Mapper 인터페이스 추상 메소드로 실행 쿼리 조회
        System.out.println(menuDto);

        List<MenuDto> list = menuMapper.findAll();
        System.out.println(list);

        sqlSession.close();

    }
}
