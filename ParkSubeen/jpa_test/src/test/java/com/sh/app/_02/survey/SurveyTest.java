package com.sh.app._02.survey;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Set;

public class SurveyTest {
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
    @DisplayName("ddl-auto")
    void test1() {
        /*
            create table tbl_hobbies (
                survey_id bigint not null,
                hobby varchar(255) not null,
                primary key (survey_id, hobby)
            ) engine=InnoDB

            create table tbl_survey (
                age tinyint not null check (age between 0 and 7),
                gender tinyint not null check (gender between 0 and 1),
                id bigint not null auto_increment,
                email varchar(255),
                primary key (id)
            ) engine=InnoDB

            alter table tbl_hobbies
               add constraint FK5srpcnjby2ol0r8i9xl3865nt
               foreign key (survey_id)
               references tbl_survey (id)
         */
    }

    @Test
    @DisplayName("survey entity 등록")
    void test2() {
        // given
        Survey survey = Survey.builder()
                .email("ssg0114@ssg.com")
                .gender(Gender.여)
                .age(Age.TWENTIES)
                .hobbies(Set.of("유튜브 시청", "SNS"))
                .build();
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(survey);
            transaction.commit();
            /*
                Hibernate:
                    insert
                    into
                        tbl_survey
                        (age, email, gender)
                    values
                        (?, ?, ?)
                Hibernate:
                    insert
                    into
                        tbl_hobbies
                        (survey_id, hobby)
                    values
                        (?, ?)
                Hibernate:
                    insert
                    into
                        tbl_hobbies
                        (survey_id, hobby)
                    values
                        (?, ?)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        // then
        entityManager.clear();
        Survey survey2 = entityManager.find(Survey.class, survey.getId());
        /*
            select
                s1_0.id,
                s1_0.age,
                s1_0.email,
                s1_0.gender,
                h1_0.survey_id,
                h1_0.hobby
            from
                tbl_survey s1_0
            left join
                tbl_hobbies h1_0
                    on s1_0.id=h1_0.survey_id
            where
                s1_0.id=?
         */
        System.out.println(survey2);
    }
}
