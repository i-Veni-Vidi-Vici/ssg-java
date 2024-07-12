package com.sh.app._04.inheritance._03.element.table.per.clazz;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class EmployeeEntityTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    void setUp() {
        this.entityManager = entityManagerFactory.createEntityManager();
        this.entityManager.getTransaction().begin();
    }

    @AfterEach
    void tearDown() {
        this.entityManager.getTransaction().commit();
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
         * ✨ 채번용 테이블✨
         *  create table hibernate_sequences (
         *         next_val bigint,
         *         sequence_name varchar(255) not null,
         *         primary key (sequence_name)
         *     ) engine=InnoDB
         * Hibernate:
         *     insert into hibernate_sequences(sequence_name, next_val) values ('default',0)
         * Hibernate:
         *     create table tbl_developer_0403 (
         *         ✨id bigint not null,
         *         ✨contact varchar(255),
         *         🙉lang varchar(255),
         *         ✨name varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_manager_0403 (
         *         ✨id bigint not null,
         *         ✨contact varchar(255),
         *         🙉level varchar(255),
         *         ✨name varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         */

    }

    @Test
    @DisplayName("Developer/Manager Entity 등록")
    void test2() {
        // given
        Developer developer = new Developer(null, "홍길동", "010-1234-1234", "java");
        Manager manager = new Manager(null, "신사임당", "010-6789-6789", "M3");
        // when 이부분 @BeforeEach @AfterEach
        this.entityManager.persist(developer);
        this.entityManager.persist(manager);

        /**
         *     select
         *         tbl.next_val
         *     from
         *         hibernate_sequences tbl
         *     where
         *         tbl.sequence_name=? for update
         * Hibernate:
         *     update
         *         hibernate_sequences
         *     set
         *         next_val=?
         *     where
         *         next_val=?
         *         and sequence_name=?
         *   Hibernate:
         *       select
         *           tbl.next_val
         *       from
         *           hibernate_sequences tbl
         *       where
         *           tbl.sequence_name=? for update
         *  Hibernate:
         *       update
         *           hibernate_sequences
         *       set
         *           next_val=?
         *       where
         *            next_val=?
         *            and sequence_name=?
         * Hibernate:
         *     insert
         *     into
         *         tbl_developer_0403
         *         (contact, name, lang, id)
         *     values
         *         (?, ?, ?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_manager_0403
         *         (contact, name, level, id)
         *     values
         *         (?, ?, ?, ?)
         */
        // then
        assertThat(developer.getId()).isNotZero();
        assertThat(manager.getId()).isNotZero();
    }

    @Test
    @DisplayName("Developer/Manager 조회")
    void test3() {
        // given
        Developer developer = new Developer(null, "홍길동", "010-1234-1234", "java");
        Manager manager = new Manager(null, "신사임당", "010-6789-6789", "M3");
        this.entityManager.persist(developer);
        this.entityManager.persist(manager);
        this.entityManager.flush();

        // when
        String jpql = "select e from Employee0403 e"; // 🙉이름 주의하기!
        TypedQuery<Employee> query = this.entityManager.createQuery(jpql, Employee.class);
        List<Employee> employees = query.getResultList();
        employees.forEach(System.out::println);
        /**
         * ✨테이블이 두개가 나옴!
         * - 자바에서 제공했던 ID, name, context를 다 갖고 있움
         *  select
         *         e1_0.id,
         *         e1_0.clazz_, ✨존재하지도 않는 컬럼값 -> 누구는 디벨로퍼, 누구는 매니저로 구분하는 구분자로
         *         e1_0.contact,
         *         e1_0.name,
         *         e1_0.lang,
         *         e1_0.level
         *     from
         *         (select
         *             id,
         *             contact,
         *             lang,
         *             name,
         *             null as level,
         *             1 as clazz_
         *         from
         *             🙉tbl_developer_0403
         *         union
         *         all select
         *             id,
         *             contact,
         *             null as lang,
         *             name,
         *             level,
         *             2 as clazz_
         *         from
         *             🙉tbl_manager_0403
         *     ) e1_0
         */

        // then
        // List - allSatisfy(List의 모든 요소는 다음 단정문을 만족해야 한다.)
        //          Employee - satisfiesAnyOf(Employee객체는 다음 하나는 만족해야 한다.)
        //                  Employee객체는 Developer 타입이다
        //                  Employee객체는 Manager 타입이다
        assertThat(employees).allSatisfy((employee -> assertThat(employee).satisfiesAnyOf(
                (_employee) -> assertThat(_employee).isInstanceOf(Developer.class),
                (_employee) -> assertThat(_employee).isInstanceOf(Manager.class)
        )));
    }
}
