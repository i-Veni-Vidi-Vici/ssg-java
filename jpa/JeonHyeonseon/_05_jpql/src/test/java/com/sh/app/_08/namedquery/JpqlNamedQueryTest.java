package com.sh.app._08.namedquery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>
 * Entity츨래스에 미리 정의된 jpql을 가져와 질의할 수 있다.
 * </pre>
 */

public class JpqlNamedQueryTest {
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
    @DisplayName("@NamedQuery - findAll")
    void test1() {
        // given
        // when
        TypedQuery<Menu> query = this.entityManager.createNamedQuery("_08.namedquery.Menu.findAll", Menu.class); // 밖에서 선언하고 가져온 것.
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
         */
        menus.forEach(System.out::println);
        // then
        assertThat(menus).isNotNull();
    }

    @Test
    @DisplayName("@NamedQuery - findByMenuName")
    void test2() {
        // given
        String menuName = "한우딸기국밥";
        // when
        TypedQuery<Menu> query = this.entityManager.createNamedQuery("_08.namedquery.Menu.findByMenuName", Menu.class) // 밖에서 선언하고 가져온 것.
                                        .setParameter("menuName", menuName);
        List<Menu> menus = query.getResultList(); // 다수 건이 나올 수 있다는 가정하에 List로 작성
        /*
         */
        menus.forEach(System.out::println);
        // then
        assertThat(menus).isNotNull()
                .allMatch((menu) -> menu.getMenuName().equals(menuName));
    }

    @Test
    @DisplayName("@NamedQuery - findByMenuNameLike")
    void test3() {
        // given
        String menuName = "밥";
        // when
        TypedQuery<Menu> query = this.entityManager.createNamedQuery("_08.namedquery.Menu.findByMenuNameLike", Menu.class) // 밖에서 선언하고 가져온 것.
                .setParameter("menuName", menuName);
        List<Menu> menus = query.getResultList(); // 다수 건이 나올 수 있다는 가정하에 List로 작성
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
                m1_0.menu_name like concat('%', ?, '%') escape ''
         */
        menus.forEach(System.out::println);
        // then
        assertThat(menus).isNotNull()
                .allMatch((menu) -> menu.getMenuName().contains(menuName)); // "밥"이라는 단어를 포함해야 하므로 contains사용
    }
}