package com.sh.app._01.one2one._01.non_identifying;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;


import static org.assertj.core.api.Assertions.assertThat;

public class MembershipCard2UserTest {
    // application-scope: 1개만 만들어서 재사용 (thread-safe)
    private static EntityManagerFactory entityManagerFactory;
    // request-scope: 웹요청마다 1개씩 생성 (non-thread-safe)
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        // jpa설정정보를 읽어서 EntityManagerFactory를 생성
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
            create table tbl_membership_card (
                enabled bit not null,
                expiry_date date,
                number varchar(255) not null,
                user_email varchar(255),
                primary key (number)
            ) engine=InnoDB
            create table tbl_user (
                created_at datetime(6),
                email varchar(255) not null,
                name varchar(255),
                primary key (email)
            ) engine=InnoDB
            alter table tbl_membership_card
               add constraint UKt177ql4elt9o4fjr8my0jf2x2 unique (user_email)
           alter table tbl_membership_card
               add constraint FKcca9ryy0c45lgqs2x1un8vw7k
               foreign key (user_email)
               references tbl_user (email)
         */
    }

}
