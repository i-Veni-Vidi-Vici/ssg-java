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
        entityManager.getTransaction().begin(); // 트랜잭션 처리를 한 번에 처리할 수 있다.
    }

    @AfterEach
    void tearDown() {
        this.entityManager.close();
        entityManager.getTransaction().commit();
    }

    @AfterAll
    static void afterAll() {
        entityManagerFactory.close();
    }

    @Test
    @DisplayName("ddl-auto=create 확인")
    void test1() {
        /*
        Hibernate:
            create table tbl_developer_0402 (
                id bigint not null,
                lang varchar(255),
                primary key (id)
            ) engine=InnoDB
        Hibernate:
            create table tbl_employee0402 (
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
         */
    }

    @Test
    @DisplayName("Developer/Manager Entity 등록")
    void test2() {
        // given
        Developer developer = new Developer(null, "홍길동", "010-1234-1234", "JAVA");
        Manager manager = new Manager(null, "신사임당", "010-6789-6789", "M3");
        // when
        // 위에서 한 번에 처리할 수 있다.
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();
        this.entityManager.persist(developer);
        this.entityManager.persist(manager);
        /*
        Hibernate:
            insert
            into
                tbl_employee0402
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
                tbl_employee0402
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
        Developer developer = new Developer(null, "홍길동", "010-1234-1234", "JAVA");
        Manager manager = new Manager(null, "신사임당", "010-6789-6789", "M3");
        this.entityManager.persist(developer);
        this.entityManager.persist(manager);
        this.entityManager.flush(); // 변경 사항을 insert쿼리로 날아옴
        // when
        String jpql = "select e from Employee0402 e"; // Class이름이 아닌 Entity이름을 작성해야 한다.
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
                tbl_employee0402 e1_0
            left join
                tbl_developer_0402 e1_1
                    on e1_0.id=e1_1.id
            left join
                tbl_manager_0402 e1_2
                    on e1_0.id=e1_2.id
         */
        employees.forEach(System.out::println);
        // then
        // List - allSatisfy(List의 모든 요소는 다음 단정문을 만족해야 한다.)
        //        Employee - satisfiesAnyOf(Employee 객체는 다음 하나를 만족해야 한다)
        //              Employee객체는 Developer 타입이다.
        //              Employee객체는 Manager 타입이다.
        assertThat(employees).allSatisfy((employee -> assertThat(employee).satisfiesAnyOf(
                (_employee) -> assertThat(_employee).isInstanceOf(Developer.class),
                (_employee) -> assertThat(_employee).isInstanceOf(Manager.class)
        )));
    }
}
