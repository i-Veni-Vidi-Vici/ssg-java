package com.sh.app._01.one2one._02.identifying;

import com.sh.app._01.one2one._01.non.identifying.MembershipCard;
import com.sh.app._01.one2one._01.non.identifying.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.YearMonth;

import static org.assertj.core.api.Assertions.*;


public class Vote2PersonTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    void setUp() {
        this.entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin(); // 트랜잭션 처리를 한 번에 처리할 수 있다.
    }

    @AfterEach
    void tearDown() {
        this.entityManager.close();
        entityManager.getTransaction().commit();
    }

    @AfterAll
    static void afterAll() {
        entityManagerFactory.close();
    }

    @Test
    @DisplayName("ddl-auto=create 확인")
    void test1() {
        /*
        tbl_vote테이블에서 person_id컬럼을 PK로 사용한다.
        FK 제약조건은 별로 생성되지 않았다. (Application의 코드로써 참조관계를 관리하게 된다)
        Hibernate:
        create table tbl_person (
            id bigint not null auto_increment,
            name varchar(255),
            primary key (id)
        ) engine=InnoDB

        Hibernate:
        create table tbl_vote (
            person_id bigint not null,
            candidate_name varchar(255) not null,
            primary key (person_id)
        ) engine=InnoDB
         */
    }

    @Test
    @DisplayName("Vote-Person 등록")
    void test2() {
        // given 홍길동 먼저 등록
        Person person = new Person(null, "홍길동");
        this.entityManager.persist(person); // GenerationType.IDENTITY지정했으므로, 바로 insert 질의
        // 이때 바로 쿼리가 나올 것이다.
        /*
            insert
            into
                tbl_person
                (name)
            values
                (?)
         */
        assertThat(person.getId()).isNotZero();

        // when 홍길동이 유재석 뽑음
        Vote vote = new Vote(person, "유재석");
        this.entityManager.persist(vote);
        this.entityManager.flush(); // 실제 쿼리 나올 수 있도록 flush사용
        /*
            insert
            into
                tbl_vote
                (candidate_name, person_id) // pk이기 때문에 person_id가 나온다.
            values
                (?, ?)
         */

        // then
        this.entityManager.clear();
        Vote vote2 = this.entityManager.find(Vote.class, vote.getPersonId()); // vote를 조회할 때 무조건 person을 조회해야한다. pk이기 때문
        /*
        Hibernate:
            select
                v1_0.person_id,
                v1_0.candidate_name,
                p1_0.id,
                p1_0.name
            from
                tbl_vote v1_0
            left join
                tbl_person p1_0
                    on p1_0.id=v1_0.person_id
            where
                v1_0.person_id=?
         */
        System.out.println(vote2);
        assertThat(vote2).isNotNull();
        assertThat(vote2.getPerson()).isNotNull();
    }

    @Test
    @DisplayName("식별자 없는 Vote객체 생성을 시도하면, 예외를 던진다.")
    void test3() {
        // given
        Person person = null;
        // when
        // then
//        assertThatThrownBy(() -> {예외(오류)가 던져지는 코드 작성}).isInstanceOf(Exception.class); // 예외처리할 때 제일 많이 사용하는 코드
        assertThatIllegalArgumentException().isThrownBy(() -> { // 예외가 던져지지 않으면 테스트 실패이다.
           new Vote(person, "강호동");
        });
        assertThatNoException().isThrownBy(() -> { // 이거는 예외를 안 던집니다라는 의미를 가진 코드 식
            new Vote(new Person(123L, "신사임당"), "강호동");
        });
    }
}
