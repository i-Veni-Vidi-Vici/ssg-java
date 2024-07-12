package com.sh.app._04.inheritance._02.joined;



import jakarta.persistence.*;
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
            create table tbl_developer_0402 (
                id bigint not null,
                lang varchar(255),
                primary key (id)
            ) engine=InnoDB

            create table tbl_employee_0402 (
                id bigint not null auto_increment,
                emp_type varchar(31) not null,
                contact varchar(255),
                name varchar(255),
                primary key (id)
            ) engine=InnoDB

            create table tbl_manager_0402 (
                id bigint not null,
                level varchar(255),
                primary key (id)
            ) engine=InnoDB
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
        String jpql = "select e from Employee0402 e"; // Class이름이 아닌 Entity이름을 작성
        TypedQuery<Employee> query = this.entityManager.createQuery(jpql, Employee.class);
        List<Employee> employees = query.getResultList();
        /*
            select
                e1_0.id,
                e1_0.emp_type,
                e1_0.contact,
                e1_0.name,
                e1_1.lang,
                e1_2.level
            from
                tbl_employee_0402 e1_0
            left join
                tbl_developer_0402 e1_1
                    on e1_0.id=e1_1.id
            left join
                tbl_manager_0402 e1_2
                    on e1_0.id=e1_2.id
         */
        employees.forEach(System.out::println);
        // then
        assertThat(employees).allSatisfy(
                employee -> assertThat(employee).satisfiesAnyOf(
                        (_employee) -> assertThat(_employee).isInstanceOf(Developer.class),
                        (_employee) -> assertThat(_employee).isInstanceOf(Manager.class)
                ));
    }
}
