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
        /*
        tbl_vote테이블에서 person_id컬럼을 PK로 사용한다.
        FK 제약조건은 별도로 생성되지 않았다. (App 코드로써 참조관계를 관리하게 된다.)
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
        // given
        Person person = new Person(null, "홍길동");
        this.entityManager.persist(person); // GenerationType.IDENTITY 지정했으로, persist시점에 곧바로 insert 쿼리가 DB로 전송됨
        /* 
            insert 
            into
                tbl_person
                (name) 
            values
                (?)
         */
        assertThat(person.getId()).isNotZero();

        // when
        Vote vote = new Vote(person, "유재석");
        this.entityManager.persist(vote);
        this.entityManager.flush();
        /*
            insert
            into
                tbl_vote
                (candidate_name, person_id)
            values
                (?, ?)
         */

        // then
        this.entityManager.clear();
        Vote vote2 = this.entityManager.find(Vote.class, vote.getPersonId());
        /*
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
        System.out.println(vote2); // Vote(personId=1, person=Person(id=1, name=홍길동), candidateName=유재석)
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
//        assertThatThrownBy(() -> {
//            // 예외가 던져지는 코드 작성
//        }).isInstanceOf(Exception.class);
        assertThatIllegalArgumentException().isThrownBy(() -> { // IllegalArgument예외가 던져질거에요. 괄호 안에 코드에 의해서
           new Vote(person, "강호동");
        });
        assertThatNoException().isThrownBy(() -> { // 이것은 예외를 던지지 않음을 테스트
            new Vote(new Person(123L, "신사임당"), "강호동");
        });

    }

}
