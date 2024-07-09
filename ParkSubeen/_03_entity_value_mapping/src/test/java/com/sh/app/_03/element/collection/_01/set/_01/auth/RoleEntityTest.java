package com.sh.app._03.element.collection._01.set._01.auth;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Set;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class RoleEntityTest {
    // application-scope: 1개만 만들어서 재사용 (thread-safe)
    private static EntityManagerFactory entityManagerFactory;
    // request-scope: 웹요청마다 1개씩 생성 (non-thread-safe)
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        // jpa설정정보를 읽어서 EntityManagerFactory를 생성
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
            drop table if exists tbl_role_0301
            drop table if exists tbl_role_permision_0301
            create table tbl_role_0301 (
                id varchar(255) not null,
                name varchar(255),
                primary key (id)
            ) engine=InnoDB
            create table tbl_role_permision_0301 (
                permission varchar(255),
                role_id varchar(255) not null
            ) engine=InnoDB
            alter table tbl_role_permision_0301
               add constraint FK9lbxh7nbbs6naqd4s74s1l05
               foreign key (role_id)
               references tbl_role_0301 (id)
         */
    }

    @Test
    @DisplayName("Role Entity 등록 - FetchType.LAZY")
    void test2() {
        // given
        Role role = Role.builder()
                .id("ROLE_ADMIN")
                .name("관리자")
                .permissions(Set.of("/admin/members", "/admin/members/update/*"))
                .build();
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(role);
            /*
                Hibernate:
                    insert
                    into
                        tbl_role_0301
                        (name, id)
                    values
                        (?, ?)
                Hibernate:
                    insert
                    into
                        tbl_role_permision_0301
                        (role_id, permission)
                    values
                        (?, ?)
                Hibernate:
                    insert
                    into
                        tbl_role_permision_0301
                        (role_id, permission)
                    values
                        (?, ?)
             */
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        entityManager.detach(role);

        Role role2 = entityManager.find(Role.class, role.getId());
        /*
            select
                r1_0.id,
                r1_0.name
            from
                tbl_role_0301 r1_0
            where
                r1_0.id=?
         */
        System.out.println(role2.getName()); // role2.toString() -> permissions.toString()
        /*
            select
                p1_0.role_id,
                p1_0.permission
            from
                tbl_role_permision_0301 p1_0
            where
                p1_0.role_id=?
         */
        System.out.println(role2.getPermissions());
        assertThat(role2).isNotNull();
        assertThat(role2.getPermissions()).isNotEmpty();
    }

    @Test
    @DisplayName("Role Entity 등록 - FetchType.EAGER")
    void test3() {
        // given
        Role role = Role.builder()
                .id("ROLE_MANAGER")
                .name("매니져")
                .permissions(Set.of("/admin/members", "/admin/members/stat"))
                .build();
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(role);
            /*
                Hibernate:
                    insert
                    into
                        tbl_role_0301
                        (name, id)
                    values
                        (?, ?)
                Hibernate:
                    insert
                    into
                        tbl_role_permision_0301
                        (role_id, permission)
                    values
                        (?, ?)
                Hibernate:
                    insert
                    into
                        tbl_role_permision_0301
                        (role_id, permission)
                    values
                        (?, ?)
             */
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        entityManager.detach(role);

        Role role2 = entityManager.find(Role.class, role.getId());
        /*
            select
                r1_0.id,
                r1_0.name,
                p1_0.role_id,
                p1_0.permission
            from
                tbl_role_0301 r1_0
            left join
                tbl_role_permision_0301 p1_0
                    on r1_0.id=p1_0.role_id
            where
                r1_0.id=?
         */
        System.out.println(role2.getName()); // 매니져
        System.out.println(role2.getPermissions()); // [/admin/members/stat, /admin/members]
        assertThat(role2).isNotNull();
        assertThat(role2.getPermissions()).isNotEmpty();
    }

    @Test
    @DisplayName("Role Entity 수정")
    void test4() {
        // given
        Role role = Role.builder()
                .id("ROLE_MANAGER")
                .name("매니져")
                .permissions(Set.of("/manager/members", "/manager/stat"))
                .build();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(role);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        // when
        transaction.begin();
        try {
            // permission은 일부 수정이 아닌 Set객체 전체를 교체한다.
            Set<String> newPermissions = Set.of("/manager/members", "/manager/products");
            role.changePermissions(newPermissions);
            transaction.commit();
            /*
                tbl_role_permission_0301테이블에서 ROLE_MANAGER관련 행을 모두 삭제후에 다시 insert한다.

                Hibernate:
                    delete
                    from
                        tbl_role_permission_0301
                    where
                        role_id=?
                Hibernate:
                    insert
                    into
                        tbl_role_permission_0301
                        (role_id, permission)
                    values
                        (?, ?)
                Hibernate:
                    insert
                    into
                        tbl_role_permission_0301
                        (role_id, permission)
                    values
                        (?, ?)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        // then
    }
}
