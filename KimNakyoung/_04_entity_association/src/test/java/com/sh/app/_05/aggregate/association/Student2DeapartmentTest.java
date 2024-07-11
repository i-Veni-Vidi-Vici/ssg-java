package com.sh.app._05.aggregate.association;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Student2DeapartmentTest {
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
    @DisplayName("ddl-auto=create 확인")
    void test() {
        /*
            create table tbl_department (
                capacity integer not null,
                id bigint not null auto_increment,
                name varchar(255),
                primary key (id)
            ) engine=InnoDB
        
            create table tbl_student (
                department_id bigint,
                id bigint not null auto_increment,
                address1 varchar(255),
                address2 varchar(255),
                name varchar(255),
                zipCode varchar(255),
                primary key (id)
            ) engine=InnoDB
         */
    }
    
    @Test
    @DisplayName("Stduent Entity 등록")
    void test2() {
        // given
        // when
        // then
    }
    

}
