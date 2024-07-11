package com.sh.app._01.one2one._02.identifying;


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
        // FK 제약조건은 별도로 생성되지 않았다. (App 코드로써 참조관계를 관리하게 된다.)
//        Hibernate:
//        create table tbl_person (
//                id bigint not null auto_increment,
//                name varchar(255),
//                primary key (id)
//    ) engine=InnoDB
//        Hibernate:
//        create table tbl_vote (
//                person_id bigint not null,
//                candidate_name varchar(255) not null,
//                primary key (person_id)
//    ) engine=InnoDB
    }

    @Test
    @DisplayName("Vote-Person 등록")
    void test2() {
        //given
        Person person = new Person(null, "홍길동");
        this.entityManager.persist(person); // GenerationType.IDENTITY 지정해서, 바로 insert 질의
        //        Hibernate:
//        insert
//                into
//        tbl_person
//                (name)
//        values
//                (?)
        System.out.println("=========");
        assertThat(person.getId()).isNotZero();

        Vote vote = new Vote(person, "유재석");
        this.entityManager.persist(vote);
        this.entityManager.flush();
//        Hibernate:
//        insert
//                into
//        tbl_vote
//                (candidate_name, person_id)
//        values
//                (?, ?)


        // then
        this.entityManager.clear();
        Vote vote2 = this.entityManager.find(Vote.class, vote.getPersonId());
//        Hibernate:
//        select
//        v1_0.person_id,
//                v1_0.candidate_name,
//                p1_0.id,
//                p1_0.name
//        from
//        tbl_vote v1_0
//        left join
//        tbl_person p1_0
//        on p1_0.id=v1_0.person_id
//        where
//        v1_0.person_id=?
        System.out.println(vote2);
        assertThat(vote2).isNotNull();
        assertThat(vote2.getPerson()).isNotNull();


    }

    @Test
    @DisplayName("식별자 없는 Vote객체를 생성하면 예외 처리")
    void test3() {
        // given
        Person person = null;
        // when
        // then
//        assertThatThrownBy(() -> {}).isInstanceOf(Exception.class);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Vote(person, "강호동");
        });
        assertThatNoException().isThrownBy(()->{
            new Vote(new Person(123L, "신사임당"), "강호동");
        });
    }
}