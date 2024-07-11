package com.sh.app._05.paging;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * JPQL의 Paging API
 *
 * 페이징 구현이 어떻게 구성되는가?
 * 1. 컨텐츠 영역에 대한 쿼리 - JPQL에 제공하는 부분
 * 2. 페이지바 html 처리
 */
public class JpqlPagingTest {
    // application-scope: 1개만 만들어서 재사용 (thread-safe)
    private static EntityManagerFactory entityManagerFactory;
    // request-scope: 웹요청마다 1개씩 생성 (non-thread-safe)
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        // jpa설정정보를 읽어서 EntityManagerFactory를 생성
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

    @ParameterizedTest
    @DisplayName("페이징 쿼리")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    void test1(int page) { // 현재페이지
        // given
//        int page = 8; // 현재페이지
        int limit = 10; // 한페이지당 메뉴수
        int offset = (page - 1) * limit; // 이번페이지에 건너뛸 메뉴수
        String jpql = """
                select
                    m
                from
                    Menu05 m
                order by
                    m.menuCode
                """;
        // when
        TypedQuery<Menu> query = this.entityManager.createQuery(jpql, Menu.class)
                .setMaxResults(limit) // 한페이지당 최대 행수
                .setFirstResult(offset); // 건너뛸 행수
        List<Menu> menus = query.getResultList();
        System.out.println(menus.size());
        menus.forEach(System.out::println);
        // then
        assertThat(menus).isNotNull()
                .size()
                .isGreaterThan(0)
                .isLessThanOrEqualTo(limit);
    }
}

