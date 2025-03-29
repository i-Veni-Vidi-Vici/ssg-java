package com.sh.app._03.primary.key._02.table.strategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberEntityPrimaryKeyTableStrategyTest {
    // application-scope : 1개만 만들어서 재사용(thread - safe)
    private static EntityManagerFactory entityManagerFactory;

    // request - scope : 웹 요청마다 1개씩 생성(non-thread-safe)
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        // jpa 설정 정볼르 읽어서 EntityManagerFactory를 생성
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    // 각 테스트 전
    @BeforeEach
    void setUp() {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    // 각 테스트 후
    @AfterEach
    void tearDown() {
        this.entityManager.close();
    }

    @AfterAll
    static void afterAll() {
        entityManagerFactory.close(); // 자원 반납
    }

    @Test
    @DisplayName("ddl - auto = create 설정")
    void test1() {
        /**
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

         create table tbl_sequence ( // seauencetable로 테이블 여러개를 관리함
             next_val bigint, // 그 식별자를 여기서 관리하게 됨
            table_name varchar(255) not null, // autoincrement가 아니라 table 식별자가 들어가게 됨
             primary key (table_name)
         ) engine=InnoDB

         insert into tbl_sequence(no, next_val) values ('tbl_member0302',0)
         **/

    }

    @Test
    @DisplayName("Member Entity객체 등록")
    void test2() {
        // given
        Member honggd = Member.builder()
                            .id("honggd")
                            .password("1234")
                            .email("honggd@gmail.com")
                            .createdAt(LocalDateTime.now())
                            .enabled(true)
                            .build(); //

        Member sinsa = Member.builder()
                .id("sinsa")
                .password("1234")
                .email("sinsa@gmail.com")
                .createdAt(LocalDateTime.now())
                .enabled(true)
                .build(); //

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(honggd);
//            entityManager.persist(sinsa);
            transaction.commit();

            /**
             *    ✨번호 가져오기
             *      select
             *         tbl.next_val
             *     from
             *         tbl_sequence tbl
             *     where
             *         tbl.table_name=? for update
             *
             *   ✨번호 사용
             *     update
             *         tbl_sequence
             *     set
             *         next_val=?
             *     where
             *         next_val=?
             *         and table_name=?
             *
             *  ✨번호 가져오기
             *     select
             *         tbl.next_val
             *     from
             *         tbl_sequence tbl
             *     where
             *         tbl.table_name=? for update
             *
             *  ✨번호 사용
             *     update
             *         tbl_sequence
             *     set
             *         next_val=?
             *     where
             *         next_val=?
             *         and table_name=?
             *
             *     insert
             *     into
             *         tbl_member0302
             *         (member_created_at, member_email, member_enabled, member_id, member_name, member_password, member_code)
             *     values
             *         (?, ?, ?, ?, ?, ?, ?)
             * Hibernate:
             *     insert
             *     into
             *         tbl_member0302
             *         (member_created_at, member_email, member_enabled, member_id, member_name, member_password, member_code)
             *     values
             *         (?, ?, ?, ?, ?, ?, ?)
             * Member(code=1, id=honggd, password=1234, name=null, email=honggd@gmail.com, createdAt=2024-07-04T12:37:48.643379200, enabled=true)
             * Member(code=2, id=sinsa, password=1234, name=null, email=sinsa@gmail.com, createdAt=2024-07-04T12:37:48.643379200, enabled=true)
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
