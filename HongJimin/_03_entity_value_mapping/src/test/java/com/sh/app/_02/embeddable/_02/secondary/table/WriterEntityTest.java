package com.sh.app._02.embeddable._02.secondary.table;

import com.sh.app._02.embeddable._01.single.table.Grade;
import com.sh.app._02.embeddable._01.single.table.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

public class WriterEntityTest {
    // application-scope : 1개만 만들어서 재사용(thread - safe)
    private static EntityManagerFactory entityManagerFactory;

    // request - scope : 웹 요청마다 1개씩 생성(non-thread-safe)
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
    @DisplayName("ddl-auto = create 확인")
    void test() {
        /**
         *  create table tbl_writer (
         *         id bigint not null auto_increment,
         *         name varchar(255) not null,
         *         primary key (id)
         *     ) engine=InnoDB
         * Hibernate:
         *     create table tbl_writer_info (
         *         writer_id bigint not null, ✨동시에 pk 컬럼으로 쓰고 있음 -> 식별관계(참조해서 한번만 사용한 경우)
         *         ✨self_introduction varchar(255),
         *         primary key (writer_id)
         *     ) engine=InnoDB
         *
         *     create table tbl_writer_address (
         *         writer_id bigint not null,
         *         addr111 varchar(255),
         *         addr222 varchar(255),
         *         zip_code varchar(255),
         *         primary key (writer_id)
         *     ) engine=InnoDB
         *
         *      alter table tbl_writer_info
         *        add constraint FKbnjxup0e5d4jqiubqdt80076i
         *        foreign key (writer_id)
         *        references tbl_writer (id)
         *
 *             alter table tbl_writer_address
         *        add constraint FKprtx8gc1okvrfni6d417s1t70
         *        foreign key (writer_id)
         *        references tbl_writer (id)
         */
    }

    @Test
    @DisplayName("Writer Entity 등록")
    void test2() { // 3개 테이블에 insert JPA 가 알아서 잘 해쥼~~~
        // given
        Writer writer = Writer.builder()
                .name("이순신")
                .address(new Address("전남 여수시", "거북마을 123번지", "01234"))
                .build();

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(writer);
            transaction.commit();

            /**
             *     insert
             *     into
             *         tbl_writer
             *         (name)
             *     values
             *         (?)
             * Hibernate:
             *     insert
             *     into
             *         tbl_writer_address
             *         (addr111, addr222, zip_code, writer_id)
             *     values
             *         (?, ?, ?, ?)
             */

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        // then
        assertThat(writer.getId()).isNotNull();
        entityManager.detach(writer);

        Writer writer2 = entityManager.find(Writer.class, writer.getId());
        assertThat(writer2).isNotNull();
        /**
         *   select
         *         w1_0.id,
         *         w1_0.name,
         *         w1_1.self_introduction,
         *         w1_2.addr111,
         *         w1_2.addr222,
         *         w1_2.zip_code
         *     from
         *         tbl_writer w1_0
         *     left join ✨table의 널값이 잇으면 제외되니까 left join을 함
         *         tbl_writer_info w1_1
         *             on w1_0.id=w1_1.writer_id
         *     left join
         *         tbl_writer_address w1_2
         *             on w1_0.id=w1_2.writer_id
         *     where
         *         w1_0.id=?
         */
    }

    @Test
    @DisplayName("Writer Entity 등록 - VO객체가 NULL인 경우")
    void test3() { // 3개 테이블에 insert JPA 가 알아서 잘 해쥼~~~
        // given
        Writer writer = Writer.builder()
                .name("이순신")
                .writerInfo(new WriterInfo("안녕하세요, 순신입니다. 제가 이번에는 거북선이라고 책을 하나 썼습니다🐸"))
                .address(new Address("전남 여수시", "거북마을 123번지", "01234"))
                .build();

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(writer);
            transaction.commit();

            /**
             * 😀😀 JPA가 3개 테이블에 알아서 insert 해쥰다~!~!~!
             *  insert
             *     into
             *         tbl_writer
             *         (name)
             *     values
             *         (?)
             * Hibernate:
             *     insert
             *     into
             *         tbl_writer_info
             *         (self_introduction, writer_id)
             *     values
             *         (?, ?)
             * Hibernate:
             *     insert
             *     into
             *         tbl_writer_address
             *         (addr111, addr222, zip_code, writer_id)
             *     values
             *         (?, ?, ?, ?)
             */

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        // then
        assertThat(writer.getId()).isNotNull();
        entityManager.detach(writer);

        Writer writer2 = entityManager.find(Writer.class, writer.getId());
        assertThat(writer2).isNotNull();
        /**
         * select
         *         w1_0.id,
         *         w1_0.name,
         *         w1_1.self_introduction,
         *         w1_2.addr111,
         *         w1_2.addr222,
         *         w1_2.zip_code
         *     from
         *         tbl_writer w1_0
         *     left join
         *         tbl_writer_info w1_1
         *             on w1_0.id=w1_1.writer_id
         *     left join
         *         tbl_writer_address w1_2
         *             on w1_0.id=w1_2.writer_id
         *     where
         *         w1_0.id=?
         */
    }
}
