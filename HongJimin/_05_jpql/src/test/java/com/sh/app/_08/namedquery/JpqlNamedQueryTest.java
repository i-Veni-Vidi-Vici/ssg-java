package com.sh.app._08.namedquery;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>프로젝션(projection)</h1>
 * SELECT 절에 조회할 대상을 지정하는 것을 프로젝션이라고 한다.
 * <code>
 * SELECT {프로젝션 대상} FROM 엔티티
 * </code>
 *
 * <pre>
 *
 *
 * 프로젝션 대상은 4가지 방식이 있다.
 * 1. 엔티티 프로젝션
 *    원하는 객체를 바로 조회할 수 있다.
 *    조회된 엔티티는 영속성 컨텍스트가 관리한다.
 *
 * 2. 임베디드 타입 프로젝션(임베디드 타입에 대한 설명은 MenuInfo 클래스에서 설명)
 *    엔티티와 거의 비슷하게 사용되며 조회의 시작점이 될 수 없다. -> from 절에 사용 불가
 *    임베디드 타입은 영속성 컨텍스트에서 관리되지 않는다.
 *
 * 3. 스칼라 타입 프로젝션
 *    숫자, 문자, 날짜 같은 기본 데이터 타입이다.
 *    스칼라 타입은 영속성 컨텍스트에서 관리되지 않는다.
 *
 * 4. new 명령어를 활용한 프로젝션
 *    다양한 종류의 단순 값들을 DTO로 바로 조회하는 방식으로 new 패키지명.DTO명을 쓰면 해당 DTO로 바로 반환받을 수 있다.
 *    new 명령어를 사용한 클래스의 객체는 엔티티가 아니므로 영속성 컨텍스트에서 관리되지 않는다.
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
        this.entityManager.getTransaction().begin();
    }

    @AfterEach
    void tearDown() {
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Test
    @DisplayName("@NamedQuery - findAll")
    void test1() {
        // given
        // when
        TypedQuery<Menu> query = this.entityManager.createNamedQuery("_08.namedquery.Menu.findAll", Menu.class);
        List<Menu> menus = query.getResultList();
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
                .setParameter("menuName", menuName); // menuName 변수를 채워 넣기!
        List<Menu> menus = query.getResultList(); // 다수 건이 나올 수 있다는 가정
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
         *         m1_0.menu_name=?
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
        String menuName = "밥"; //🙉 test2랑 달라진 점
        // when
        TypedQuery<Menu> query = this.entityManager.createNamedQuery("_08.namedquery.Menu.findByMenuNameLike", Menu.class)
                .setParameter("menuName", menuName); // menuName %로 감싸서 처리됨
        List<Menu> menus = query.getResultList(); // 다수 건이 나올 수 있다는 가정
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
         *         m1_0.menu_name like concat('%', ?, '%') escape ''
         */
        menus.forEach(System.out::println);

        // then
        assertThat(menus).isNotNull()
                .allMatch((menu) -> menu.getMenuName().contains(menuName));//🙉 test2랑 달라진 점 equals -> contains
    }
}
