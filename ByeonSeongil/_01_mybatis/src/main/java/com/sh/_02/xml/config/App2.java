package com.sh._02.xml.config;

import static com.common.MyBatisTemplate.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class App2 {
    public static void main(String[] args) {
        SqlSession sqlSession = getSqlSession();

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menuDto = menuMapper.findByMenuCode(3); // Mapper인터페이스-추상메서드로 실행쿼리 조회
        System.out.println(menuDto);

        List<MenuDto> list = menuMapper.findAll();
        System.out.println(list);

        sqlSession.close();
    }
}
