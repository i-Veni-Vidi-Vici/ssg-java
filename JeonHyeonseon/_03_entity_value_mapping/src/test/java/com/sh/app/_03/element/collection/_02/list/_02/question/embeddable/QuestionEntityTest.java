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
    // 전형적인 1대N관계 테이블 매핑이다.
    void test1() {
        /*
            Hibernate:
                create table tbl_question_0202 (
                    id bigint not null auto_increment,
                    text varchar(255),
                    primary key (id)
                ) engine=InnoDB

            Hibernate:
                create table tbl_question_choice_0202 (
                    idx integer not null,
                    question_id bigint not null,
                    a varchar(255),
                    b varchar(255),
                    primary key (idx, question_id)
                ) engine=InnoDB

            Hibernate:
                alter table tbl_question_choice_0202
                   add constraint FKr08439eb7xfa8dqbrs7tkim4o
                   foreign key (question_id)
                   references tbl_question_0202 (id)
         */
    }

    @Test
    @DisplayName("Question 등록")
    void test2() {
        // given
        String text = "다음 중 과일과 색깔이 잘 매칭된 것을 고르세요";
        List<Choice> choices = List.of(
                new Choice("사과", "검정색"),
                new Choice("바나나", "파란색"),
                new Choice("토마토", "토마토색"),
                new Choice("딸기", "아이보리색")
                ); // List.of() 변경할 일이 없고, 변경한다면 전체 다 변경됨.
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
                    tbl_question_0202
                    (text)
                values
                    (?)
            Hibernate:
                insert
                into
                    tbl_question_choice_0202
                    (question_id, idx, a, b)
                values
                    (?, ?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_question_choice_0202
                    (question_id, idx, a, b)
                values
                    (?, ?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_question_choice_0202
                    (question_id, idx, a, b)
                values
                    (?, ?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_question_choice_0202
                    (question_id, idx, a, b)
                values
                    (?, ?, ?, ?)
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
        entityManager.clear(); // 이미 위에 영속성컨텍스트에 있기 때문에 한 번 지우고 조회할 것이다.
        Question question2 = entityManager.find(Question.class, question.getId());
        /*
        Hibernate:
            select
                q1_0.id,
                c1_0.question_id,
                c1_0.idx,
                c1_0.a,
                c1_0.b,
                q1_0.text
            from
                tbl_question_0202 q1_0
            left join
                tbl_question_choice_0202 c1_0
                    on q1_0.id=c1_0.question_id
            where
                q1_0.id=?
         */
        System.out.println(question2);

        List<Choice> newChoices = List.of(
                new Choice("버거킹", "와퍼"),
                new Choice("맥도날드", "와퍼"),
                new Choice("스타벅스", "누룽지죽"),
                new Choice("박서방순대국", "인디안치킨커리")
        );
        transaction.begin();
        try {
            question2.changeChoices(newChoices);
            transaction.commit(); // flush() + commit() 변경사항이 저장(flush) + commit
            /*
            // update문으로 바뀌는 것이 아니라 delete문으로 지워지고 새로 table이 생성된다.
            Hibernate:
                delete
                from
                    tbl_question_choice_0202
                where
                    question_id=?
            Hibernate:
                insert
                into
                    tbl_question_choice_0202
                    (question_id, idx, a, b)
                values
                    (?, ?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_question_choice_0202
                    (question_id, idx, a, b)
                values
                    (?, ?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_question_choice_0202
                    (question_id, idx, a, b)
                values
                    (?, ?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_question_choice_0202
                    (question_id, idx, a, b)
                values
                    (?, ?, ?, ?)
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
