package com.sh.app._05.paging;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * JPQl의 Paging API
 *
 * 페이징 구현이 어떻게 구성되는가?
 * 1. 컨텐츠 영역에 대한 쿼리 - JPQL에 제공하는 부분
 * 2. 페이지바 html 처리
 *
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
        entityManager.getTransaction().begin();
    }

    @AfterEach
    void tearDown() {
        entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @AfterAll
    static void afterAll() {
        entityManagerFactory.close();
    }

    @ParameterizedTest
    @DisplayName("페이징 쿼리")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8})
    void test1(int page) { // 현재 페이지
        // given
//        int page = 8; // 현재 페이지
        int limit = 10; // 한 페이지당 메뉴 수
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
                .setMaxResults(limit) // 한페이지당 최대 행수
                .setFirstResult(offset); // 건너뛸 행수
        List<Menu> menus = query.getResultList();
        /*
            select
                m1_0.menu_code,
                m1_0.category_code,
                m1_0.menu_name,
                m1_0.menu_price,
                m1_0.orderable_status
            from
                tbl_menu m1_0
            order by
                m1_0.menu_code
            limit
                ?, ?
         */
        System.out.println(menus.size());
        menus.forEach(System.out::println);
        // then
        assertThat(menus).isNotNull()
                .size()
                .isGreaterThan(0)
                .isLessThanOrEqualTo(limit);
    }
}