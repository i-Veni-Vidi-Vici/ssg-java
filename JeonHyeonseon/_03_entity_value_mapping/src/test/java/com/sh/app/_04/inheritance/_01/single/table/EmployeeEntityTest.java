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
            create table tbl_employee (
                id bigint not null auto_increment,
                emp_type varchar(31) not null, // 자식 클래스를 구분하기 위해서 부모 클래스에서 사용됨
                contact varchar(255),
                lang varchar(255), // developer 자식클래스에서 선언한 필드
                level varchar(255), // manager 자식클래스에서 선언한 필드
                name varchar(255),
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
        Developer developer = new Developer(null, "홍길동", "010-1234-1234", "JAVA");
        Manager manager = new Manager(null, "신사임당", "010-6789-6789", "M3");
        this.entityManager.persist(developer);
        this.entityManager.persist(manager);
        this.entityManager.flush(); // 변경 사항을 insert쿼리로 날아옴
        // when
        String jpql = "select e from Employee e"; // jpql에서는 *를 사용하지 않고 별칭을 사용해야 한다. *를 사용하게 되면 오류 발생한다
        TypedQuery<Employee> query = this.entityManager.createQuery(jpql, Employee.class);
        List<Employee> employees = query.getResultList();
        employees.forEach(System.out::println);
        /*
        Hibernate:
            select
                e1_0.id,
                e1_0.emp_type,
                e1_0.contact,
                e1_0.name,
                e1_0.lang,
                e1_0.level
            from
                tbl_employee e1_0
        Developer(super=Employee(id=1, name=홍길동, contact=010-1234-1234), lang=JAVA)
        Manager(super=Employee(id=2, name=신사임당, contact=010-6789-6789), level=M3)
         */
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
