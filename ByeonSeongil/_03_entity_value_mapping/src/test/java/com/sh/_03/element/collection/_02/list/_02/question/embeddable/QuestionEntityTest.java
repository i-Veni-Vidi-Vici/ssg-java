package com.sh._03.element.collection._02.list._02.question.embeddable;


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
//        Hibernate:
//        create table tbl_question_0202 (
//                id bigint not null auto_increment,
//                text varchar(255),
//                primary key (id)
//    ) engine=InnoDB
//        Hibernate:
//        create table tbl_question_choice_0202 (
//                idx integer not null,
//                question_id bigint not null,
//                a varchar(255),
//                b varchar(255),
//                primary key (idx, question_id)
//    ) engine=InnoDB
    }

    @Test
    @DisplayName("Question 등록")
    void test2() {
        // given
        String text = "다음 중 과일과 색깔이 잘 매칭된 것을 고르세요.";
        List<Choice> choices = List.of(
                new Choice("사과", "검정색"),
                new Choice("바나나", "파란색"),
                new Choice("토마토", "토마토색"),
                new Choice("딸기", "빨간색")
        );
//        Hibernate:
//        insert
//                into
//        tbl_question_0202
//                (text)
//        values
//                (?)
//        Hibernate:
//        insert
//                into
//        tbl_question_choice_0202
//                (question_id, idx, a, b)
//        values
//                (?, ?, ?, ?)
//        Hibernate:
//        insert
//                into
//        tbl_question_choice_0202
//                (question_id, idx, a, b)
//        values
//                (?, ?, ?, ?)
//        Hibernate:
//        insert
//                into
//        tbl_question_choice_0202
//                (question_id, idx, a, b)
//        values
//                (?, ?, ?, ?)
//        Hibernate:
//        insert
//                into
//        tbl_question_choice_0202
//                (question_id, idx, a, b)
//        values
//                (?, ?, ?, ?)

        Question question = new Question(null, text, choices);
        // when
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
        // then
        assertThat(question.getId()).isNotNull();
    }


    @Test
    @DisplayName("Question객체 가져와서 수정하기")
    void test3() {
        // given
        String text = "음식점과 메뉴의 조합이 올바른 것은?";
        List<Choice> choices = List.of(
                new Choice("맥도날드", "드릴"),
                new Choice("버거킹", "와퍼"),
                new Choice("스타벅스", "스타킹"),
                new Choice("맘스터치", "맘스")
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
        // when
        entityManager.clear();
        Question question2 = entityManager.find(Question.class, question.getId());
//        Hibernate:
//        select
//        q1_0.id,
//                c1_0.question_id,
//                c1_0.idx,
//                c1_0.a,
//                c1_0.b,
//                q1_0.text
//        from
//        tbl_question_0202 q1_0
//        left join
//        tbl_question_choice_0202 c1_0
//        on q1_0.id=c1_0.question_id
//        where
//        q1_0.id=?
        System.out.println(question2);

        List<Choice> newChoices = List.of(
                new Choice("버거킹", "와퍼"),
                new Choice("맥도날드", "드릴"),
                new Choice("스타벅스", "스타킹"),
                new Choice("맘스터치", "맘스")
        );
        transaction.begin();
        try {
            question2.changeChoices(newChoices);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        Question question3 = entityManager.find(Question.class, question.getId());
        assertThat(question3.getChoices()).isEqualTo(newChoices);

    }
}
