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
 * - id 환경식별자
 * - transaction 제어여부
 *      - ManagedTransactionFactory : 트랜잭션 관리를 mybatis에 위임
 *      - JdbcTransactionFactory : 트랜잭션 관리를 앱에서 직접처리
 * - connection pool = 커넥션 수영장 (DataBaseConnectionPool) 사용여부
 *      - PooleDataSource = DBCP 쓰겟다
 *      - UnpooleDataSource = DBCP 안쓰겟다

 * Configuration
 * - 쿼리실행 Mapper 등록
 * - 기타 jdbc 설정
 * SqlSessionFactory객체
 * - 프로그램별 1개 생성
 * SqlSession객체
 * - 사용자 요청이 있을 때 마다 새로 생성
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb";// :// 이 뜻은 프로토콜 접속자 표시
        String user = "sh";
        String password = "sh";

        Environment environment = new Environment("dev",new JdbcTransactionFactory(),
                new PooledDataSource(driver,url,user,password));// 이 작업이 직접 jdbc를 컨트롤 하겠다
        Configuration configuration=new Configuration(environment);
        // mapper 등록 (쿼리를 실행할 메소드 정도로 생각), Mapper란?? = 쿼리를 가진 메소드 묶음 인터페이스
        configuration.addMapper(TestMapper.class);// 쿼리를 등록한다// 넣어놓을때는 configuration에 넣어놓고
        configuration.addMapper(MenuMapper.class);
        //TestMapper.class 에서 .class는 원본이고 이거를 베이스로 객체를 만드는거다, 클래스와 객체 사이에 있다, 클래스당 1개

        // 설정
        configuration.setMapUnderscoreToCamelCase(true);

        // SqlSessionFactory - SqlSession
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(configuration);///// 여기까지가 환경설정 최초 한 번 하는거
        SqlSession sqlSession = sqlSessionFactory.openSession(false);// autocommit false 설정

        // 쿼리 실행
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menuDto=menuMapper.findByMenuCode(1);
        System.out.println(menuDto);
        List<MenuDto> list=menuMapper.findAll();
        System.out.println(list);

        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);// 가져오는건 sqlsession mapper를 가져온다
        // 이 말은 인터페이스에서 구현객체를 저절로 만들어준다
        LocalDateTime now = testMapper.selectNow();
        System.out.println(now);

        // 반환, 커넥션 풀로 반환한다
        sqlSession.close();
    }
}
