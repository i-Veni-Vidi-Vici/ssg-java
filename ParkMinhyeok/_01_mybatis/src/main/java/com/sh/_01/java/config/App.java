package com.sh._01.java.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb";
        String user = "sh";
        String password = "sh";

        Environment environment = new Environment("dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(driver, url, user, password));
        Configuration configuration = new Configuration(environment);
        // mapper 등록(mapper란? 쿼리를 가진 메소드 묶음 인터페이스)
        configuration.addMapper(TestMapper.class);
        configuration.addMapper(MenuMapper.class);
        // 설정
        configuration.setMapUnderscoreToCamelCase(true);

        // SqlSessionFactory - SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession(false); // autocommit false 설정

        // 쿼리 실행
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menuDto = menuMapper.findByMenuCode(1);
        System.out.println(menuDto);

        List<MenuDto> list = menuMapper.findAll();
        System.out.println(list);

        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        LocalDateTime now = testMapper.selectNow();
        System.out.println(now);

        // 반환
        sqlSession.close();
    }
}
