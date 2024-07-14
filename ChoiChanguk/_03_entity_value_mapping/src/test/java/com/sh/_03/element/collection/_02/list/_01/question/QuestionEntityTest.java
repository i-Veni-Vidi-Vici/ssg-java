package com.sh._03.element.collection._02.list._01.question;


import com.sh._03.element.collection._01.set._01.auth.Role;
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
        String text="다음 중 SQL의 종류가 아닌 것을 고르세요";
        List<String > choices= List.of("DQL","DML","DCL","DHL");
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
        String text="신호등의 색깔이 아닌 것은??";
        List<String > choices= List.of("초록색","빨간색","노란색","자몽색");
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
        // 지연로딩 lazy 기본값이다 @ElementCollection(fetch = FetchType.LAZY)
        // 조인쿼리를 한 번에 쓰고 싶으면 @ElementCollection(fetch = FetchType.EAGER)
        /*
        지금 이건 EAGER로 바꿔서 생긴 쿼리이다
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

        System.out.println(question);

        // when
        entityManager.clear();
        Question question2=entityManager.find(Question.class,question.getId());

        System.out.println("question2 = " + question2);

        List<String > newChoices=List.of("GREEN","BLUE","RED","YELLOW");

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
