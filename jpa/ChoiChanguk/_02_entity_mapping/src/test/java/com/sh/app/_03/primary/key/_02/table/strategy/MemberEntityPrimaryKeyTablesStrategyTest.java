package com.sh.app._03.primary.key._02.table.strategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberEntityPrimaryKeyTablesStrategyTest {
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
        // 컬럼순서는 abc순서로 생성
        /*
                        Hibernate:
            create table tbl_member0301 (
                member_enabled bit,
                member_code bigint not null auto_increment,
                member_create_at datetime(6),
                member_password varchar(20) not null,
                member_email varchar(255),
                member_id varchar(255),
                member_name varchar(100) default '홍길동' not null,
                primary key (member_code)
            ) engine=InnoDB
        Hibernate:
            create table tbl_member0302 (
                member_enabled bit,
                member_code bigint not null,
                member_create_at datetime(6),
                member_password varchar(20) not null,
                member_email varchar(255),
                member_id varchar(255),
                member_name varchar(100) default '홍길동' not null,
                primary key (member_code)
            ) engine=InnoDB
        Hibernate:
            create table tbl_sequence (
                next_val bigint,
                table_name varchar(255) not null,
                primary key (table_name)
            ) engine=InnoDB
        Hibernate:
            insert into tbl_sequence(table_name, next_val) values ('tbl_member0302',0)
         */
    }

    @Test
    @DisplayName("Member Entity객체 등록")
    void test2() {
        //given

        Member honggd = Member.builder()
                .id("honggd")
                .password("1234")
                .email("honggd@naver.com")
                .createAt(LocalDateTime.now())
                .enabled(true)
                .build();

        Member sinsa = Member.builder()
                .id("sinsa")
                .password("1234")
                .email("sinsa@naver.com")
                .createAt(LocalDateTime.now())
                .enabled(true)
                .build();

        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();

        try{
            entityManager.persist(honggd); //
            entityManager.persist(sinsa); //
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
             */
        }catch (Exception e)
        {
            transaction.rollback();
            e.printStackTrace();
        }

        System.out.println("honggd = " + honggd);
        System.out.println("sinsa = " + sinsa);

        assertThat(honggd.getCode()).isNotNull();
        assertThat(sinsa.getCode()).isNotNull();
    }

}
