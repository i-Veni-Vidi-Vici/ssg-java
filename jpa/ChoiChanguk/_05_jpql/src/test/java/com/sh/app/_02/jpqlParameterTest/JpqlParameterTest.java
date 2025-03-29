package com.sh.app._02.jpqlParameterTest;


import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

/**
 * <pre>
 * 파라미터 바인딩하는 방법
 * 1. 이름 기준 파라미터(named parameters)
 * 	  ':' 다음에 이름 기준 파라미터를 지정한다. :name
 *
 * ex_) 테이블에 있는 이름 : 입력하는 메뉴
 * m.menucode : menuCode
 * 2. 위치 기준 파라미터(positional parameters)
 *    '?' 다음에 값을 주고 위치 값은 1부터 시작한다. ?1, 1번부터 값이 시작한다
 *
 *
 * </pre>
 */

// vote에서 person을 참조한다
public class JpqlParameterTest {
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
    @DisplayName("이름 파라미터 테스트")
    void test1() {
        //given
        String menuName = "한우딸기국밥";
        String jpql = """
                select
                    m
                from 
                      Menu02 m          
                where
                    m.menuName=:menuName""";
        //when

        TypedQuery<Menu> query=this.entityManager.createQuery(jpql,Menu.class).setParameter("menuName",menuName);
//        query.setParameter("menuName",menuName);

        List<Menu> menus = query.getResultList();
        menus.forEach(System.out::println);
        //then

    }

    @Test
    @DisplayName("Like 연산처리")
    void test2() {
        String menuName = "밥";
        String jpql= """
                select m
                from Menu02 m
                where m.menuName like :menuName""";

        TypedQuery<Menu> query = this.entityManager.createQuery(jpql, Menu.class).setParameter("menuName", "%" + menuName + "%");

        List<Menu> menus=query.getResultList();
        menus.forEach(System.out::println);


    }

    @Test
    @DisplayName("위치 파라미터 테스트")
    void test4() {
        //given
        String menuName = "한우딸기국밥";
        String orderableStatus =  "Y";
        String jpql= """
                select
                m
                from Menu02 m
                where
                m.orderableStatus=?1
                and m.menuName=?2""";

        TypedQuery<Menu> query=this.entityManager.createQuery(jpql,Menu.class)
                .setParameter(1,orderableStatus)
                .setParameter(2,menuName);
        List<Menu> menus=query.getResultList();
        System.out.println("menus = " + menus);
        //when
        //then

    }




}

















