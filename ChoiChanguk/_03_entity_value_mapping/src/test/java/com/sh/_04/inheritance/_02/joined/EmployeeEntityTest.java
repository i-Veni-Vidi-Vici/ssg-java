package com.sh._04.inheritance._02.joined;



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
                tbl_employee
                (contact, name, lang, emp_type)
            values
                (?, ?, ?, 'dev')
        Hibernate:
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
        Developer developer = new Developer(null, "홍길동", "010-1234-1234", "Java");
        Manager manager = new Manager(null, "신사임당", "010-6789-6789", "M3");
        this.entityManager.persist(developer);
        this.entityManager.persist(manager);
        this.entityManager.flush();
        // when
        String jpql = "select e from Employee0402 e"; // Entity이름을 작성
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
