package com.sh.app._06.join;


import com.sh.app._06.join.MenuEntity;
import jakarta.persistence.*;
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
    @DisplayName("내부 조인")
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
         *     join 🙉내부 조인🙉
         *         tbl_category c1_0
         *             on m1_0.category_code=c1_0.category_code
         */
        System.out.println(menus.size()); // 78개 메뉴 중, 카테고리 코드 2개가 null인 값을 제외한 76개가 나옴!
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
                    Menu06 m left join Category06 c
                        on m.categoryCode = c.categoryCode
                """;
        // when
        TypedQuery<Menu> query = this.entityManager.createQuery(jpql, Menu.class);
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
            left join🙉
                tbl_category c1_0
                    on m1_0.category_code=c1_0.category_code
         */
        System.out.println(menus.size()); // 78
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
                    Menu06 m  right join Category06 c
                        on m.categoryCode = c.categoryCode
                """;
        // when
        TypedQuery<Category> query = this.entityManager.createQuery(jpql, Category.class);
        List<Category> categories = query.getResultList();
        /**
         * Hibernate:
         *     select
         *         c1_0.category_code,
         *         c1_0.category_name,
         *         c1_0.ref_category_code
         *     from
         *         tbl_menu m1_0
         *     right join
         *         tbl_category c1_0
         *             on m1_0.category_code=c1_0.category_code
         */
        System.out.println(categories.size()); // 12
        // jpa는 딱 하나의 entity만 보장해줌 -> 같은 카테고리 코드를 가진 메뉴는 많겠지만, 한 카테고리 코드에 하나씩만 보여줌
        categories.forEach(System.out::println);
        // then
        assertThat(categories).isNotNull();
    }

    @Test
    @DisplayName("세타 조인(크로스조인)") // 🙉 Menu06과 Category06의 모든 행이 만남! 각각 10행, 5행일 경우 총 50행이 생김
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
         * Hibernate:
         *     select
         *         m1_0.menu_name,
         *         c1_0.category_name
         *     from
         *         tbl_menu m1_0,
         *         tbl_category c1_0
         */
        System.out.println(rows.size()); // Menu06 78행 , Category06 12행이 만나서 936행이 됨!
        rows.forEach((row -> {
            System.out.println(row[0] + " " + row[1]);
        }));
        // then
        assertThat(rows).isNotNull();
    }

    /**
     * 엔티티 연관관계가 있을 때, join 처리 방식
     * 1. MenuEntity에 대한 조회만 우선 처리된다.
     *   - 프락시 객체가 먼저 생겻..?
     * 2. MenuEntity#category 필드는 실제 사용되어질 때, 다시 조회하게 된다.
     *   - 이는 JPA의 N + 1이슈를 유발한다.(조회 성능을 심각하게 떨어뜨린다.)
     */
    @Test
    @DisplayName("엔티티 연관관계가 있을때 join - N + 1 이슈")
    void test5() {
        // given 🙉 m.category 이렇게 쓰면 join 조건절 따로 적지 않아도 됨
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
        menus.forEach(System.out::println); // MenuEntity#toString() - Category#toString()
        // then
        assertThat(menus).isNotNull();
    }

    @Test
    @DisplayName("엔티티 연관관계가 있을때 fetch join")
    void test6() {
        // given
        String jpql = """
                select
                    m
                from
                    MenuHajima m join fetch m.category
                """;
        // when
        TypedQuery<MenuEntity> query = this.entityManager.createQuery(jpql, MenuEntity.class);
        List<MenuEntity> menus = query.getResultList();
        /*

         */
        menus.forEach(System.out::println); // MenuEntity#toString() - Category#toString()
        // then
        assertThat(menus).isNotNull();
    }

    /**
     * 1. 🙉조인쿼리로 조회 후, 적절한 DTO로 처리하기
     * 2. 각각 조회하기
     */
    @Test
    @DisplayName("Aggregate 너머의 엔티티 참조하기")
    void test7() {
        // given
        String jpql = """
                select
                    m.menuCode,
                    m.menuName,
                    c.categoryName
                    
                from
                    Menu06 m join Category06 c
                        on m.categoryCode = c.categorycode
                """;
        // when
        TypedQuery<MenuCategoryResponseDto> query = this.entityManager.createQuery(jpql, MenuCategoryResponseDto.class);
        List<MenuCategoryResponseDto> dtos = query.getResultList();
        dtos.forEach(System.out::println);
        // then
    }

    /**
     * 1. 🙉조인쿼리로 조회 후, 적절한 DTO로 처리하기
     * 2. 각각 조회하기
     */
    @Test
    @DisplayName("Aggregate 너머의 엔티티 참조하기 - 각각 조회")
    void test8() {
        // given
        Long menuCode = 10L;

        // when
        Menu menu = this.entityManager.find(Menu.class, 10L);
        Long categoryCode = menu.getCategoryCode();
        Category category = this.entityManager.find(Category.class, categoryCode);

        MenuCategoryResponseDto dto = new MenuCategoryResponseDto(
                menu.getMenuCode(),
                menu.getMenuName(),
                category.getCategoryName()
        );

        // then
        System.out.println(dto);
    }
}
