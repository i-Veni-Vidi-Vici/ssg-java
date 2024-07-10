package com.sh.app._02.many2one;


import com.sh.app._01.one2one._02.identifying.Person;
import com.sh.app._01.one2one._02.identifying.Vote;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Review2RestaurantTest {
    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
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

    }

    @Test
    @DisplayName("Review 등록")
    void test2() {

        //given
        Restaurant restaurant = new Restaurant(null,"길동이네 떡뽁이");
        this.entityManager.persist(restaurant);
        assertThat(restaurant.getId()).isNotNull();

        //when
        Review review = Review.builder()
                .restaurant(restaurant) // 레스토랑 지정
                .grade(Grade.STAR5)
                .comment("미쳤다 고기별점5개")
                .build();
        this.entityManager.persist(review); // 등록


        //then
        System.out.println(review);
        assertThat(review.getId()).isNotNull();

        this.entityManager.clear();
        Review review2 = this.entityManager.find(Review.class, review.getId());
        assertThat(review2).isNotNull();
        assertThat(review2.getRestaurant()).isNotNull();
    }

    @Test
    @DisplayName("식당별 N건의 리뷰를 조회")
    void test3() {
        //given
        Restaurant restaurant = new Restaurant(null,"족발장수");
        List<Review> reviews = List.of(
                Review.builder().restaurant(restaurant).grade(Grade.STAR5).comment("와우 족발이다").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR4).comment("족발이 맛있어요").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR3).comment("막국수 마싯다").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR2).comment("두번은 안 먹을 맛 !").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR1).comment("양이 없네요").build()
        );
        this.entityManager.persist(restaurant);
        reviews.forEach(this.entityManager::persist);

        //when
        this.entityManager.clear();
        String jpql = """
                select r from Review r
                where r.restaurant = :restaurant
                """;

        TypedQuery<Review> query = this.entityManager.createQuery(jpql, Review.class)
                .setParameter("restaurant", restaurant);

        List<Review> reviews2 = query.getResultList();
        reviews2.forEach(System.out::println); // 반복문 돌면서 리뷰 하나씩

        //then

        assertThat(reviews2).isNotEmpty()
                .allMatch((review) -> review.getRestaurant().equals(restaurant));



    }






}
