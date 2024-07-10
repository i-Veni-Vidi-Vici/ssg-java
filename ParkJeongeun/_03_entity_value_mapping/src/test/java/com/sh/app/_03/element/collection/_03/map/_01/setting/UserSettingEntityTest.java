package com.sh.app._03.element.collection._03.map._01.setting;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class UserSettingEntityTest {
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
    }

    @Test
    @DisplayName("UserSetting Entity 등록")
    void test2() {
        // given
        UserSetting userSetting = UserSetting.builder()
                .userId(123L)
                .props(Map.of("Notification", "No", "Display","LIGHT"))
                .build();
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(userSetting);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        assertThat(userSetting.getId()).isNotZero();
    }

    @Test
    @DisplayName("UserSetting Entity props 수정/삭제")
    void test3() {
        // given
        UserSetting userSetting = UserSetting.builder()
                .userId(456L)
                .props(Map.of("Notification", "No", "Display","LIGHT"))
                .build();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(userSetting);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        // when
        entityManager.clear();
        // 수정,삭제를 위해서는 조회가 선행되어야 함
        UserSetting userSetting2 = entityManager.find(UserSetting.class, userSetting.getId());
        System.out.println(userSetting2);
        // 알림설정 변경
        transaction.begin();
        try {
//            userSetting2.changeProp("Notification", "YES");
            userSetting2.removeProp("Display");
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        assertThat(userSetting.getId()).isNotZero();
    }
}