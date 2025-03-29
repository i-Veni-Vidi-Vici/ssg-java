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
        /*
            create table tbl_user (
                home_addr1 varchar(255),
                home_addr2 varchar(255),
                home_zip_code varchar(255),
                id varchar(255) not null,
                work_addr1 varchar(255),
                work_addr2 varchar(255),
                work_zip_code varchar(255),
                primary key (id)
            ) engine=InnoDB
         */
    }

    @Test
    @DisplayName("User Entity 등록")
    void test2() {
        // given
        User user = User.builder()
                .id("honggd")
                .homeAddress(new Address("집1", "집2", "00000"))
                .workAddress(new Address("회사1", "회사2", "11111"))
                .build();
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(user);
            /*
                insert
                into
                    tbl_user
                    (home_addr1, home_addr2, home_zip_code, work_addr1, work_addr2, work_zip_code, id)
                values
                    (?, ?, ?, ?, ?, ?, ?)
             */
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        assertThat(user.getId()).isNotNull();
        entityManager.detach(user);

        User user2 = entityManager.find(User.class, user.getId());
        /*
            select
                u1_0.id,
                u1_0.home_addr1,
                u1_0.home_addr2,
                u1_0.home_zip_code,
                u1_0.work_addr1,
                u1_0.work_addr2,
                u1_0.work_zip_code
            from
                tbl_user u1_0
            where
                u1_0.id=?
         */
        assertThat(user).isNotNull();
    }

    @Test
    @DisplayName("Writer Entity 등록 - VO객체가 null인 경우")
    void test3() {
        // given
        User user = User.builder()
                .id("honggd")
                .homeAddress(new Address("집1", "집2", "00000"))
                .build();
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(user);
            /*
                insert
                into
                    tbl_user
                    (home_addr1, home_addr2, home_zip_code, work_addr1, work_addr2, work_zip_code, id)
                values
                    (?, ?, ?, ?, ?, ?, ?)
             */
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        assertThat(user.getId()).isNotNull();
        entityManager.detach(user);

        User user2 = entityManager.find(User.class, user.getId());
        /*
            select
                u1_0.id,
                u1_0.home_addr1,
                u1_0.home_addr2,
                u1_0.home_zip_code,
                u1_0.work_addr1,
                u1_0.work_addr2,
                u1_0.work_zip_code
            from
                tbl_user u1_0
            where
                u1_0.id=?
         */
        assertThat(user2).isNotNull();
        System.out.println(user2);
        /*
            User(id=honggd, homeAddress=Address(address1=집1, address2=집2, zipCode=00000), workAddress=null)
         */
    }
}
