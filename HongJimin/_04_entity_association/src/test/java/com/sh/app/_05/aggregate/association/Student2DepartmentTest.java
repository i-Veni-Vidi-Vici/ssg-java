package com.sh.app._05.aggregate.association;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;


public class Student2DepartmentTest { // Department2Student도 가능함!
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
         * Hibernate:
         *     create table tbl_department (
         *         capacity integer not null,
         *         id bigint not null auto_increment,
         *         name varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         *
         * Hibernate:
         *     create table tbl_student (
         *         department_id bigint,
         *         id bigint not null auto_increment,
         *         address1 varchar(255),
         *         address2 varchar(255),
         *         name varchar(255),
         *         zipCode varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         */
    }

    @Test
    @DisplayName("Student Entity 등록")
    void test2() {
        // given
        Department department = new Department(null, "컴퓨터 공학과", 30);
        this.entityManager.persist(department);
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_department
         *         (capacity, name)
         *     values
         *         (?, ?)
         */

        // when
        Student student = new Student(null, "홍길동", department.getId(),
                new Address("서울시 강남구", "삼성동 1234", "01234"));
        this.entityManager.persist(student);
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_student
         *         (address1, address2, zipCode, department_id, name)
         *     values
         *         (?, ?, ?, ?, ?)
         */

        // then
        assertThat(student.getId()).isNotNull();
        assertThat(student.getDepartmentId()).isEqualTo(department.getId());
    }
}
