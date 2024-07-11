package com.sh.app._03.element.collection._01.set._01.auth;

import com.sh.app._02.embeddable._03.attribute.override.Address;
import com.sh.app._02.embeddable._03.attribute.override.User;
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
         *     create table tbl_role_0301 (
         *         id varchar(255) not null,
         *         name varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_role_permission_0301 (
         *         permission varchar(255),
         *         role_id varchar(255) not null
         *     ) engine=InnoDB
         *
         * Hibernate:
         *     alter table tbl_role_permission_0301
         *        add constraint FKtnx1qruioxk7914798vcf8uup
         *        foreign key (role_id)
         *        references tbl_role_0301 (id)
         */
    }

    @Test
    @DisplayName("Role Entity 등록 - fetch = FetchType.LAZY")
    void test2() {
        Role role = Role.builder()
                .id("ROLE_ADMIN")
                .name("관리자")
                .permissions(Set.of("/admin/members", "/admin/members/update/*"))
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
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_role_0301
         *         (name, id)
         *     values
         *         (?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_role_permission_0301
         *         (role_id, permission)
         *     values
         *         (?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_role_permission_0301
         *         (role_id, permission)
         *     values
         *         (?, ?)
         */

        entityManager.detach(role);

        Role role2 = entityManager.find(Role.class, role.getId());
        /**
         * Hibernate:
         *     select
         *         r1_0.id,
         *         r1_0.name
         *     from
         *         tbl_role_0301 r1_0
         *     where
         *         r1_0.id=?
         */
        System.out.println(role2.getName()); // 관리자. role2.toString() 호출 -> permissions.toString() 호출
        /**
         * Hibernate:
         *     select
         *         p1_0.role_id,
         *         p1_0.permission
         *     from
         *         tbl_role_permission_0301 p1_0
         *     where
         *         p1_0.role_id=?
         * [/admin/members, /admin/members/update/*]
         */
        // Permission이 실제 필요하므로 이 코드 바로 전에 select쿼리를 날린다
        System.out.println(role2.getPermissions()); // [/admin/members, /admin/members/update/*]


        assertThat(role2).isNotNull();
        assertThat(role2.getPermissions()).isNotEmpty();

    }

    @Test
    @DisplayName("Role Entity 등록 - fetch = FetchType.EAGER")
    void test3() {
        Role role = Role.builder()
                .id("ROLE_ADMIN")
                .name("매니저")
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
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_role_0301
         *         (name, id)
         *     values
         *         (?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_role_permission_0301
         *         (role_id, permission)
         *     values
         *         (?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_role_permission_0301
         *         (role_id, permission)
         *     values
         *         (?, ?)
         */

        entityManager.detach(role);

        Role role2 = entityManager.find(Role.class, role.getId()); // .eager는 find에서 바로 select
        /**
         * Hibernate:
         *     select
         *         r1_0.id,
         *         r1_0.name,
         *         p1_0.role_id,
         *         p1_0.permission
         *     from
         *         tbl_role_0301 r1_0
         *     left join
         *         tbl_role_permission_0301 p1_0
         *             on r1_0.id=p1_0.role_id
         *     where
         *         r1_0.id=?
         */
        System.out.println(role2.getName()); // 매니저. role2.toString() -> permissions.toString()
        System.out.println(role2.getPermissions()); // [/manager/stat, /manager/members]
        assertThat(role2).isNotNull();
        assertThat(role2.getPermissions()).isNotEmpty();

    }

    @Test
    @DisplayName("Role Entity 수정")
    void test4() {
        // given
        Role role = Role.builder()
                .id("ROLE_ADMIN")
                .name("매니저")
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
            // permisiion은 일부 수정이 아닌 Set객체 전체를 교체한다.
            Set<String> newPermissions = Set.of("/manager/members", "/manager/products");
//            role.setPermissions(newPermissions);
            role.changePermissions(newPermissions); // 외부에서 set을 못하므로 Role클래스에 set을 대신한 메소드를 사용한다
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        // tbl_role_permission_0301 테이블에서 ROLE_MANAGER 관련 행을 모두 삭제 후에 다시 insert한다.
        /**
         * Hibernate:
         *     delete
         *     from
         *         tbl_role_permission_0301
         *     where
         *         role_id=?
         * Hibernate:
         *     insert
         *     into
         *         tbl_role_permission_0301
         *         (role_id, permission)
         *     values
         *         (?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_role_permission_0301
         *         (role_id, permission)
         *     values
         *         (?, ?)
         */
        entityManager.detach(role);

        Role role2 = entityManager.find(Role.class, role.getId());
        /**
         * Hibernate:
         *     select
         *         r1_0.id,
         *         r1_0.name,
         *         p1_0.role_id,
         *         p1_0.permission
         *     from
         *         tbl_role_0301 r1_0
         *     left join
         *         tbl_role_permission_0301 p1_0
         *             on r1_0.id=p1_0.role_id
         *     where
         *         r1_0.id=?
         */

        System.out.println(role2.getName()); // role2.toString() -> permissions.toString()
        // 매니저
        System.out.println(role2.getPermissions());
        // [/manager/products, /manager/members]
        assertThat(role2).isNotNull();
        assertThat(role2.getPermissions()).isNotEmpty();

    }
}