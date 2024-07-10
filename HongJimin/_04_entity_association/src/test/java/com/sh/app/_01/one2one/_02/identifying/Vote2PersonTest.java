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
        this.entityManager.getTransaction().begin();
    }

    @AfterEach
    void tearDown() {
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @AfterAll
    static void afterAll() {
        entityManagerFactory.close();
    }

    @Test
    @DisplayName("ddl-auto=create 확인")
    void test() {
        /**
         * ✨tbl_vote에서 person_id 컬럼을 PK로 사용한다.
         * FK 제약조건은 별도로 생성되지 않음 -> (앱 코드로써 참조관계를 관리하게 된다.)
         *
         * Hibernate:
         *     create table tbl_person (
         *         ✨id bigint not null auto_increment,
         *         name varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         *
         * Hibernate:
         *     create table tbl_vote (
         *         ✨person_id bigint not null,
         *         candidate_name varchar(255) not null,
         *         primary key (person_id)
         *     ) engine=InnoDB
         */
    }

    @Test
    @DisplayName("Vote - Person 등록")
    void test2() {
        // given 🙉홍길동 먼저 등록
        Person person = new Person(null, "홍길동");
        this.entityManager.persist(person); // GenerationType.IDENTITY로 지정했으므로, 바로 INSERT쿼리 날라감(auto-increment 때문에)
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_person
         *         (name)
         *     values
         *         (?)
         */
        assertThat(person.getId()).isNotZero();

        // when 🙉홍길동이 유재석 뽑음
        Vote vote = new Vote(person, "유재석"); // person객체와 뽑은 후보를 넣어줌, PERSON이 null이 아닌지 체크하고, person도 꺼내고, person_id도 꺼내옴
        this.entityManager.persist(vote);
        this.entityManager.flush();
        /**
         *     insert
         *     into
         *         tbl_vote
         *         (candidate_name, 🙉person_id) 🙉person_id가 날라감
         *     values
         *         (?, ?)
         */


        // then
        this.entityManager.clear(); // 🙉영속성 컨텍스트 비움
        Vote vote2 = this.entityManager.find(Vote.class, vote.getPersonId()); // 🙉vote를 조회할 때, person을 무조건 조회해야 함
        /**
         * 🙉조인쿼리 꺄를🙉
         * select
         *         v1_0.person_id,
         *         v1_0.candidate_name,
         *         p1_0.id,
         *         p1_0.name
         *     from
         *         tbl_vote v1_0
         *     left join
         *         tbl_person p1_0
         *             on p1_0.id=v1_0.person_id
         *     where
         *         v1_0.person_id=?
         */
        System.out.println(vote2); // Vote(personId=1, person=Person(id=1, name=홍길동), candidateName=유재석)
        assertThat(vote2).isNotNull();
        assertThat(vote2.getPerson()).isNotNull();
    }

    @Test
    @DisplayName("식별자 없는 Vote 객체 생성을 시도하면, 예외를 던져요🙉")
    void test3() {
        // given
        Person person = null;

        // when

        // then
//        assertThatThrownBy(() -> {
//            // 🙉 {}안에 오류가 던져질만한 코드를 넣으면 됨! 이거를 밑에처럼 써도됨
//        }).isInstanceOf(Exception.class);
        assertThatIllegalArgumentException().isThrownBy(() -> { // 이런 코드르 실행하면 exception이 던져질거다 -> 예외가 안던져지거나, IllegalArgumentException이 아닌 다른 예외가 던져지면 실패!
            new Vote(person, "강호동");
        });
        assertThatNoException().isThrownBy(() -> {
            new Vote(new Person(123L, "신사임당"),"강호동");
        }); // 이렇게 하면 예외가 안던져져요~
    }
}
