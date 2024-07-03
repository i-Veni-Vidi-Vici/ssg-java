package com.sh.app._02.crud;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class CRUDTest {
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
    @DisplayName("메뉴 한건 조회")
    void test1() {
        // given
        Long menuCode = 1L;

        // when
        Menu menu = this.entityManager.find(Menu.class, menuCode); // 타입, pk값
        System.out.println(menu);

        // then
        assertThat(menu)
                .isNotNull()
                .satisfies(
                        (_menu) -> assertThat(_menu.getMenuCode()).isEqualTo(menuCode),
                        (_menu) -> assertThat(_menu.getMenuName()).isNotNull(),
                        (_menu) -> assertThat(_menu.getMenuPrice()).isNotZero(),
                        (_menu) -> assertThat(_menu.getOrderableStatus()).satisfiesAnyOf(
                                (orderableStatus) -> assertThat(orderableStatus).isEqualTo("Y"),
                                (orderableStatus) -> assertThat(orderableStatus).isEqualTo("N")
                        )
                );
    }


    // 하나에 관해서는 할 수 있지만, 여러건 조회는 얘네가 제공하는 jpql을 사용하기
    @Test
    @DisplayName("메뉴 여러건 조회")
    void test2() {
        // given
        String jpql = "select m from Menu as m"; // jpa 안에서만 사용 가능한, sql, entity객체에 대한 쿼리
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);

        // when
        List<Menu> menus = query.getResultList();
        System.out.println(menus);

        // then
        assertThat(menus)
                .isNotEmpty()
                .allMatch((menu) -> menu != null); // 요소별로 람다를 실행함, 모두 true 여야 단정 성공, 하나라도 false면 단정 실패
    }

    /**
     * <pre>
     *   EntityTransaction 객체를 통해 트랜잭션 범위 및 commit / rollback 처리를 해줘야 함
     * </pre>
     */
    @Test
    @DisplayName("메뉴 신규 등록")
    void test3() { // 등록은 Entity 매니저한테 부탁해야함
        // given
        Menu menu = new Menu();
        menu.setMenuName("강심장버거");
        menu.setMenuPrice(13000);
        menu.setCategoryCode(4L);
        menu.setOrderableStatus("Y");

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin(); // 트랜잭션 시작 ~ commit/rollback 까지가 트랜잭션 범위가 됨
        try {
            entityManager.persist(menu); // 영속성 컨텍스트에 menu 엔티티 객체를 저장, @GeneratedValue 설정시 insert 쿼리는 바로 실행, PK를 알아야 영속성 컨텍스트에 저장이 가능함)
            System.out.println("menu가 영속성 컨텍스트에 저장되었습니다...");
            transaction.commit(); // DB에 쿼리 질의 insert into.. / 영속성 컨텍스트에 저장과 실제 db에 저장되는 것은 다름, 제너레이트 valu값을 쓴 경우에는 insert 쿼리가 바로 실행됨
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        assertThat(menu.getMenuCode()).isNotZero(); // auto_increment로 id값을 할당받음
        assertThat(entityManager.contains(menu)).isTrue(); // 영속성 컨텍스트에 menu 객체 저장
    }

    @Test
    @DisplayName("메뉴 정보 수정")
    void test4() {
        // given (엔티티 조회가 먼저한 후, 수정을 진행함)
        Menu menu = entityManager.find(Menu.class, 1L);
        System.out.println(menu);

        int newMenuPrice = menu.getMenuPrice() + 100;

        // when -> 🌟이부분이 service단에 작성될 예정
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            // entity 등록/수정/삭제 코드
            menu.setMenuPrice(newMenuPrice); // 실제 변경은 여기서 이뤄짐 , but 업데이트 쿼리는 아님!
            System.out.println("영속성 컨텍스트 메뉴 객체의 정보가 변경되었습니다. : " + menu);
            transaction.commit(); // update쿼리가 여기서 날아감

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }

        // then
        Menu menu2 = entityManager.find(Menu.class, 1L);
        assertThat(menu2.getMenuPrice()).isEqualTo(newMenuPrice);
    }

    @Test
    @DisplayName("메뉴 객체 삭제") // jpa에서 수정/ 삭제 할 때는 무조건 한 건을 가져와야 함
    void test5() {
        // given
        Menu menu = entityManager.find(Menu.class, 1L);

        // when -> 🌟이부분이 service단에 작성될 예정
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            // entity 등록/수정/삭제 코드
            entityManager.remove(menu); // 가지고 있는 객체 지워!, 메뉴 객체가 영속성에서는 삭제되었지만, 쿼리 날리는 것은 별개
            System.out.println("영속성 컨텍스트 메뉴 객체가 삭제되었습니다. : " + menu);
            transaction.commit(); // update쿼리가 여기서 날아감

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        Menu menu2 = entityManager.find(Menu.class, 1L);
        assertThat(menu2).isNull();

    }
}
