package com.sh.app._03.element.collection._02.list._02.question.embeddable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class QuestionEntityTest {
    // application-scope: 1개만 만들어서 재사용 (thread-safe)
    private static EntityManagerFactory entityManagerFactory;
    // request-scope: 웹요청마다 1개씩 생성 (non-thread-safe)
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        // jpa설정정보를 읽어서 EntityManagerFactory를 생성
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
         *     create table tbl_question_0202 (
         *         id bigint not null auto_increment,
         *         text varchar(255),
         *         primary key (id)
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
         *     alter table tbl_question_choice_0202
         *        add constraint FKr08439eb7xfa8dqbrs7tkim4o
         *        foreign key (question_id)
         *        references tbl_question_0202 (id)
         */
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
                new Choice("딸기", "아이보리색")
                );
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
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_0202
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
         * Question(id=1, text=다음 중 과일과 색깔이 잘 매칭된 것을 고르세요., choices=[Choice(a=사과, b=검정색), Choice(a=바나나, b=파란색), Choice(a=토마토, b=토마토색), Choice(a=딸기, b=아이보리색)])
         */
    }

    @Test
    @DisplayName("Question객체 가져와서 수정하기")
    void test3() {
        // given
        String text = "음식점과 메뉴의 조합이 올바른 것은?";
        List<Choice> choices = List.of(
                new Choice("맥도날드", "와퍼"),
                new Choice("스타벅스", "누룽지죽"),
                new Choice("버거킹", "와퍼"),
                new Choice("박서방순대국", "인디안치킨커리")
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
        System.out.println(question2);
        // then
//        assertThat(question.getId()).isNotNull();

        System.out.println(question2);

        List<Choice> newChoices = List.of(
                new Choice("버거킹", "와퍼"),
                new Choice("맥도날드", "와퍼"),
                new Choice("박서방순대국", "인디안치킨커리"),
                new Choice("스타벅스", "누룽지죽")
        );
        transaction.begin();
        try {
            question2.changeChoices(newChoices);
            transaction.commit(); // flush and commit
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        Question question3 = entityManager.find(Question.class, question.getId());
        assertThat(question3.getChoices()).isEqualTo(newChoices);
        System.out.println(question3);

        /**
         * Question(id=1, text=음식점과 메뉴의 조합이 올바른 것은?, choices=[Choice(a=맥도날드, b=와퍼), Choice(a=스타벅스, b=누룽지죽), Choice(a=버거킹, b=와퍼), Choice(a=박서방순대국, b=인디안치킨커리)])
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
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice_0202
         *         (question_id, idx, a, b)
         *     values
         *         (?, ?, ?, ?)
         * Question(id=1, text=음식점과 메뉴의 조합이 올바른 것은?, choices=[Choice(a=버거킹, b=와퍼), Choice(a=맥도날드, b=와퍼), Choice(a=박서방순대국, b=인디안치킨커리), Choice(a=스타벅스, b=누룽지죽)])
         */
    }
}