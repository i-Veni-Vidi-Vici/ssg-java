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
 * - id 환결식별자
 * - transaction 제어여부
 *      - ManagedTransactionFactory : 트랜잭션관리를 mybatis에 위임
 *      - JdbcTransactionFactory : 트랜잭션관리를 앱에서 직접 처리
 * - connection pool(DBCP) 사용여부
 *      - PooledDataSource
 *      - UnPooledDataSource

 * Configuration
 * - 쿼리실행 Mapper 등록
 * - 기타 jdbc 설정
 * SqlSessionFactory객체
 * - 프로그램별 1개 생성
 * SqlSession객체
 * - 사용자 요청이 있을 때 마다 생성
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb";
        String user = "sh";
        String password = "sh";

        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(driver, url, user, password));

        Configuration configuration = new Configuration(environment);
        // mapper등록
        // mapper란? 쿼리를 가진 메서드 묶음 인터페이스
        configuration.addMapper(TestMapper.class);
        configuration.addMapper(MenuMapper.class);

        // 설정
        configuration.setMapUnderscoreToCamelCase(true);

        // SqlSessionFactory - SqlSession
        // SqlSession - Connection과 비슷
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession(false); // autocommit false 설정

        // 쿼리 실행
        // 구현 객체를 mybatis가 자동으로 만들어서 반환
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menuDto = menuMapper.findByMenuCode(3);
        System.out.println(menuDto);

        List<MenuDto> list = menuMapper.findAll();
        System.out.println(list);

        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        LocalDateTime now = testMapper.selectNow();
        System.out.println(now);

        // 반환 - (실제로는 해제되는것이 아니라 커넥션 풀로 돌아감)
        sqlSession.close();
    }
}
