package com.sh.app._03.primary.key._02.table.strategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberEntityPrimaryKeyTableStrategyTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    void setUp() {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterEach
    void tearDown() {
        this.entityManager.close();
    }

    @AfterAll
    static void afterAll() {
        entityManagerFactory.close();
    }

    @Test
    @DisplayName("ddl-auto = create 설정")
    void test1() {
        /*
           create table tbl_member0301 (
                member_enabled bit,
                member_code bigint not null auto_increment,
                member_created_at datetime(6),
                member_password varchar(20) not null,
                member_email varchar(255),
                member_id varchar(255),
                member_name varchar(100) default '홍길동',
                primary key (member_code)
            ) engine=InnoDB
         */
    }

    @Test
    @DisplayName("Member Entity객체 등록")
    void test2() {
        // given
        Member honggd = Member.builder()
                .id("honggd")
                .password("1234")
                .email("honggd@gmail.com")
                .createdAt(LocalDateTime.now())
                .enabled(true)
                .build();
        Member sinsa = Member.builder()
                .id("sinsa")
                .password("1234")
                .email("sinsa@gmail.com")
                .createdAt(LocalDateTime.now())
                .enabled(true)
                .build();

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(honggd);
            entityManager.persist(sinsa);
            transaction.commit();
            /*

             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        System.out.println(honggd);
        System.out.println(sinsa);


        // then
        assertThat(honggd.getCode()).isNotNull().isNotZero();
        assertThat(sinsa.getCode()).isNotNull().isNotZero();
    }

}
