package com.sh.app._03.element.collection._01.set._02.auth.embeddable;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RoleEntityTest {
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
            create table tbl_role_0302 (
                id varchar(255) not null,
                name varchar(255),
                primary key (id)
            ) engine=InnoDB

            create table tbl_role_permission_0302 (
                desc varchar(255) not null,
                role_id varchar(255) not null,
                url varchar(255) not null,
                primary key (desc, role_id, url)
            ) engine=InnoDB

            alter table tbl_role_permission_0302
               add constraint FK37qnj7e8e7yirilhp1b1vm8nu
               foreign key (role_id)
               references tbl_role_0302 (id)
         */
    }

    @Test
    @DisplayName("Role Entity 등록")
    void test2() {
        // given
        Role role = Role.builder()
                .id("ROLE_ADMIN")
                .name("관리자")
                .permissions(Set.of(
                        new Permission("/admin/members", "관리자용 회원관리"),
                        new Permission("/admin/roles", "관리자용 권한관리")
                ))
                .build();
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(role);
            transaction.commit();
            /*

             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        System.out.println(role);
        entityManager.clear();

        Role role2 = entityManager.find(Role.class, role.getId());
        System.out.println(role2);
        assertThat(role2).isNotNull();
        assertThat(role2.getPermissions()).isNotEmpty();
    }


    @Test
    @DisplayName("Role 엔티티에 커미션들 수정하기")
    void test3() {
        //given
        Role role = Role.builder()
                .id("ROLE_ADMIN")
                .name("관리자")
                .permissions(Set.of(
                        new Permission("/admin/members", "관리자용 회원관리"),
                        new Permission("/admin/roles", "관리자용 권한관리")
                ))
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
        //when
        Set<Permission> newPermissions = Set.of(
                new Permission("/admin/members", "관리자용 회원관리")
        );
        transaction.begin();
        try {
            //수정

            role.changePermissions(newPermissions);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }



        //then
        assertThat(role.getPermissions()).isSameAs(newPermissions);
    }

}
