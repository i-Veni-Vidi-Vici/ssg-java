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
    @ValueSource(ints ={1,2,3})
    @DisplayName("페이징 쿼리")
    void test1(int page) { // 현재 페이지
        // given
        int limit =10; // 한 페이지당 메뉴수
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
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class)
                .setMaxResults(limit)
                .setFirstResult(offset);
        List<Menu> menus = query.getResultList();
        System.out.println(menus.size());
        // then
        assertThat(menus).isNotNull()
                .size()
                .isGreaterThan(0)
                .isLessThanOrEqualTo(limit);
    }
}
