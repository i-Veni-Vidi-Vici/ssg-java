package com.sh.app._06.join;

import com.sh.app._03.projection.CategoryResponseDto;
import com.sh.app._03.projection.MenuVo;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>
 * 조인을 언제 사용하는가?
 * - 애그리거트(엔티티)와 애그리거트(엔티티)를 연결해서 조회하는 경우
 * => 카테고리 애그리거트(엔티티)와 메뉴 애그리커드(엔티티)가 다른 것임을 의미한다. 별도의 생명주기를 가지고 관리한다.
 *
 * 조인의 종류
 * 1. 일반 조인 : 일반적인 SQL 조인을 의미 (내부 조인, 외부 조인, 세타 조인(크로스조인))
 * 2. fetch(페치) 조인 : JPQL에서 성능 최적화를 위해 제공하는 기능으로 연관 된 엔티티나 컬렉션을 한 번에 조회할 수 있다.
 *              지연 로딩이 아닌 즉시 로딩을 수행하며 join fetch 명령어를 사용한다. => 엔티티에 있는 모든 정보를 다 읽어온다.
 * </pre>
 */

public class JpqlJoinTest {
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
    @DisplayName("내부조인")
    void test1() {
        // given
        String jpql = """
                select
                    m
                from
                    Menu06 m join Category06 c
                        on m.categoryCode = c.categoryCode
                """;
        // when
        TypedQuery<Menu> query = this.entityManager.createQuery(jpql, Menu.class);
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
            join // 내부조인
                tbl_category c1_0
                    on m1_0.category_code=c1_0.category_code
         */
        System.out.println(menus.size());
        menus.forEach(System.out::println); // 77
        // then
        assertThat(menus).isNotNull()
                .allMatch((menu) -> menu.getCategoryCode() != null);
    }

    @Test
    @DisplayName("외부조인 - LEFT")
    void test2() {
        // given
        String jpql = """
                select
                    m
                from
                    Menu06 m left join Category06 c
                        on m.categoryCode = c.categoryCode
                """;
        // when
        TypedQuery<Menu> query = this.entityManager.createQuery(jpql, Menu.class);
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
            left join
                tbl_category c1_0
                    on m1_0.category_code=c1_0.category_code
         */
        System.out.println(menus.size()); // 모든 메뉴 엔티티 조회 (전체 사이즈)
        menus.forEach(System.out::println);
        // then
        assertThat(menus).isNotNull();
    }

    @Test
    @DisplayName("외부조인 - RIGHT")
    void test3() {
        // given
        String jpql = """
                select
                    c
                from
                    Menu06 m right join Category06 c
                        on m.categoryCode = c.categoryCode
                """;
        // when
        TypedQuery<Category> query = this.entityManager.createQuery(jpql, Category.class);
        List<Category> categories = query.getResultList();
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
            left join
                tbl_category c1_0
                    on m1_0.category_code=c1_0.category_code
         */
        System.out.println(categories.size()); // 모든 메뉴 엔티티 조회 (전체 사이즈)
        // jpa는 동일한 엔티티 객체를 딱 하나 가지고 있다.
        categories.forEach(System.out::println); // 12
        // then
        assertThat(categories).isNotNull();
    }

    @Test
    @DisplayName("세타조인(크로스조인)")
    void test4() {
        // given
        String jpql = """
                select
                    m.menuName,
                    c.categoryName
                from
                    Menu06 m, Category06 c
                """;
        // when
        Query query = this.entityManager.createQuery(jpql);
        List<Object[]> rows = query.getResultList();
        /*
        Hibernate:
            select
                m1_0.menu_name,
                c1_0.category_name
            from
                tbl_menu m1_0,
                tbl_category c1_0
         */
        System.out.println(rows.size()); // 948
        rows.forEach((row -> {
            System.out.println(row[0] + " " + row[1]);
        }));
        // then
        assertThat(rows).isNotNull();
    }

    /**
     * 1. MenuEntity에 대한 조회만 우선 처리된다.
     * 2. MenuEntity#category(MenuEntity에 있는 category)필드는 실제 사용되어질 때 다시 조회하게 된다.
     *    이는 JPA의 N+1이슈를 유발한다. (조회성능을 심각하게 떨어뜨린다)
     */
    @Test
    @DisplayName("엔티티 연관관계가 있을 때 join 처리 - N+1 이슈")
    void test5() {
        // given
        // 엔티티 연관관계에서는 MenuEntity m join m.category 라고 작성한다
        String jpql = """
                select
                    m
                from
                    MenuEntity m join m.category
                """;
        // when
        TypedQuery<MenuEntity> query = this.entityManager.createQuery(jpql, MenuEntity.class);
        List<MenuEntity> menus = query.getResultList();
        /*
        Hibernate:
            select
                me1_0.menu_code,
                me1_0.category_code,
                me1_0.menu_name,
                me1_0.menu_price,
                me1_0.orderable_status
            from
                tbl_menu me1_0
            join
                tbl_category c1_0
                    on c1_0.category_code=me1_0.category_code
         */
        // MenuEntity#toString()를 조회했을 때 Category#toString도 호출했을 것이다.
        menus.forEach(System.out::println);
        /*
        // 조회 성능을 깍아먹는 방식 : N + 1방법(엄청 느려진다) -> 한 번에 구하는 방법 중 하나가 fetchJoin이다
        Hibernate:
            select
                c1_0.category_code,
                c1_0.category_name,
                c1_0.ref_category_code
            from
                tbl_category c1_0
            where
                c1_0.category_code=?
        Hibernate:
            select
                c1_0.category_code,
                c1_0.category_name,
                c1_0.ref_category_code
            from
                tbl_category c1_0
            where
                c1_0.category_code=?
        Hibernate:
            select
                c1_0.category_code,
                c1_0.category_name,
                c1_0.ref_category_code
            from
                tbl_category c1_0
            where
                c1_0.category_code=?
        Hibernate:
            select
                c1_0.category_code,
                c1_0.category_name,
                c1_0.ref_category_code
            from
                tbl_category c1_0
            where
                c1_0.category_code=?
        Hibernate:
            select
                c1_0.category_code,
                c1_0.category_name,
                c1_0.ref_category_code
            from
                tbl_category c1_0
            where
                c1_0.category_code=?
        Hibernate:
            select
                c1_0.category_code,
                c1_0.category_name,
                c1_0.ref_category_code
            from
                tbl_category c1_0
            where
                c1_0.category_code=?
        Hibernate:
            select
                c1_0.category_code,
                c1_0.category_name,
                c1_0.ref_category_code
            from
                tbl_category c1_0
            where
                c1_0.category_code=?
        Hibernate:
            select
                c1_0.category_code,
                c1_0.category_name,
                c1_0.ref_category_code
            from
                tbl_category c1_0
            where
                c1_0.category_code=?
         */
        // then
        assertThat(menus).isNotNull();
    }

    @Test
    @DisplayName("엔티티 연관관계가 있을 때 fetch join 처리 ")
    void test6() {
        // given
        // 문법적으로는 join fetch이다.
        String jpql = """
                select
                    m
                from
                    MenuEntity m join fetch m.category
                """;
        // when
        TypedQuery<MenuEntity> query = this.entityManager.createQuery(jpql, MenuEntity.class);
        List<MenuEntity> menus = query.getResultList();
        /*
        // 엔티티 객체가 만들어질 때 카테고리 객체까지 다 보여준다. (한 번에 다 보여준다. test5 쿼리랑 비교해보기)
        Hibernate:
            select
                me1_0.menu_code,
                c1_0.category_code,
                c1_0.category_name,
                c1_0.ref_category_code,
                me1_0.menu_name,
                me1_0.menu_price,
                me1_0.orderable_status
            from
                tbl_menu me1_0
            join
                tbl_category c1_0
                    on c1_0.category_code=me1_0.category_code
         */
        menus.forEach(System.out::println);
        // then
        assertThat(menus).isNotNull();
    }

    /**
     * 1. 조인쿼리로 조회 후 적절한 DTO로 처리하기
     * 2. 각각 조회하기
     */
    @Test
    @DisplayName("Aggregate 너머의 엔티티 참조하기 - 조인쿼리")
    void test7() {
        // given
        String jpql = """
                select
                    m.menuCode,
                    m.menuName,
                    c.categoryName
                from
                    Menu06 m join Category06 c
                        on m.categoryCode = c.categoryCode
                """;
        // when
        TypedQuery<MenuCategoryResponseDto> query = this.entityManager.createQuery(jpql, MenuCategoryResponseDto.class);
        List<MenuCategoryResponseDto> dtos = query.getResultList();
        /*
        Hibernate:
            select
                m1_0.menu_code,
                m1_0.menu_name,
                c1_0.category_name
            from
                tbl_menu m1_0
            join
                tbl_category c1_0
                    on m1_0.category_code=c1_0.category_code
         */
        dtos.forEach(System.out::println);
        // then
    }

    @Test
    @DisplayName("Aggregate 너머의 엔티티 참조하기 - 각각 조회")
    void test8() {
        // given
        Long menuCode = 10L;

        // when
        Menu menu = this.entityManager.find(Menu.class, menuCode);
        Long categoryCode = menu.getCategoryCode();
        Category category = this.entityManager.find(Category.class, categoryCode);

        // 최종적으로 사용자에게 보여주는 정보들
        MenuCategoryResponseDto dto = new MenuCategoryResponseDto(
                menu.getMenuCode(),
                menu.getMenuName(),
                category.getCategoryName());

        // then
        System.out.println(dto);
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
                m1_0.menu_code=?
        Hibernate:
            select
                c1_0.category_code,
                c1_0.category_name,
                c1_0.ref_category_code
            from
                tbl_category c1_0
            where
                c1_0.category_code=?
         */
    }
}