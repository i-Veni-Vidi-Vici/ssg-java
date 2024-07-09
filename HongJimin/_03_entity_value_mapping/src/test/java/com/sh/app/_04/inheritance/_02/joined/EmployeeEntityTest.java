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
        /**
         *  Hibernate: 🙉자식 Developer 클래스
         *  create table tbl_developer_0402 (
         *         id bigint not null,
         *         lang varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         *
         * Hibernate: 🙉부모 Employee 클래스
         *     create table tbl_employee_0402 (
         *         id bigint not null auto_increment, ✨이 아이디 값을 alter문을 통해 fk로 참조하고 이쑹ㅁ
         *         emp_type varchar(31) not null,
         *         contact varchar(255),
         *         name varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         * Hibernate: 🙉자식 Manager 클래스
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
    @DisplayName("Developer/Manager Entity 등록")
    void test2() {
        // given
        Developer developer = new Developer(null, "홍길동", "010-1234-1234", "java");
        Manager manager = new Manager(null, "신사임당", "010-6789-6789", "M3");
        // when 이부분 @BeforeEach @AfterEach
//        EntityTransaction transaction = entityManager.getTransaction();
//        transaction.begin();

        this.entityManager.persist(developer);
        this.entityManager.persist(manager);

        /**
         *     🙉 id - autoincrement 처리 🙉
         *     insert
         *     into
         *         tbl_employee_0402
         *         (contact, name, emp_type)
         *     values
         *         (?, ?, 'dev') ✨여기서 발급받은 아이디를
         *
         * Hibernate:
         *     insert
         *     into
         *         tbl_developer_0402
         *         (lang, id) ✨여기서 사용
         *     values
         *         (?, ?)
         *  🙉 id - autoincrement 처리 🙉
         * Hibernate:
         *     insert
         *     into
         *         tbl_employee_0402
         *         (contact, name, emp_type)
         *     values
         *         (?, ?, 'manager') ✨여기서 발급받은 아이디를
         * Hibernate:
         *     insert
         *     into
         *         tbl_manager_0402
         *         (level, id) ✨여기서 사용
         *     values
         *         (?, ?)
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
        // when


        this.entityManager.persist(developer);
        this.entityManager.persist(manager);
        this.entityManager.flush();

        // when
        String jpql = "select e from Employee0402 e"; // Class 이름이 아닌 Entity 이름을 작성
//        String jpql = "select * from Employee"; //jpql에서 이렇게 쓰면 오류남, 별칭써줘야함
        TypedQuery<Employee> query = this.entityManager.createQuery(jpql, Employee.class);
        List<Employee> employees = query.getResultList();

        /**
         * select
         *         e1_0.id,
         *         e1_0.emp_type,
         *         e1_0.contact,
         *         e1_0.name,
         *         e1_1.lang,
         *         e1_2.level
         *     from
         *         tbl_employee_0402 e1_0
         *     left join
         *         tbl_developer_0402 e1_1
         *             on e1_0.id=e1_1.id
         *     left join
         *         tbl_manager_0402 e1_2
         *             on e1_0.id=e1_2.id
         */
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
