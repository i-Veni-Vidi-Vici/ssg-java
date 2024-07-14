package com.sh.app._07.subquery;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>
 * SQL처럼 서브쿼리를 지원하지만,
 * select, from 절에서는 사용 불가능
 * where, having 조건절에서만 사용 가능
 * </pre>
 */
public class JpqlSubqueryTest {
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
    @DisplayName("")
    void test1() {

        String categoryName = "한식";

        String jpql= """
                select m
                from Menu07 m
                where m.categoryCode=(
                select 
                    c.categoryCode 
                from
                    Category07 c
            where 
    c.categoryName=:categoryName)
                """;
        TypedQuery<Menu> query=this.entityManager.createQuery(jpql,Menu.class).setParameter("categoryName",categoryName);
        List<Menu> resultList = query.getResultList();
        resultList.forEach(System.out::println);

    }

    
}

