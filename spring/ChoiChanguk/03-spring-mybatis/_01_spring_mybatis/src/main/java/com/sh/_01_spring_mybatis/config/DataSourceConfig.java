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


import javax.sql.DataSource;

/**
 * <pre>
 * @PropertySource - @Value 설정값을 읽어와야 하지만,
 * application.properties 혹은 application.yaml에 작성되있는 경우, @Value만 작성하면 된다
 *
 * 등록할 빈
 * - DataSource
 * - SqlSessionFactory
 * - SqlSessionTemplate
 *
 * </pre>
 */
@Configuration
//@PropertySource() //
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
     * DB에 접속하는 Connection객체를 관리할 ConnectionPool이 필요하다
     * HikariCP는 그 중 경량화된 라이브러리, Springboot에서 기본적으로 사용하고 있다
     *
     * destroyMethod = "close"
     * - 빈이 메모리 해제될 때 호출되는 메소드
     * - DB접속과 관련된 자원해제처리가 close안에 구현되어 있다
     */

    @Bean(destroyMethod = "close") // 이미 구현이 되어있기 때문에 호출만 하면 된다
    public HikariDataSource dataSource() {
        HikariDataSource dataSource=new HikariDataSource();
        // DB에 접속하기 위한 기본 정보
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);

        // ConnectionPool 관련 속성
        dataSource.setConnectionTimeout(30000); // 커넥션 최대 대기 시간설정, 지금은 30초
        dataSource.setIdleTimeout(60000); // 커넥션 풀안에서 사용중이 아닌 커넥션 객체를 가리킨다, 60초 동안 사용 안하면 제거하라
        dataSource.setMaximumPoolSize(50); // 커넥션객체 최대수 50개

        // 트랜잭션 관련
        dataSource.setAutoCommit(false); // true = DML날라가면 바로 commit, false = 직접 commit 해야됨

        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        org.apache.ibatis.session.Configuration configuration=new org.apache.ibatis.session.Configuration();

        // Mapper 등록
        configuration.addMapper(MenuMapper.class);
        // 추가설정
        configuration.setMapUnderscoreToCamelCase(true);

        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource()); // dataSource 의존주입
        sqlSessionFactoryBean.setConfiguration(configuration);

        //별칭 등록
        sqlSessionFactoryBean.addTypeAliases(MenuDto.class);

// mapper인터페이스 패키지 구조와 xml경로가 다른 경우
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//                .getResources("classpath*:mappers/**/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    /**
     * SqlSessionTemplate 빈은 @Service에서 의존주입 받아 처리하게 된다
     * - Service에서 처리 하는 이유 : @Service가 트랜잭션처리를 하는 곳이기 때문이다
     * - SqlqSessionTemplate빈으로부터 Mapper빈을 가져와 실제 요청하게 된다
     * - 매요청마다 SqlSessionTemplate빈은 독립적으로 사용이 가능하다
     * @param sqlSessionFactory
     * @return
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}










