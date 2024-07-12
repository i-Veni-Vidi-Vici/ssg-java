package com.sh.app._05.paging;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * JPQL의 Paging API
 *
 * 페이징 구현이 어떻게 구성되는가?
 * 1. 컨텐츠 영역에 대한 쿼리를 작성
 * 2. 페이지바 html 처리
 */
public class JpqlPagingTest { // Department2Student도 가능함!
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
    void test1(int page) { // 현재 페이지
        // given
//        int page = 1; // 현재 페이지 -> 위에서 넘어와서 없어도 됨!
        int limit = 10; // 한 페이지 당 메뉴수
        int offset = (page - 1) * limit;  //이번 페이지에 건너뛸 메뉴수, 1페이지는 0개, 2페이지는 10개
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
                .setMaxResults(limit) // 🙉 한페이지당 최대 행수
                .setFirstResult(offset); // 🙉 건너뛸 행수
        List<Menu> menus = query.getResultList();
        System.out.println(menus.size());
        menus.forEach(System.out::println); // ✨메뉴가 78개여서 마지막만 8개가 나옴!

        // then
        assertThat(menus).isNotNull()
                .size()
                .isGreaterThan(0) // 🙉0보다는 크면서
                .isLessThanOrEqualTo(limit); // 🙉limit 보다는 작은
    }
}
