package com.sh.app._03.primary.key._01.identity.strategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberEntityPrimaryKeyIdentityStrategy {
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
            alter table tbl_member02
            add constraint UKps06eg11othmdnvtj50nbvqmc unique (member_email)
        Hibernate:
            alter table tbl_member0301
            add constraint UK1dp8som30bwbf99s3q065yy0k unique (member_email) Hibernate:
        create table tbl_member01 (
        member_enabled bit,
        member_created_at datetime(6),
        member_id varchar(255) not null,
        member_name varchar(255),
        member_password varchar(255),
        primary key (member_id)
    ) engine=InnoDB
         */
    }

    @Test
    @DisplayName("Member Entity객체 등록")
    void test2() {
        //given
//        Member member=new Member();
//        member.setId("honggd");
//        member.setPassword("1234");
//        member.setName("홍길동");
//        member.setCreatedAt(LocalDateTime.now());
//        member.setEnabled(true);

        Member member = Member.builder()
                .id("cstangga")
                .password("1234")
                .email("cstangga@naver.com")
                .name("최창욱")
                .createAt(LocalDateTime.now())
                .enabled(true)
                .build();

        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();

        try{
            entityManager.persist(member); //
            transaction.commit();
            /*
            Hibernate:
                insert
                into
                     tbl_member01
                    (member_created_at, member_enabled, member_name, member_password, member_id)
                values
                    (?, ?, ?, ?, ?)
             */
        }catch (Exception e)
        {
            transaction.rollback();
            e.printStackTrace();
        }

        //then
        System.out.println("member = " + member);
        assertThat(member.getCode()).isNotNull().isNotZero();
//        Member member2=entityManager.find(Member.class,member.getId());
//        assertThat(member2).isNotNull();
    }

}
