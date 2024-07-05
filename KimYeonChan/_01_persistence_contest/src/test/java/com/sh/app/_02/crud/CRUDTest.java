package com.sh.app._02.crud;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CRUDTest {
    private static EntityManagerFactory factory;
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        // jpa 설정정보를 읽어서 EntityManagerFactory를 생성
        factory = Persistence.createEntityManagerFactory("jpatest");
    }

    @BeforeEach
    void setUp() {
        this.entityManager = factory.createEntityManager();
    }

    @AfterEach
    void tearDown() {
        this.entityManager.close();
    }

    @AfterAll
    static void afterAll() {
        factory.close();
    }

    @Test
    @DisplayName("메뉴 한건 조회")
    void test1() {
        // given
        Long menuCode = 1L;
        // when
        Menu menu = this.entityManager.find(Menu.class, menuCode);
        // then
        assertThat(menu)
                .isNotNull()
                .satisfies(
                        (_menu) -> assertThat(_menu.getMenuCode()).isEqualTo(menuCode),
                        (_menu) -> assertThat(_menu.getMenuName()).isNotNull(),
                        (_menu) -> assertThat(_menu.getMenuPrice()).isPositive(),
                        (_menu) -> assertThat(_menu.getOrderableStatus()).satisfiesAnyOf(
                                (orderableStatus) -> assertThat(orderableStatus).isEqualTo("Y"),
                                (orderableStatus) -> assertThat(orderableStatus).isEqualTo("N")
                        )
                );
    }

    @Test
    @DisplayName("메뉴 여러건 조회")
    void test2() {
        // given
        String jpql = "select m from Menu as m"; // jpa 안에서만 사용가능한 sql
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        // when
        List<Menu> menus = query.getResultList();
        System.out.println(menus);
        // then
        assertThat(menus)
                .isNotEmpty()
                .allMatch((menu) -> menu != null);
    }

    /**
     * EntityTransaction 객체를 통해서 트랜잭션 범위 및 commit/rollback 처리를 해줘야 한다.
     */
    @Test
    @DisplayName("메뉴 한건 등록")
    void test3() {
        // given
        Menu menu = new Menu();
        menu.setMenuName("홍어쉐이크");
        menu.setMenuPrice(10_000_000);
        menu.setCategoryCode(4L);
        menu.setOrderableStatus("Y");
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin(); // 트랜잭션 시작 ~ commit/rollback 까지가 트랜잭션 범위가 된다.
        try {
            entityManager.persist(menu); // 엔티티객체를 저장 (@GeneratedValue 설정시 insert 쿼리는 바로 실행. pk를 알아야 영속성컨텍스트에 저장된다.)
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        assertThat(menu.getMenuCode()).isNotNull(); // auto_increment로 id값을 할당 받음
        assertThat(entityManager.contains(menu)).isTrue(); // 영속성 컨텍스트에 menu 객체 저장
    }

    @Test
    @DisplayName("메뉴 정보 수정")
    void test4() {
        // given (엔티티 조회 후 수정을 진행한다.)
        Menu menu = entityManager.find(Menu.class, 1L);
        System.out.println(menu);

        // when

        // then
    }

    @Test
    @DisplayName("메뉴객체 삭제")
    void test5() {
        // given
        Menu menu = entityManager.find(Menu.class, 1L);
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.remove(menu);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        Menu menu2 = entityManager.find(Menu.class, 1L);
        assertThat(menu2).isNull();
    }
}
