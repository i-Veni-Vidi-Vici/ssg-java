package com.sh.app._03.element.collection._02.list._01.question;


import com.sh.app._03.element.collection._01.set._01.auth.Role;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionEntityTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
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
        /*
            create table tbl_question (
                id bigint not null auto_increment,
                text varchar(255),
                primary key (id)
            ) engine=InnoDB

            create table tbl_question_choice (
                idx integer not null,
                queston_id bigint not null,
                text varchar(255),
                primary key (idx, queston_id)
            ) engine=InnoDB

            alter table tbl_question_choice
               add constraint FKqgcnocl60bnrd80hwwvieph9p
               foreign key (queston_id)
               references tbl_question (id)
         */
    }

    @Test
    @DisplayName("Question 등록")
    void test2() {
        // given
        String text = "다음 중 SQL의 종류가 아닌 것을 고르세요.";
        List<String> choices = List.of("DQL", "DML", "DCL", "DHL");
        Question question = new Question(null, text, choices);

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(question);
            transaction.commit();
            /*
                insert
                into
                    tbl_question
                    (text)
                values
                    (?)
            Hibernate:
                insert
                into
                    tbl_question_choice
                    (queston_id, idx, text)
                values
                    (?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_question_choice
                    (queston_id, idx, text)
                values
                    (?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_question_choice
                    (queston_id, idx, text)
                values
                    (?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_question_choice
                    (queston_id, idx, text)
                values
                    (?, ?, ?)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        System.out.println(question);

        // then
        assertThat(question.getId()).isNotNull();
    }

    @Test
    @DisplayName("Question객체 가져와서 수정하기")
    void test3() {
        // given
        String text = "신호등 색깔이 아닌것은.";
        List<String> choices = List.of("초록색", "빨강색", "주황색", "회색");
        Question question = new Question(null, text, choices);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(question);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        System.out.println(question);

        // when
        entityManager.clear(); // 영속성에 담겨있어서 select 안날라가니까 보려고 지움
        Question question2 = entityManager.find(Question.class, question.getId());
        System.out.println(question2);
        /*
        // Question에 @ElementCollection(fetch = FetchType.EAGER)
        // FetchType이 EAGER로 되어 있기 때문에 조인쿼리로 한번에 날라간다.
        // 만약 LAZY로 되어 있으면 두번 나눠서 날라간다.
            select
                q1_0.id,
                c1_0.queston_id,
                c1_0.idx,
                c1_0.text,
                q1_0.text
            from
                tbl_question q1_0
            left join
                tbl_question_choice c1_0
                    on q1_0.id=c1_0.queston_id
            where
                q1_0.id=?
         */
        System.out.println(question);

        List<String> newChoices = List.of("GREEN", "BLUE", "RED", "YELLOW");
        transaction.begin();
        try {
            question2.changeChoices(newChoices);
            transaction.commit();
            /*
            // 수정 시 Update문이 실행되지 않고 Delete 후 다시 insert 하는 흐름
            delete
            from
                tbl_question_choice
            where
                queston_id=?
        Hibernate:
            insert
            into
                tbl_question_choice
                (queston_id, idx, text)
            values
                (?, ?, ?)
        Hibernate:
            insert
            into
                tbl_question_choice
                (queston_id, idx, text)
            values
                (?, ?, ?)
        Hibernate:
            insert
            into
                tbl_question_choice
                (queston_id, idx, text)
            values
                (?, ?, ?)
        Hibernate:
            insert
            into
                tbl_question_choice
                (queston_id, idx, text)
            values
                (?, ?, ?)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        // then
        Question question3 = entityManager.find(Question.class, question.getId());
        assertThat(question3.getChoices()).isEqualTo(newChoices);
    }

}
