package com.sh.app._06.composite.primary.key._01.embbededid;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfessorClazzEntityTest {

    private static EntityManagerFactory entityManagerFactory;
    // request-scope: 웹 요청마다 1개씩 생성 (non-thread-safe)
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        // jpa 설정정보를 읽어서 EntityManagerFactory를 생성
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
        // given
        // when
        // then
        //  create table tbl_professor_clazz (
        //        clazz_id bigint not null,
        //        professor_id bigint not null,
        //        classroom enum ('A','B','C'),
        //        primary key (clazz_id, professor_id)
        //    ) engine=InnoDB
    }

    @Test
    @DisplayName("복합키를 사용한 엔티티 등록")
    void test2() {
        // given
        ProfessorClazzId professorClazzId = new ProfessorClazzId(100L, 200L);
        ProfessorClazz professorClazz = new ProfessorClazz(professorClazzId, Classroom.A);
        System.out.println(professorClazz);

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try{
            entityManager.persist(professorClazz);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        entityManager.clear();
        ProfessorClazz professorClazz2 = entityManager.find(ProfessorClazz.class, professorClazz.getId());
        System.out.println();
        assertThat(professorClazz2).isNotNull();
    }
}
