package com.sh.app._01.one2one._02.identifying;


import com.sh.app._01.one2one._01.non.identifying.MembershipCard;
import com.sh.app._01.one2one._01.non.identifying.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.YearMonth;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

// vote에서 person을 참조한다
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
        tbl_vote테이블에서 person_id컬럼을 PK로 사용한다, 근데 fk지정이 없다
        FK 제약조건은 별도로 생성되지 않았다 = application 코드로써 참조관계를 관리하게된다
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
        Person person = new Person(null, "홍길동");
        this.entityManager.persist(person); // 이때 쿼리는 날라간, auto_increment를 해야하기 때문에
        System.out.println("person = " + person);
        assertThat(person.getId()).isNotNull();

        Vote vote=new Vote(person,"유재석");
        this.entityManager.persist(vote);
        System.out.println("vote = " + vote);

        this.entityManager.flush();

        entityManager.clear(); // select쿼리를 보려고 영속성컨텍스트에서 삭제를 한다
        // 영속성컨텍스트에 등록이 되어있으면 쿼리 안날리고 그냥 그거 쓰면 되니깐

        Vote vote2=this.entityManager.find(Vote.class,vote.getPersonId());
        Person person2=this.entityManager.find(Person.class, person.getId());

        System.out.println("person2 = " + person2);
        System.out.println("vote2 = " + vote2);


    }
    @Test
    @DisplayName("식별자 없는 Vote객체 생성을 시도하면 예외를 던진다")
    void test3() {
        Person person=null;

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Vote(person, "강호동");
        }); // 이건 예외가 안던져지면 테스트 실패다
    }

}

















