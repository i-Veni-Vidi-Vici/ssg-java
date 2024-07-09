package com.sh.app._02.embeddable._02.multiple.table;

import com.sh.app._02.embeddable._01.single.table.Grade;
import com.sh.app._02.embeddable._01.single.table.Restaurant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

public class WriterEntityTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
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
    @DisplayName("ddl-auto=create 확인")
    void test() {
        /*
               create table tbl_writer (
                    id bigint not null auto_increment,
                    name varchar(255) not null,
                    primary key (id)
                ) engine=InnoDB

                create table tbl_writer_info (
                    writer_id bigint not null,
                    self_introduction varchar(255),
                    primary key (writer_id)
                ) engine=InnoDB

                create table tbl_writer_address (
                    writer_id bigint not null,
                    addr111 varchar(255),
                    addr222 varchar(255),
                    zip_code varchar(255),
                    primary key (writer_id)
                ) engine=InnoDB

                alter table tbl_writer_info
                   add constraint FKbnjxup0e5d4jqiubqdt80076i
                   foreign key (writer_id)
                   references tbl_writer (id)

                alter table tbl_writer_address
                   add constraint FKprtx8gc1okvrfni6d417s1t70
                   foreign key (writer_id)
                   references tbl_writer (id)
         */
    }

    @Test
    @DisplayName("Writer Entity 등록")
    void test2() {
        // given
        Writer writer = Writer.builder()
                .name("이순신")
                .writerInfo(new WriterInfo("안녕하세요 이순신"))
                .address(new Address("전남", "충북", "아아ㅏ아"))
                .build();

        // when

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(writer);
            transaction.commit();
        }
        catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        // then

        assertThat(writer.getId()).isNotNull();

        entityManager.detach(writer);
        Writer writer2 = entityManager.find(Writer.class,writer.getId());
        assertThat(writer2).isNotNull();
    }

    @Test
    @DisplayName("Writer Entity 등록 - VO 객체가 널인경우 ")
    void test3() {

        Writer writer = Writer.builder()
                .name("이순신")
                .address(new Address("전남", "충북", "아아ㅏ아"))
                .build();

        // when

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(writer);
            transaction.commit();
        }
        catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        // then

        assertThat(writer.getId()).isNotNull();

        entityManager.detach(writer);
        Writer writer2 = entityManager.find(Writer.class,writer.getId());
        assertThat(writer2).isNotNull();
    }

}