package com.sh.app._04.inheritance._01.single.table;


import com.sh.app._03.element.collection._03.map._02.setting.embeddable.PropValue;
import com.sh.app._03.element.collection._03.map._02.setting.embeddable.UserSetting;
import jakarta.persistence.*;
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
        Developer developer = new Developer(null, "홍길동", "010-1234-1234", "Java");
        Manager manager = new Manager(null, "신사임당", "010-6789-6789", "M3");
        // when
        this.entityManager.persist(developer);
        this.entityManager.persist(manager);
        /*
        developer 엔티티
        Hibernate:
            insert
            into
                tbl_employee
                (contact, name, lang, emp_type)
            values
                (?, ?, ?, 'dev')

        Manager엔티티
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
        this.entityManager.flush(); // select쿼리 날아감
        // when
        String jpql = "select e from Employee e";
        TypedQuery<Employee> query = this.entityManager.createQuery(jpql, Employee.class); // TypedQuery 객체 생성
        List<Employee> employees = query.getResultList(); // 쿼리 결과가 여러건이여서 List로 받는다
        employees.forEach(System.out::println);
//        Developer(super=Employee(id=1, name=홍길동, contact=010-1234-1234), lang=Java)
//        Manager(super=Employee(id=2, name=신사임당, contact=010-6789-6789), level=M3)
        /**
         then
         List - allSatisfy(List의 모든 요소는 다음 단정문을 만족해야 한다.)
                  Employee - satisfiesAnyOf(Employee객체는 다음 둘 중 하나는 만족해야 한다.)
                         1. Employee객체는 Developer 타입이다.
                         2. Employee객체는 Manager 타입이다.
         */
//        assertThat(employees).allSatisfy(
//                employee -> assertThat(employee).satisfiesAnyOf(
//                        (_employee) -> assertThat(_employee).isInstanceOf(Developer.class),
//                        (_employee) -> assertThat(_employee).isInstanceOf(Manager.class)
//                ));
    }
}