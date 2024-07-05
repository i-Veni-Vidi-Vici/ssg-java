package com.sh.app._02.column;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class MemberEntityColumnTest {

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
        //테이블이 생성되었나요?

        /*

    drop table if exists tbl_member02
    create table tbl_member01 (
        member_enabled bit,
        member_created_at datetime(6),
        member_id varchar(255) not null,
        member_name varchar(255),
        member_password varchar(255),
        primary key (member_id)
    ) engine=InnoDB

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


         */


    }

    @Test
    @DisplayName("Member Entity객체")
    void test2(){
        //given
//        Member member = new Member();
//        member.setId("honggd");
//        member.setName("홍길동");
//        member.setEnabled(true);
//        member.setPassword("1234");
//        member.setCreatedAt(LocalDateTime.now());
        Member member = Member.builder()
                .id("honggd")
                .password("1234")
                .email("honggd@gamil.com")
                .createdAt(LocalDateTime.now())
                .enabled(true)
                .build();
        //when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(member);
            transaction.commit();
            /*
            insert
            into
        tbl_member01
        (member_created_at, member_enabled, member_name, member_password, member_id)
        values
        (?, ?, ?, ?, ?)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        //then
        Member member2 = entityManager.find(Member.class, member.getId()); // 여긴 왜 쿼리가 안날라갈까? 영속성 컨텍스트가 이미 있어서 DB까지 안물어봐도됨
        assertThat(member2).isNotNull();

    }

    // 지금 현재 create로 되어있어서 테스트 할 때 마다 테이블 삭제하고 테이블 삭제하고 다시 만듦 항상 drop 테이블이 먼저임

}