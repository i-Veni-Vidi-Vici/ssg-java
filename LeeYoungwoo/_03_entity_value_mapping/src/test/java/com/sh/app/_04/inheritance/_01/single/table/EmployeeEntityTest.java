package com.sh.app._04.inheritance._01.single.table;


import com.sh.app._03.element.collection._01.set._02.auth.embeddable.Permission;
import com.sh.app._03.element.collection._01.set._02.auth.embeddable.Role;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Set;

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
        this.entityManager.close();
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
            create table tbl_employee (
                id bigint not null auto_increment,
                emp_type varchar(31) not null,
                contact varchar(255),
                lang varchar(255),
                level varchar(255),
                name varchar(255),
                primary key (id)
            ) engine=InnoDB
         */
    }

    @Test
    @DisplayName("Developer/Manager Entity 등록")
    void test2() {
        // given
        Developer developer = new Developer(null,"홍길동", "010-1234-1234", "Java");
        Manager manager = new Manager(null,"신사임당", "010-6789-6789", "M3");

        // when
        this.entityManager.persist(developer);
        this.entityManager.persist(manager);
        /*
            insert
            into
                tbl_employee
                (contact, name, lang, emp_type)
            values
                (?, ?, ?, 'dev')

            insert
            into
                tbl_employee
                (contact, name, level, emp_type)
            values
                (?, ?, ?, 'manager')
         */

        // then
        assertThat(developer.getId()).isNotZero();
        assertThat(manager.getId()).isNotZero();
    }

    @Test
    @DisplayName("Developer/Manager 조회")
    void test3() {
        // given
        Developer developer = new Developer(null,"홍길동", "010-1234-1234", "Java");
        Manager manager = new Manager(null,"신사임당", "010-6789-6789", "M3");
        this.entityManager.persist(developer);
        this.entityManager.persist(manager);
        this.entityManager.flush();
        // when
        String jpql = "select e from Employee  e"; // jpql 문법(from절에 별칭 붙히고 select문에 그거 쓰기)
        TypedQuery<Employee> query = this.entityManager.createQuery(jpql, Employee.class);
        List<Employee> employees = query.getResultList();
        employees.forEach(System.out::println);
        /*
            select
                e1_0.id,
                e1_0.emp_type,
                e1_0.contact,
                e1_0.name,
                e1_0.lang,
                e1_0.level
            from
                tbl_employee e1_0

            Developer(super=Employee(id=1, name=홍길동, contact=010-1234-1234), lang=Java)
            Manager(super=Employee(id=2, name=신사임당, contact=010-6789-6789), level=M3)
         */

        // then
        // List - allSatisfy(List의 모든 요소는 다음 단정문을 만족해야 한다.)
        //         Employee - satisfiesAnyOf(Employee 객체는 다음 하나는 만족해야 한다.)
        //                  Employee 객체는 Developer 타입이다.
        //                  Employee 객체는 Manager 타입이다.
        assertThat(employees).allSatisfy(
                employee -> assertThat(employee).satisfiesAnyOf(
                        (_employee) -> assertThat(_employee).isInstanceOf(Developer.class),
                        (_employee) -> assertThat(_employee).isInstanceOf(Manager.class)
        ));
    }
}
