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
        entityManager.getTransaction().begin(); // 트랜잭션 처리를 한 번에 처리할 수 있다.
    }

    @AfterEach
    void tearDown() {
        this.entityManager.close();
        entityManager.getTransaction().commit();
    }

    @AfterAll
    static void afterAll() {
        entityManagerFactory.close();
    }

    @Test
    @DisplayName("ddl-auto=create 확인")
    void test1() {
        /*
            Hibernate:
                create table tbl_restaurant (
                    id bigint not null auto_increment,
                    name varchar(255),
                    primary key (id)
                ) engine=InnoDB
            Hibernate:
                create table tbl_review (
                    grade tinyint check (grade between 0 and 4),
                    id bigint not null auto_increment,
                    restaurant_id bigint,
                    comment varchar(255),
                    primary key (id)
                ) engine=InnoDB
            Hibernate:
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
        Restaurant restaurant = new Restaurant(null, "길동이네 떡뽁이");
        this.entityManager.persist(restaurant);
        /*
        Hibernate:
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
                .comment("JMT🧆")
                .build();
        this.entityManager.persist(review); // flush사용하지 않아도 쿼리가 날아온다.
        /*
        Hibernate:
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
        Hibernate:
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
                Review.builder().restaurant(restaurant).grade(Grade.STAR5).comment("왕!! 족발이당😋").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR4).comment("배부르게 먹었습니다").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR3).comment("나쁘지 않네요").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR4).comment("야호! 다음에 또 먹을래여").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR2).comment("초큼 많이 짰어요..😑").build()
        );
        this.entityManager.persist(restaurant);
        reviews.forEach(this.entityManager::persist);
        // when
        this.entityManager.clear();
        // 특정 레스토랑의 리뷰 모두 보기
        String jpql = """
                select
                    r
                from
                    Review r
                where
                    r.restaurant = :restaurant
                """;
        TypedQuery<Review> query = this.entityManager.createQuery(jpql, Review.class)
                                        .setParameter("restaurant", restaurant); // restaurant 조회해줘
        List<Review> reviews2 = query.getResultList();
        /*
        Hibernate:
            select
                r1_0.id,
                r1_0.comment,
                r1_0.grade,
                r1_0.restaurant_id
            from
                tbl_review r1_0
            where
                r1_0.restaurant_id=?
        Hibernate:
            select
                r1_0.id,
                r1_0.name
            from
                tbl_restaurant r1_0
            where
                r1_0.id=?
         */
        reviews2.forEach(System.out::println); // 반복문을 돌면서 리뷰를 하나씩 출력
        // then
        assertThat(reviews2).isNotEmpty()
                .allMatch((review) -> review.getRestaurant().equals(restaurant)); // 리뷰 내용이 같니?
    }
}
