package com.sh.app._02.crud;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CRUDTest {
    // application scope -> 1개만 만들어서 재사용 (thread-safe)
    private static EntityManagerFactory entityManagerFactory;
    // request scope -> 웹요청마다 1개씩 생성 (non-thread-safe)
    private EntityManager entityManager;

    @BeforeAll
    static void beforeAll() {
        // jpa 설정정보를 읽어서 EntityManagerFactory를 생성
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
        entityManagerFactory.close(); // 자원반납
    }

    @Test
    @DisplayName("메뉴 한건 조회")
    void test1() {
        // given
        Long menuCode = 1L;
        // when
        Menu menu = this.entityManager.find(Menu.class, menuCode); // 타입, PK값 전달
        System.out.println(menu);
        // then
        assertThat(menu).isNotNull()
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

    @Test
    @DisplayName("메뉴 여러건 조회")
    void test2() {
        // given
        String jpql = "select m from Menu as m"; // jpa 안에서만 사용가능한 sql. entity객체에 대한 쿼리
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        // when
        List<Menu> menus = query.getResultList();
        System.out.println(menus);
        // then
        assertThat(menus).isNotNull()
                        .allMatch((menu) -> menu != null);
    }

    /**
     * <pre>
     * DML은 EntityTransacton객체를 통해서 트랜잭션 범위 및 commit/rollback처리 필요
     * </pre>
     */
    @Test
    @DisplayName("메뉴 신규 등록")
    void test3() {
        // given
        Menu menu = new Menu();
        menu.setMenuName("강심장버거");
        menu.setMenuPrice(13000);
        menu.setCategoryCode(4L);
        menu.setOrderableStatus("Y");
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin(); // 트랜잭션 시작 ~ commit/rollback까지가 트랜잭션 범위가 됨
        try{
            entityManager.persist(menu); // DB에 쿼리 질의 insert into (실제 쿼리 날라감) : @GeneratedValue 때문
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        assertThat(menu.getMenuCode()).isNotZero(); // auto_increment로 id값을 할당받음
        assertThat(entityManager.contains(menu)).isTrue(); // 영속성 컨텍스트에 menu객체 저장
    }

    @Test
    @DisplayName("메뉴 정보 수정")
    void test4() {
        // given (엔티티 조회 후 수정 진행함)
        Menu menu = entityManager.find(Menu.class, 1L);
        System.out.println(menu);

        int newMenuPrice = 5500;
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            // entity 등록/수정/삭제
            menu.setMenuPrice(newMenuPrice);
            System.out.println("영속성컨텍스트 메뉴 객체의 정보가 변경되었음 : " + menu);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        Menu menu2 = entityManager.find(Menu.class, 1L);
        assertThat(menu2.getMenuPrice()).isEqualTo(newMenuPrice);
    }

    @Test
    @DisplayName("메뉴 객체 삭제")
    void test5() {
        // given
        Menu menu = entityManager.find(Menu.class, 1L);

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            // entity 등록/수정/삭제
            entityManager.remove(menu);
            System.out.println("영속성컨텍스트 메뉴 객체가 삭제되었음 : " + menu);
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        Menu menu2 = entityManager.find(Menu.class, 1L);
        assertThat(menu2).isNull();
    }
}
