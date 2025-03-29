package com.sh.app._05.paging;


import jakarta.persistence.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * <pre>
 * JPQL 의 Paging API
 *  1. 컨텐츠 영역에 대한 쿼리
 *  2. 페이지바 html 처리
 * </pre>
 */
public class JpqlTest {
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

    @ParameterizedTest
    @DisplayName("페이징 쿼리")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    void test1(int page) {
        // given
        int limit = 10; // 한페이지당 메뉴 수
        int offset = (page - 1) * limit; // 이번 페이지에 건너뛸 메뉴 수
        String jpql = """
                select
                    m
                from
                    Menu05 m
                order by
                    m.menuCode
                """;
        // when
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class)
                .setMaxResults(limit)  // 한페이지당 최대 행수
                .setFirstResult(offset); // 건너뛸 행수
        List<Menu> menus = query.getResultList();
        System.out.println(menus.size());
        // then
        assertThat(menus)
                .isNotNull()
                .size()
                .isGreaterThan(0)
                .isLessThanOrEqualTo(limit);
    }
}
