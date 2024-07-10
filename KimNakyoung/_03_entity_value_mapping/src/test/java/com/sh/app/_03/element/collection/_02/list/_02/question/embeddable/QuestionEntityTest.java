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
        /*
            create table tbl_question (
                id bigint not null auto_increment,
                text varchar(255),
                primary key (id)
            ) engine=InnoDB

            create table tbl_question_choice (
                idx integer not null,
                question_id bigint not null,
                text varchar(255),
                primary key (idx, question_id)
            ) engine=InnoDB

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
        String text = "다음 중 과일과 색깔이 잘 매칭된 것을 고르세요.";
        List<Choice> choices = List.of(
                new Choice("사과","검정색"),
                new Choice("바나나","파란색"),
                new Choice("토마토","토마토색"),
                new Choice("파인애플","노랑색")
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
    }


    @Test
    @DisplayName("Question객체 가져와서 수정하기")
    void test3() {
        // given
        String text = "음식점과 메뉴의 조합이 올바른 것은?";
        List<Choice> choices = List.of(
                new Choice("맥도날드","와퍼"),
                new Choice("스타벅스","누룽지죽"),
                new Choice("버거킹","와퍼"),
                new Choice("박서방순대국","인디안치킨커리")
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
        // 이미 영속성 컨텍스트에 들어간거임

        //when
        entityManager.clear(); // 영속성 싹다 지우고
        Question question2 = entityManager.find(Question.class, question.getId()); // 조회함
        System.out.println(question2); // 쿼리 뭐 날라가는지 테스트 가능



        // then
        List<Choice> newChoices = List.of(
                new Choice("스타벅스","누룽지죽"),
                new Choice("버거킹","와퍼"),
                new Choice("맥도날드","와퍼"),
                new Choice("박서방순대국","인디안치킨커리")
        );
        transaction.begin();
        try {
            question2.changeChoices(newChoices); // 값 변경 할 때는 메서드 만들기! set으로 바로 바꾸면 안됨 책임이 불명확함.
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        //then
        Question question3 = entityManager.find(Question.class, question.getId()); //  다시조회
        assertThat(question3.getChoices()).isEqualTo(newChoices); 






    }

}
