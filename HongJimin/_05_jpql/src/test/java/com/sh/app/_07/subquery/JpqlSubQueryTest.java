package com.sh.app._07.subquery;


import com.sh.app._06.join.MenuCategoryResponseDto;
import com.sh.app._06.join.MenuEntity;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>
 *   JpqlSubQuery
 * - SQL 처럼 서브쿼리를 지원하지만, select, from 절에서는 사용할 수 없음(인라인 뷰 없움)
 * - where, having 절에서만 사용할 수 있음
 * </pre>
 */
public class JpqlSubQueryTest {
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
    @Test
    @DisplayName("서브쿼리 테스트")
    void test1() {
        // given
        String categoryName = "한식";

        // when
        String jpql = """
                select
                    m
                from
                    Menu07 m
                where
                    m.categoryCode = (
                        select
                            c.categoryCode
                        from
                            Category07 c
                        where
                            c.categoryName = :categoryName)
                """;
        TypedQuery<Menu> query = this.entityManager.createQuery(jpql, Menu.class)
                                    .setParameter("categoryName", categoryName);
        List<Menu> menus = query.getResultList();
        /**
         * Hibernate:
         *     select
         *         m1_0.menu_code,
         *         m1_0.category_code,
         *         m1_0.menu_name,
         *         m1_0.menu_price,
         *         m1_0.orderable_status
         *     from
         *         tbl_menu m1_0
         *     where
         *         m1_0.category_code=(
         *             select
         *                 c1_0.category_code
         *             from
         *                 tbl_category c1_0
         *             where
         *                 c1_0.category_name=?
         *         )
         */
        menus.forEach(System.out::println);

        // then
        Long categoryCode = 4L; // 🙉한식의 카테고리 코드 = 4
        assertThat(menus).isNotNull()
                .allMatch((menu) -> menu.getCategoryCode() == categoryCode);
    }


}
