package com.sh.app._02.embeddable._03.attribute.override;

import com.sh.app._02.embeddable._02.multiple.table.Address;
import com.sh.app._02.embeddable._02.multiple.table.Writer;
import com.sh.app._02.embeddable._02.multiple.table.WriterInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class UserEntityTest {
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
            create table tbl_user (
                home_addr1 varchar(255),
                home_addr2 varchar(255),
                home_zip_code varchar(255),
                id varchar(255) not null,
                work_addr1 varchar(255),
                work_addr2 varchar(255),
                work_zip_code varchar(255),
                primary key (id)
            ) engine=InnoDB
         */
    }

    @Test
    @DisplayName("User Entity 등록")
    void test2() {
        // given
        User user = User.builder()
                .id("honggd")
//                .homeAddress(new Address("집1", "집2","00000"))
//                .workAddress(new Address("회사1", "회사2","11111"))
                .build();
        System.out.println(user);
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(user);
            transaction.commit();
            /*
                insert
                into
                    tbl_user
                    (home_addr1, home_addr2, home_zip_code, work_addr1, work_addr2, work_zip_code, id)
                values
                    (?, ?, ?, ?, ?, ?, ?)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        assertThat(user.getId()).isNotNull();
    }

    @Test
    @DisplayName("Writer Entity 등록 - VO객체가 Null인 경우")
    void test3() {
        // given
        User user = User.builder()
                .id("honggd")
//                .homeAddress(new Address("집1", "집2","00000"))
                .build();
        System.out.println(user);
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
//            entityManager.persist(writer);
            transaction.commit();
            /*
                Hibernate:
                    insert
                    into
                        tbl_writer
                        (name)
                    values
                        (?)

                Hibernate:
                    insert
                    into
                        tbl_writer_address
                        (addr111, addr222, zip_code, writer_id)
                    values
                        (?, ?, ?, ?)
             */
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
//        assertThat(writer.getId()).isNotNull();
//        entityManager.detach(writer);

//        Writer writer2 = entityManager.find(Writer.class, writer.getId());
//        assertThat(writer2).isNotNull();
        /*
            select
                w1_0.id,
                w1_0.name,
                w1_1.self_introduction,
                w1_2.addr111,
                w1_2.addr222,
                w1_2.zip_code
            from
                tbl_writer w1_0
            left join
                tbl_writer_info w1_1
                    on w1_0.id=w1_1.writer_id
            left join
                tbl_writer_address w1_2
                    on w1_0.id=w1_2.writer_id
            where
                w1_0.id=?
         */
    }

}