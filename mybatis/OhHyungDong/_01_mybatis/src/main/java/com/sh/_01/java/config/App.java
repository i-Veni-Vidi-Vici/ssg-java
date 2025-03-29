package com.sh._01.java.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.awt.*;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

/**
 *  Environment
 *  *  - id 환경 식별자
 *  *  - transaction 제어여부
 *  *      - ManagedTransactionFactory : 트랜잭션관리를 mybatis에 위임
 *  *      - JdbcTransactionFactory : 트랜잭션관리를 앱에서 직접 처리
 *
 *     - connection pool (DBCP)사용여부
 *  *      - PooledDataSource
 *  *      - UnpooledDataSource
 *  * Configuration
 *  *  - 쿼리실행 Mapper 등록
 *  *  - 기타 jdbc 설정
 *  *
 *  * SqlSessionFactory객체
 *  *  - 프로그램별 1개 생성
 *  * SqlSession객체
 *  *  - 사용자 요청이 있을때 마다 새로 생성
 */
public class App {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb ";
        String user = "sh";
        String password = "sh";

        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(driver, url, user, password));

        Configuration configuration = new Configuration(environment);

        // mapper 등록 (mapper란 ? 쿼리를 가진 메소드 묶음 인터페이스)
        configuration.addMapper(TestMapper.class);
        configuration.addMapper(MenuMapper.class);

        // 설정
        // sql 컬럼명이랑 자바의 객체에 이름을 동일하게 만들어줌
        configuration.setMapUnderscoreToCamelCase(true); //기본값은 false underScore -> CamelCase랑 짝지어준다.

        //SqlSessionFactory - SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        //------ 환경설정 코드 ------

        SqlSession sqlSession = sqlSessionFactory.openSession(false); //autocommit : false 설정

        //쿼리 실행 - mybatis가 인터페이스 구현객체를 반환시켜줌

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menuDto = menuMapper.findByMenuCode(1);
        System.out.println(menuDto);

        List<MenuDto> list = menuMapper.findAll();
        System.out.println(list);

        TestMapper tesetmapper = sqlSession.getMapper(TestMapper.class);
        LocalDate now = tesetmapper.selectNow();
        System.out.println(now);

        //반환
        sqlSession.close();

    }
}
