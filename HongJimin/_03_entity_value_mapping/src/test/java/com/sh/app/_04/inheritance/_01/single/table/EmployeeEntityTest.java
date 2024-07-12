package com.sh.app._04.inheritance._01.single.table;



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
        /**
         *   create table tbl_employee (
         *         id bigint not null auto_increment, ✨Employee에 선언한 필드
         *         emp_type varchar(31) not null, 🙉Employee 클래스에서 선언한 필드
         *         contact varchar(255), ✨Employee에 선언한 필드
         *         lang varchar(255), 🐸자식 클래스에서 선언한 필드
         *         level varchar(255), 🙉Manager 클래스에서 선언한 필드
         *         name varchar(255), ✨Employee에 선언한 필드
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
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();

        // when
        this.entityManager.persist(developer);
        this.entityManager.persist(manager);
        /**
         * insert
         *     into
         *         tbl_employee
         *         (contact, name, lang, emp_type)
         *     values
         *         (?, ?, ?, 'dev')
         * Hibernate:
         *     insert
         *     into
         *         tbl_employee
         *         (contact, name, level, emp_type)
         *     values
         *         (?, ?, ?, 'manager')
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
        String jpql = "select e from Employee e";
//        String jpql = "select * from Employee"; //jpql에서 이렇게 쓰면 오류남, 별칭써줘야함
        TypedQuery<Employee> query = this.entityManager.createQuery(jpql, Employee.class);
        List<Employee> employees = query.getResultList();
        employees.forEach(System.out::println);

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
