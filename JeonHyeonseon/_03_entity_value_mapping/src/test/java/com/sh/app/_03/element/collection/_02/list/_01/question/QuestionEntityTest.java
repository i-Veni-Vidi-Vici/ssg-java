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
    // 전형적인 1대N관계 테이블 매핑이다.
    void test1() {
        /*
            create table tbl_question (
                id bigint not null auto_increment,
                text varchar(255),
                primary key (id)
            ) engine=InnoDB
         -------------------------------------------
            create table tbl_question_choice (
                idx integer not null,
                question_id bigint not null,
                text varchar(255),
                primary key (idx, question_id)
            ) engine=InnoDB
         -------------------------------------------
            alter table tbl_question_choice
               add constraint FKnrcac8c0g5gp794wy85aecfoh
               foreign key (question_id)
               references tbl_question (id)
         */
    }

    @Test
    @DisplayName("Question 등록")
    void test2() {
        // given
        String text = "다음 중 SQL의 종류가 아닌 것을 고르세요.";
        List<String> choices = List.of("DQL", "DML", "DCL", "DHL"); // List.of() 변경할 일이 없고, 변경한다면 전체 다 변경됨.
        Question question = new Question(null, text, choices);
        // 이렇게 만든 경우 외부에서 변경 불가능하다. set 사용 금지. private으로 되어있기 때문이다.

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(question);
            transaction.commit();
            /*
            Hibernate:
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
                    (question_id, idx, text)
                values
                    (?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_question_choice
                    (question_id, idx, text)
                values
                    (?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_question_choice
                    (question_id, idx, text)
                values
                    (?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_question_choice
                    (question_id, idx, text)
                values
                    (?, ?, ?)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        System.out.println(question); // Question(id=1, text=다음 중 SQL의 종류가 아닌 것을 고르세요., choices=[DQL, DML, DCL, DHL])
        // then
        assertThat(question.getId()).isNotNull();
    }

    @Test
    @DisplayName("Question객체 가져와서 수정하기")
    // 지연로딩
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
        entityManager.clear(); // 이미 위에 영속성컨텍스트에 있기 때문에 한 번 지우고 조회할 것이다.
        Question question2 = entityManager.find(Question.class, question.getId());
        /*
        Hibernate:
            select
                q1_0.id,
                c1_0.question_id,
                c1_0.idx,
                c1_0.text,
                q1_0.text
            from
                tbl_question q1_0
            left join
                tbl_question_choice c1_0
                    on q1_0.id=c1_0.question_id
            where
                q1_0.id=?
         */
        System.out.println(question2);

        List<String> newChoices = List.of("GREEN", "BLUE", "RED", "YELLOW");
        transaction.begin();
        try {
            question2.changeChoices(newChoices);
            transaction.commit(); // flush() + commit() 변경사항이 저장(flush) + commit
            /*
            // update문으로 바뀌는 것이 아니라 delete문으로 지워지고 새로 table이 생성된다.
            Hibernate:
                delete
                from
                    tbl_question_choice
                where
                    question_id=?
            Hibernate:
                insert
                into
                    tbl_question_choice
                    (question_id, idx, text)
                values
                    (?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_question_choice
                    (question_id, idx, text)
                values
                    (?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_question_choice
                    (question_id, idx, text)
                values
                    (?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_question_choice
                    (question_id, idx, text)
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
