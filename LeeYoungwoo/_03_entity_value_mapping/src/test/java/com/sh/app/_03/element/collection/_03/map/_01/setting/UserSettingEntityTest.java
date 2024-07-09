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
            create table tbl_user (
                home_addr1 varchar(255),
                home_addr2 varchar(255),
                home_zip_code varchar(255),
                id varchar(255) not null,
                work_addr1 varchar(255),
                work_addr2 varchar(255),
                work_zip_code varchar(255),
                primary key (id)
            ) engine=InnoDB

            create table tbl_user_setting (
                id bigint not null auto_increment,
                updated_at datetime(6),
                user_id bigint,
                primary key (id)
            ) engine=InnoDB

            create table tbl_user_setting_map (
                user_setting_id bigint not null,
                value props varchar(255),
                name props_KEY varchar(255) not null,
                primary key (user_setting_id, props_KEY)
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
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(userSetting);
            transaction.commit();
            /*
            insert
            into
                tbl_user_setting
                (updated_at, user_id)
            values
                (?, ?)
        Hibernate:
            insert
            into
                tbl_user_setting_map
                (user_setting_id, name, value)
            values
                (?, ?, ?)
        Hibernate:
            insert
            into
                tbl_user_setting_map
                (user_setting_id, name, value)
            values
                (?, ?, ?)
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
        // when
        entityManager.clear();
        UserSetting userSetting2 = entityManager.find(UserSetting.class, userSetting.getId());
        /*
            select
                us1_0.id,
                p1_0.user_setting_id,
                p1_0.name,
                p1_0.value,
                us1_0.updated_at,
                us1_0.user_id
            from
                tbl_user_setting us1_0
            left join
                tbl_user_setting_map p1_0
                    on us1_0.id=p1_0.user_setting_id
            where
                us1_0.id=?
         */
        System.out.println(userSetting2);
        // 알림설정 변경
        transaction.begin();
        try {
//            userSetting2.changeProp("Notification", "YES");
            userSetting2.removeProp("Display");
            transaction.commit();
            /*
            // 특정값을 찍어낼 수 있기 때문에 Update쿼리가 날라간다.
            // userSetting2.changeProp("Notification", "YES"); 경우
                update
                    tbl_user_setting_map
                set
                    value=?
                where
                    user_setting_id=?
                    and name=?

            // userSetting2.removeProp("Display"); 경우
                delete
                from
                    tbl_user_setting_map
                where
                    user_setting_id=?
                    and name=?
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        assertThat(userSetting.getId()).isNotZero();
    }
}
