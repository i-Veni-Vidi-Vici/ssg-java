package com.sh.app._02.column;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.annotations.DynamicInsert;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberEntityColumnTest {
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
        /**
         * Hibernate:
         *     drop table if exists tbl_member01
         * Hibernate:
         *     drop table if exists tbl_member02
         * Hibernate:
         *     create table tbl_member01 (
         *         member_enabled bit,
         *         member_created_At datetime(6),
         *         member_id varchar(255) not null,
         *         member_name varchar(255),
         *         member_password varchar(255),
         *         primary key (member_id)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_member02 (
         *         member_enabled bit,
         *         member_created_At datetime(6),
         *         member_password varchar(20) not null,
         *         member_email varchar(255),
         *         member_id varchar(255) not null,
         *         member_name varchar(100) default '홍길동' not null,
         *         primary key (member_id)
         *     ) engine=InnoDB
         * Hibernate:
         *     alter table tbl_member02
         *        add constraint UKps06eg11othmdnvtj50nbvqmc unique (member_email)
         *        <UKps06eg11othmdnvtj50nbvqmc - 임의로 붙여진 제약조건명>
         */
    }

    @Test
    @DisplayName("Member Entity객체 등록")
    void test2() {
        // given
//        Member member = new Member();
//        member.setId("honggd");
//        member.setPassword("1234");
////        member.setName("홍길동"); // 아예 쓰지 않거나
//        member.setName(null); // null을 쓰면 default값으로 들어간다
//        member.setEmail("honggd@gmail.com");
//        member.setCreatedAt(LocalDateTime.now());
//        member.setEnabled(true);

        Member member = Member.builder()
                .id("honggd")
                .password("1234")
                .email("honggd@email.com")
                .createdAt(LocalDateTime.now())
                .enabled(true)
                .build();

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            entityManager.persist(member);
            transaction.commit();
            /**
             * Hibernate:
             *     insert
             *     into
             *         tbl_member02
             *         (member_created_At, member_email, member_enabled, member_name, member_password, member_id)
             *     values
             *         (?, ?, ?, ?, ?, ?)
             */
//            @DynamicInsert // insert시 값이 null인 필드는 제외한다.
            /**
             * Hibernate:
             *     insert
             *     into
             *         tbl_member02
             *         (member_created_At, member_email, member_enabled, member_password, member_id)
             *     values
             *         (?, ?, ?, ?, ?)
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
