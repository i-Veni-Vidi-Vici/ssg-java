package com.sh.app._03.element.collection._02.list._02.question.embeddable;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.List;

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
/**
 * Hibernate:
 *     create table tbl_question0202 (
 *         id bigint not null auto_increment,
 *         text varchar(255),
 *         primary key (id)
 *     ) engine=InnoDB
 * Hibernate:
 *     create table tbl_question_choice (
 *         idx integer not null,
 *         question_id bigint not null,
 *         text varchar(255),
 *         primary key (idx, question_id)
 *     ) engine=InnoDB
 * Hibernate:
 *     create table tbl_question_choice_0202 (
 *         idx integer not null,
 *         question_id bigint not null,
 *         a varchar(255),
 *         b varchar(255),
 *         primary key (idx, question_id)
 *     ) engine=InnoDB
 * Hibernate:
 *     alter table tbl_question_choice
 *        add constraint FKnrcac8c0g5gp794wy85aecfoh
 *        foreign key (question_id)
 *        references tbl_question (id)
 * Hibernate:
 *     alter table tbl_question_choice_0202
 *        add constraint FKbiuq4qubiy11iqim7pi04wcgi
 *        foreign key (question_id)
 *        references tbl_question0202 (id)
 */
    }

    @Test
    @DisplayName("Question 등록")
    void test2() {
        String text = "다음중 과일과 색깔이 잘 매칭된 것을 고르세요.";
        List<Choice> choices = List.of(
                new Choice("사과", "빨간색"),
                new Choice("바나나", "노란색"),
                new Choice("포도", "보라색"),
                new Choice("감귤", "파란색")
        );
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
        assertThat(question.getChoices()).isEqualTo(choices);

        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_question0202
         *         (text)
         *     values
         *         (?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice_0202
         *         (question_id, idx, a, b)
         *     values
         *         (?, ?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice_0202
         *         (question_id, idx, a, b)
         *     values
         *         (?, ?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice_0202
         *         (question_id, idx, a, b)
         *     values
         *         (?, ?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice_0202
         *         (question_id, idx, a, b)
         *     values
         *         (?, ?, ?, ?)
         * Question(id=1, text=다음중 과일과 색깔이 잘 매칭된 것을 고르세요., choices=[Choice(a=사과, b=빨간색), Choice(a=바나나, b=노란색), Choice(a=포도, b=보라색), Choice(a=감귤, b=파란색)])
         */
    }

    @Test
    @DisplayName("Text 객체 가져와서 수정하기")
    void test3() {
        // given
        String text = "음식점과 메뉴의 조합이 올바른 것은??";
        List<Choice> choice = List.of(
                new Choice("맥도날드", "빅맥"),
                new Choice("버거킹", "와퍼"),
                new Choice("롯데리아", "데리버거")
        );
        Question question = new Question(null, text , choice);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(question);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // when
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_question0202
         *         (text)
         *     values
         *         (?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice_0202
         *         (question_id, idx, a, b)
         *     values
         *         (?, ?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice_0202
         *         (question_id, idx, a, b)
         *     values
         *         (?, ?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice_0202
         *         (question_id, idx, a, b)
         *     values
         *         (?, ?, ?, ?)
         * Question(id=2, text=음식점과 메뉴의 조합이 올바른 것은??, choices=[Choice(a=맥도날드, b=빅맥), Choice(a=버거킹, b=와퍼), Choice(a=롯데리아, b=데리버거)])
         */
        System.out.println(question);
        entityManager.clear();
        /**
         * Hibernate:
         *     select
         *         q1_0.id,
         *         q1_0.text
         *     from
         *         tbl_question0202 q1_0
         *     where
         *         q1_0.id=?
         * Hibernate:
         *     select
         *         c1_0.question_id,
         *         c1_0.idx,
         *         c1_0.a,
         *         c1_0.b
         *     from
         *         tbl_question_choice_0202 c1_0
         *     where
         *         c1_0.question_id=?
         * Question(id=2, text=음식점과 메뉴의 조합이 올바른 것은??, choices=[Choice(a=맥도날드, b=빅맥), Choice(a=버거킹, b=와퍼), Choice(a=롯데리아, b=데리버거)])
         */
        Question question2 = entityManager.find(Question.class, question.getId());
        System.out.println(question2);

        List<Choice> newChoice = List.of(
                new Choice("순대실록", "순대국"),
                new Choice("아웃백", "스테이크"),
                new Choice("게살천국", "킹크랩")
        );

        transaction.begin();
        try {
            question2.changeChoices(newChoice);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        /**
         * Hibernate:
         *     delete
         *     from
         *         tbl_question_choice_0202
         *     where
         *         question_id=?
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice_0202
         *         (question_id, idx, a, b)
         *     values
         *         (?, ?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice_0202
         *         (question_id, idx, a, b)
         *     values
         *         (?, ?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice_0202
         *         (question_id, idx, a, b)
         *     values
         *         (?, ?, ?, ?)
         */

        // then
        Question question3 = entityManager.find(Question.class, question.getId());
        //Question(id=2, text=음식점과 메뉴의 조합이 올바른 것은??, choices=[Choice(a=순대실록, b=순대국), Choice(a=아웃백, b=스테이크), Choice(a=게살천국, b=킹크랩)])
        System.out.println(question3);
        assertThat(question3.getChoices()).isEqualTo(newChoice);
    }
}

