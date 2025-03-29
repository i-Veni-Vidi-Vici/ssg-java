package com.sh.app._06.composite.key._02.idclass;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfessorClazzEntityTest {
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
    }

    @AfterEach
    void tearDown() {
        this.entityManager.close();
    }

    @AfterAll
    static void afterAll() {
        entityManagerFactory.close();
    }

    @Test
    @DisplayName("ddl-auto=create 확인")
    void test1() {
        /**
             create table tbl_professor_clazz (
             clazzId bigint not null,
             professorId bigint not null,
             classroom enum ('A','B','C'),
             primary key (clazzId, professorId) // 복합키
             ) engine=InnoDB
         */

    }

    @Test
    @DisplayName("복합키를 사용한 엔티티 등록")
    void test2() {
        //given
        ProfessorClazz professorClazz=new ProfessorClazz(100L,200L, Classroom.A);

        //when
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();

        try{
            entityManager.persist(professorClazz);
            transaction.commit();
        }catch (Exception e)
        {
            transaction.rollback();
            e.printStackTrace();
        }

        entityManager.clear();
        ProfessorClazz professorClazz1=entityManager.find(ProfessorClazz.class,new ProfessorClazzId(100L,200L));

    }

}
