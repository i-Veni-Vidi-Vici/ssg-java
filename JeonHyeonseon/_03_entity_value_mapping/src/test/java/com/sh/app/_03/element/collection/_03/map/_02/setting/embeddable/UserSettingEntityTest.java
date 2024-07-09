package com.sh.app._03.element.collection._03.map._02.setting.embeddable;

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
    // 전형적인 1대N관계 테이블 매핑이다.
    void test1() {
        /*
            Hibernate:
                create table tbl_user_setting_0302 (
                    id bigint not null auto_increment,
                    updated_at datetime(6),
                    user_id bigint,
                    primary key (id)
                ) engine=InnoDB

            Hibernate:
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
        Map<String, PropValue> props = Map.of(
                "Notification", new PropValue("push", true),
                "Language", new PropValue("Korean", true));
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
        assertThat(userSetting.getId()).isNotNull().isNotZero();
        // map의 모든 요소가 동등한지 비교 검증
        assertThat(userSetting.getProps()).containsExactlyEntriesOf(props);
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
        // 수정/삭제하려면 조회를 먼저 해야한다
        UserSetting userSetting2 = entityManager.find(UserSetting.class, userSetting.getId());
        /*
        Hibernate:
            select
                us1_0.id,
                p1_0.user_setting_id,
                p1_0.name,
                p1_0.enabled,
                p1_0.value,
                us1_0.updated_at,
                us1_0.user_id
            from
                tbl_user_setting_0302 us1_0
            left join
                tbl_user_setting_map_0302 p1_0
                    on us1_0.id=p1_0.user_setting_id
            where
                us1_0.id=?
         */
        System.out.println(userSetting2); // 조회쿼리 확인
        // 알림설정 변경
        transaction.begin();
        try {
//            userSetting2.changeProp("Notification", "push", false);
            userSetting2.removeProp("Notification");
            transaction.commit();
            /*
            // userSetting2.changeProp("Notification", "push", false); 수정했을 경우
            Hibernate:
                update
                    tbl_user_setting_map_0302
                set
                    enabled=?,
                    value=?
                where
                    user_setting_id=?
                    and name=?
           -------------------------------------
           // userSetting2.removeProp("Notification"); 삭제했을 경우
            Hibernate:
                delete
                from
                    tbl_user_setting_map_0302
                where
                    user_setting_id=?
                    and name=?
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
    }
}
