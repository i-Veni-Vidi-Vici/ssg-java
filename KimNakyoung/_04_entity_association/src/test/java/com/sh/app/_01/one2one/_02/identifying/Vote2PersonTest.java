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
    void test1() {
        //given
        Person person = new Person(null,"홍길동");
        this.entityManager.persist(person); // GenerationType.IDENTITY
        assertThat(person.getId()).isNotZero();

        Vote vote = new Vote(person, "유재석");
        this.entityManager.persist(vote);
        this.entityManager.flush();

        //when

        //then
        this.entityManager.clear(); // 영속성 비웠음 조회하면 select 날리는지 볼려고
        Vote vote2 = this.entityManager.find(Vote.class, vote.getPersonId());
        System.out.println(vote2);
        assertThat(vote2).isNotNull();
        assertThat(vote2.getPersonId()).isNotNull();

    }


    @Test
    @DisplayName("식별자 없는 Vote객체 생성을 시도하면, 예외를 던진다.")
    void test3() {
        //given
        Person person = null;
        //when
        //then


//        assertThatThrownBy(() -> {}).isInstanceOf(Exception.class);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Vote(person, "강호동");
        });
        assertThatNoException().isThrownBy(() -> {
            new Vote(new Person(123L,"신사임당"), "강호동");
        });
    }

}
