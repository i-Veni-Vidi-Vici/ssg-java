package com.sh.app._02.column;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


public class MemberEntityColumnTest {
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
        // 테이블이 생성 되었나요?
        //z- 컬럼 순서는 abc 순으로 생성


        /**
         * Hibernate:
         *     drop table if exists tbl_member01
         * 7월 04, 2024 11:00:08 오전 org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
         * INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@aa752bb] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
         * Hibernate:
         *     create table tbl_member01 (
         *         member_enabled bit,
         *         member_created_at datetime(6),
         *         member_id varchar(255) not null,
         *         member_name varchar(255),
         *         member_password varchar(255),
         *         primary key (member_id)
         *     ) engine=InnoDB
         */
        // given
        // when
        // then
    }

    @Test
    @DisplayName("Member Entity 객체 등록")
    void test2() {

        //Hibernate:
        //    insert
        //    into
        //        tbl_member01
        //        (member_created_at, member_enabled, member_name, member_password, member_id)
        //    values
        //        (?, ?, ?, ?, ?)

        //    insert
        //    into
        //        tbl_member02
        //        (member_created_at, member_enabled, member_password, member_id)
        //    values
        //        (?, ?, ?, ?)
        // given
//        Member member = new Member();
//        member.setId("honggd");
//        member.setPassword("1234");
////        member.setName("홍길동");
//        member.setCreatedAt(LocalDateTime.now());
//        member.setEnabled(true);
        //given
        // 빌더패턴을 적용
        Member member = Member.builder()
                .id("hoggd")
                .password("1234")
                .email("honggd@gmail.com")
                .createdAt(LocalDateTime.now())
                .enabled(true)
                .build();
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(member);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        Member member2 = entityManager.find(Member.class, member.getId());
        assertThat(member2).isNotNull();
    }
}
