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
 * Entity클래스에 미리 정의된 jpql을 가져와 질의할 수 있다.
 * </pre>
 */
public class JpqlNamedQueryTest {
    // application-scope: 1개만 만들어서 재사용 (thread-safe)
    private static EntityManagerFactory entityManagerFactory;
    // request-scope: 웹요청마다 1개씩 생성 (non-thread-safe)
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        // jpa설정정보를 읽어서 EntityManagerFactory를 생성
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

    @Test
    @DisplayName("@NamedQuery - findAll")
    void test1() {
        // given
        // when
        TypedQuery<Menu> query = this.entityManager.createNamedQuery("_08.namedquery.Menu.findAll", Menu.class);
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
        TypedQuery<Menu> query = this.entityManager.createNamedQuery("_08.namedquery.Menu.findByMenuName", Menu.class)
                .setParameter("menuName", menuName);
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
            where
                m1_0.menu_name=?
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
        TypedQuery<Menu> query = this.entityManager.createNamedQuery("_08.namedquery.Menu.findByMenuNameLike", Menu.class)
                .setParameter("menuName", menuName);
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
            where
                m1_0.menu_name like concat('%', ?, '%') escape ''
         */
        menus.forEach(System.out::println);
        // then
        assertThat(menus).isNotNull()
                .allMatch((menu) -> menu.getMenuName().contains(menuName));
    }
}

