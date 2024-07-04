package com.sh.app._03.persistence.context;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
//        menu.setMenuCode(200L);
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

    /**
     * 영속 상태의 entity 객체를 더 이상 영속 컨텍스트에서 관리하지 않도록 하는 것이다.
     */
    @Test
    @DisplayName("준영속 detach")
    void test4() {
        // given
        Menu menu = entityManager.find(Menu.class, 10L);
        Menu menu1 = entityManager.find(Menu.class, 10L);
        // when
        entityManager.detach(menu);
        Menu menu2 = entityManager.find(Menu.class, 10L);

        // then
        assertThat(entityManager.contains(menu)).isFalse();
        System.out.println(System.identityHashCode(menu));
        System.out.println(System.identityHashCode(menu1));
        System.out.println(System.identityHashCode(menu2));
    }

    /**
     * 모든 영속된 엔티티객체를 영속성 컨텍스트로부터 제거한다.
     */
    @Test
    @DisplayName("준영속 clear")
    void test5() {
        // given
        Menu menu10 = entityManager.find(Menu.class, 10L);
        Menu menu11 = entityManager.find(Menu.class, 11L);
        assertThat(entityManager.contains(menu10)).isTrue();
        assertThat(entityManager.contains(menu11)).isTrue();
        // when
        entityManager.clear();
        // then
        assertThat(entityManager.contains(menu10)).isFalse();
        assertThat(entityManager.contains(menu11)).isFalse();
    }

    /**
     * remove를 호출하면, 단순히 영속성컨텍스테서 제거뿐 아니라 db로 delete 요청까지 질의함
     * flush: 영속성 컨텍스트의 변경사항으로 실제 DB에 동기화하는 작업
     */
    @Test
    @DisplayName("삭제 remove")
    void test6() {
        // given
        Menu menu = entityManager.find(Menu.class, 10L);
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.remove(menu); // 영속성 컨텍스트에서 삭제 처리
//            entityManager.flush(); // delete 쿼리 질의
//            transaction.commit(); // commit
            transaction.commit(); // delete 질의
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        assertThat(entityManager.contains(menu)).isFalse();
    }

    /**
     * 준영속객체를 다시 영속컨텍스트에 포함시킬수 있다.
     * - 동일한 pk를 가진 엔티티객체가 없다면 사입
     * - 동일한 pk를 가진 엔티티객체가 있다면 수정(갱신)
     */
    @Test
    @DisplayName("다시 영속시키기 merge")
    void test7() {
        // given
        Menu menu = entityManager.find(Menu.class, 10L);
        entityManager.detach(menu);
        assertThat(entityManager.contains(menu)).isFalse();
        // when
        // pk가 10인 Menu 객체를 다시 조회후에 menu10 객체와 병합 시도한다.
        entityManager.merge(menu);
        // then
        assertThat(entityManager.contains(menu)).isTrue();
    }

    @Test
    @DisplayName("영속성컨테스트 종료 close")
    void test8() {
        // given
        Menu menu = entityManager.find(Menu.class, 11L);
        // when
        entityManager.close();
        // then
        assertThatThrownBy(() -> {
            entityManager.find(Menu.class, 11L);
        }).isInstanceOf(IllegalStateException.class);
    }
}
