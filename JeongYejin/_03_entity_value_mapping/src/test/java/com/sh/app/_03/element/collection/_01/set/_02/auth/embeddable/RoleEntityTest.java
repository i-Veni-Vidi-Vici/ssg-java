package com.sh.app._03.element.collection._01.set._02.auth.embeddable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Set;

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
        /**
         * Hibernate:
         *     create table tbl_role_0302 (
         *         id varchar(255) not null,
         *         name varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_role_permission_0302 (
         *         description varchar(255) not null,
         *         role_id varchar(255) not null,
         *         url varchar(255) not null,
         *         primary key (description, role_id, url)
         *     ) engine=InnoDB
         * Hibernate:
         *     alter table tbl_role_permission_0302
         *        add constraint FK37qnj7e8e7yirilhp1b1vm8nu
         *        foreign key (role_id)
         *        references tbl_role_0302 (id)
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
            /**
             * Hibernate:
             *     insert
             *     into
             *         tbl_role_0302
             *         (name, id)
             *     values
             *         (?, ?)
             * Hibernate:
             *     insert
             *     into
             *         tbl_role_permission_0302
             *         (role_id, description, url)
             *     values
             *         (?, ?, ?)
             * Hibernate:
             *     insert
             *     into
             *         tbl_role_permission_0302
             *         (role_id, description, url)
             *     values
             *         (?, ?, ?)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        System.out.println(role);
        // Role(id=ROLE_ADMIN, name=관리자, permissions=[Permission(url=/admin/members, description=관리자용 회원관리), Permission(url=/admin/roles, description=관리자용 권한관리)])
        // then
        entityManager.clear();

        Role role2 = entityManager.find(Role.class, role.getId());
        /**
         * Hibernate:
         *     select
         *         r1_0.id,
         *         r1_0.name,
         *         p1_0.role_id,
         *         p1_0.description,
         *         p1_0.url
         *     from
         *         tbl_role_0302 r1_0
         *     left join
         *         tbl_role_permission_0302 p1_0
         *             on r1_0.id=p1_0.role_id
         *     where
         *         r1_0.id=?
         */
        System.out.println(role2);
        // Role(id=ROLE_ADMIN, name=관리자, permissions=[Permission(url=/admin/members, description=관리자용 회원관리), Permission(url=/admin/roles, description=관리자용 권한관리)])
        assertThat(role2).isNotNull();
        assertThat(role2.getPermissions()).isNotEmpty();
    }

    @Test
    @DisplayName("Role Entity 수정")
    void test3() {
        // given
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
            /**
             * Hibernate:
             *     insert
             *     into
             *         tbl_role_0302
             *         (name, id)
             *     values
             *         (?, ?)
             * Hibernate:
             *     insert
             *     into
             *         tbl_role_permission_0302
             *         (role_id, description, url)
             *     values
             *         (?, ?, ?)
             * Hibernate:
             *     insert
             *     into
             *         tbl_role_permission_0302
             *         (role_id, description, url)
             *     values
             *         (?, ?, ?)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // when
        Set<Permission> newPermissions = Set.of(new Permission("url", "description"));
        transaction.begin();
        try {
            // permisiion은 일부 수정이 아닌 Set객체 전체를 교체한다.
//            role.setPermissions(newPermissions);
            role.changePermissions(newPermissions);
            System.out.println(System.identityHashCode(role.getPermissions())); // 1471278212

            transaction.commit(); // flush작업 중에 Set<Permission>객체가 대체되었다.
            /**
             * Hibernate:
             *     delete
             *     from
             *         tbl_role_permission_0302
             *     where
             *         role_id=?
             * Hibernate:
             *     insert
             *     into
             *         tbl_role_permission_0302
             *         (role_id, description, url)
             *     values
             *         (?, ?, ?)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        System.out.println(System.identityHashCode(newPermissions)); // 1471278212
        System.out.println(System.identityHashCode(role.getPermissions())); // 1336265843
        // 실제 객체의 주소기준으로 객체의 동일성을 체크한다.
        System.out.println(role.getPermissions().hashCode()); // -1717693910
        System.out.println(newPermissions.hashCode()); // -1717693910
        // hashCode()는 값기준으로 객체의 동일성을 체크한다.
//        assertThat(role.getPermissions()).isSameAs(newPermissions);
    }
}
