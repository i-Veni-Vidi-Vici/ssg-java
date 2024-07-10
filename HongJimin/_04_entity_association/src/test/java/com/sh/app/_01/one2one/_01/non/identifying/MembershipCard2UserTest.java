package com.sh.app._01.one2one._01.non.identifying;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;

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
         * Hibernate: ✨FK 조건✨
         *     alter table tbl_membership_card
         *        add constraint FKcca9ryy0c45lgqs2x1un8vw7k
         *        foreign key (user_email)
         *        references tbl_user (email)
         */
    }

    // ✨등록은 2가지 - 유저가 멤버십 카드르 참조할 때, 안 할 때 둘 다 사용해야함!✨

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
                .expiryDate(YearMonth.of(20248, 7)) // 년 월까지만 관리
                .enabled(true)
                .build();

        // when
        this.entityManager.persist(user);
        this.entityManager.persist(membershipCard);
        this.entityManager.flush(); // 쿼리를 확인하는 용도
        /**
         * ✨flush 했을 때, insert문 두개가 날라감!
         * insert
         *     into
         *         tbl_user
         *         (created_at, name, email)
         *     values
         *         (?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_membership_card
         *         (enabled, expiry_date, user_email, number)
         *     values
         *         (?, ?, ?, ?)
         */


        // then
        this.entityManager.clear(); // 영속성 컨텍스트 안의 영속 객체 모두 제거(준영속처리)

        MembershipCard membershipCard2 = this.entityManager.find(MembershipCard.class, membershipCard.getNumber());
        /**
         * ✨조회했을 때, 조인 쿼리가 날라감✨
         *  🙉FetchType.EAGER인 경우 Join 쿼리
         *
         *  select
         *         mc1_0.number,
         *         mc1_0.enabled,
         *         mc1_0.expiry_date,
         *         o1_0.email,
         *         o1_0.created_at,
         *         o1_0.name
         *     from
         *         tbl_membership_card mc1_0
         *     left join
         *         tbl_user o1_0
         *             on o1_0.email=mc1_0.user_email
         *     where
         *         mc1_0.number=?
         *  🙉 FetchType.LAZY인 경우 쿼리
         *    select
         *         mc1_0.number,
         *         mc1_0.enabled,
         *         mc1_0.expiry_date,
         *         mc1_0.user_email
         *     from
         *         tbl_membership_card mc1_0
         *     where
         *         mc1_0.number=?
         * Hibernate:
         *     select
         *         u1_0.email,
         *         u1_0.created_at,
         *         u1_0.name
         *     from
         *         tbl_user u1_0
         *     where
         *         u1_0.email=?
         */
        System.out.println(membershipCard2); // ❓❓❓내부적으로 toString이 호출(롬복한테 호출해달라 함)하는데, 이때 필요해서 쿼리를 다시 날리게 됨


        assertThat(membershipCard2).isNotNull();
        assertThat(membershipCard2.getOwner()).isNotNull(); // 등록했으니까 반드시 있어야 함!

    }

    @Test
    @DisplayName("MembershipCard 등록(User가 null인 경우)")
    void test3() {
        // given
        MembershipCard membershipCard = MembershipCard.builder()
                .number("8888-2222-3333-4444")
                .expiryDate(YearMonth.of(20248, 7)) // 년 월까지만 관리
                .enabled(true)
                .build();

        // when
        this.entityManager.persist(membershipCard);
        this.entityManager.flush(); // 쿼리를 확인하는 용도
        /**
         * flush 했을 때의 쿼리
         * Hibernate:
         *     insert
         *     into
         *         tbl_membership_card
         *         (enabled, expiry_date, user_email, number)
         *     values
         *         (?, ?, ?, ?)
         */


        // then
        this.entityManager.clear(); // 영속성 컨텍스트 안의 영속 객체 모두 제거(준영속처리)

        MembershipCard membershipCard2 = this.entityManager.find(MembershipCard.class, membershipCard.getNumber());
        /**
         * ✨조회했을 때
         *     select
         *         mc1_0.number,
         *         mc1_0.enabled,
         *         mc1_0.expiry_date,
         *         mc1_0.user_email
         *     from
         *         tbl_membership_card mc1_0
         *     where
         *         mc1_0.number=?
         */
    System.out.println(membershipCard2.toString()); //MembershipCard(number=8888-2222-3333-4444, owner=null, expiryDate=20248-07, enabled=true)



        assertThat(membershipCard2).isNotNull();
        assertThat(membershipCard2.getOwner()).isNull(); //
    }
}
