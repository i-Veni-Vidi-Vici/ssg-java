package com.sh.app._03.persistence.context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class EntityLifeCycleTest {
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
    @DisplayName("비영속성 테스트")
    void test1() {
        // given
        Menu menu = entityManager.find(Menu.class, 10L);
        System.out.println(menu);

        // when
        Menu menu2 = new Menu();
        menu2.setMenuCode(menu.getMenuCode());
        menu2.setMenuName(menu.getMenuName());
        menu2.setMenuPrice(menu.getMenuPrice());
        menu2.setCategoryCode(menu.getCategoryCode());
        menu2.setOrderableStatus(menu.getOrderableStatus());
        System.out.println(menu2);

        // then
        assertThat(menu)
                .isNotSameAs(menu2);
        assertThat(entityManager.contains(menu)).isTrue();
        assertThat(entityManager.contains(menu2)).isFalse();
    }

    @Test
    @DisplayName("영속 컨텍스트에 추가")
    void test2() {
        // given
        Menu menu = new Menu();
        menu.setMenuCode(200L);
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
    @DisplayName("엔티티 객체 동일성 보장")
    void test3() {
        // given
        Long menuCode = 10L;

        // when
        Menu menu = entityManager.find(Menu.class, menuCode);
        Menu menu2 = entityManager.find(Menu.class, menuCode);

        // then
        
    }
}
