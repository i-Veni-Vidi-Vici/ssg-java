package com.sh.app._08.namedquery;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

/**
 * <pre>
 *     // 일반 sql문을 작성할 수 있다
 *  Native query란 SQL 쿼리를 그대로 사용하는 것을 말한다.
 *  이를 사용하면 ORM의 기능을 이용하면서 SQL 쿼리도 활용할 수 있어서 더욱 강력한 데이터베이스 접근이 가능하다.
 *  따라서 복잡한 쿼리를 작성할 때나, 특정 데이터베이스에서만 사용 가능한 기능을 사용해야 할 때 등에 Native query를 사용한다.
 *
 * 네이티브 쿼리 API는 다음의 3가지가 있다.
 *  1. 결과 타입 정의
 *      public Query createNativeQuery(String sqlString, Class resultClass);
 *
 *  2. 결과 타입을 정의할 수 없을 때
 *      public Query createNativeQuery(String sqlString);
 *
 *  3. 결과 매핑 사용
 *      public Query createNativeQuery(String sqlString, String resultSetMapping);
 *
 * </pre>
 */

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>
 * Entity클래스에 미리 정의된 jpql을 가져와 질의할 수 있다.
 * </pre>
 */
public class JpqlNamedQueryTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    void setUp() {
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityManager.getTransaction().begin();
    }

    @AfterEach
    void tearDown() {
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @AfterAll
    static void afterAll() {
        entityManagerFactory.close();
    }

    @Test
    @DisplayName("결과 타입을 지정해서 Native query  사용하기")
    void test1() {
        // given
      Long menuCode=15L;
      String sql= """
              select 
              from
                tbl_menu
              where
                menu_code ?""";
    }


}

