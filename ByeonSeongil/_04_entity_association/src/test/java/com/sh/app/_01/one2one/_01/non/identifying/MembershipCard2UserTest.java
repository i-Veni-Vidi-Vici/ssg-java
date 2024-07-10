package com.sh.app._01.one2one._01.non.identifying;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

public class MembershipCard2UserTest {
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
//        Hibernate:
//        create table tbl_membership_card (
//                enabled bit not null,
//                expiry_date date,
//                number varchar(255) not null,
//                user_email varchar(255),
//                primary key (number)
//    ) engine=InnoDB
//                Hibernate:
//        create table tbl_user (
//                create_at datetime(6),
//                email varchar(255) not null,
//                name varchar(255),
//                primary key (email)
//    ) engine=InnoDB
//        Hibernate:
//        alter table tbl_membership_card
//        add constraint UKt177ql4elt9o4fjr8my0jf2x2 unique (user_email)
//                Hibernate:
//        alter table tbl_membership_card
//        add constraint FKcca9ryy0c45lgqs2x1un8vw7k
//        foreign key (user_email)
//                references tbl_user (email)
    }
}
