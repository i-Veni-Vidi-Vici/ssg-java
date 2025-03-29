package com.sh.app._01.one2one._01.non.identifying;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.time.YearMonth;
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
        /*
                create table tbl_membership_card (
                    enabled bit not null,
                    expiry_date date,
                    number varchar(255) not null,
                    user_email varchar(255),
                    primary key (number)
                ) engine=InnoDB
            Hibernate:
                create table tbl_user (
                    created_at datetime(6),
                    email varchar(255) not null,
                    name varchar(255),
                    primary key (email)
                ) engine=InnoDB
            Hibernate:
                alter table tbl_membership_card
                   add constraint UKt177ql4elt9o4fjr8my0jf2x2 unique (user_email)
            Hibernate:
                alter table tbl_membership_card
                   add constraint FKcca9ryy0c45lgqs2x1un8vw7k
                   foreign key (user_email)
                   references tbl_user (email)
         */
    }

    @Test
    @DisplayName("MembershipCard_User 등록")
    void test2() {
        User user=User.builder()
                .email("honggd@naver.com")
                .name("홍길동")
                .build();

        MembershipCard membershipCard = MembershipCard.builder()
                .number("1111-2222-3333-4444")
                .owner(user)
                .expiryDate(YearMonth.of(2028,7))
                .enabled(true)
                .build();

        this.entityManager.persist(user);
        this.entityManager.persist(membershipCard);
        this.entityManager.flush(); // 쿼리 날라감

        // 지금 위에는 영속성컨텍스트에 존재해서 select쿼리가 안날라간다 그래서
        this.entityManager.clear(); // 여기서 영속성객체를 제거 한다 (준영속처리)
        MembershipCard membershipCard2=entityManager.find(MembershipCard.class,membershipCard.getNumber());
        System.out.println("membershipCard2 = " + membershipCard2);

        assertThat(membershipCard2).isNotNull();
        assertThat(membershipCard2.getOwner()).isNotNull();


    }


}

















