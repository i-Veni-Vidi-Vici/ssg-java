package com.sh.app._01.one2one._01.non.identifying;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


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
        /**
         *
         * create table tbl_membership_card (
         *         enabled bit not null,
         *         expiry_date date,
         *         number varchar(255) not null,
         *         user_email varchar(255), ✨이부분이 중요! ->@oneToOne & @JoinColumn(name = "user_email")이 붙은 User owner밖에 없는데 이걸로 userEmail을 참조함
         *         primary key (number)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_user (
         *         created_at datetime(6),
         *         email varchar(255) not null,
         *         name varchar(255),
         *         primary key (email)
         *     ) engine=InnoDB
         * Hibernate:
         *     alter table tbl_membership_card
         *        add constraint UKt177ql4elt9o4fjr8my0jf2x2 unique (user_email) ✨이게 없으면 하나의 회원이 여러개의 멤버십 카드를 가질 수 있기 때문! -> 하나의 이메일은 하나의 멤버십 카드를 가질 수 있다!
         * Hibernate:
         *     alter table tbl_membership_card
         *        add constraint FKcca9ryy0c45lgqs2x1un8vw7k
         *        foreign key (user_email)
         *        references tbl_user (email)
         */
    }

    // 등록은 2가지 - 유저가 멤버십 카드르 참조할 때, 안 할 때 둘 다 사용해야함!

}
