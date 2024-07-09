package com.sh.app._05_access._01.field;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


public class MemberEntityPrimaryKeyIdentityStrategyTest {
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
         *Hibernate:
         *     create table tbl_member0301 (
         *         member_enabled bit,
         *         member_code bigint not null auto_increment,
         *         member_created_at datetime(6),
         *         member_password varchar(20) not null,
         *         member_email varchar(255),
         *         member_id varchar(255),
         *         member_name varchar(100) default '홍길동',
         *         primary key (member_code)
         *     ) engine=InnoDB
         */
        // given
        // when
        // then
    }

    @Test
    @DisplayName("Member Entity 객체 등록")
    void test2() {

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
        System.out.println(member);
        //pk 컬럼값이 정상적으로 잘 적용이 되었는가를 확인
        assertThat(member.getCode()).isNotNull().isNotZero();
    }
}
