package com.sh.app._04.inheritance._01.single.table;


import com.sh.app._03.element.collection._03.map._01.setting.UserSetting;
import jakarta.persistence.*;
import jakarta.transaction.Transaction;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

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
         * Hibernate:
         *     create table tbl_employee (
         *         id bigint not null auto_increment,
         *         emp_type varchar(31) not null,
         *         contact varchar(255),
         *         lang varchar(255),
         *         level varchar(255),
         *         name varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         */
    }

    @DisplayName("Developer/Manager Entity 등록")
    @Test
    public void test2() {
        //given
        Developer developer = new Developer(null, "홍길동", "010-1234-1234", "Java");
        Manager manager = new Manager(null, "신사임당", "010-5252-8282", "L5");
        //when
        this.entityManager.persist(developer);
        this.entityManager.persist(manager);
        //then
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_employee
         *         (contact, name, lang, emp_type)
         *     values
         *         (?, ?, ?, 'dev')
         *
         * Hibernate:
         *     insert
         *     into
         *         tbl_employee
         *         (contact, name, level, emp_type)
         *     values
         *         (?, ?, ?, 'manager')
         */
        assertThat(developer.getId()).isNotZero();
        assertThat(manager.getId()).isNotZero();
    }


    @DisplayName("Developer/Manager 조회")
    @Test
    public void test3() {
        //given
        Developer developer = new Developer(null, "홍길동", "010-1234-1234", "Java");
        Manager manager = new Manager(null, "신사임당", "010-5252-8282", "L5");
        this.entityManager.persist(developer);
        this.entityManager.persist(manager);
        this.entityManager.flush();
        //when
        String jpql = "select e from Employee e";
        TypedQuery<Employee> query = this.entityManager.createQuery(jpql, Employee.class);
        List<Employee> employees = query.getResultList();
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
         */

        /**
         * Developer(super=Employee(id=1, name=홍길동, contact=010-1234-1234), lang=Java)
         * Manager(super=Employee(id=2, name=신사임당, contact=010-5252-8282), level=L5)
         */
        employees.forEach(System.out::println);
        //then
        assertThat(employees).isNotEmpty().allSatisfy((employee -> assertThat(employee).satisfiesAnyOf(
                (_employee) -> assertThat(_employee).isInstanceOf(Developer.class),
                (_employee) -> assertThat(_employee).isInstanceOf(Manager.class)
        )));
    }
}