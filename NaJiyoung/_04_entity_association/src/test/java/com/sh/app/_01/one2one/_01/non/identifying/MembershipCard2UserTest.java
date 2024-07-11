package com.sh.app._01.one2one._01.non.identifying;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.YearMonth;

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
        entityManager.getTransaction().begin();
    }

    @AfterEach
    void tearDown() {
        entityManager.getTransaction().commit();
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
            Hibernate:
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
    @DisplayName("MembershipCard-User 등록")
    void test2() {
        // given
        User user = User.builder()
                .email("honggd@naver.com")
                .name("홍길동")
                .build();
        MembershipCard membershipCard = MembershipCard.builder()
                .number("1111-2222-3333-4444")
                .owner(user)
                .expiryDate(YearMonth.of(2028, 7))
                .enabled(true)
                .build();
        // when
        this.entityManager.persist(user);
        this.entityManager.persist(membershipCard);
        this.entityManager.flush();
        /*
            Hibernate:
                insert
                into
                    tbl_user
                    (created_at, name, email)
                values
                    (?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_membership_card
                    (enabled, expiry_date, user_email, number)
                values
                    (?, ?, ?, ?)
         */
        // then
        this.entityManager.clear(); // 영속성컨텍스트 안의 영속객체 모두 제거 (준영속처리)

        MembershipCard membershipCard2 = this.entityManager.find(MembershipCard.class, membershipCard.getNumber());
        /*
            Fetchtype.EAGER인 경우 : (조인 쿼리)
            Hibernate:
                select
                    mc1_0.number,
                    mc1_0.enabled,
                    mc1_0.expiry_date,
                    o1_0.email,
                    o1_0.created_at,
                    o1_0.name
                from
                    tbl_membership_card mc1_0
                left join
                    tbl_user o1_0
                        on o1_0.email=mc1_0.user_email
                where
                    mc1_0.number=?
         */
        /*
            FetchType.LAZY인 경우 :
            Hibernate:
                select
                    mc1_0.number,
                    mc1_0.enabled,
                    mc1_0.expiry_date,
                    mc1_0.user_email
                from
                    tbl_membership_card mc1_0
                where
                    mc1_0.number=?
            Hibernate:
                select
                    u1_0.email,
                    u1_0.created_at,
                    u1_0.name
                from
                    tbl_user u1_0
                where
                    u1_0.email=?
         */
        System.out.println(membershipCard2.toString());

        assertThat(membershipCard2).isNotNull();
        assertThat(membershipCard2.getOwner()).isNotNull();
    }

    @Test
    @DisplayName("MembershipCard 등록(User가 null인 경우)")
    void test3() {
        // given
        MembershipCard membershipCard = MembershipCard.builder()
                .number("8888-2222-3333-4444")
                .expiryDate(YearMonth.of(2028, 7))
                .enabled(true)
                .build();
        // when
        this.entityManager.persist(membershipCard);
        this.entityManager.flush();
        /*
            Hibernate:
                insert
                into
                    tbl_membership_card
                    (enabled, expiry_date, user_email, number)
                values
                    (?, ?, ?, ?)
         */
        // then
        this.entityManager.clear(); // 영속성컨텍스트 안의 영속객체 모두 제거 (준영속처리)

        MembershipCard membershipCard2 = this.entityManager.find(MembershipCard.class, membershipCard.getNumber());
        /*
            Hibernate:
            select
                mc1_0.number,
                mc1_0.enabled,
                mc1_0.expiry_date,
                mc1_0.user_email
            from
                tbl_membership_card mc1_0
            where
                mc1_0.number=?
         */
        System.out.println(membershipCard2.toString()); // owner=null

        assertThat(membershipCard2).isNotNull();
        assertThat(membershipCard2.getOwner()).isNull(); // User가 null이기 때문
    }
}