package com.sh.app._03.element.collection._02.list._01.question;


import com.sh.app._03.element.collection._01.set._01.auth.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
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

        /**
         * Hibernate:
         *     create table tbl_question (
         *         id bigint not null auto_increment,
         *         text varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_question_choice (
         *         idx integer not null,
         *         text bigint not null,
         *         text2 varchar(255),
         *         primary key (idx, text)
         *     ) engine=InnoDB
         * Hibernate:
         *     alter table tbl_question_choice
         *        add constraint FKeutwv4fl5df4vegl513b40caf
         *        foreign key (text)
         *        references tbl_question (id)
         */
    }

    @Test
    @DisplayName("Question 등록")
    void test2() {
        String text = "전자제품 브랜드가 아닌것은?";
        List<String> choice = List.of("삼성", "엘지", "다이슨", "농심");
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
        System.out.println(question);
        assertThat(question.getChoice()).isEqualTo(choice);
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_question
         *         (text)
         *     values
         *         (?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice
         *         (text, idx, text2)
         *     values
         *         (?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice
         *         (text, idx, text2)
         *     values
         *         (?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice
         *         (text, idx, text2)
         *     values
         *         (?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice
         *         (text, idx, text2)
         *     values
         *         (?, ?, ?)
         * Question(id=1, text=다음 중 SQL의 종류가 아닌것을 고르세요, choice=[DQL, DML, DCL, DHL])
         */
    }

    @Test
    @DisplayName("Text 객체 가져와서 수정하기")
    void test3() {
        // given
        String text = "신호등 색깔이 아닌 것은?";
        List<String> choice = List.of("초록색", "노랑색", "빨강색", "보라색");
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
        System.out.println(question);
        entityManager.clear();
        Question question2 = entityManager.find(Question.class, question.getId());
        System.out.println(question2);

        List<String> newChoice = List.of("GREEN", "BLUE", "RED", "YELLOW");

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
         *         tbl_question_choice
         *     where
         *         text=?
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice
         *         (text, idx, text2)
         *     values
         *         (?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice
         *         (text, idx, text2)
         *     values
         *         (?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice
         *         (text, idx, text2)
         *     values
         *         (?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice
         *         (text, idx, text2)
         *     values
         *         (?, ?, ?)
         */

        // then
        Question question3 = entityManager.find(Question.class, question.getId());
        assertThat(question3.getChoice()).isEqualTo(newChoice);

    }
}

