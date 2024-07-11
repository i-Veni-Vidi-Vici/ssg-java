package com.sh.app._02.embeddable._03.attribute.override;


import com.sh.app._02.embeddable._02.secondary.table.Writer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class UserEntityTest {
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
                .homeAddress(new Address("집1", "집2","00000"))
                .workAddress(new Address("회사1", "회사2","11111"))
                .build();
        System.out.println(user);
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(user);
            transaction.commit();
            /*
                insert
                into
                    tbl_user
                    (home_addr1, home_addr2, home_zip_code, work_addr1, work_addr2, work_zip_code, id)
                values
                    (?, ?, ?, ?, ?, ?, ?)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        assertThat(user.getId()).isNotNull();
    }

    @Test
    @DisplayName("User Entity 등록 - VO객체가 Null인 경우")
    void test3() {
        // given
        User user1 = User.builder()
                .id("길동이")
                .homeAddress(new Address("집1", "집2","00000"))
                .build();
        System.out.println(user1);
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(user1);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        entityManager.detach(user1);
        User user2 = entityManager.find(User.class, user1.getId());
        System.out.println(user2);
        assertThat(user2).isNotNull();
        assertThat(user2.getHomeAddress()).isNotNull();
        assertThat(user2.getWorkAddress()).isNull();

    }

}
