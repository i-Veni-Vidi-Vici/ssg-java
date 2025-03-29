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
    @DisplayName("ddl-auto = create 설정")
    void test1() {
        // 테이블이 생성되었나요?
        /**
         * Hibernate:
         *     drop table if exists tbl_member01
         * Hibernate:
         *     drop table if exists tbl_member02
         * Hibernate:
         *     drop table if exists tbl_member0301
         * Hibernate:
         *     drop table if exists tbl_member0302
         * Hibernate:
         *     drop table if exists tbl_sequence
         * Hibernate:
         *     create table tbl_member01 (
         *         member_enabled bit,
         *         member_created_At datetime(6),
         *         member_id varchar(255) not null,
         *         member_name varchar(255),
         *         member_password varchar(255),
         *         primary key (member_id)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_member02 (
         *         member_enabled bit,
         *         member_created_At datetime(6),
         *         member_password varchar(20) not null,
         *         member_email varchar(255),
         *         member_id varchar(255) not null,
         *         member_name varchar(100) default '홍길동' not null,
         *         primary key (member_id)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_member0301 (
         *         member_enabled bit,
         *         member_code bigint not null auto_increment, (<- auto_increment가 추가)
         *         member_created_At datetime(6),
         *         member_password varchar(20) not null,
         *         member_email varchar(255),
         *         member_id varchar(255),
         *         member_name varchar(100) default '홍길동',
         *         primary key (member_code)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_member0302 (
         *         member_enabled bit,
         *         member_code bigint not null,
         *         member_created_At datetime(6),
         *         member_password varchar(20) not null,
         *         member_email varchar(255),
         *         member_id varchar(255),
         *         member_name varchar(100) default '홍길동',
         *         primary key (member_code)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_sequence (
         *         next_val bigint,
         *         table_name varchar(255) not null,
         *         primary key (no)
         *     ) engine=InnoDB
         * Hibernate:
         *     insert into tbl_sequence(table_name, next_val) values ('tbl_member0302',0)
         * Hibernate:
         *     alter table tbl_member02
         *        add constraint UKps06eg11othmdnvtj50nbvqmc unique (member_email)
         *        <UKps06eg11othmdnvtj50nbvqmc - 임의로 붙여진 제약조건명>
         * Hibernate:
         *     alter table tbl_member0301
         *        add constraint UK7sh8kciw1x8ett0cnxcjyfgvv unique (member_email)
         * Hibernate:
         *     alter table tbl_member0302
         *        add constraint UK7sh8kciw1x8ett0cnxcjyfgvv unique (member_email)
         */
    }

    @Test
    @DisplayName("Member Entity객체 등록")
    void test2() {
        // given
//        Member member = new Member();
//        member.setId("honggd");
//        member.setPassword("1234");
////        member.setName("홍길동"); // 아예 쓰지 않거나
//        member.setName(null); // null을 쓰면 default값으로 들어간다
//        member.setEmail("honggd@gmail.com");
//        member.setCreatedAt(LocalDateTime.now());
//        member.setEnabled(true);

        Member honggd = Member.builder()
                .id("honggd")
                .password("1234")
                .email("honggd@email.com")
                .createdAt(LocalDateTime.now())
                .enabled(true)
                .build();
        Member sinsa = Member.builder()
                .id("sinsa")
                .password("1234")
                .email("sinsa@email.com")
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
            /**
             * Hibernate:
             *     select
             *         tbl.next_val
             *     from
             *         tbl_sequence tbl
             *     where
             *         tbl.table_name=? for update
             * Hibernate:
             *     update
             *         tbl_sequence
             *     set
             *         next_val=?
             *     where
             *         next_val=?
             *         and table_name=?
             * Hibernate:
             *     select
             *         tbl.next_val
             *     from
             *         tbl_sequence tbl
             *     where
             *         tbl.table_name=? for update
             * Hibernate:
             *     update
             *         tbl_sequence
             *     set
             *         next_val=?
             *     where
             *         next_val=?
             *         and table_name=?
             * Hibernate:
             *     insert
             *     into
             *         tbl_member0302
             *         (member_created_At, member_email, member_enabled, member_id, member_name, member_password, member_code)
             *     values
             *         (?, ?, ?, ?, ?, ?, ?)
             * Hibernate:
             *     insert
             *     into
             *         tbl_member0302
             *         (member_created_At, member_email, member_enabled, member_id, member_name, member_password, member_code)
             *     values
             *         (?, ?, ?, ?, ?, ?, ?)
             * Member(code=1, id=honggd, password=1234, name=null, email=honggd@email.com, createdAt=2024-07-04T12:38:37.295468700, enabled=true)
             * Member(code=2, id=sinsa, password=1234, name=null, email=sinsa@email.com, createdAt=2024-07-04T12:38:37.295468700, enabled=true)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        System.out.println(honggd);
        System.out.println(sinsa);
        // then
        assertThat(honggd.getCode()).isNotNull().isNotZero();
        assertThat(sinsa.getCode()).isNotNull().isNotZero();
    }
}
