package com.sh._03.element.collection._03.map._02.setting.embeddable;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

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
        /*
            create table tbl_user_setting_0302 (
                id bigint not null auto_increment,
                updated_at datetime(6),
                user_id bigint,
                primary key (id)
            ) engine=InnoDB

            create table tbl_user_setting_map_0302 (
                enabled bit,
                user_setting_id bigint not null,
                name varchar(255) not null,
                value varchar(255) not null,
                primary key (user_setting_id, name)
            ) engine=InnoDB

            alter table tbl_user_setting_map_0302
               add constraint FKkhnmcscocfc5654ff9ioil8jt
               foreign key (user_setting_id)
               references tbl_user_setting_0302 (id)
         */
    }

    @Test
    @DisplayName("UserSetting Entity 등록")
    void test2() {
        // given
        UserSetting userSetting = UserSetting.builder()
                .userId(123L)
                .props(
                        Map.of(
                                "Notification", new PropValue("push", true),
                                "Language", new PropValue("Korean", true)))
                .build();
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(userSetting);
            transaction.commit();
            /*
            Hibernate:
                insert
                into
                    tbl_user_setting_0302
                    (updated_at, user_id)
                values
                    (?, ?)
            Hibernate:
                insert
                into
                    tbl_user_setting_map_0302
                    (user_setting_id, name, enabled, value)
                values
                    (?, ?, ?, ?)
            Hibernate:
                insert
                into
                    tbl_user_setting_map_0302
                    (user_setting_id, name, enabled, value)
                values
                    (?, ?, ?, ?)

             */
        } catch (Exception e) {
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
                .props(
                        Map.of(
                                "Notification", new PropValue("push", true),
                                "Language", new PropValue("Korean", true)))
                .build();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(userSetting);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // when
        entityManager.clear();
        UserSetting userSetting2 = entityManager.find(UserSetting.class, userSetting.getId());
        /*
         */
        System.out.println(userSetting2);
        // 알림설정 변경
        transaction.begin();
        try {
            userSetting2.changeProp("Notification", "push", false);
//            userSetting2.removeProp("Notification");
            transaction.commit();
            /*
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        
        // then
        assertThat(userSetting.getId()).isNotZero();
    }

}
