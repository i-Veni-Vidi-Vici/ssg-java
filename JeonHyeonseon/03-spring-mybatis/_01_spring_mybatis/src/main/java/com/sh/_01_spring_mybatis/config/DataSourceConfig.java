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
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * <pre>
 * @PropertySource - @Value 설정값을 읽어와야 하지만,
 * application.properties 혹은 application.yaml에 작성된 경우, @Value만 작성하면 된다.
 *
 * 등록할 빈
 * - DataSource
 * - SqlSessionFactory
 * - SqlSessionTemplate
 * </pre>
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
     * destroyMethod = "close"
     *  - 빈이 메모리 해제될 때 호출되는 메소드 (자원반환. 사용한 메모리 반환)
     *  - DB 접속과 관련된 자원해제처리가 close안에 구현되어 있다.
     * @return
     */
    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        // 기본적으로 DB에 접속하기 위한 정보
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);

        // ConnectionPool 관련 속성 설정
        dataSource.setConnectionTimeout(30000); // 커넥션 최대 대기 시간을 30초로 설정함
        dataSource.setIdleTimeout(60000); // Idle은 커넥션풀 내에 사용중이지 않은 커넥션캑체를 가리킴. Idle최대 대기시간. 60초동안 안쓰면 정리해.
        dataSource.setMaximumPoolSize(50); // 커넥션객체 최대수는 50개

        // 트랜잭션
        dataSource.setAutoCommit(false); // 자동커밋 기능 해제(직접 트랜잭션 관리함)
        return dataSource;
    }

    /**
     * @Bean메소드의 매개변수 선언으로 의존주입을 처리할 수 있다.
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(HikariDataSource dataSource) throws Exception {
        // 어노테이션으로도 configuration을 작성했기에 구분하기 위해 ibatis는 풀 네임을 작성해야한다.
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        // Mapper 등록
        configuration.addMapper(MenuMapper.class);
        // 추가설정
        configuration.setMapUnderscoreToCamelCase(true); // 컬럼명 - 프로퍼티명 자동매칭해주는 코드

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource()); // dataSource빈을 의존 주입
        sqlSessionFactoryBean.setConfiguration(configuration);

        // 별칭 등록
        sqlSessionFactoryBean.setTypeAliasesPackage("com.sh"); // 풀네임 대신에 별칭으로 접근 가능하다.

        // mapper인터페이스 패키지 구조와 xml경로가 다른 경우
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mappers/**/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    /**
     * SqlSessionTemplate빈은 @Service에서 의존주입을 받아 처리하게 된다.
     * - @Service가 트랜잭션을 처리하는 곳이기 때문이다.
     * - SqlSessionTemplate빈으로부터 Mapper빈을 가져와 실제 요청하게 된다.
     * - 매 요청마다 SqlSessionTemplate빈은 독립적으로 사용이 가능하다.
     * @param sqlSessionFactory
     * @return
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
