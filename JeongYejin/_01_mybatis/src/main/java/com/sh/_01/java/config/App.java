package com.sh._01.java.config;

import com.sh.Main;
import org.apache.ibatis.annotations.Select;
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
 * - id 환경식별자
 * - connection pool (DBCP) 사용여부
 *     - [V] PooledDataSource
 *     - [ ] UnpooledDataSource
 * - transaction 제어여부
 *     - [ ] ManagedTransactionFactory : 트랜잭션관리를 mybatis에 위임
 *     - [V] JdbcTransactionFactory : 트랜잭션관리를 app에서 직접 처리
 * Configuration
 *  - 쿼리실행 Mapper 등록
 *  - 기타 jdbc 설정
 *
 * SqlSessionFactory객체
 *  - 프로그램별 1개 생성
 * SqlSesstion객체
 *  - 사용자 요청이 있을 때 마다 새로 생성
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/menudb";
        String url = "jdbc:mysql://localhost/menudb";
        String user = "sh";
        String password = "sh";

        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(driver, url, user, password));
        Configuration configuration = new Configuration(environment);
        // mapper 등록 (mapper란? 쿼리를 가진 메소드 묶음 인터페이스)
        configuration.addMapper(TestMapper.class); // 넣어놓을 땐 configuration에
        configuration.addMapper(MenuMapper.class);
        // 설정
        configuration.setMapUnderscoreToCamelCase(true);

        // SqlSessionFactory - SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession(false); // autocommit false 설정

        // 쿼리 실행
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class); // 꺼내올 땐 sqlSession에서
        LocalDateTime now = testMapper.selectNow();
        System.out.println(now);

        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menuDto = menuMapper.findByMenuCode(1);
        System.out.println(menuDto);

        List<MenuDto> list = menuMapper.findAll();
        System.out.println(list);

        // 반환
        sqlSession.close();
    }
}