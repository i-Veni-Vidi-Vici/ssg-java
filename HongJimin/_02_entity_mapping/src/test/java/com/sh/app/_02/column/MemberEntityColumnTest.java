package com.sh.app._02.column;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberEntityColumnTest {
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
        // 테이블이 생성되었나요?
        // 컬럼순서는 abc순으로 생성
        /**
             drop table if exists tbl_member02

             create table tbl_member02 (
                 member_enabled bit,
                 member_created_at datetime(6),
                 member_password varchar(20) not null,
                 member_email varchar(255),
                 member_id varchar(255) not null,
                 member_name varchar(100) default '홍길동' not null,
                 primary key (member_id)
             ) engine=InnoDB

             alter table tbl_member02
             add constraint UKps06eg11othmdnvtj50nbvqmc unique (member_email)
        **/

    }

    @Test
    @DisplayName("Member Entity객체 등록")
    void test2() {
        // given
        // 빌더 패턴 적용(디자인패턴 - 생성)
        // Builder 패턴의 장점 : 순서를 지키지 않아도 됨!, 값을 빼먹어도 됨
        // ✨Member 객체 잘 만들었따~
        Member member = Member.builder()
                            .id("honggd")
                            .password("1234")
                            .email("honggd@gmail.com")
                            .createdAt(LocalDateTime.now())
                            .enabled(true)
                            .build(); //

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(member);
            transaction.commit();
            /**
             *  insert
             *     into
             *         tbl_member02
             *         (member_created_at, member_email, member_enabled, member_name, member_password, member_id)
             *     values
             *         (?, ?, ?, ?, ?, ?)
             *
             * @DynamicInsert 사용시, memberName 필드는 null이라서 제외되었다.
             *
             * insert
             *     into
             *         tbl_member02
             *         (member_created_at, member_email, member_enabled, member_password, member_id)
             *     values
             *         (?, ?, ?, ?, ?)
             *
             */

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        // then
        Member member2 = entityManager.find(Member.class, member.getId());
        assertThat(member2).isNotNull();
    }
}
