package com.sh.app._04._enum;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberEntityEnumTest {
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
        Member hong = Member.builder()
                .id("honggd")
                .password("1234")
                .email("honggd@gmail.com")
                .gender(Gender.MALE)
                .memberRole(MemberRole.ROLE_MEMBER)
                .createdAt(LocalDateTime.now())
                .enabled(true)
                .build();
        Member sinsa = Member.builder()
                .id("sinsa")
                .password("1234")
                .email("sinsa@gmail.com")
                .gender(Gender.FEMALE)
                .memberRole(MemberRole.ROLE_ADMIN)
                .createdAt(LocalDateTime.now())
                .enabled(true)
                .build();

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(hong);
            entityManager.persist(sinsa);
            transaction.commit();
            /*
                select tbl.next_val
                from tbl_sequence tbl
                where tbl.table_name=? for update
                update tbl_sequence
                set next_val=?
                where next_val=?
                  and table_name=?

                select tbl.next_val
                from tbl_sequence tbl
                where tbl.table_name=? for update
                update tbl_sequence
                set next_val=?
                where next_val=?
                  and table_name=?

                insert
                into
                    tbl_member0302
                    (member_created_at, member_email, member_enabled, member_id, member_name, member_password, member_code)
                values
                    (?, ?, ?, ?, ?, ?, ?)
                insert
                into
                    tbl_member0302
                    (member_created_at, member_email, member_enabled, member_id, member_name, member_password, member_code)
                values
                    (?, ?, ?, ?, ?, ?, ?)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        System.out.println(hong);
        System.out.println(sinsa);
        // then
        assertThat(hong.getCode()).isNotNull().isNotZero();
        assertThat(sinsa.getCode()).isNotNull().isNotZero();
    }

}
