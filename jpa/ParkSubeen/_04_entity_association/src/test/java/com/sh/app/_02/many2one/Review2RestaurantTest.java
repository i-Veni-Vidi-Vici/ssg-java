package com.sh.app._02.many2one;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class Review2RestaurantTest {
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
            create table tbl_restaurant (
                id bigint not null auto_increment,
                name varchar(255),
                primary key (id)
            ) engine=InnoDB

            create table tbl_review (
                grade tinyint check (grade between 0 and 4),
                id bigint not null auto_increment,
                restaurant_id bigint,
                comment varchar(255),
                primary key (id)
            ) engine=InnoDB

            alter table tbl_review
               add constraint FK9yyqul6rl3ggckiexwuwbhg9k
               foreign key (restaurant_id)
               references tbl_restaurant (id)
         */
    }

    @Test
    @DisplayName("Review 등록")
    void test2() {
        // given
        Restaurant restaurant = new Restaurant(null, "길동이네 떡뾱기");;
        this.entityManager.persist(restaurant);
        /*
            insert
            into
                tbl_restaurant
                (name)
            values
                (?)
         */
        assertThat(restaurant.getId()).isNotNull();

        // when
        Review review = Review.builder()
                .restaurant(restaurant)
                .grade(Grade.STAR5)
                .comment("존맛탱🤩")
                .build();
        this.entityManager.persist(review);
        /*
            insert
            into
                tbl_review
                (comment, grade, restaurant_id)
            values
                (?, ?, ?)
         */

        // then
        System.out.println(review);
        assertThat(review.getId()).isNotNull();

        this.entityManager.clear();
        Review review2 = this.entityManager.find(Review.class, review.getId());
        /*
            select
                r1_0.id,
                r1_0.comment,
                r1_0.grade,
                r2_0.id,
                r2_0.name
            from
                tbl_review r1_0
            left join
                tbl_restaurant r2_0
                    on r2_0.id=r1_0.restaurant_id
            where
                r1_0.id=?
         */
        assertThat(review2).isNotNull();
        assertThat(review2.getRestaurant()).isNotNull();
    }

    @Test
    @DisplayName("식당별 N건의 Review 조회")
    void test3() {
        // given
        Restaurant restaurant = new Restaurant(null, "족발장수");
        List<Review> reviews = List.of(
                Review.builder().restaurant(restaurant).grade(Grade.STAR5).comment("와우 족발!! 마시쒀어~").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR4).comment("족발 너어어~?!").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR3).comment("그냥 그래~ 헷갈료~").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR2).comment("내 인생 최악").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR4).comment("족발족발족발죠앙~😋").build()
        );
        this.entityManager.persist(restaurant);
        reviews.forEach(this.entityManager::persist);
        // when
        this.entityManager.clear();
        String jpql = """
                select
                    r
                from
                    Review r
                where
                    r.restaurant = :restaurant
                """;
        TypedQuery<Review> query = this.entityManager.createQuery(jpql, Review.class)
                                                    .setParameter("restaurant", restaurant);
        List<Review> reviews2 = query.getResultList();
        reviews2.forEach(System.out::println);
        // then
        assertThat(reviews2).isNotEmpty()
                .allMatch((review) -> review.getRestaurant().equals(restaurant));
    }
}
