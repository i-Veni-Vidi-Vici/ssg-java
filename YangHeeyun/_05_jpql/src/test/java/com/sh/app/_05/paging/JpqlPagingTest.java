
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
 * 1. 컨텐츠 영역에 대한 쿼리 - JPQL에 제공하는 부분 (한 페이지에 출력할 내용)
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

    @ParameterizedTest // 여러개의 값을 주는 테스트를 한번에 작성하기 위한 어노테이션, 테스트에 주입할 값을 @ValueSource에 배열로 지정함
    @DisplayName("페이징 쿼리")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8}) // tbl_menu에 80개가 있으므로 10개씩 나누면 8페이지까지 나옴
    void test1(int page) { // 현재페이지
        // given
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
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class)
                .setMaxResults(limit) // 한페이지당 최대 행수
                .setFirstResult(offset); // 건너뛸 행수
        List<Menu> menus = query.getResultList();
        System.out.println(menus.size()); // 10
        menus.forEach(System.out::println);
        // then
        assertThat(menus).isNotNull()
                .size()
                .isGreaterThan(0)
                .isLessThanOrEqualTo(limit);
    }
}
