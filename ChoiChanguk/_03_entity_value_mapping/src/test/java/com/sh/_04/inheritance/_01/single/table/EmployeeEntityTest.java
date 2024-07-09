package com.sh._04.inheritance._01.single.table;


import com.sh._03.element.collection._03.map._02.setting.embeddable.PropValue;
import com.sh._03.element.collection._03.map._02.setting.embeddable.UserSetting;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setMaxStackTraceElementsDisplayed;

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
    @DisplayName("Developer/Manger Entity 등록")
    void test2() {
        Developer developer=new Developer(null,"홍길동","010-1234-1234","JAVA");
        Manager manager=new Manager(null,"신사임당","010-6578-6578","M3");

        this.entityManager.persist(developer);
        this.entityManager.persist(manager);

        //

        assertThat(developer.getId()).isNotZero();
        assertThat(manager.getId()).isNotZero();

    }

    @Test
    @DisplayName("Developer/Manger Entity 등록")
    void test3() {
        Developer developer=new Developer(null,"홍길동","010-1234-1234","JAVA");
        Manager manager=new Manager(null,"신사임당","010-6578-6578","M3");

        this.entityManager.persist(developer);
        this.entityManager.persist(manager);

        this.entityManager.flush(); //

        String jpql="select e from Employee e"; // 이건 별칭을 써야지 에러가 안남,  select * 에서, * 이걸 못알아먹음
        TypedQuery<Employee> query=this.entityManager.createQuery(jpql,Employee.class);
        List<Employee> employees = query.getResultList();
        employees.forEach(System.out::println);
    }
}
