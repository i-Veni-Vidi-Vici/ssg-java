package com.sh.app._04.persist.cascade;

import com.sh.app._03.one2many._03.map.Game;
import com.sh.app._03.one2many._03.map.GameMember;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Club2StudentTest {
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
        /*
            create table tbl_club (
                id bigint not null auto_increment,
                name varchar(255),
                primary key (id)
            ) engine=InnoDB

            create table tbl_student (
                club_id bigint,
                id bigint not null auto_increment,
                name varchar(255),
                primary key (id)
            ) engine=InnoDB

            alter table tbl_student
               add constraint FKg28pk9odj1ft4fhxc78nn819i
               foreign key (club_id)
               references tbl_club (id)
         */
    }

    @Test
    @DisplayName("Club 등록 시 Student도 등록처리")
    void test2() {
        // given
        Set<Student> students = Set.of(
                new Student(null, "홍길동"),
                new Student(null, "신사임당"),
                new Student(null, "이순신")
        );
        Club club = new Club(null, "우리동네 코딩방", students);
        // when
        this.entityManager.persist(club);
        this.entityManager.flush();
        /* cascade 사용전 */
        /*
            Hibernate:
                insert
                into
                    tbl_club
                    (name)
                values
                    (?)
            Hibernate:
                update
                    tbl_student
                set
                    club_id=?
                where
                    id=?
            Hibernate:
                update
                    tbl_student
                set
                    club_id=?
                where
                    id=?
            Hibernate:
                update
                    tbl_student
                set
                    club_id=?
                where
                    id=?
         */
        /* cascade 사용후 */
        /*
            Hibernate:
                insert
                into
                    tbl_club
                    (name)
                values
                    (?)
            Hibernate:
                insert
                into
                    tbl_student
                    (name)
                values
                    (?)
            Hibernate:
                insert
                into
                    tbl_student
                    (name)
                values
                    (?)
            Hibernate:
                insert
                into
                    tbl_student
                    (name)
                values
                    (?)
            Hibernate:
                update
                    tbl_student
                set
                    club_id=?
                where
                    id=?
            Hibernate:
                update
                    tbl_student
                set
                    club_id=?
                where
                    id=?
            Hibernate:
                update
                    tbl_student
                set
                    club_id=?
                where
                    id=?
         */
        System.out.println(club);
        // then
        assertThat(club.getId()).isNotZero();
        assertThat(club.getStudents()).allMatch((student) -> student.getId() != null);
    }
}
