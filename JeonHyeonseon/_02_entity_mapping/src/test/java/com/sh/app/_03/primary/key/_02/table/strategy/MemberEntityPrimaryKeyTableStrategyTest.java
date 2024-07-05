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

    // 크게 한 번만 실행
    @BeforeAll
    static void beforeAll() {
        // jpa 설정 정보를 읽어서 EntityManagerFactory를 생성
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    // 각 테스트의 앞서서 한번
    @BeforeEach
    void setUp() {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    // 각 테스트의 끝에 한 번
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
        // 컬럼순서는 abc순으로 생성된다.
        /*
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

            // 별도로 빼는 이유 : 테이블 여러개를 관리하기 위해서
            create table tbl_sequence (
                next_val bigint, // 그에 맞는 값이 next_val에 들어간다. Member클래스에서 읽어보기
                table_name varchar(255) not null, // 테이블 식별자가 여기에 들어간다.
                primary key (table_name)
            ) engine=InnoDB

            insert into tbl_sequence(table_name, next_val) values ('tbl_member0302',0)
        */
    }

    @Test
    @DisplayName("Member Entity객체 등록")
    void test2() {
        // given
        // 빌더 패턴 적용 (디자인 패턴 - 생성)
        // 순서도 마음대로, 빼는 것도 마음대로 할 수 있다.
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
           -----------------------------------------
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
            -----------------------------------------
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
        System.out.println(honggd);
        System.out.println(sinsa);
        // then
        assertThat(honggd.getCode()).isNotNull().isNotZero();
        assertThat(sinsa.getCode()).isNotNull().isNotZero();
    }
}
