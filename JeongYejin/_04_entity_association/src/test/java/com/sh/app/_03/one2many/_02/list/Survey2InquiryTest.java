package com.sh.app._03.one2many._02.list;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Survey2InquiryTest {
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
        /**
         * Hibernate:
         *     create table tbl_inquiry (
         *         inquiry_idx integer,
         *         id bigint not null auto_increment,
         *         survey_id bigint,
         *         text varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_survey (
         *         id bigint not null auto_increment,
         *         title varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         * Hibernate:
         *     alter table tbl_inquiry
         *        add constraint FKrrev4ubx6sn4a45y2a7ttpx5q
         *        foreign key (survey_id)
         *        references tbl_survey (id)
         */
    }
    @Test
    @DisplayName("Survey 등록")
    void test2() {
        // given
        List<Inquiry> inquiries = List.of(
                new Inquiry(null, "좋아하는 계절은 무엇인가요?"),
                new Inquiry(null, "좋아하는 음식은 무엇인가요?"),
                new Inquiry(null, "좋아하는 색깔은 무엇인가요?"),
                new Inquiry(null, "좋아하는 동물은 무엇인가요?")
        );
        Survey survey = new Survey(null, "개인취향검사", inquiries);
        // when
        inquiries.forEach(this.entityManager::persist);
        this.entityManager.persist(survey);
        this.entityManager.flush();
        // then
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
         * Hibernate:
         *     update
         *         tbl_inquiry
         *     set
         *         survey_id=?,
         *         inquiry_idx=?
         *     where
         *         id=?
         * Hibernate:
         *     update
         *         tbl_inquiry
         *     set
         *         survey_id=?,
         *         inquiry_idx=?
         *     where
         *         id=?
         * Hibernate:
         *     update
         *         tbl_inquiry
         *     set
         *         survey_id=?,
         *         inquiry_idx=?
         *     where
         *         id=?
         * Hibernate:
         *     update
         *         tbl_inquiry
         *     set
         *         survey_id=?,
         *         inquiry_idx=?
         *     where
         *         id=?
         */
        this.entityManager.clear();
        Survey survey2 = this.entityManager.find(Survey.class, survey.getId());
        /**
         * fetch = FetchType.LAZY
         *
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
         *         i1_0.inquiry_idx,
         *         i1_0.id,
         *         i1_0.text
         *     from
         *         tbl_inquiry i1_0
         *     where
         *         i1_0.survey_id=?
         * ============================================================
         * fetch = FetchType.EAGER
         *
         * Hibernate:
         *     select
         *         s1_0.id,
         *         i1_0.survey_id,
         *         i1_0.inquiry_idx,
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
         *
         */
        System.out.println(survey2);

        //then
        assertThat(survey2).isNotNull();
        assertThat(survey2.getInquiries()).isEqualTo(inquiries);
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
        // then
        /**
         * - survey_id, inquiry_idx 모두 제거하는 update문 4건
         * - survey_id, inquiry_idx 재지정하는 update문 3건
         * 
         * Hibernate: 
         *     update
         *         tbl_inquiry 
         *     set
         *         survey_id=null,
         *         inquiry_idx=null 
         *     where
         *         survey_id=? 
         *         and id=?
         * Hibernate: 
         *     update
         *         tbl_inquiry 
         *     set
         *         survey_id=null,
         *         inquiry_idx=null 
         *     where
         *         survey_id=? 
         *         and id=?
         * Hibernate: 
         *     update
         *         tbl_inquiry 
         *     set
         *         survey_id=null,
         *         inquiry_idx=null 
         *     where
         *         survey_id=? 
         *         and id=?
         * Hibernate: 
         *     update
         *         tbl_inquiry 
         *     set
         *         survey_id=null,
         *         inquiry_idx=null 
         *     where
         *         survey_id=? 
         *         and id=?
         * Hibernate: 
         *     update
         *         tbl_inquiry 
         *     set
         *         survey_id=?,
         *         inquiry_idx=? 
         *     where
         *         id=?
         * Hibernate: 
         *     update
         *         tbl_inquiry 
         *     set
         *         survey_id=?,
         *         inquiry_idx=? 
         *     where
         *         id=?
         * Hibernate: 
         *     update
         *         tbl_inquiry 
         *     set
         *         survey_id=?,
         *         inquiry_idx=? 
         *     where
         *         id=?
         */
        Inquiry inquiry = new Inquiry(null, "당신이 제일 좋아하는 책은 무엇입니까?");
        this.entityManager.persist(inquiry);
        survey.addInquiry(inquiry);
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_inquiry
         *         (text)
         *     values
         *         (?)
         * Hibernate:
         *     update
         *         tbl_inquiry
         *     set
         *         survey_id=null,
         *         inquiry_idx=null
         *     where
         *         survey_id=?
         *         and id=?
         */
        // then
        assertThat(survey.getInquiries()).hasSize(4);
    }
}