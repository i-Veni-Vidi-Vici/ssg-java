package com.sh.app._04.ingeritance._02.joined;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeEntityTest {
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
         * Hibernate:
         *     create table tbl_developer_0402 (
         *         id bigint not null,
         *         lang varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_employee_0402 (
         *         id bigint not null auto_increment,
         *         emp_type varchar(31) not null,
         *         contact varchar(255),
         *         name varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_manager_0402 (
         *         id bigint not null,
         *         level varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         * Hibernate:
         *     alter table tbl_developer_0402
         *        add constraint FKmj9gqcebwhr6rb47vwqrwgk1b
         *        foreign key (id)
         *        references tbl_employee_0402 (id)
         * Hibernate:
         *     alter table tbl_manager_0402
         *        add constraint FKm4hi74o867f82v8nnqnr9yrqq
         *        foreign key (id)
         *        references tbl_employee_0402 (id)
         */
    }

    @Test
    @DisplayName("Delveloper/Manager Entity 등록")
    void test2() {
        // given
        Developer developer = new Developer(null, "홍길동", "010-2134-1234", "JAVA");
        Manager manager = new Manager(null, "신사임당", "010-6487-7897", "M3");
        // when
        this.entityManager.persist(developer);
        this.entityManager.persist(manager);
        // then
        assertThat(developer.getId()).isNotZero();
        assertThat(manager.getId()).isNotZero();
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_employee_0402
         *         (contact, name, emp_type)
         *     values
         *         (?, ?, 'dev')
         * Hibernate:
         *     insert
         *     into
         *         tbl_developer_0402
         *         (lang, id) -- 여기는 value로써 id를 처리한다.
         *     values
         *         (?, ?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_employee_0402
         *         (contact, name, emp_type)
         *     values
         *         (?, ?, 'manager')
         * Hibernate:
         *     insert
         *     into
         *         tbl_manager_0402
         *         (level, id)
         *     values
         *         (?, ?)
         */
    }

    @Test
    @DisplayName("Developer/Manager 조회")
    void test3() {
        // given
        Developer developer = new Developer(null, "홍길동", "010-2134-1234", "JAVA");
        Manager manager = new Manager(null, "신사임당", "010-6487-7897", "M3");
        this.entityManager.persist(developer);
        this.entityManager.persist(manager);
        this.entityManager.flush();
        // when
        String jpql = "select e from Employee0402 e";
        TypedQuery<Employee> query = this.entityManager.createQuery(jpql, Employee.class); // 부모타입의 쿼리를 주었다!
        List<Employee> employees = query.getResultList();
        employees.forEach(System.out::println);
        // then
        // List - allSatisfy(List의 모든 요소는 다음 단정문을 만족해야 한다.)
        //          Employee - satisfiesAnyOf(Employee객체는 다음 중 하나는 만족해야 한다.)
        //                 Employee객체는 Developer 타입이다.
        //                 Employee객체는 Manager 타입이다.

        assertThat(employees).allSatisfy((employee -> assertThat(employee).satisfiesAnyOf(
                (_employee) -> assertThat(_employee).isInstanceOf(Developer.class),
                (_employee) -> assertThat(_employee).isInstanceOf(Manager.class)
        )));
        /**
         * Hibernate:
         *     select
         *         e1_0.id,
         *         e1_0.emp_type,
         *         e1_0.contact,
         *         e1_0.name,
         *         e1_0.lang,
         *         e1_0.level
         *     from
         *         tbl_employee e1_0
         * Developer(lang=JAVA)
         * Manager(level=M3)
         */
        // @ToString(callSuper = true)
        /**
         * Developer(super=Employee(id=1, name=홍길동, contact=010-2134-1234), lang=JAVA)
         * Manager(super=Employee(id=2, name=신사임당, contact=010-6487-7897), level=M3)
         */
    }
}