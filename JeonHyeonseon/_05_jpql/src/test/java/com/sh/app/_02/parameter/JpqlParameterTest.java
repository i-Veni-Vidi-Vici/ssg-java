package com.sh.app._02.parameter;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>
 * 파라미터 바인딩하는 방법
 * 1. 이름 기준 파라미터(named parameters)
 * 	  ':' 다음에 이름 기준 파라미터를 지정한다. ex) :name
 * 2. 위치 기준 파라미터(positional parameters)
 *    '?' 다음에 값을 주고 위치 값은 1부터 시작한다. ex) ?1
 * </pre>
 */

public class JpqlParameterTest {
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
    @DisplayName("이름 파라미터 테스트")
    void test1() {
        // given
        String menuName = "한우딸기국밥";
        String orderableStatus = "Y";
        // :menuName이라고 작성한 곳에 한우딸기국밥이라는 값이 들어간다
        String jpql = """
                select
                    m
                from
                    Menu02 m
                where
                    m.orderableStatus = :orderableStatus
                    and m.menuName = :menuName
                """;
        // when
//        TypedQuery<Menu> query = this.entityManager.createQuery(jpql, Menu.class);
//        query.setParameter("menuName", menuName);
        TypedQuery<Menu> query = this.entityManager.createQuery(jpql, Menu.class)
                                        .setParameter("menuName", menuName) // 위의 두 식을 하나로 작성할 수 있다.
                                        .setParameter("orderableStatus", orderableStatus); // 이렇게 추가해서 작성하면 되고, 순서도 상관없다.
        List<Menu> menus = query.getResultList(); // m.menuName = :menuName이게 PK컬럼 조회가 아니기 때문에 getResultList()로 조회해야 한다.
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
                m1_0.menu_name=?
                and m1_0.orderable_status=?
         */
        menus.forEach(System.out::println);
        // then
        // menuName과 orderableStatus가 같은지 체크하는 식
        assertThat(menus).isNotNull()
                .allMatch((menu) -> menu.getMenuName().equals(menuName) && menu.getOrderableStatus().equals(orderableStatus));
    }

    @Test
    @DisplayName("Like 연산처리")
    void test4() {
        // given
        String menuName = "밥";
        String jpql = """
                select
                    m
                from
                    Menu02 m
                where
                    m.menuName like :menuName
                """;
        // when
        TypedQuery<Menu> query = this.entityManager.createQuery(jpql, Menu.class)
                                .setParameter("menuName", "%" + menuName + "%");
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
                m1_0.menu_name like ? escape ''
         */
        menus.forEach(System.out::println);
        // then
        assertThat(menus).isNotNull()
                .allMatch((menu) -> menu.getMenuName().contains(menuName)); // 밥을 포함한 menuName 찾기
    }

    @Test
    @DisplayName("in 연산자")
    void test3() {
        // given
        List<Long> categoryCodes = List.of(4L, 5L, 6L);
        // 엔티티 기준으로 작성해야 한다.
        String jpql = """
                select
                    m
                from
                    Menu02 m
                where
                    m.categoryCode in :categoryCodes
                order by
                    m.menuName asc
                """;
        // when
        TypedQuery<Menu> query = this.entityManager.createQuery(jpql, Menu.class)
                .setParameter("categoryCodes", categoryCodes);
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
                m1_0.category_code in (?, ?, ?)
            order by
                m1_0.menu_name
         */
        menus.forEach(System.out::println);
        // then
        assertThat(menus).isNotNull()
                .allMatch((menu) -> categoryCodes.contains(menu.getCategoryCode())); // List한테 물어보는 것(너 categoryCode가지고 있어?)
    }

    @Test
    @DisplayName("위치 기반 파라미터 테스트")
    void test5() {
        // given
        String menuName = "한우딸기국밥";
        String orderableStatus = "Y";
        // :menuName이라고 작성한 곳에 한우딸기국밥이라는 값이 들어간다
        String jpql = """
                select
                    m
                from
                    Menu02 m
                where
                    m.orderableStatus = ?1
                    and m.menuName = ?2
                """;
        // when
        TypedQuery<Menu> query = this.entityManager.createQuery(jpql, Menu.class)
                .setParameter(1, orderableStatus)
                .setParameter(2, menuName);
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
                m1_0.orderable_status=?
                and m1_0.menu_name=?
         */
        menus.forEach(System.out::println);
        // then
        // menuName과 orderableStatus가 같은지 체크하는 식
        assertThat(menus).isNotNull()
                .allMatch((menu) -> menu.getMenuName().equals(menuName) && menu.getOrderableStatus().equals(orderableStatus));
    }
}