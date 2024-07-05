package com.sh.app._01.sns.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.io.Writer;
import java.time.LocalDate;
import java.util.Locale;
import java.util.TimeZone;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberEntityTest {
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
    @DisplayName("ddl-auto=create 확인")
    void test() {
    }

    @Test
    @DisplayName("Writer Entity 등록")
    void test2() {
        Member member = new Member(
                "jeongyj",
                new Account("찐굴", "jjingul@gmail.com", "1234", "image.jpg", null, null, AccountStatus.활성),
                new Profile("정예진", LocalDate.of(2000,03,11), Gender.Female, "01082545898", "서울시동작구", "@instagram", "환영합니당..."),
                new SNS(20, 100, 2, 3, 1, 2),
                new Settings(true, true, Locale.KOREA, TimeZone.getTimeZone("ko"), true)
        );

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            entityManager.persist(member); // 세개의 테이블에 각각 인서트해주는 걸 JPA가 해준다!
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        assertThat(member.getId()).isNotNull();

        entityManager.detach(member);
        Member member2 = entityManager.find(Member.class, member.getId());
        assertThat(member2).isNotNull();
        // 여러 테이블에서 조회를 실행하는 것보다 조인을 하는 게 DB 트래픽을 줄이는 데 도움이 된다.

    }
}
