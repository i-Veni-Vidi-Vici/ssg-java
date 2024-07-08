package com.sh.app._01.sns.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

public class MemberTest {
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
            create table tbl_member (
                accountStatus tinyint check (accountStatus between 0 and 2),
                lastLoginDate datetime(6),
                signUpDate datetime(6),
                userId bigint not null auto_increment,
                emailAddress varchar(255),
                password varchar(255),
                userName varchar(255),
                primary key (userId)
            ) engine=InnoDB
            create table tbl_setting (
                account tinyint check (account between 0 and 1),
                notification tinyint check (notification between 0 and 1),
                theme tinyint check (theme between 0 and 1),
                userId bigint not null,
                language varchar(255),
                timeZone varchar(255),
                primary key (userId)
            ) engine=InnoDB
            create table tbl_snsInfo (
                numberOfComments integer,
                numberOfFollowers integer,
                numberOfFollowing integer,
                numberOfLikes integer,
                numberOfPosts integer,
                numberOfStories integer,
                userId bigint not null,
                primary key (userId)
            ) engine=InnoDB
            create table tbl_userInfo (
                gender tinyint check (gender between 0 and 1),
                birth date,
                userId bigint not null,
                aboutMe varchar(255) not null,
                address varchar(255),
                fullName varchar(255),
                phoneNumber varchar(255),
                website varchar(255) not null,
                primary key (userId)
            ) engine=InnoDB
            alter table tbl_setting
               add constraint FKm9phicdcci0q6t8gf9p9va3a9
               foreign key (userId)
               references tbl_member (userId)
           alter table tbl_snsInfo
               add constraint FKc6q1m2bfoftc6id1on1fe6pkg
               foreign key (userId)
               references tbl_member (userId)
           alter table tbl_userInfo
               add constraint FKfcbl093u050pv8t9h97wmagh0
               foreign key (userId)
               references tbl_member (userId)
         */
    }

    @Test
    @DisplayName("member entity 등록")
    void test2() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode("pass123");
//        System.out.println(encodedPassword);

        // given
        Member member = Member.builder()
                .username("subkka")
                .emailAddress("beeniaa@naver.com")
                .password(encodedPassword)
                .profilePicture(new Picture("강아지", "static/dog.jpeg"))
                .signUpDate(LocalDateTime.of(2024, 7, 8, 12, 10, 35))
                .lastLoginDate(LocalDateTime.of(2024, 7, 8, 21, 00, 30))
                .accountStatus(AccountStatus.활성)
                .user(new User("박수빈", LocalDate.of(1999,1,14), Gender.FEMALE, "010-1111-1111", "서울시", "ssg0114@ssg.com", "안녕하세요"))
                .snsInfo(new SNSInfo(150, 150, 0, 0, 0, 1))
                .settingInfo(new SettingInfo(Notification.Y, Account.PRIVATE, Locale.KOREA, TimeZone.getDefault(), Theme.다크모드))
                .build();
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(member);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        entityManager.detach(member);
        Member member2 = entityManager.find(Member.class, member.getUserID());
        System.out.println(member2);
    }

    @Test
    @DisplayName("User Bio 수정")
    void test3() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode("pass123");

        // given
        Member member = Member.builder()
                .username("subkka")
                .emailAddress("beeniaa@naver.com")
                .password(encodedPassword)
                .profilePicture(new Picture("강아지", "static/dog.jpeg"))
                .signUpDate(LocalDateTime.of(2024, 7, 8, 12, 10, 35))
                .lastLoginDate(LocalDateTime.of(2024, 7, 8, 21, 00, 30))
                .accountStatus(AccountStatus.활성)
                .user(new User("박수빈", LocalDate.of(1999,1,14), Gender.FEMALE, "010-1111-1111", "서울시", "ssg0114@ssg.com", "안녕하세요"))
                .snsInfo(new SNSInfo(150, 150, 0, 0, 0, 1))
                .settingInfo(new SettingInfo(Notification.Y, Account.PRIVATE, Locale.KOREA, TimeZone.getDefault(), Theme.다크모드))
                .build();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(member);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        String newUserBio = "안녕하세요, 박수빈입니다😊";

        // when
        transaction.begin();
        try {
            member.changeUserBio(newUserBio);
            transaction.commit();
        } catch(Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        entityManager.detach(member);
        Member member2 = entityManager.find(Member.class, member.getUserID());
        System.out.println(member2);
    }

    @Test
    @DisplayName("SNS 좋아요 수 수정")
    void test4() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode("pass123");

        // given
        Member member = Member.builder()
                .username("subkka")
                .emailAddress("beeniaa@naver.com")
                .password(encodedPassword)
                .profilePicture(new Picture("강아지", "static/dog.jpeg"))
                .signUpDate(LocalDateTime.of(2024, 7, 8, 12, 10, 35))
                .lastLoginDate(LocalDateTime.of(2024, 7, 8, 21, 00, 30))
                .accountStatus(AccountStatus.활성)
                .user(new User("박수빈", LocalDate.of(1999,1,14), Gender.FEMALE, "010-1111-1111", "서울시", "ssg0114@ssg.com", "안녕하세요"))
                .snsInfo(new SNSInfo(150, 150, 1, 10, 1, 1))
                .settingInfo(new SettingInfo(Notification.Y, Account.PRIVATE, Locale.KOREA, TimeZone.getDefault(), Theme.다크모드))
                .build();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(member);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        int newNumOfLike = 35;

        // when
        transaction.begin();
        try {
            member.changeNumOfLike(newNumOfLike);
            transaction.commit();
        } catch(Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        entityManager.detach(member);
        Member member2 = entityManager.find(Member.class, member.getUserID());
        System.out.println(member2);
    }
}
