package com.sh.app._05.aggregate.association;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Student2DepartmentTest {
    // application-scope: 1개만 만들어서 재사용 (thread-safe)
    private static EntityManagerFactory entityManagerFactory;
    // request-scope: 웹요청마다 1개씩 생성 (non-thread-safe)
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        // jpa설정정보를 읽어서 EntityManagerFactory를 생성
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
            create table tbl_department (
                capacity integer not null,
                id bigint not null auto_increment,
                name varchar(255),
                primary key (id)
            ) engine=InnoDB

            create table tbl_student (
                department_id bigint,
                id bigint not null auto_increment,
                address1 varchar(255),
                address2 varchar(255),
                name varchar(255),
                zipCode varchar(255),
                primary key (id)
            ) engine=InnoDB
         */
    }

    @Test
    @DisplayName("Student Entity 등록")
    void test2() {
        // given
        Department department = new Department(null, "컴퓨터 공학과", 30);
        this.entityManager.persist(department);
        /*
            insert
            into
                tbl_department
                (capacity, name)
            values
                (?, ?)
         */
        // when
        Student student = new Student(null, "홍길동", department.getId(), new Address("서울시 강남구", "삼성동 1234", "01234"));
        this.entityManager.persist(student);
        /*
            insert
            into
                tbl_student
                (address1, address2, zipCode, department_id, name)
            values
                (?, ?, ?, ?, ?)
         */
        // then
        assertThat(student.getId()).isNotNull();
        assertThat(student.getDepartmentId()).isEqualTo(department.getId());
    }
}
