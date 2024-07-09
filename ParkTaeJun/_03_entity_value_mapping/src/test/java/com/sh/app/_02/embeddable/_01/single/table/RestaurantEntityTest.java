package com.sh.app._02.embeddable._01.single.table;

import com.sh.app._01.aggregate.Address;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantEntityTest {
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
            create table tbl_restaurant (
                sinse integer,
                created_at datetime(6),
                updated_at datetime(6),
                address1 varchar(255),
                address2 varchar(255),
                id varchar(255) not null,
                name varchar(255) not null,
                zipCode varchar(255),
                grade enum ('FIVE_STAR','FOUR_STAR','ONE_STAR','THREE_STAR','TWO_STAR'),
                primary key (id)
            ) engine=InnoDB
         */
    }

    @Test
    @DisplayName("restaurant 엔티티 등록")
    void test2() {
        // given
        Restaurant restaurant = Restaurant.builder()
                .id("abc-1234")
                .name("ABC 파스타즈")
                .since(Year.of(1966))
                .address(new Address("서울시 강남구", "삼성동 1234", "01234"))
                .grade(Grade.FIVE_STAR)
                .build();
        System.out.println(restaurant);
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(restaurant);
            transaction.commit();
            /*
                insert
                into
                    tbl_restaurant
                    (address1, address2, zipCode, created_at, grade, name, sinse, updated_at, id)
                values
                    (?, ?, ?, ?, ?, ?, ?, ?, ?)
             */
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        System.out.println(restaurant);

        // then
        assertThat(restaurant.getCreatedAt()).isNotNull();
        entityManager.detach(restaurant);

        Restaurant restaurant2 = entityManager.find(Restaurant.class, restaurant.getId());
        assertThat(restaurant2).isSameAs(restaurant);
    }

}
