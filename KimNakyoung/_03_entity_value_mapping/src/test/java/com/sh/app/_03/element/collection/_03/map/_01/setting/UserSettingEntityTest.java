package com.sh.app._03.element.collection._03.map._01.setting;


import com.sh.app._03.element.collection._02.list._02.question.embeddable.Choice;
import com.sh.app._03.element.collection._02.list._02.question.embeddable.Question;
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
        /*
            create table tbl_user_setting (
                id bigint not null auto_increment,
                updated_at datetime(6),
                user_id bigint,
                primary key (id)
            ) engine=InnoDB

            create table tbl_user_setting_map (
                user_setting_id bigint not null,
                name varchar(255) not null,
                value varchar(255),
                primary key (user_setting_id, name)
            ) engine=InnoDB

            alter table tbl_user_setting_map
               add constraint FK860y6diic9lv1le2qj0mwkni1
               foreign key (user_setting_id)
               references tbl_user_setting (id)
         */
    }

    @Test
    @DisplayName("UserSetting Entity 등록")
    void test2() {
        // given
        UserSetting userSetting = UserSetting.builder()
                .userId(123L)
                .props(Map.of("Notification", "NO", "Display", "LIGHT"))
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

        //when
        entityManager.clear(); // 구별하기위해서 끊음
        UserSetting userSetting2 = entityManager.find(UserSetting.class, userSetting.getId()); // 수정삭제 하려면 조회가 먼저
        //알림설정 변경


        transaction.begin();
        try {
//            userSetting2.changeProp("Notification", "YES"); //규격 맞추기위해 트랜잭션안에서 하자 !
            userSetting2.removeProp("Display");
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        assertThat(userSetting.getUserId()).isNotZero();

        // then
    }

}
