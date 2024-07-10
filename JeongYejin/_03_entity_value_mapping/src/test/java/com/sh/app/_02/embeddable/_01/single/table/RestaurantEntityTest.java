package com.sh.app._02.embeddable._01.single.table;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

public class RestaurantEntityTest {
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
    @DisplayName("ddl-auto=create 확인")
    void test() {
        /**
         * Hibernate:
         *     create table tbl_restaurant (
         *         since integer,
         *         created_at datetime(6),
         *         update_at datetime(6),
         *         address1 varchar(255),
         *         address2 varchar(255),
         *         id varchar(255) not null,
         *         name varchar(255) not null,
         *         zipCode varchar(255),
         *         grade enum ('FIVE_STAR','FOUR_STAR','ONE_STAR','THREE_STAR','TWO_STAR'),
         *         primary key (id)
         *     ) engine=InnoDB
         */
    }

    @Test
    @DisplayName("restaurant 엔티티 등록")
    void test2() {
        // given
        Restaurant restaurant = Restaurant.builder()
                .id("abc-1234")
                .name("ABC 파스타즈")
                .since(Year.of(1960))
                .address(new Address("서울시 강남구", "삼성동 1234", "01234"))
                .grade(Grade.FIVE_STAR)
//                .createdAt()
//                .updatedAt()
                .build();
        System.out.println(restaurant);
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.persist(restaurant);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        System.out.println(restaurant);
        // then
        assertThat(restaurant.getCreatedAt()).isNotNull();
//        entityManager.detach(restaurant);

        Restaurant restaurant2 = entityManager.find(Restaurant.class, restaurant.getId());
        // 이미 영속성컨텍스트에 들어가 있어서 조회 쿼리가 날라가지 않는다.
        assertThat(restaurant2).isSameAs(restaurant); // detach를 추가하면 같지 않다
        /**
         * Restaurant(id=abc-1234, name=ABC 파스타즈, since=1960, grade=FIVE_STAR, address=Address(address1=서울시 강남구, address2=삼성동 1234, zipCode=01234), createdAt=null, updatedAt=null)
         * Hibernate:
         *     insert
         *     into
         *         tbl_restaurant
         *         (address1, address2, zipCode, created_at, grade, name, since, update_at, id)
         *     values
         *         (?, ?, ?, ?, ?, ?, ?, ?, ?)
         * Restaurant(id=abc-1234, name=ABC 파스타즈, since=1960, grade=FIVE_STAR, address=Address(address1=서울시 강남구, address2=삼성동 1234, zipCode=01234), createdAt=2024-07-05T11:36:23.922866, updatedAt=2024-07-05T11:36:23.922866)
         */
    }
}
