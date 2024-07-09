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
        entityManagerFactory = Persistence.
                createEntityManagerFactory("jpatest");
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

         */
    }

    @Test
    @DisplayName("Question 등록")
    void test2() {
        String text="다음 중 과일과 색깔이 잘 매칭된 것을 고르세요";
        List<Choice > choices= List.of(
                new Choice("사과","검정색"),
                new Choice("바나나","파란색"),
                new Choice("토마토","토마토색"),
                new Choice("딸기","아이보리")
        );
        Question question=new Question(null,text,choices);

        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();

        try{
            entityManager.persist(question);
            transaction.commit();
        }catch (Exception e)
        {
            transaction.rollback();
            e.printStackTrace();
        }

        System.out.println(question);

        assertThat(question.getId()).isNotNull();
    }

    @Test
    @DisplayName("Question객체 가져와서 수정하기")
    void test3() {
        // given
        String text="음식점과 메뉴의 조합이 올바른 것은??";
        List<Choice > choices= List.of(
                new Choice("맥도날드","와퍼"),
                new Choice("스타벅스","누룽지죽"),
                new Choice("버거킹","와퍼"),
                new Choice("박서방순대국","인디안치킨커리")
        );

        Question question=new Question(null,text,choices);

        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();

        try{
            entityManager.persist(question);
            transaction.commit();
        }catch (Exception e)
        {
            transaction.rollback();
            e.printStackTrace();
        }



        System.out.println(question);

        // when
        entityManager.clear();
        Question question2=entityManager.find(Question.class,question.getId());

        System.out.println("question2 = " + question2);

        List<Choice > newChoices= List.of(
                new Choice("버거킹","와퍼"),
                new Choice("스타벅스","누룽지죽"),
                new Choice("맥도날드","와퍼"),
                new Choice("박서방순대국","인디안치킨커리")
        );

        transaction.begin();

        try{
            question2.changeChoices(newChoices);
            transaction.commit(); // flush and commit 이다
        }catch (Exception e)
        {
            transaction.rollback();
            e.printStackTrace();
        }
        Question question3=entityManager.find(Question.class,question.getId());
        assertThat(question3.getChoices()).isEqualTo(newChoices);
        // 여기서 update문으로 내용값이 바뀌는게 아니라, detele문으로 싹 지우고 다시 한다
        // 이유는 개수가 어떻게 될지 모르니깐 아예 지워버리고 새롭게 넣는다

        // then


    }



}
