package com.sh.app._04.persist.cascade;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Club2StudentTest {
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
            Hibernate:
                create table tbl_student (
                    club_id bigint,
                    id bigint not null auto_increment,
                    name varchar(255),
                    primary key (id)
                ) engine=InnoDB
            Hibernate:
                create table tbl_club (
                    id bigint not null auto_increment,
                    name varchar(255),
                    primary key (id)
                ) engine=InnoDB
            Hibernate:
                alter table tbl_student
                   add constraint FKg28pk9odj1ft4fhxc78nn819i
                   foreign key (club_id)
                   references tbl_club (id)
         */
    }
    
    @Test
    @DisplayName("Club 등록시 Student도 등록처리")
    void test2() {
        // given
        Set<Student> students = Set.of(
            new Student(null, "홍길동"),
            new Student(null, "신사임당"),
            new Student(null, "이순신")
        );
        Club club = new Club(null, "우리동네 코딩방", students);
        // when
        this.entityManager.persist(club);
        this.entityManager.flush();
        System.out.println(club);
        // then
        assertThat(club.getId()).isNotZero();
        assertThat(club.getStudents()).allMatch((student) -> student.getId() != null);
    }
}
