package com.sh.app._05.access._02.property;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberEntityAccessPropertyTest {
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
            drop table if exists tbl_member0502
            create table tbl_member0502 (
                enabled bit not null,
                code bigint,
                createdAt datetime(6),
                memberCode bigint not null auto_increment,
                email varchar(255),
                id varchar(255),
                name varchar(255),
                password varchar(255),
                primary key (memberCode)
            ) engine=InnoDB
         */
    }

    @Test
    @DisplayName("Member Entity객체 등록")
    void test2() {
        // given
        // 빌더패턴 적용 (디자인패턴 - 생성)
        Member member = Member.builder()
                            .id("honggd")
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
            /*
                Hibernate:
                    insert
                    into
                        tbl_member0502
                        (member_created_at, member_email, member_enabled, member_id, member_name, member_password)
                    values
                        (?, ?, ?, ?, ?, ?)
                Member(code=1, id=honggd, password=1234, name=null, email=honggd@gmail.com, createdAt=2024-07-04T14:48:54.530436400, enabled=true)
            */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        System.out.println(member);
        assertThat(member.getCode()).isNotNull().isNotZero();
    }
}
