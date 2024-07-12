package com.sh.app._06.join;

import com.sh.app._03.projection.CategoryResponseDto;
import com.sh.app._03.projection.MenuVo;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
/**
 * <pre>
 * 조인을 언제 사용하는가?
 * - aggregate(엔티티)와 aggregate(엔티티)를 연결해서 조회하는 경우
 *
 * 조인의 종류
 * 1. 일반 조인 : 일반적인 SQL 조인을 의미 (내부 조인, 외부 조인, 세타 조인(크로스 조인))
 * 2. fetch 조인 : JPQL에서 성능 최적화를 위해 제공하는 기능으로 연관 된 엔티티나 컬렉션을 한 번에 조회할 수 있다.
 *              지연 로딩이 아닌 즉시 로딩을 수행하며 join fetch 명령어를 사용한다.
 * </pre>
 */
public class JpqlJoinTest {
    private static EntityManagerFactory entityManagerFactory;
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
    @DisplayName("내부조인")
    void test() {
        // given
        String jpql = """
                select
                    m
                from
                    Menu06 m 
                join Category06 c
                        on m.categoryCode = c.categoryCode
                """;

        // when
        TypedQuery<Menu> query = this.entityManager.createQuery(jpql, Menu.class);
        List<Menu> menus = query.getResultList();
        System.out.println(menus.size()); // 75
        menus.forEach(System.out::println);
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
                    Menu06 m 
                left join Category06 c
                        on m.categoryCode = c.categoryCode
                """;

        // when
        TypedQuery<Menu> query = this.entityManager.createQuery(jpql, Menu.class);
        List<Menu> menus = query.getResultList();
        System.out.println(menus.size()); // 77
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
                    Menu06 m 
                right join Category06 c
                        on m.categoryCode = c.categoryCode
                """;
        // when
        TypedQuery<Category> query = this.entityManager.createQuery(jpql, Category.class);
        List<Category> categories = query.getResultList();
        System.out.println(categories.size()); // 12
        categories.forEach(System.out::println);
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
        /**
         *
         */
        rows.forEach((row) -> {
            System.out.println(row[0] + " " + row[1]);
        });
        System.out.println(rows.size());
        // then
        assertThat(rows).isNotNull();
    }

    /**
     * 엔티티 연관관계가 있을 때 join 처리방식
     * MenuEntity에 대한 조회만 우선 처리된다.
     * MenuEntity#category필드는 실제 사용되어질 때 다시 조회하게 된다.
     *   이는 JPA의 N+1이슈를 유발한다. (조회성능을 심각하게 떨어뜨린다.)
     */
    @Test
    @DisplayName("엔티티 연관관계가 있을 때 join처리 - N+1 이슈")
    void test5() {
        // given
        String jpql = """
                select
                    m
                from
                    MenuEntity m join m.category
                """;
        // 프록시 객체가 들어있다가 실제 처리할 때 조회하게 된다.
        // when
        TypedQuery<MenuEntity> query = this.entityManager.createQuery(jpql, MenuEntity.class);
        List<MenuEntity> menus = query.getResultList();
        /**
         * Hibernate:
         *     select
         *         me1_0.menu_code,
         *         me1_0.category_code,
         *         me1_0.menu_name,
         *         me1_0.menu_price,
         *         me1_0.orderable_status
         *     from
         *         tbl_menu me1_0
         *     join
         *         tbl_category c1_0
         *             on c1_0.category_code=me1_0.category_code
         */
        menus.forEach(System.out::println); // MenuEntity#toString() - Category#toString() ; 이때 비로소 카테고리에 필요한 내용들이 필요하게 된거임
        // 그래서 그제서야 조회쿼리를 날림 !!
        // N+1 문제 이슈 ; 성능 저하! 해결방법 -> fetch join
        /**
         *
         * Hibernate:
         *     select
         *         c1_0.category_code,
         *         c1_0.category_name,
         *         c1_0.ref_category_code
         *     from
         *         tbl_category c1_0
         *     where
         *         c1_0.category_code=?
         * Hibernate:
         *     select
         *         c1_0.category_code,
         *         c1_0.category_name,
         *         c1_0.ref_category_code
         *     from
         *         tbl_category c1_0
         *     where
         *         c1_0.category_code=?
         * Hibernate:
         *     select
         *         c1_0.category_code,
         *         c1_0.category_name,
         *         c1_0.ref_category_code
         *     from
         *         tbl_category c1_0
         *     where
         *         c1_0.category_code=?
         * Hibernate:
         *     select
         *         c1_0.category_code,
         *         c1_0.category_name,
         *         c1_0.ref_category_code
         *     from
         *         tbl_category c1_0
         *     where
         *         c1_0.category_code=?
         * Hibernate:
         *     select
         *         c1_0.category_code,
         *         c1_0.category_name,
         *         c1_0.ref_category_code
         *     from
         *         tbl_category c1_0
         *     where
         *         c1_0.category_code=?
         * Hibernate:
         *     select
         *         c1_0.category_code,
         *         c1_0.category_name,
         *         c1_0.ref_category_code
         *     from
         *         tbl_category c1_0
         *     where
         *         c1_0.category_code=?
         * Hibernate:
         *     select
         *         c1_0.category_code,
         *         c1_0.category_name,
         *         c1_0.ref_category_code
         *     from
         *         tbl_category c1_0
         *     where
         *         c1_0.category_code=?
         * Hibernate:
         *     select
         *         c1_0.category_code,
         *         c1_0.category_name,
         *         c1_0.ref_category_code
         *     from
         *         tbl_category c1_0
         *     where
         *         c1_0.category_code=?
         */
        // then
        assertThat(menus).isNotNull();
    }

    @Test
    @DisplayName("엔티티 연관관계가 있을 때 fetch join처리 - N+1 이슈 해결")
    void test6() {
        // given
        String jpql = """
                select
                    m
                from
                    MenuEntity m join fetch m.category
                """;
        // when
        TypedQuery<MenuEntity> query = this.entityManager.createQuery(jpql, MenuEntity.class);
        List<MenuEntity> menus = query.getResultList();
        /**
         * Hibernate:
         *     select
         *         me1_0.menu_code,
         *         c1_0.category_code,
         *         c1_0.category_name,
         *         c1_0.ref_category_code,
         *         me1_0.menu_name,
         *         me1_0.menu_price,
         *         me1_0.orderable_status
         *     from
         *         tbl_menu me1_0
         *     join
         *         tbl_category c1_0
         *             on c1_0.category_code=me1_0.category_code
         */
        menus.forEach(System.out::println);
        // then

    }

    /**
     * 1. 각각 조회하기
     * 2. 조인쿼리로 조회 후 적절한 DTO로 처리하기
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
        List<MenuCategoryResponseDto> menuCategoryResponseDtos = query.getResultList();
        menuCategoryResponseDtos.forEach(System.out::println);
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
         *         m1_0.menu_code=?
         * Hibernate:
         *     select
         *         c1_0.category_code,
         *         c1_0.category_name,
         *         c1_0.ref_category_code
         *     from
         *         tbl_category c1_0
         *     where
         *         c1_0.category_code=?
         */

        MenuCategoryResponseDto dto = new MenuCategoryResponseDto(
                menu.getMenuCode(),
                menu.getMenuName(),
                category.getCategoryName()
        );
        // then
        System.out.println(dto);
    }
}
/**
 * jpa는 동일한 엔티티 객체를 딱 하나만 갖고 있도록 보장해준다.
 */