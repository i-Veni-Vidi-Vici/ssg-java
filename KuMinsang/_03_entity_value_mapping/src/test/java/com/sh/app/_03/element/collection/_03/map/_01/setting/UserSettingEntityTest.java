package com.sh.app._03.element.collection._03.map._01.setting;


import com.sh.app._03.element.collection._02.list._02.question.embeddable.Choice;
import com.sh.app._03.element.collection._02.list._02.question.embeddable.Question;
import jakarta.persistence.*;
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
        /**
         * Hibernate:
         *     create table tbl_user_setting (
         *         id bigint not null auto_increment,
         *         updated_at datetime(6),
         *         user_id bigint,
         *         primary key (id)
         *     ) engine=InnoDB
         *
         *
         *     Hibernate:
         *     create table tbl_user_setting_map (
         *         user_setting_id bigint not null,
         *         props varchar(255),
         *         props_KEY varchar(255) not null,
         *         primary key (user_setting_id, props_KEY)
         *     ) engine=InnoDB
         * Hibernate:
         *     alter table tbl_user_setting_map
         *        add constraint FK860y6diic9lv1le2qj0mwkni1
         *        foreign key (user_setting_id)
         *        references tbl_user_setting (id)
         */
    }

    @DisplayName("UserSetting Entity 등록")
    @Test
    public void test2() {
        //given
        UserSetting userSetting = UserSetting.builder()
                .userId(123L)
                .props(Map.of("Notification", "NO", "Display", "LIGHT"))
                .build();
        //when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            entityManager.persist(userSetting);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();;
            e.printStackTrace();
        }
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_user_setting
         *         (updated_at, user_id)
         *     values
         *         (?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_user_setting_map
         *         (user_setting_id, name, value)
         *     values
         *         (?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_user_setting_map
         *         (user_setting_id, name, value)
         *     values
         *         (?, ?, ?)
         */
        //then
        assertThat(userSetting).isNotNull();
        assertThat(userSetting.getProps()).isNotEmpty();
    }

    @DisplayName("UserSetting Entity props 수정")
    @Test
    public void test3() {
        //given
        UserSetting userSetting = UserSetting.builder()
                .userId(456L)
                .props(Map.of("Notification", "NO", "Display", "LIGHT"))
                .build();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            entityManager.persist(userSetting);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();;
            e.printStackTrace();
        }
        //when
        entityManager.clear();
        UserSetting userSetting2 = entityManager.find(UserSetting.class, userSetting.getId());
        System.out.println(userSetting2);
        //알림 설정을 변경
        transaction.begin();
        try {
            userSetting2.changeProp("Notification", "YES");
            transaction.commit();
            /**
             * Hibernate:
             *     update
             *         tbl_user_setting_map
             *     set
             *         value=?
             *     where
             *         user_setting_id=?
             *         and name=?
             */
        }catch (Exception e){
            transaction.rollback();
        }

        //then
        //UserSetting(id=1, userId=456, updatedAt=2024-07-09T11:40:34.044676, props={Notification=YES, Display=LIGHT})
        System.out.println(userSetting2);
        assertThat(userSetting).isNotNull();
        assertThat(userSetting.getProps()).isNotEmpty();
    }
}

