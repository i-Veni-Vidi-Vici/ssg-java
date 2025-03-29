package com.sh._01.java.config;

import com.sh.menu.model.dto.MenuDto;
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
 *
 */
public class App {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost/menudb";
        String user = "sh";
        String password = "sh";

        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),
                new PooledDataSource(driver, url, user, password));

        Configuration configuration = new Configuration(environment);
        // mapper 등록 (쿼리실행 할 메소드)
        configuration.addMapper(TestMapper.class);
        configuration.addMapper(MenuMapper.class);
        // 설정
        configuration.setMapUnderscoreToCamelCase(true); // 따로 설정해 줘야함

        // SqlSessionFactory - SqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession(false); // autocommit false 설정

        // 쿼리 실행
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menuDto = menuMapper.findByMenuCode(1);
        System.out.println(menuDto);

        List<MenuDto> list = menuMapper.findAll();
        System.out.println(list);

        TestMapper testmapper = sqlSession.getMapper(TestMapper.class);
        LocalDateTime now = testmapper.selectNow();
        System.out.println(now);

        // 반환
        sqlSession.close(); // 실제로 메모리에서 해제되진 않을거고 connectionpool로 반환하게 된다


    }

}
