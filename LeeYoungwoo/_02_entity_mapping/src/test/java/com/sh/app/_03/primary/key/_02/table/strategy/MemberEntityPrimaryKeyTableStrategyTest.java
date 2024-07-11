package com.sh.app._03.primary.key._02.table.strategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberEntityPrimaryKeyTableStrategyTest {
    // application-scope: 1개만 만들어서 재사용 (thread-safe)
    private static EntityManagerFactory entityManagerFactory;
    // request-scope: 웹 요청마다 1개씩 생성 (non-thread-safe)
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        // jpa 설정정보를 읽어서 EntityManagerFactory를 생성
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
        // 테이블이 생성되었나요?
        /*
            create table tbl_member0302 (
                member_endabled bit,
                member_code bigint not null,
                member_createdAt datetime(6),
                member_password varchar(20) not null,
                member_email varchar(255),
                member_id varchar(255),
                member_name varchar(100) default '홍길동',
                primary key (member_code)
            ) engine=InnoDB

            create table tbl_sequence (
                next_val bigint,
                table_name varchar(255) not null,
                primary key (table_name)
            ) engine=InnoDB

            insert into tbl_sequence(table_name, next_val) values ('tbl_member0302',0)
         */
    }

    @Test
    @DisplayName("Member Entity객체 등록")
    void test2() {
        // given
        // builder 패턴 적용(디자인패턴 - 생성)
        Member honggd = Member.builder()
                .id("honggd")
                .password("1234")
                .email("honggd@gmail.com")
                .createdAt(LocalDateTime.now())
                .enabled(true)
                .build();
        Member sinsa = Member.builder()
                .id("sinsa")
                .password("1234")
                .email("sinsa@gmail.com")
                .createdAt(LocalDateTime.now())
                .enabled(true)
                .build();


        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(honggd);
            entityManager.persist(sinsa);
            transaction.commit();

            /*
            select
                tbl.next_val
            from
                tbl_sequence tbl
            where
                tbl.table_name=? for update

            update
                tbl_sequence
            set
                next_val=?
            where
                next_val=?
                and table_name=?

            select
                tbl.next_val
            from
                tbl_sequence tbl
            where
                tbl.table_name=? for update

            update
                tbl_sequence
            set
                next_val=?
            where
                next_val=?
                and table_name=?

            insert
            into
                tbl_member0302
                (member_createdAt, member_email, member_endabled, member_id, member_password, member_code)
            values
                (?, ?, ?, ?, ?, ?)

            insert
            into
                tbl_member0302
                (member_createdAt, member_email, member_endabled, member_id, member_password, member_code)
            values
                (?, ?, ?, ?, ?, ?)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        System.out.println(honggd); // Member(code=1, id=honggd, password=1234, name=null, email=honggd@gmail.com, createdAt=2024-07-04T12:24:29.454430400, enabled=true)
        System.out.println(sinsa); // Member(code=1, id=honggd, password=1234, name=null, email=honggd@gmail.com, createdAt=2024-07-04T12:24:29.454430400, enabled=true)

        // then
        assertThat(honggd.getCode()).isNotNull().isNotZero();
        assertThat(sinsa.getCode()).isNotNull().isNotZero();
    }
}
