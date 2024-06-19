package com.sh._01_spring_mybatis.config;

import com.sh._01_spring_mybatis.menu.model.dao.MenuMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * <pre>
 * @PropertySource - @Value 설정값을 읽어와야 하지만,
 * application.properties 혹은 application.yaml에 작성되있는 경우, @Value만 작성하면 된다.
 *
 * 등록할 빈
 * - DataSource
 * - SqlSessionFactory
 * - SqlSessionTemplate
 *
 * <pre>
 *
 */
@Configuration
public class DataSourceConfig {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    /**
     * DB에 접속하는 Connection객체를 관리할 ConnectionPool이 필요하다.
     * HikariCP는 그 중 빠르고 경량화된 라이브러리여서 Springboot에서 기본적으로 사용하고 있다.
     *
     * destoryMethod="close"
     * - 빈이 메모리 해제될 때 호출되는 메소드
     * - DB접속과 관련된 자원해제처리가 close 안에 구현되어 있다.
     * @return
     */
    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        // DB에 접속하기 위한 정보
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);

        // ConnectionPool 관련 속성
        dataSource.setConnectionTimeout(30000); // 커넥션 최대 대기시간 30초로 설정
        dataSource.setIdleTimeout(60000); // Idle 커넥션풀 내에 사용중이 아닌 커넥션 객체를 가리킨다.
        dataSource.setMaximumPoolSize(50); // 커넥션 객체 최대 수 50

        // 트랜잭션 관련
        dataSource.setAutoCommit(false); // 자동커밋 해제 (직접 트랜잭션 관리)
        return dataSource;
    }

    /**
     * @Bean 메소드의 매개변수 선언으로 의존주입처리할 수 있다.
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(HikariDataSource dataSource) throws Exception{
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        // Mapper 등록
        configuration.addMapper(MenuMapper.class);

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource()); // dataSource 의존주입
        sqlSessionFactoryBean.setConfiguration(configuration);

        return sqlSessionFactoryBean.getObject();
    }

    /**
     * SqlSessionTemplate빈은 이제 @Service에서 의존주입을 받아 처리하게 된다.
     * - @Service가 트랜잭션처리를 하는 곳이기 때문이다.
     * - SqlSessionTemplate빈으로부터 Mapper빈을 가져와 실제 요청하게 된다.
     * - 매 요청마다 SqlSessionTemplate빈은 독립적으로 사용이 가능하다.
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
