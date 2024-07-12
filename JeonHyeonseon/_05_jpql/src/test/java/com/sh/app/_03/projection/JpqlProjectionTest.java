package com.sh.app._03.projection;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import javax.print.attribute.HashPrintServiceAttributeSet;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <h1>프로젝션(projection)</h1>
 * SELECT 절에 조회할 대상을 지정하는 것을 프로젝션이라고 한다.
 * <code>
 * SELECT {프로젝션 대상} FROM 엔티티
 * </code>
 *
 * <pre>
 * 프로젝션 대상은 4가지 방식이 있다.
 * 1. 엔티티 프로젝션
 *    원하는 객체를 바로 조회할 수 있다.
 *    조회된 엔티티는 영속성 컨텍스트가 관리한다.
 *
 * 2. 임베디드 타입 프로젝션(임베디드 타입에 대한 설명은 MenuInfo 클래스에서 설명)
 *    엔티티와 거의 비슷하게 사용되며 조회의 시작점이 될 수 없다. -> from 절에 사용 불가
 *    임베디드 타입은 영속성 컨텍스트에서 관리되지 않는다.
 *
 * 3. 스칼라(값 하나) 타입 프로젝션
 *    숫자, 문자, 날짜 같은 기본 데이터 타입이다.
 *    스칼라 타입은 영속성 컨텍스트에서 관리되지 않는다.
 *
 * 4. new 명령어를 활용한 프로젝션
 *    다양한 종류의 단순 값들을 DTO로 바로 조회하는 방식으로 new 패키지명. DTO명을 쓰면 해당 DTO로 바로 반환받을 수 있다.
 *    new 명령어를 사용한 클래스의 객체는 엔티티가 아니므로 영속성 컨텍스트에서 관리되지 않는다.
 * </pre>
 */

public class JpqlProjectionTest {
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
    @DisplayName("1. 엔티티 프로젝션 - Category")
    void test1() {
        // given
        String jpql = """
                select
                    c
                from
                    Category03 c
                """;
        // 조회 후 바로 영속성 컨텍스트로 들어간다.
        // when
        TypedQuery<Category> query = this.entityManager.createQuery(jpql, Category.class);
        List<Category> categories = query.getResultList();
        /*
        Hibernate:
            select
                c1_0.category_code,
                c1_0.category_name,
                c1_0.ref_category_code
            from
                tbl_category c1_0
         */
        categories.forEach(System.out::println);

        // 반환받은 Category객체(영속성 컨텍스트에서 관리받음)를 수정한다고 가정했을 때
        categories.get(0).changeCategoryName("새 카테고리");
        /*
        영속성 컨텍스트에 변화가 생겼기 때문에 이렇게 나온다.
        Hibernate:
            update
                tbl_category
            set
                category_name=?,
                ref_category_code=?
            where
                category_code=?
         */

        // then
        assertThat(categories).isNotNull()
                .allMatch((category) -> category != null);
    }

    @Test
    @DisplayName("2. 임베디드(VO) 프로젝션")
    void test2() {
        // given
        String jpql = """
                select
                    m.menuVo
                from
                    Menu0302 as m
                """;
        // when
        TypedQuery<MenuVo> query = this.entityManager.createQuery(jpql, MenuVo.class);
        List<MenuVo> menuVos = query.getResultList();
        /*
        Hibernate:
            select
                me1_0.menu_name,
                me1_0.menu_price
            from
                tbl_menu me1_0
         */
        menuVos.forEach(System.out::println);
        // then
        assertThat(menuVos).isNotNull()
//                .allMatch((menuVo) -> menuVo instanceof MenuVo); // allMatch는 true/false로 나옴
                .allSatisfy(menuVo -> assertThat(menuVo).isInstanceOf(MenuVo.class)); // 위의 식과 같은 의미이다.
    }

    @Test
    @DisplayName("3. 스칼라 프로젝션") // 스칼라가 의미하는 것은 값이 하나라는 것이다.
    void test3() {
        // given
        String jpql = """
                select
                    c.categoryName
                from
                    Category03 c
                """;
        // when
        TypedQuery<String> query = this.entityManager.createQuery(jpql, String.class);
        List<String> categoryNames = query.getResultList();
        /*
        Hibernate:
            select
                c1_0.category_name
            from
                tbl_category c1_0
         */
        categoryNames.forEach(System.out::println);
        // then
        assertThat(categoryNames).isNotNull();
    }

    @Test
    @DisplayName("3-2. 스칼라 프로젝션 - count") // 스칼라가 의미하는 것은 값이 하나라는 것이다.
    void test3_2() {
        // given
        String jpql = """
                select
                    count(c)
                from
                    Category03 c
                """;
        // when
        TypedQuery<Long> query = this.entityManager.createQuery(jpql, Long.class);
        Long count = query.getSingleResult(); // 그룹함수 결과는 기본형이 아닌 wrapper타입으로 관리하기.
        /*
        Hibernate:
            select
                count(c1_0.category_code)
            from
                tbl_category c1_0
         */
        // then
        assertThat(count).isNotNull();
    }

    @Test
    @DisplayName("여러 컬럼 조회 : Query-Object[] 사용하기(반환타입을 지정할 수 없는 경우)")
    void test4_0() {
        // given
        String jpql = """
                select
                    c.categoryCode,
                    c.categoryName,
                    123
                from
                    Category03 c
                """;
        // when
        Query query = this.entityManager.createQuery(jpql);
        List<Object[]> rows = query.getResultList();
        // [{1L, 식사, 123}, {2L, 디저트, 123}, ...] 식으로 나온다.[]는 리스트, {}는 Object
        /*
        Hibernate:
            select
                c1_0.category_name
            from
                tbl_category c1_0
         */
        for (int i = 0; i < rows.size(); i++) {
            Object[] row = rows.get(i);
            // Object로 넘어오기 때문에 다운캐스팅이 필수
            Long categoryCode = (Long) row[0];
            String categoryName = (String) row[1];
            Integer number = (Integer) row[2];
            System.out.printf("%d %s %d\n", categoryCode, categoryName, number);
            /*
            Hibernate:
                select
                    c1_0.category_code,
                    c1_0.category_name,
                    123
                from
                    tbl_category c1_0
            1 식사 123
            2 음료 123
            3 디저트 123
            4 한식 123
            5 중식 123
            6 일식 123
            7 퓨전 123
            8 커피 123
            9 쥬스 123
            10 기타 123
            11 동양 123
            12 서양 123
             */
        }
        // then
        assertThat(rows).isNotNull()
                .allSatisfy((row) -> {
                    assertThat(row[0]).isInstanceOf(Long.class);
                    assertThat(row[1]).isInstanceOf(String.class);
                    assertThat(row[2]).isInstanceOf(Integer.class);
                });
    }

    /**
     * 반환된 DTO객체는 영속되지 않는다. (엔티티객체가 아니기 때문)
     */
    @Test
    @DisplayName("4. DTO 프로젝션")
    void test4() {
        // given
        String jpql = """
                select
                    new com.sh.app._03.projection.CategoryResponseDto(
                        c.categoryCode,
                        c.categoryName,
                        123
                    )
                from
                    Category03 c
                """;
        // when
        TypedQuery<CategoryResponseDto> query = this.entityManager.createQuery(jpql, CategoryResponseDto.class);
        List<CategoryResponseDto> categoryResponseDtos = query.getResultList();
        /*
        Hibernate:
            select
                c1_0.category_code,
                c1_0.category_name,
                123
            from
                tbl_category c1_0
         */
        categoryResponseDtos.forEach(System.out::println);

        // DTO를 수정한다고 가정했을 때 - DTO객체 수정은 영속성 컨텍스트 또는 DB에 어떤 영향도 줄 수 없다. (영속객체가 아니기 때문)
        categoryResponseDtos.get(0).setCategoryCode(100L); // 이것은 영속객체가 아니므로 DTO,db에는 영향이 없다.

        // then
        assertThat(categoryResponseDtos).isNotNull()
                .allSatisfy((categoryResponseDto) ->
                        assertThat(categoryResponseDto).isInstanceOf(CategoryResponseDto.class));
    }
}