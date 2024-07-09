package com.sh._03.element.collection._03.map._01.setting;


import com.sh._03.element.collection._02.list._02.question.embeddable.Choice;
import com.sh._03.element.collection._02.list._02.question.embeddable.Question;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.map;

public class UserSettingEntityTest {
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
    @DisplayName("UserSetting Entity 등록")
    void test2() {
        UserSetting userSetting= UserSetting.builder()
                .userId(1234L)
                .props(Map.of("Notification","NO","Display","LIGHT"))
                .build();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try{
            entityManager.persist(userSetting);
            transaction.commit();
            //
        }catch (Exception e)
        {
            transaction.rollback();
            e.printStackTrace();
        }

        System.out.println("userSetting = " + userSetting);
        assertThat(userSetting.getUserId()).isNotZero();
    }

    @Test
    @DisplayName("UserSetting Entity props 수정/삭제")
    void test3() {
        // given
        UserSetting userSetting= UserSetting.builder()
                .userId(567L)
                .props(Map.of("Notification","NO","Display","LIGHT"))
                .build();

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try{
            entityManager.persist(userSetting);
            transaction.commit();
            //
        }catch (Exception e)
        {
            transaction.rollback();
            e.printStackTrace();
        }
        System.out.println("userSetting = " + userSetting);
        assertThat(userSetting.getUserId()).isNotZero();

        // when
        // 알림설정을 변경한다 // 일단 가져오는게 선행되어야 한다
        entityManager.clear();
        UserSetting userSetting2=entityManager.find(UserSetting.class, userSetting.getId());
        System.out.println("userSetting2 = " + userSetting2);


        transaction.begin();
        try{
//            userSetting2.changeProp("Notification","YES");
//            entityManager.persist(userSetting2);
            userSetting2.removeProp("Display");
            transaction.commit();

            //
        }catch (Exception e)
        {
            transaction.rollback();
            e.printStackTrace();
        }
        // 이놈은 delete가 아니라 update네?? 이유는 같은 타입와 길이 등등 똑같으니깐 딱 선택해서 바꿀 수 있기 떄문이다
        System.out.println("userSetting2 = " + userSetting2);


    }




}
