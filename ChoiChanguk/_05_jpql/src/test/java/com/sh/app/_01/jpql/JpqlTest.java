package com.sh.app._01.jpql;


import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

/**
 *
 * <h1>JPQL(Java Persistence Query Language)</h1>
 * <pre>
 * - JPQL은 엔터티 객체를 중심으로 개발할 수 있는 객체 지향 쿼리이다.
 * - SQL보다 간결하며 특정 DBMS에 의존하지 않는다.
 * - 방언을 통해 해당 DBMS에 맞는 SQL을 실행하게 된다.
 * - JPQL은 find() 메소드를 통한 조회와 다르게 항상 데이터베이스에 SQL을 실행해서 결과를 조회한다.
 * </pre>
 *
 * <h2>JPQL의 기본 문법</h2>
 * <pre>
 * SELECT, UPDATE, DELETE 등의 키워드 사용은 SQL과 동일하다.
 * INSERT 는 persist() 메소드를 사용하면 된다.
 * 키워드(sql 문법에 해당하는, select, from, where)는 대소문자를 구분하지 않지만, 엔터티와 속성은 대소문자를 구분함에 유의한다.
 * 엔터티 별칭을 필수로 사용해야 하며 별칭 없이 작성하면 에러가 발생한다.
 *
 *
 * JPQL 사용 방법은 다음과 같다.
 * 1. 작성한 JPQL(문자열)을 `entityManager.createQuery()` 메소드를 통해 쿼리 객체로 만든다.
 * 2. 쿼리 객체는 `TypedQuery`, `Query` 두 가지가 있다.
 * 	- TypedQuery : 반환할 타입을 명확하게 지정하는 방식일 때 사용하며 쿼리 객체의 메소드 실행 결과로 지정한 타입이 반환 된다.
 * 	- Query : 반환할 타입을 명확하게 지정할 수 없을 때 사용하며 쿼리 객체 메소드의 실행 결과로 Object 또는 Object[]이 반환 된다.
 * 3. 쿼리 객체에서 제공하는 메소드 `getSingleResult()` 또는 `getResultList()`를 호출해서 쿼리를 실행하고 데이터베이스를 조회한다.
 * 	- getSingleResult() : 결과가 정확히 한 행일경우 사용하며 없거나 많으면 예외가 발생한다.
 * 	- getResultList() : 결과가 2행 이상일 경우 사용하며 컬렉션을 반환한다. 결과가 없으면 빈 컬렉션을 반환한다.
 * 	</pre>
 */
// vote에서 person을 참조한다
public class JpqlTest {
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
    @DisplayName("sample")
    void test0() {
        //given
        //when
        //then

    }
    @Test
    @DisplayName("TypedQuery 테스트")
    void test1() {
        // 테이블 별칭을 선언하고, select절에서 사용해야 한다, *를 사용할 수 없다
        String jpql="select m from Menu01 as m"; // 조회나는 곳이 Entity 이니깐, Entity name값을 써야 한다

        // when
        TypedQuery<Menu> query = this.entityManager.createQuery(jpql, Menu.class);
        List<Menu> menus=query.getResultList();

        //이쯤에서 쿼리가 날라감

        for(Menu menu:menus)
        {
            System.out.println("menu = " + menu);
        }
    }

    @Test
    @DisplayName("TypedQuery - String 테스트")
    void test2() {
        //given
        // where 조건절에서도 table의 아닌 entity기준으로 조회한다
        String jpql="select m.menuName from Menu01 m where m.menuCode = 7"; // m.필드명
        //when
        TypedQuery<String> query = this.entityManager.createQuery(jpql, String.class);// 출력되는 타입을 쓴다, 지금은 menuName이므로 String으로 한다

        String menuName=query.getSingleResult();
        System.out.println("menuName = " + menuName);
        //then

    }

    /**
     * TypedQuery와 다르게 반환타입
     */
    @Test
    @DisplayName("Query - Menu 테스트")
    void test3() {
        //given

        //given
        // where 조건절에서도 table의 아닌 entity기준으로 조회한다
        String jpql="select m from Menu01 as m"; // m.필드명
        //when
        Query query = this.entityManager.createQuery(jpql);// 출력되는 타입을 쓴다, 지금은 menuName이므로 String으로 한다
        List<Menu> menus=query.getResultList();

        System.out.println("menus = " + menus);
        //when
        //then

    }

    @Test
    @DisplayName("distinct 키워드")
    void test4() {
        String jpql="select distinct m.categoryCode from Menu01 m  ";

        TypedQuery<Long> query = this.entityManager.createQuery(jpql, Long.class);


    }




}

















