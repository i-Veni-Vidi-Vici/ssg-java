package com.sh.app._04_enum;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


public class MemberEntityEnumTest {
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

        /**
         *    create table tbl_member0302 (
         *         member_enabled bit,
         *         member_code bigint not null,
         *         member_created_at datetime(6),
         *         member_password varchar(20) not null,
         *         member_email varchar(255),
         *         member_id varchar(255),
         *         member_name varchar(100) default '홍길동',
         *         primary key (member_code)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_sequence (
         *         next_val bigint,
         *         no varchar(255) not null,
         *         primary key (no)
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
        //    create table tbl_member04 (
        //        member_enabled bit,
        //        member_gender tinyint check (member_gender between 0 and 1),
        //        member_code bigint not null,
        //        member_created_at datetime(6),
        //        member_password varchar(20) not null,
        //        member_email varchar(255),
        //        member_id varchar(255),
        //        member_name varchar(100) default '홍길동',
        //        member_role enum ('ROLE_ADMIN','ROLE_MEMBER'),
        //        primary key (member_code)
        //    ) engine=InnoDB
        //Hibernate:
        //    create table tbl_sequence (
        //        next_val bigint,
        //        table_name varchar(255) not null,
        //        primary key (table_name)
        //    ) engine=InnoDB

        //given
        // 빌더패턴을 적용
        Member hoggd = Member.builder()
                .id("hoggd")
                .password("1234")
                .name("홍길동")
                .gender(Gender.MALE)
                .memberRole(MemberRole.ROLE_MEMBER)
                .email("honggd@gmail.com")
                .createdAt(LocalDateTime.now())
                .enabled(true)
                .build();

        Member sinsa = Member.builder()
                .id("sinsa")
                .password("1234")
                .name("신사임당")
                .gender(Gender.FEMALE)
                .memberRole(MemberRole.ROLE_ADMIN)
                .email("sinsa@gmail.com")
                .createdAt(LocalDateTime.now())
                .enabled(true)
                .build();
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(hoggd);
            entityManager.persist(sinsa);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }


        // then
        System.out.println(hoggd);
        System.out.println(sinsa);
        //pk 컬럼값이 정상적으로 잘 적용이 되었는가를 확인
        assertThat(hoggd.getCode()).isNotNull().isNotZero();
        assertThat(sinsa.getCode()).isNotNull().isNotZero();
    }
}
