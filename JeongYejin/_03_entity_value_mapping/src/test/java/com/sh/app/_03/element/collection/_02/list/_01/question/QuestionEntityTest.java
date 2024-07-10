package com.sh.app._03.element.collection._02.list._01.question;

import com.sh.app._03.element.collection._01.set._02.auth.embeddable.Permission;
import com.sh.app._03.element.collection._01.set._02.auth.embeddable.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Set;

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
         *     create table tbl_question (
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
         *     alter table tbl_question_choice
         *        add constraint FKnrcac8c0g5gp794wy85aecfoh
         *        foreign key (question_id)
         *        references tbl_question (id)
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
         *         tbl_question
         *         (text)
         *     values
         *         (?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice
         *         (question_id, idx, text)
         *     values
         *         (?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice
         *         (question_id, idx, text)
         *     values
         *         (?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice
         *         (question_id, idx, text)
         *     values
         *         (?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice
         *         (question_id, idx, text)
         *     values
         *         (?, ?, ?)
         */
    }

    @Test
    @DisplayName("Question객체 가져와서 수정하기")
    void test3() {
        // given
        String text = "신호등의 색깔이 아닌 것은?";
        List<String> choices = List.of("초록색", "빨강색", "주황색", "자몽색");
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

        /**
         * Hibernate:
         *     select
         *         q1_0.id,
         *         q1_0.text
         *     from
         *         tbl_question q1_0
         *     where
         *         q1_0.id=?
         * Hibernate:
         *     select
         *         c1_0.question_id,
         *         c1_0.idx,
         *         c1_0.text
         *     from
         *         tbl_question_choice c1_0
         *     where
         *         c1_0.question_id=?
         * Question(id=1, text=신호등의 색깔이 아닌 것은?, choices=[초록색, 빨강색, 주황색, 자몽색])
         *
         * 지연로딩 ((fetch = FetchType.LAZY)(default) vs (fetch = FetchType.EAGER))
         * 일단 필요한 테이블 question만 조회하고 question_choice는 나중에 필요할 때 조회한다.
         *
         * Hibernate:
         *     select
         *         q1_0.id,
         *         c1_0.question_id,
         *         c1_0.idx,
         *         c1_0.text,
         *         q1_0.text
         *     from
         *         tbl_question q1_0
         *     left join
         *         tbl_question_choice c1_0
         *             on q1_0.id=c1_0.question_id
         *     where
         *         q1_0.id=?
         * Question(id=1, text=신호등의 색깔이 아닌 것은?, choices=[초록색, 빨강색, 주황색, 자몽색])
         */
        System.out.println(question2);

        List<String> newChoices = List.of("GREEN", "BLUE", "RED", "YELLOW");
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
         * Question(id=1, text=신호등의 색깔이 아닌 것은?, choices=[초록색, 빨강색, 주황색, 자몽색])
         * Hibernate:
         *     delete
         *     from
         *         tbl_question_choice
         *     where
         *         question_id=?
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice
         *         (question_id, idx, text)
         *     values
         *         (?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice
         *         (question_id, idx, text)
         *     values
         *         (?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice
         *         (question_id, idx, text)
         *     values
         *         (?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_question_choice
         *         (question_id, idx, text)
         *     values
         *         (?, ?, ?)
         * Question(id=1, text=신호등의 색깔이 아닌 것은?, choices=[초록색, 빨강색, 주황색, 자몽색])
         */
    }
}