package com.sh._04.inheritance._03.table.per.clazz;


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
        /*
            Hibernate:
                create table tbl_developer_0402 (
                    id bigint not null,
                    lang varchar(255),
                    primary key (id)
                ) engine=InnoDB
            Hibernate:
                create table tbl_employee_0402 (
                    id bigint not null auto_increment,
                    emp_type varchar(31) not null,
                    contact varchar(255),
                    name varchar(255),
                    primary key (id)
                ) engine=InnoDB
            Hibernate:
                create table tbl_manager_0402 (
                    id bigint not null,
                    level varchar(255),
                    primary key (id)
                ) engine=InnoDB
            Hibernate:
                alter table tbl_developer_0402
                   add constraint FKmj9gqcebwhr6rb47vwqrwgk1b
                   foreign key (id)
                   references tbl_employee_0402 (id)
            Hibernate:
                alter table tbl_manager_0402
                   add constraint FKm4hi74o867f82v8nnqnr9yrqq
                   foreign key (id)
                   references tbl_employee_0402 (id)
         */
    }
    
    @Test
    @DisplayName("Developer/Manager Entity 등록")
    void test2() {
        // given
        Developer developer = new Developer(null, "홍길동", "010-1234-1234", "Java");
        Manager manager = new Manager(null, "신사임당", "010-6789-6789", "M3");
        // when
        this.entityManager.persist(developer);
        this.entityManager.persist(manager);
        /*
            Hibernate:
                insert
                into
                    tbl_employee_0402
                    (contact, name, emp_type)
                values
                    (?, ?, 'dev')
            Hibernate:
                insert
                into
                    tbl_developer_0402
                    (lang, id)
                values
                    (?, ?)
            Hibernate:
                insert
                into
                    tbl_employee_0402
                    (contact, name, emp_type)
                values
                    (?, ?, 'manager')
            Hibernate:
                insert
                into
                    tbl_manager_0402
                    (level, id)
                values
                    (?, ?)
         */
        // then
        assertThat(developer.getId()).isNotZero();
        assertThat(manager.getId()).isNotZero();
    }

    @Test
    @DisplayName("Developer/Manager 조회")
    void test3() {
        // given
        Developer developer = new Developer(null, "홍길동", "010-1234-1234", "Java");
        Manager manager = new Manager(null, "신사임당", "010-6789-6789", "M3");
        this.entityManager.persist(developer);
        this.entityManager.persist(manager);
        this.entityManager.flush();
        // when
        String jpql = "select e from Employee e";
        TypedQuery<Employee> query = this.entityManager.createQuery(jpql, Employee.class);
        List<Employee> employees = query.getResultList();
        employees.forEach(System.out::println);
        // then
        // List - allSatisfy(List의 모든 요소는 다음 단정문을 만족해야 한다.)
        //          Employee - satisfiesAnyOf(Employee객체는 다음 하나는 만족해야 한다.)
        //                 Employee객체는 Developer 타입이다.
        //                 Employee객체는 Manager 타입이다.
        assertThat(employees).allSatisfy(
                employee -> assertThat(employee).satisfiesAnyOf(
                        (_employee) -> assertThat(_employee).isInstanceOf(Developer.class),
                        (_employee) -> assertThat(_employee).isInstanceOf(Manager.class)
        ));
    }
}
