package com.sh.app._04.grouping;


import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>
 * JPQL의 그룹함수는 COUNT, MAX, MIN, SUM, AVG로 SQL의 그룹함수와 별반 차이가 없다.
 *
 * 단 몇가지 주의사항이 있다.
 * 1. 그룹함수의 반환 타입은 결과 값이 정수면 Long, 실수면 Double로 반환된다.
 * 2. 값이 없는 상태에서 count를 제외한 그룹 함수는 null이되고 count만 0이 된다.
 *    따라서 반환 값을 담기 위해 선언하는 변수 타입을 기본자료형으로 하게 되면, 조회 결과를 언박싱 할때 NPE가 발생한다.
 * 3. 그룹 함수의 반환 자료형은 Long or Double 형이기 때문에 Having 절에서 그룹 함수 결과값과 비교하기 위한 파라미터 타입은 Long or Double로 해야한다.
 * </pre>
 */
public class JpqlGroupingTest {
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
    @DisplayName("SUM 그룹함수")
    void test() {
        // given
        String jpl = """
                select sum(m.menuPrice)
                from Menu04 m
                """;

        // when
        TypedQuery<Long> query = this.entityManager.createQuery(jpl, Long.class);
        Long sum = query.getSingleResult();

        // then
        System.out.println(sum);
        assertThat(sum)
                .isNotNull()
                .isPositive();
    }

    @Test
    @DisplayName("특정 카테고리 메뉴의 평균 가격을 조회")
    void test2() {
        // given
        Long categoryCode = 4L;
        String jql = """
                select avg(m.menuPrice)
                from Menu04 m
                where m.categoryCode = :categoryCode
                """;

        // when
        TypedQuery<Double> query = this.entityManager.createQuery(jql, Double.class);
        query.setParameter("categoryCode", categoryCode);
        Double avg = query.getSingleResult();

        // then
        System.out.println(avg);
        assertThat(avg)
                .isNotNull()
                .isPositive();
    }

    @Test
    @DisplayName("group by 적용하기")
    void test3() {
        // given
        String jpql = """
                select
                    m.categoryCode,
                    round(avg(m.menuPrice), 1)
                from
                    Menu04 m
                group by
                    m.categoryCode
                """;

        // when
        TypedQuery<MenuStatByCategoryDto> query = this.entityManager.createQuery(jpql, MenuStatByCategoryDto.class);
        List<MenuStatByCategoryDto> dtos = query.getResultList();
        dtos.forEach(System.out::println);

        // then
        assertThat(dtos).isNotNull();
    }

    /**
     * having 절: group by에 대한 조건절, 그룹함수를 조건절에 사용할 수 있다.
     * - 카테고리별 메뉴수가 3개 이상인 카테고리, 메뉴 수를 조회
     * - 단정문에서는 조회된 메뉴수가 3개 이상인지 확인한다.
     */
    @Test
    @DisplayName("group by + having 적용하기")
    void test4() {
        // given
        String jpql = """
                select
                    m.categoryCode,
                    count(m.menuCode)
                from
                    Menu04 m
                group by
                    m.categoryCode
                having
                    count(m.menuCode) >= 3
                """;

        // when
        TypedQuery<MenuStatByCategoryDto> query = this.entityManager.createQuery(jpql, MenuStatByCategoryDto.class);
        List<MenuStatByCategoryDto> dtos = query.getResultList();
        dtos.forEach(System.out::println);

        // then
        assertThat(dtos).isNotNull();
    }
}
