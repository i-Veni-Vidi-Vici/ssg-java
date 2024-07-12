package com.sh.app._03.one2many._02.list;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;


public class Survey2InquiryTest {
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
         *     create table tbl_survey (
         *         id bigint not null auto_increment,
         *         title varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_inquiry (
         *         question_ixdx integer,
         *         id bigint not null auto_increment,
         *         survey_id bigint,
         *         text varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         *
         * Hibernate:
         *     create table tbl_survey (
         *         id bigint not null auto_increment,
         *         title varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         */
    }
    @Test
    @DisplayName("Survey 등록")
    void test2() {
        // given
        List<Inquiry> inqueries = List.of(
                new Inquiry(null, "좋아하는 계절은 무엇인가요?"),
                new Inquiry(null, "좋아하는 음식은 무엇인가요?"),
                new Inquiry(null, "좋아하는 색은 무엇인가요?"),
                new Inquiry(null, "좋아하는 동물은 무엇인가요?")
        );
        Survey survey = new Survey(null, "개인취향 검사", inqueries);
        // when
        inqueries.forEach(this.entityManager::persist);
        this.entityManager.persist(survey);
        this.entityManager.flush();
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_inquiry
         *         (text)
         *     values
         *         (?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_inquiry
         *         (text)
         *     values
         *         (?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_inquiry
         *         (text)
         *     values
         *         (?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_inquiry
         *         (text)
         *     values
         *         (?)
         * Hibernate:
         *     insert
         *     into
         *         tbl_survey
         *         (title)
         *     values
         *         (?)
         *
         *  🙉 update 🙉
         *  Hibernate:
         *     update
         *         tbl_inquiry
         *     set
         *         survey_id=?,
         *         question_ixdx=?
         *     where
         *         id=?
         * Hibernate:
         *     update
         *         tbl_inquiry
         *     set
         *         survey_id=?,
         *         question_ixdx=?
         *     where
         *         id=?
         * Hibernate:
         *     update
         *         tbl_inquiry
         *     set
         *         survey_id=?,
         *         question_ixdx=?
         *     where
         *         id=?
         * Hibernate:
         *     update
         *         tbl_inquiry
         *     set
         *         survey_id=?,
         *         question_ixdx=?
         *     where
         *         id=?
         */

        this.entityManager.clear();
        Survey survey2 = this.entityManager.find(Survey.class, survey.getId());
        /**
         * 🙉 그럴줄 알았다~ FetchType.LAZY여서~ 따로 select 하지!!
         * Hibernate:
         *     select
         *         s1_0.id,
         *         s1_0.title
         *     from
         *         tbl_survey s1_0
         *     where
         *         s1_0.id=?
         * Hibernate:
         *     select
         *         i1_0.survey_id,
         *         i1_0.question_ixdx,
         *         i1_0.id,
         *         i1_0.text
         *     from
         *         tbl_inquiry i1_0
         *     where
         *         i1_0.survey_id=?
         * 🙉 그럴줄 알았다~ FetchType.EAGER여서~ join쿼리로 select 하지!!
         * Hibernate:
         *     select
         *         s1_0.id,
         *         i1_0.survey_id,
         *         i1_0.question_ixdx,
         *         i1_0.id,
         *         i1_0.text,
         *         s1_0.title
         *     from
         *         tbl_survey s1_0
         *     left join
         *         tbl_inquiry i1_0
         *             on s1_0.id=i1_0.survey_id
         *     where
         *         s1_0.id=?
         */
        System.out.println(survey2);

        // then
        assertThat(survey2).isNotNull();
        assertThat(survey2.getInquiries()).isEqualTo(inqueries);
    }

    @Test
    @DisplayName("Survey의 하위 Inquiry를 추가/삭제")
    void test3() {
        // given
        List<Inquiry> inquiries = List.of(
                new Inquiry(null, "좋아하는 계절은 무엇인가요?"),
                new Inquiry(null, "좋아하는 음식은 무엇인가요?"),
                new Inquiry(null, "좋아하는 색깔은 무엇인가요?"),
                new Inquiry(null, "좋아하는 동물은 무엇인가요?")
        );
        Survey survey = new Survey(null, "개인취향검사", inquiries);
        inquiries.forEach(this.entityManager::persist);
        this.entityManager.persist(survey);
        this.entityManager.flush();
        // when
        survey.removeInquiry(inquiries.get(0));
        this.entityManager.flush();
        /*
        - survey_id, question_idx 모두 제거하는 update문 4건
        - survey_id, question_idx를 재지정하는 update문 3건
        Hibernate:
            update
                tbl_inquiry
            set
                survey_id=null,
                question_idx=null
            where
                survey_id=?
                and id=?
        Hibernate:
            update
                tbl_inquiry
            set
                survey_id=null,
                question_idx=null
            where
                survey_id=?
                and id=?
        Hibernate:
            update
                tbl_inquiry
            set
                survey_id=null,
                question_idx=null
            where
                survey_id=?
                and id=?
        Hibernate:
            update
                tbl_inquiry
            set
                survey_id=null,
                question_idx=null
            where
                survey_id=?
                and id=?
        Hibernate:
            update
                tbl_inquiry
            set
                survey_id=?,
                question_idx=?
            where
                id=?
        Hibernate:
            update
                tbl_inquiry
            set
                survey_id=?,
                question_idx=?
            where
                id=?
        Hibernate:
            update
                tbl_inquiry
            set
                survey_id=?,
                question_idx=?
            where
                id=?
         */
        Inquiry inquiry = new Inquiry(null, "당신이 제일 좋아하는 책은 무엇입니까?");
        this.entityManager.persist(inquiry);
        survey.addInquiry(inquiry);
        // then
        assertThat(survey.getInquiries()).hasSize(4);
    }

}
