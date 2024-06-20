package com.sh._01_spring_mybatis.config;

import com.sh._01_spring_mybatis.menu.model.dao.MenuMapper;
import com.sh._01_spring_mybatis.menu.model.dto.MenuDto;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @PropertySource - @Value 설정값을 읽어와야하지만,
 * application.properties 혹은 application.yaml에 작성되어있는경우, @Value만 작성하면 됨
 *
 * 등록할 빈
 * 1. DataSource
 * 2. SqlSessionFactory
 * 3. SqlSessionTemplate
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
     * DB에 접속하는 Connection객체를 관리할 ConnectionPool이 필요함
     * HikariCP는 그 중 빠르고 경량화된 라이브러리여서 springboot에서 기본적으로 사용하고 있음
     *
     * destroyMethod = "close"
     * - 빈이 메모리 해제될때 호출되는 메소드
     * - DB접속과 관련된 자원 해제처리가 close안에 구현되어 있음
     */
    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        // DB에 접속하기 위한 정보
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);

        // ConnectionPool 관련 속성
        dataSource.setConnectionTimeout(30000); // 커넥션 최대 대기시간 30초
        dataSource.setIdleTimeout(60000); // Idle : 커넥션 풀 내에 사용중이 아닌 커넥션 객체를 가리킴. Idle 최대 대기시간 60초
        dataSource.setMaximumPoolSize(50); // 커넥션객체 최대 수 50개

        // 트랜잭션 관련
        dataSource.setAutoCommit(false); // 자동커밋 해제 (직접 트랜잭션 관리)
        return dataSource;
    }

    /**
     * @Bean메소드의 매개변수 선언으로 의존주입 처리할 수 있음 : (HikariDataSource dataSource)
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(HikariDataSource dataSource) throws Exception{
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        // Mapper등록
        configuration.addMapper(MenuMapper.class);
        // 추가설정
//        configuration.setMapUnderscoreToCamelCase(true); // 컬럼명 - 프로퍼티명 자동 매칭

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource); // dataSource 의존주입
        sqlSessionFactoryBean.setConfiguration(configuration);

        // 별칭 등록
//        sqlSessionFactoryBean.setTypeAliasesPackage("com.sh"); // 풀네임 대신 별칭으로 접근 가능

        // mapper인터페이스 패키지 구조와 xml경로가 다른 경우
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mappers/**/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    /**
     * SqlSessionTemplate빈은 이제 @Service에서 의존주입을 받아 처리하게 됨
     * - @Service가 트랜잭션 처리를 하는 곳이기 때문
     * - SqlSessionTemplate빈으로부터 Mapper빈을 가져와 실제 요청하게 됨
     * - 매요청마다 SqlSessionTemplate빈은 독립적으로 사용 가능
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}