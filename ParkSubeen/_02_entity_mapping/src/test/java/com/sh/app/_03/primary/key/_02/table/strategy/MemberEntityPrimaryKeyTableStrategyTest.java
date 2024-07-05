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
        // 컬럼순서는 abc순으로 생성
        /*
            drop table if exists tbl_sequence
            drop table if exists tbl_member0302
            create table tbl_member0302 (
                member_enabled bit,
                member_code bigint not null,
                member_created_at datetime(6),
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
            alter table tbl_member0302
            add constraint UK7sh8kciw1x8ett0cnxcjyfgvv unique (member_email)
         */
    }

    @Test
    @DisplayName("Member Entity객체 등록")
    void test2() {
        // given
        // 빌더패턴 적용 (디자인패턴 - 생성)
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
                Hibernate:
                    select
                        tbl.next_val
                    from
                        tbl_sequence tbl
                    where
                        tbl.table_name=? for update
                Hibernate:
                    update
                        tbl_sequence
                    set
                        next_val=?
                    where
                        next_val=?
                        and table_name=?
                Hibernate:
                    select
                        tbl.next_val
                    from
                        tbl_sequence tbl
                    where
                        tbl.table_name=? for update
                Hibernate:
                    update
                        tbl_sequence
                    set
                        next_val=?
                    where
                        next_val=?
                        and table_name=?
                Hibernate:
                    insert
                    into
                        tbl_member0302
                        (member_created_at, member_email, member_enabled, member_id, member_name, member_password, member_code)
                    values
                        (?, ?, ?, ?, ?, ?, ?)
                Hibernate:
                    insert
                    into
                        tbl_member0302
                        (member_created_at, member_email, member_enabled, member_id, member_name, member_password, member_code)
                    values
                        (?, ?, ?, ?, ?, ?, ?)
                Member(code=1, id=honggd, password=1234, name=null, email=honggd@gmail.com, createdAt=2024-07-04T12:37:22.443277900, enabled=true)
                Member(code=2, id=sinsa, password=1234, name=null, email=sinsa@gmail.com, createdAt=2024-07-04T12:37:22.443277900, enabled=true)
            */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        System.out.println(honggd);
        System.out.println(sinsa);
        assertThat(honggd.getCode()).isNotNull().isNotZero();
        assertThat(sinsa.getCode()).isNotNull().isNotZero();
    }
}
