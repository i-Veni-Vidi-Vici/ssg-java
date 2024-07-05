package com.sh.app._05.access._02.property;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberEntityAccessPropertyTest {
    // application scope -> 1개만 만들어서 재사용 (thread-safe)
    private static EntityManagerFactory entityManagerFactory;
    // request scope -> 웹요청마다 1개씩 생성 (non-thread-safe)
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
        entityManagerFactory.close(); // 자원반납
    }

    @Test
    @DisplayName("ddl-auto = create 설정")
    void test1() {
        // 테이블이 생성되었나요?
    }

    @Test
    @DisplayName("Member Entity 객체 등록")
    void test2() {
        // given
        // 빌더패턴 적용 (디자인패턴 중 생성패턴)
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
        try{
            entityManager.persist(member);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        System.out.println(member);
        // then
        assertThat(member.getCode()).isNotNull().isNotZero();
    }
}