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
        /**
         * Hibernate:
         *   create table tbl_restaurant ( 🙉얘는 아무것도 모름
         *         id bigint not null auto_increment,
         *         name varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         *
         * Hibernate:
         *     create table tbl_review ( 🙉얘가 restaurant를 알고 있움
         *         grade tinyint check (grade between 0 and 4),
         *         id bigint not null auto_increment,
         *         restaurant_id bigint,
         *         comment varchar(255),
         *         primary key (id)
         *     ) engine=InnoDB
         * Hibernate:
         *     alter table tbl_review
         *        add constraint FK9yyqul6rl3ggckiexwuwbhg9k
         *        foreign key (restaurant_id)
         *        references tbl_restaurant (id)
         */
    }

    @Test
    @DisplayName("Reveiw 등록")
    void test2() {
        // given
        Restaurant restaurant = new Restaurant(null, "길동이네 뗙복희");
        this.entityManager.persist(restaurant);
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_restaurant
         *         (name)
         *     values
         *         (?)
         */
        assertThat(restaurant.getId()).isNotNull();

        // when
        Review review = new Review().builder()
                .restaurant(restaurant) // restaurant지정
                .grade(Grade.STAR5)
                .comment("😋😋😋GMT~!~!~😋😋😋")
                .build();
        this.entityManager.persist(review); // flush를 안써도 확인이 될거임
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_review
         *         (comment, grade, restaurant_id)
         *     values
         *         (?, ?, ?)
         */


        // then
        System.out.println(review);
        assertThat(review.getId()).isNotNull();

        this.entityManager.clear();
        Review review2 = this.entityManager.find(Review.class, review.getId());
        /**
         * Hibernate:
         *     select
         *         r1_0.id,
         *         r1_0.comment,
         *         r1_0.grade,
         *         r2_0.id,
         *         r2_0.name
         *     from
         *         tbl_review r1_0
         *     left join
         *         tbl_restaurant r2_0
         *             on r2_0.id=r1_0.restaurant_id
         *     where
         *         r1_0.id=?
         * 7월 10, 2024 11:20:
         */
        assertThat(review2).isNotNull();
        assertThat(review2.getRestaurant()).isNotNull();
    }

    @Test
    @DisplayName("식당 별 N건의 Review 조회")
    void test3() {
        // given
        Restaurant restaurant = new Restaurant(null, "족발장슈");
        List<Review> reviews = List.of(
                Review.builder().restaurant(restaurant).grade(Grade.STAR5).comment("🐷왕족발보쌈🐷").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR4).comment("😊와우아ㅗ아우앙융😊").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR5).comment("🤑돈방석 앉으세요~~🤑").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR2).comment("🐽이게 족발이제~🐽").build(),
                Review.builder().restaurant(restaurant).grade(Grade.STAR2).comment("😂아쉬운 맛😂").build()
        );
        this.entityManager.persist(restaurant);
        reviews.forEach(this.entityManager::persist);
        /**
         * restaurant insert문 하나에 review insert문 5개 들어감
         */

        // when
        this.entityManager.clear();
        String jpql = """
                select
                    r
                from
                    Review r
                where
                    r.restaurant = :restaurant
                """; // 특정 restaurant의 여러건 review 조회 할 수 잇움
        TypedQuery<Review> query = this.entityManager.createQuery(jpql, Review.class)
                                        .setParameter("restaurant", restaurant);
        List<Review> reviews2 = query.getResultList(); // 여러건의 결과조회할 때 ResultList를 사용하면 됨
        /**
         * 🙉🙉Restaurant에 review 필드가 없어도 jpql이 만들어준다는 것을 기억하기!🙉🙉
         * Hibernate:
         *     select
         *         r1_0.id,
         *         r1_0.comment,
         *         r1_0.grade,
         *         r1_0.restaurant_id
         *     from
         *         tbl_review r1_0
         *     where
         *         r1_0.restaurant_id=?
         * Hibernate:
         *     select
         *         r1_0.id,
         *         r1_0.name
         *     from
         *         tbl_restaurant r1_0
         *     where
         *         r1_0.id=?
         */
        reviews2.forEach(System.out::println);

        // then
        assertThat(reviews2).isNotEmpty()
                .allMatch((review -> review.getRestaurant().equals(restaurant))); // restaurant와 내용이 같니? 메모리 상으로는 같은 건 아님!
    }

}
