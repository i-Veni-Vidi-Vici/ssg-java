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
 * JPQL의 Paging API
 *
 * 페이징 구현이 어떻게 구성되는가?
 * 1. 컨텐츠 영역에 대한 쿼리 작성 - JPQL이 제공하는 부분이다
 * 2. 페이지바 html 처리
 */

public class JpqlPagingTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    void setUp() {
        this.entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin(); // 트랜잭션 처리를 한 번에 처리할 수 있다.
    }

    @AfterEach
    void tearDown() {
        this.entityManager.close();
        entityManager.getTransaction().commit();
    }

    @AfterAll
    static void afterAll() {
        entityManagerFactory.close();
    }

    @ParameterizedTest
    @DisplayName("페이징 쿼리")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    void test1(int page) { // int page를 작성함으로써 현재 페이지가 넘어온다.
        // given
//        int page = 1; // 현재 페이지
        int limit = 10; // 한 페이지당 메뉴수
        int offset = (page - 1) * limit; // 이번 페이지에 건너뛸 메뉴 수.
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
                                    .setMaxResults(limit) // 한 페이지당 최대 행수(메뉴수)
                                    .setFirstResult(offset); // 건너뛸 행수(메뉴수)
        List<Menu> menus = query.getResultList();
        System.out.println(menus.size());
        menus.forEach(System.out::println);
        // then
        assertThat(menus).isNotNull()
                .size()
                .isGreaterThan(0) // 0보다는 크면서
                .isLessThanOrEqualTo(limit); // limit보다 작은
    }
}