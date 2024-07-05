//package com.sh.app._05.access._02.property;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//import org.junit.jupiter.api.*;
//
//import java.time.LocalDateTime;
//
//import static com.sh.app._04._enum.Gender.FEMALE;
//import static com.sh.app._04._enum.Gender.MALE;
//import static com.sh.app._04._enum.MemberRole.ROLE_ADMIN;
//import static com.sh.app._04._enum.MemberRole.ROLE_MEMBER;
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class MemberEntityAccessPropertyTest {
//    // application-scope: 1개만 만들어서 재사용 (thread-safe)
//    private static EntityManagerFactory entityManagerFactory;
//    // request-scope: 웹요청마다 1개씩 생성 (non-thread-safe)
//    private EntityManager entityManager;
//
//    @BeforeAll
//    static void beforeAll() {
//        // jpa설정정보를 읽어서 EntityManagerFactory를 생성
//        entityManagerFactory = Persistence.createEntityManagerFactory("jpatest");
//    }
//
//    @BeforeEach
//    void setUp() {
//        this.entityManager = entityManagerFactory.createEntityManager();
//    }
//
//    @AfterEach
//    void tearDown() {
//        this.entityManager.close();
//    }
//
//    @AfterAll
//    static void afterAll() {
//        entityManagerFactory.close();
//    }
//
//    @Test
//    @DisplayName("ddl-auto = create 설정")
//    void test1() {
//        // 테이블이 생성되었나요?
//        // 컬럼순서는 abc순서로 생성
//        /*
//            Hibernate:
//    create table tbl_member04 (
//        member_enabled bit,
//        member_gender tinyint check (member_gender between 0 and 1), // 이부분 index 처리
//        member_code bigint not null,
//        member_create_at datetime(6),
//        member_password varchar(20) not null,
//        member_email varchar(255),
//        member_id varchar(255),
//        member_name varchar(100) default '홍길동',
//        member_role enum ('ROLE_ADMIN','ROLE_MEMBER'), // 이 부분이 중요하다 String처리
//        primary key (member_code)
//    ) engine=InnoDB
//         */
//    }
//
//    @Test
//    @DisplayName("Member Entity객체 등록")
//    void test2() {
//        //given
//
//        Member honggd = Member.builder()
//                .id("honggd")
//                .password("1234")
//                .email("honggd@naver.com")
//                .gender(MALE)
//                .memberRole(ROLE_ADMIN)
//                .createAt(LocalDateTime.now())
//                .enabled(true)
//                .build();
//
//        Member sinsa = Member.builder()
//                .id("sinsa")
//                .password("1234")
//                .email("sinsa@naver.com")
//                .gender(FEMALE)
//                .memberRole(ROLE_MEMBER)
//                .createAt(LocalDateTime.now())
//                .enabled(true)
//                .build();
//
//        EntityTransaction transaction=entityManager.getTransaction();
//        transaction.begin();
//
//        try{
//            entityManager.persist(honggd); //
//            entityManager.persist(sinsa); //
//            transaction.commit();
//            /*
//                    Hibernate:
//                    select
//                        tbl.next_val
//                    from
//                        tbl_sequence tbl
//                    where
//                        tbl.table_name=? for update
//                Hibernate:
//                    update
//                        tbl_sequence
//                    set
//                        next_val=?
//                    where
//                        next_val=?
//                        and table_name=?
//                Hibernate:
//                    select
//                        tbl.next_val
//                    from
//                        tbl_sequence tbl
//                    where
//                        tbl.table_name=? for update
//                Hibernate:
//                    update
//                        tbl_sequence
//                    set
//                        next_val=?
//                    where
//                        next_val=?
//                        and table_name=?
//             */
//        }catch (Exception e)
//        {
//            transaction.rollback();
//            e.printStackTrace();
//        }
//
//        System.out.println("honggd = " + honggd);
//        System.out.println("sinsa = " + sinsa);
//
//        assertThat(honggd.getCode()).isNotNull();
//        assertThat(sinsa.getCode()).isNotNull();
//    }
//
//}
