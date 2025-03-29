package com.sh.app._02.many2one;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

// vote에서 person을 참조한다
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
        Restaurant restaurant=new Restaurant(null, "길동이네 떡볶이");
        this.entityManager.persist(restaurant);
        assertThat(restaurant.getId()).isNotNull();

        Review review= Review.builder()
                .restaurant(restaurant)
                .grade(Grade.STAR5)
                .comment("존맛탱")
                .build();
        this.entityManager.remove(review);

        System.out.println("review = " + review);
        assertThat(review.getId()).isNotNull();

        this.entityManager.clear();
        Review review2=this.entityManager.find(Review.class,review.getId());
        assertThat(review2).isNotNull();
        assertThat(review2.getRestaurant()).isNotNull();

    }

    @Test
    @DisplayName("식당 별 N건의 리뷰를 조회")
    void test3() {
        Restaurant restaurant=new Restaurant(null, "족발장수");
        List<Review> reviews = List.of(
                Review.builder().restaurant(restaurant).grade(Grade.STAR5).comment("존맛탱탱").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR4).comment("존맛탱탱4").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR1).comment("존맛탱탱1").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR2).comment("존맛탱탱2").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR3).comment("존맛탱탱3").build()
        );

        this.entityManager.persist(restaurant);
        reviews.forEach(this.entityManager::persist); // 건건이 등록해야 해서 foreach로 등록

        this.entityManager.clear();
        String jpql= """
                select 
                    r
                from 
                    Review r
                where
                    r.restaurant = :restaurant
                """; // 여기서 :는 파라미터라 생각해
        TypedQuery<Review> query=this.entityManager
                .createQuery(jpql,Review.class)
                .setParameter("restaurant",restaurant);

        List<Review> reviews2=query.getResultList();
        System.out.println("query = " + query);
        System.out.println("reviews2 = " + reviews2);
        reviews2.forEach(System.out::println);


    }
}

















