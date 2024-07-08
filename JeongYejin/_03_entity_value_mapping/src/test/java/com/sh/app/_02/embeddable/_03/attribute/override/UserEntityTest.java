package com.sh.app._02.embeddable._03.attribute.override;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class UserEntityTest {
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
    @DisplayName("ddl-auto=create 확인")
    void test() {
        /**
         * Hibernate:
         *     create table tbl_user (
         *         home_addr1 varchar(255),
         *         home_addr2 varchar(255),
         *         home_zip_code varchar(255),
         *         id varchar(255) not null,
         *         work_addr1 varchar(255),
         *         work_addr2 varchar(255),
         *         work_zip_code varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         */
    }

    @Test
    @DisplayName("User Entity 등록")
    void test2() {
        User user = User.builder()
                .id("jeongyj")
                .homeAddress(new Address("서울시 동작구", "신대방2동", "07063"))
                .workAddress(new Address("서울시 강남구", "삼성동", "01234"))
                .build();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            entityManager.persist(user); // 세개의 테이블에 각각 인서트해주는 걸 JPA가 해준다!
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        assertThat(user.getId()).isNotNull();
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_user
         *         (home_addr1, home_addr2, home_zip_code, work_addr1, work_addr2, work_zip_code, id)
         *     values
         *         (?, ?, ?, ?, ?, ?, ?)
         */

        entityManager.detach(user);
        User user2 = entityManager.find(User.class, user.getId());
        assertThat(user2).isNotNull();
        // 여러 테이블에서 조회를 실행하는 것보다 조인을 하는 게 DB 트래픽을 줄이는 데 도움이 된다.
        /**
         * Hibernate:
         *     select
         *         u1_0.id,
         *         u1_0.home_addr1,
         *         u1_0.home_addr2,
         *         u1_0.home_zip_code,
         *         u1_0.work_addr1,
         *         u1_0.work_addr2,
         *         u1_0.work_zip_code
         *     from
         *         tbl_user u1_0
         *     where
         *         u1_0.id=?
         */
    }

    @Test
    @DisplayName("User Entity 등록 - VO객체가 Null인 경우")
    void test3() {
        User user = User.builder()
                .id("jeongyj")
                .homeAddress(new Address("서울시 동작구", "신대방2동", "07063"))
//                .workAddress(new Address("서울시 강남구", "삼성동", "01234"))
                .build();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            entityManager.persist(user); // 세개의 테이블에 각각 인서트해주는 걸 JPA가 해준다!
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        assertThat(user.getId()).isNotNull();
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_user
         *         (home_addr1, home_addr2, home_zip_code, work_addr1, work_addr2, work_zip_code, id)
         *     values
         *         (?, ?, ?, ?, ?, ?, ?)
         */
        entityManager.detach(user);
        User user2 = entityManager.find(User.class, user.getId());
        assertThat(user2).isNotNull();
        /**
         * Hibernate:
         *     select
         *         u1_0.id,
         *         u1_0.home_addr1,
         *         u1_0.home_addr2,
         *         u1_0.home_zip_code,
         *         u1_0.work_addr1,
         *         u1_0.work_addr2,
         *         u1_0.work_zip_code
         *     from
         *         tbl_user u1_0
         *     where
         *         u1_0.id=?
         */
        System.out.println(user2);
        // User(id=jeongyj, homeAddress=Address(address1=서울시 동작구, address2=신대방2동, zipCode=07063), workAddress=null)
    }
}
