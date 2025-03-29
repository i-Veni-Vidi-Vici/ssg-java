package com.sh.app._03.primary.key._02.table.strategy;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberEntityPrimaryKeyIdentityTest {
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

    @DisplayName("ddl-auto =create 설정")
    @Test
    public void test1() {
        //given
        //when
        //then
    }

    /**
     * ibernate:
     *     create table tbl_member0302 (
     *         enabled bit,
     *         member_code bigint not null,
     *         member_created_at datetime(6),
     *         member_password varchar(20) not null,
     *         member_email varchar(255),
     *         member_id varchar(255),
     *         member_name varchar(100) default 'NamelessOne',
     *         primary key (member_code)
     *     ) engine=InnoDB
     * Hibernate:
     *     create table tbl_sequence (
     *         next_val bigint,
     *         no varchar(255) not null,
     *         primary key (no)
     *     ) engine=InnoDB
     * Hibernate:
     *     insert into tbl_sequence(no, next_val) values ('tbl_member0302',0)
     * Hibernate:
     *     alter table tbl_member02
     *        add constraint UKps06eg11othmdnvtj50nbvqmc unique (member_email)
     * Hibernate:
     *     alter table tbl_member0301
     *        add constraint UK1dp8som30bwbf99s3q065yy0k unique (member_email)
     * Hibernate:
     *     alter table tbl_member0301
     *        add constraint UK9yl1bdu01s0af4m42qli1ile2 unique (member_id)
     * Hibernate:
     *     alter table tbl_member0302
     *        add constraint UK7sh8kciw1x8ett0cnxcjyfgvv unique (member_email)
     * Hibernate:
     *     alter table tbl_member0302
     *        add constraint UKl68aev3usikvaq0875aum4ogd unique (member_id)
     */

    @DisplayName("Member Entity 객체 등록")
    @Test
    public void test2() {
        //given
        Member bongo = Member.builder()
                .id("Bongo")
                .password("1234")
                .name("봉고쟝")
                .email("bongocat@bongo.com")
                .createdAt(LocalDateTime.now())
                .enabled(true)
                .build();
        Member pikachu = Member.builder()
                .id("pikachu")
                .password("4321")
                .name("피카츄")
                .email("pika@bongo.com")
                .createdAt(LocalDateTime.now())
                .enabled(true)
                .build();
        //when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            entityManager.persist(bongo);
            entityManager.persist(pikachu);
            transaction.commit();
            /**
             * @DynamicInsert 사용시 memberName필드는 null이라서 제외된다
             * DTO객체 붙여줌
             */
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        System.out.println(bongo);
        System.out.println(pikachu);
        //then
        assertThat(bongo.getCode()).isNotNull().isNotZero();
        assertThat(pikachu.getCode()).isNotNull().isNotZero();
    }
}
