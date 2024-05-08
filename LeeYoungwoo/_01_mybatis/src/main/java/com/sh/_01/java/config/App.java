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

/**
 * <pre>
 * Environment
 * -id 환경식별자
 *  - transaction 제어여부
 *      - ManagedTransactionFactory : 트랜잭션 관리를 mybatis에 위임
 *      - JdbcTransactionFactory : 트랜잭션 관리를 앱에서 직접 처리
 *  - connection pool (DBCP)사용여부
 *      - PooledDataSource
 *      - UnpooledDataSource
 *
 * Configuration
 *  - 쿼리실행 Mapper 등록
 *  - 기타 jdbc 설정
 *
 * SqlSessionFactory 객체
 *  - 프로그램별 1개 생성
 * SqlSession 객체
 *  - 사용자 요청이 있을때 마다 새로 생성
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb";
//        String url = "jdbc:mysql://localhost/menudb"; // 포트번호 3306은 mysql기본 포트번호라 생략 가능
        String user = "sh";
        String password = "sh";

        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(driver, url, user, password));
        Configuration configuration = new Configuration(environment);
        // mapper 등록 (mapper : 쿼리를 가진 메소드 묶음 인터페이스)
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
        System.out.println(now); // 2024-05-08T11:43:16

        // 반환
        sqlSession.close();

    }
}
