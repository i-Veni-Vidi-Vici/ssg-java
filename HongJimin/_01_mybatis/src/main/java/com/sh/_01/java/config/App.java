package com.sh._01.java.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment; // ibatis로 시작을 했다가 구글 밑으로 들어가면서 mybatis라고 바뀜, mybatis안에도 옛날 ibatis가 남아있어서 가끔 튀어나옴
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <pre>
 *   Envionment
 * - id 환경 식별자
 * - transaction 제어 여부
 *     - ManaggedTransacionFactory : 트랜잭션 관리를 mybatis에 위임
 *     - JdbcTransactionFactory : 트랜잭션 관리를 앱에서 직접 처리
 * - connection pool ( DBCP )사용 여부
 *     - PooledDataSource
 *     - UnPooledDataSource
 *     - JDBC 단점
 *         - 쿼리 사용할 때마다 connection을 쓰고 close(메모리 상에서 진짜 지워버림)하는 것을 방지하기 위함
 *     - connection pool장점
 *         - connection을 튜브처럼 만들어 놓고, 놀고 있는 connection을 쓰고 다 쓰면 다시 돌려놓자!가 connection pool의 아이디어
 *         - 동시에 여러 사용자의 요청을 처리할 수 있다는 장점이 있음
 *
 * Configuration
 * - 쿼리 실행 Mapper 등록
 * - 기타 jdbc 설정
 *
 * SqlSessionFactory 객체
 * - Envionment이랑 Configuration을 사용해 만듦
 * - 프로그램 별 1개만 생성
 * - SqlSession객체를 직어내는 역할
 *
 * SQLSession객체
 * - 사용자 요청이 있을 때마다 새로 생성
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb"; // port번호는 생략 가능 3306으로 고정이어서!
        String user = "sh";
        String password = "sh";


        Environment environment = new Environment("dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(driver,url, user, password));
        Configuration configuration = new Configuration(environment);
        // mapper 등록 (쿼리를 실행할 메소드) -> 더이상 preparedStatement 작성 안해도됨
        // mapper란? 쿼리를 가진 메소드 묶음 인터페이스
        configuration.addMapper(TestMapper.class);
        configuration.addMapper(MenuMapper.class);
        // 설정
        configuration.setMapUnderscoreToCamelCase(true); // ⛳컬럼명과 동일한 이름을 찾아서 넣어주려고 하는 과정, menu_code가 아니라 menuCode를 찾아줘! 하는 과정, 기본 값이 false임

        // SqlSessionFactory - SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration); //공장 생성 완료 - ⚙🛠✨여기까지가 환경 설정
        SqlSession sqlSession = sqlSessionFactory.openSession(false); // autocommit false 설정

        // 쿼리 실행
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menuDto = menuMapper.findByMenuCode(1);
        System.out.println(menuDto);

        List<MenuDto> list = menuMapper.findAll();
        System.out.println(list); // 리스트로 만들어주는 것도 가능!

        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        LocalDateTime now = testMapper.selectNow();// 메소드에 관한 값이 나옴
        System.out.println(now);

        // 반환
        sqlSession.close();
    }
}











