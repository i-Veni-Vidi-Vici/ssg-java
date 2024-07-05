package com.sh.app._06._composite.primary.key._02.idclass;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProfessorClazzEntityTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        // jpa 설정 정볼르 읽어서 EntityManagerFactory를 생성
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    // 각 테스트 전
    @BeforeEach
    void setUp() {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    // 각 테스트 후
    @AfterEach
    void tearDown() {
        this.entityManager.close();
    }

    @AfterAll
    static void afterAll() {
        entityManagerFactory.close(); // 자원 반납
    }

    @Test
    @DisplayName("ddl - auto = create 확인")
    void test1() {
        /**
         *     create table tbl_professor_clazz0602 (
         *         clazz_id bigint not null,
         *         professor_id bigint not null,
         *         classroom enum ('A','B','C'),
         *         primary key (clazz_id, professor_id)
         *     ) engine=InnoDB
         */

    }
    @Test
    @DisplayName("복합키를 사용한 엔티티 등록")
    void test2() {

        // given
        ProfessorClazz professorClazz = new ProfessorClazz(100L, 200L, Classroom.A);
        System.out.println(professorClazz);

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(professorClazz);
            transaction.commit();
            /**
             *    insert
             *     into
             *         tbl_professor_clazz0602
             *         (classroom, clazz_id, professor_id)
             *     values
             *         (?, ?, ?)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        entityManager.clear(); // 영속성 컨텍스트 정리
        ProfessorClazz professorClazz2 = entityManager.find(ProfessorClazz.class, new ProfessorClazzId(100L, 200L)); // 값을 줄 때는 따로 주고, 조회할 때는 한번에 같이 줌
        /**
         select
             pc1_0.clazz_id,
             pc1_0.professor_id,
             pc1_0.classroom
         from
            tbl_professor_clazz0602 pc1_0
         where
             (
             pc1_0.clazz_id, pc1_0.professor_id
             ) in ((?, ?))
         */
        System.out.println(professorClazz2);
//        assertThat(entityManager.find(ProfessorClazz.class, professorClazz.getId())).isNotNull(); // select 쿼리를 안날림 , 영속성 컨텍스트에 있기 때문
        assertThat(professorClazz2).isNotNull();


    }
}
