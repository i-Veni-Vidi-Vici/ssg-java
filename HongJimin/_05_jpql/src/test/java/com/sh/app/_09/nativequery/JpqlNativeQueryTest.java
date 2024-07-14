package com.sh.app._09.nativequery;


import jakarta.persistence.*;
import org.hibernate.sql.ast.tree.cte.CteTable;
import org.junit.jupiter.api.*;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>
 *  Native query란 SQL 쿼리를 그대로 사용하는 것을 말한다.
 *  이를 사용하면 ORM의 기능을 이용하면서 SQL 쿼리도 활용할 수 있어서 더욱 강력한 데이터베이스 접근이 가능하다.
 *  따라서 복잡한 쿼리를 작성할 때나, 특정 데이터베이스에서만 사용 가능한 기능을 사용해야 할 때 등에 Native query를 사용한다.
 *
 * 네이티브 쿼리 API는 다음의 3가지가 있다.
 *  1. 결과 타입 정의(엔티티 클래스만 지정 가능)
 *      public Query createNativeQuery(String sqlString, Class resultClass);
 *
 *  2. 결과 타입을 정의할 수 없을 때
 *      public Query createNativeQuery(String sqlString);
 *
 *  3. 결과 매핑 사용
 *      public Query createNativeQuery(String sqlString, String resultSetMapping);
 *
 * </pre>
 */
public class JpqlNativeQueryTest {
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
    @DisplayName("결과 타입을 지정해서 Native query 사용하기")
    void test1() {
        // given
        Long menuCode = 15L;

        // when 🙉진짜 sql처럼 작성
        String sql = """
                select
                    *
                from
                    tbl_menu
                where
                    menu_code = ?
                """;
        // 🙉 Entity클래스를 반환타입으로 지정하면, 조회결과를 영속성 컨텍스트에서 관리하게 된다.
        Query query = this.entityManager.createNativeQuery(sql, Menu.class) // Menu안에 영속성 컨텍스트가 바로 관리가 됨
                            .setParameter(1, menuCode);
        Menu menu = (Menu) query.getSingleResult();
        /**
         * Hibernate:
         *     select
         *         *
         *     from
         *         tbl_menu
         *     where
         *         menu_code = ?
         */
        System.out.println(menu);

        // then
        assertThat(menu).isNotNull();
        assertThat(this.entityManager.contains(menu)).isTrue(); // entityManager야 너 menu객체 가지고 있어?
    }

    @Test
    @DisplayName("결과 타입을 지정하지 않고 Native query 사용하기(엔티티 클래스 외에는 지저 불가)")
    void test2() {
        // given
        Long menuCode = 15L;

        // when 🙉진짜 sql처럼 작성
        String sql = """
                select
                    menu_code,
                    menu_name, 
                    (select category_name from tbl_category where category_code = m.category_code) 
                from
                    tbl_menu m
                where
                    menu_code = ?
                """; // 🙉얘를 받는 ResponseDto를 쓸 거여서 별칭을 달아줌
        // 🙉 Entity클래스를 반환타입으로 지정하면, 조회결과를 영속성 컨텍스트에서 관리하게 된다.
        Query query = this.entityManager.createNativeQuery(sql)
                .setParameter(1, menuCode);
         Object[] row  = (Object[])query.getSingleResult();
        /**
         * Hibernate:
         *     select
         *         menu_code,
         *         menu_name,
         *         (select
         *             category_name
         *         from
         *             tbl_category
         *         where
         *             category_code = m.category_code)
         *     from
         *         tbl_menu m
         *     where
         *         menu_code = ?
         */
        Arrays.stream(row).forEach(System.out::println);
        /**
         * 15
         * 죽방멸치튀김우동
         * 일식
         */

        // then
        assertThat(row).hasSize(3);
        // 엔티티 타입이 아닌 경우, EntityManager#contains()인자로 전달할 수 없다.IllegalArgumentException
//        assertThat(this.entityManager.contains(row)).isFalse();
    }

    @Test
    @DisplayName("@NamedNativeQuery 사용하기 - 엔티티")
    void test3() {
        // given
        Long menuCode = 15L;
        // when
        Query query = this.entityManager.createNamedQuery("_09.nativequery.Menu.findByMenuCode", Menu.class)
                .setParameter(1, menuCode);
        Menu menu = (Menu) query.getSingleResult();
        /**
         * Hibernate:
         *     select
         *         *
         *     from
         *         tbl_menu
         *     where
         *         menu_code = ?
         */
        System.out.println(menu); // Menu(menuCode=15, menuName=죽방멸치튀김우동, menuPrice=11000, categoryCode=6, orderableStatus=N)

        // then
        assertThat(menu).isNotNull();
        assertThat(this.entityManager.contains(menu)).isTrue();
    }

    @Test
    @DisplayName("@NamedNativeQuery 사용하기 - DTO @SqlResultSetMapping")
    void test4() {
        // given
        Long menuCode = 15L;
        // when
        Query query = this.entityManager.createNamedQuery("_09.nativequery.Menu.findMenuAndCategory")
                .setParameter(1, menuCode); // entity아니니까 날려버림
        MenuCategoryResponseDto menu = (MenuCategoryResponseDto) query.getSingleResult();
        /**
         * Hibernate:
         *     select
         *         menu_code "menuCode",
         *         menu_name "menuName",
         *         (select
         *             category_name
         *         from
         *             tbl_category
         *         where
         *             category_code = m.category_code) "categoryName"
         *     from
         *         tbl_menu m
         *     where
         *         menu_code = ?
         */
        System.out.println(menu);
        // then
        assertThat(menu).isNotNull();
    }
}
