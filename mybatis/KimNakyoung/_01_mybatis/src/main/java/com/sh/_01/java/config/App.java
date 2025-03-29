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
// ibatis 라는 프로젝트로 시작했다가 구글 밑으로 들어가면서 mybatis로 바꿔져서 기존 ibatis 프로젝트를 품었다.

/**
 * <pre>
 *
 * Environment
 * - id 환경 식별자
 * - transaction 제어여부
 *      - ManagedTransactionFactory : 트랜잭션관리를 mybatis에 위임
 *      - JdbcTransactionFactory : 트랜잭션관리를 앱에서 직접 처리
 * - connection pool (DBCP) 사용여부
 *      - PooledDataSource
 *      - UnPooledDataSource
 *
 *

 * Configuration
 * - 쿼리실행 Mapper 등록
 * - 기타 jdbc 설정
 *
 * sqlSessionFactory객체
 * - 프로그램 별 1개 생성
 * sqlSesstion객체
 *  - 사용자 요청이 있을 때 마다 새로 생성
 * </pre>
 */



public class App {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb"; // 3306번(기본, 생략가능)에 기다리고 있는 서버에 접속 하고 싶습니다.
        String user = "sh";
        String password = "sh";

        //식별자
        // Jdbc 쓸꺼니 안쓸꺼니

        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(driver,url,user,password));
        Configuration configuration = new Configuration(environment);
        // mapper등록 (쿼리실행할 메소드)
        configuration.addMapper(TestMapper.class);
        configuration.addMapper(MenuMapper.class);
        // 설정
        // 클래스객체란 ?

        configuration.setMapUnderscoreToCamelCase(true); // 짝지어주자. _ 를 카멜케이싱으로 짝지어주자

        //SqlSesstionFactory - SqlSesstion
        // 공장으로 sql 객체 찍어내기

        SqlSessionFactory sqlSesstionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSesstionFactory.openSession(false);

        // 쿼리 실행

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class); // 인터페이스 만드세요
        MenuDto menuDto = menuMapper.findByMenuCode(1);// 1번 메뉴 주세요
        System.out.println(menuDto);

        List<MenuDto> list = menuMapper.findAll();
        System.out.println(list);

        TestMapper testMapper = sqlSession.getMapper(TestMapper.class); // 인터페이스 만드세요
        LocalDateTime now = testMapper.selectNow();
        System.out.println(now);


    }
}
