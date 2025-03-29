package com.sh.app._06.composite.primary.key._01.embeddedId;

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

    // 크게 한 번만 실행
    @BeforeAll
    static void beforeAll() {
        // jpa 설정 정보를 읽어서 EntityManagerFactory를 생성
        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
    }

    // 각 테스트의 앞서서 한번
    @BeforeEach
    void setUp() {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    // 각 테스트의 끝에 한 번
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
        /*
            create table tbl_professor_clazz (
                clazz_id bigint not null,
                professor_id bigint not null,
                classroom enum ('A','B','C'),
                primary key (clazz_id, professor_id)
            ) engine=InnoDB
         */
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
        try {
            entityManager.persist(professorClazz);
            transaction.commit();
            /*
                insert
                    into
                        tbl_professor_clazz
                        (classroom, clazz_id, professor_id)
                    values
                        (?, ?, ?)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        entityManager.clear(); // select문을 보기 위해 영속성컨텍스트 정리(비우기)
        ProfessorClazz professorClazz2 = entityManager.find(ProfessorClazz.class, professorClazz.getId());
        /*
            select
                pc1_0.clazz_id,
                pc1_0.professor_id$,
                pc1_0.classroom
            from
                tbl_professor_clazz pc1_0
            where
                (
                    pc1_0.clazz_id, pc1_0.professor_id
                ) in ((?, ?)) // 두개의 복합키를 동시에 동등비교를 하고싶어서 =이 아닌 in 사용
         */
        System.out.println(professorClazz2); // ProfessorClazz(id=ProfessorClazzId(professorId=100, clazzId=200), classroom=A)
        assertThat(professorClazz2).isNotNull(); // id(PK) 조회할 때

    }
}