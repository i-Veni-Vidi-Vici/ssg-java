package com.sh.app._05.paging;


import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

/**
 * <pre>
 * JPQL의 paging API
 * 1. 컨텐츠 영역에 대한 쿼리
 * 2. 페이지바 html 처리
 * </pre>
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
    @DisplayName("페이징 쿼리")
    void test1PagingQuery() {
        //given
        int limit=10; //한 페이지당 몇개 보여줄까??
        int page=1;
        int offset=(page-1)*limit;
        String jpql= """
                select 
                    m
                    from Menu05 m
                    order by m.menuCode
                """;
        TypedQuery<Menu> query=this.entityManager.createQuery(jpql,Menu.class)
                .setMaxResults(limit)// 한페이지당 최대 행수
                .setFirstResult(offset);

        List<Menu> menus= query.getResultList();

//        menus.forEach(System.out::println);
        System.out.println(menus.size());
        //when

        //then

    }



}

















