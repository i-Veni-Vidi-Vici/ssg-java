package com.sh.app._07.subquery;

import com.sh.app._06.join.MenuCategoryResponseDto;
import com.sh.app._06.join.MenuEntity;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>
 * SQL처럼 서브쿼리를 지원하지만,
 * select, from절에서는 사용할 수 없고,
 * where절, having절에서만 사용할 수 있다.
 * </pre>
 */

public class JpqlSubqueryTest {
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
                        where c.categoryName = :categoryName)
                """;
        TypedQuery<Menu> query = this.entityManager.createQuery(jpql, Menu.class)
                .setParameter("categoryName", categoryName); // setParameter를 사용하는 이유는 where절에서 :categoryName을 가져와야 하기 때문이다
        List<Menu> menus = query.getResultList();
        /*
        Hibernate:
            select
                m1_0.menu_code,
                m1_0.category_code,
                m1_0.menu_name,
                m1_0.menu_price,
                m1_0.orderable_status
            from
                tbl_menu m1_0
            where
                m1_0.category_code=(
                    select
                        c1_0.category_code
                    from
                        tbl_category c1_0
                    where
                        c1_0.category_name=?
                )
         */
        menus.forEach(System.out::println);
        // then
        Long categoryCode = 4L; // "한식"의 카테고리번호 = 4
        assertThat(menus).isNotNull()
                .allMatch((menu) -> menu.getCategoryCode() == categoryCode); // 모두 다 한식만 나와야한다.
    }
}