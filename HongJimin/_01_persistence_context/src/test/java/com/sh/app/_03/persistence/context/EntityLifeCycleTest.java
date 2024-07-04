package com.sh.app._03.persistence.context;

import com.sh.app._02.crud.Menu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>
 * 영속성 컨텍스트는 엔티티 매니저가 엔티티 객체를 저장하는 공간으로 엔티티 객체를 보관하고 관리한다.
 * 엔티티 매니저가 생성 될 때 하나의 영속성 컨텍스트가 만들어진다.
 *
 * 엔티티의 생명 주기
 * - 비영속, 영속, 준영속, 삭제 상태
 * </pre>
 */
public class EntityLifeCycleTest {
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
    @DisplayName("비영속성 테스트")
    void test1() {
        // given -> 얘는 영속하는애
        Menu menu = entityManager.find(Menu.class, 10L); // 조회만 해도 영속성 컨텍스트에 등록이 됨
        System.out.println(menu);

        // when -> 얘는 영속하고 있지 않은 애
        Menu menu2 = new Menu();
        menu2.setMenuCode(menu.getMenuCode());
        menu2.setMenuName(menu.getMenuName());
        menu2.setMenuPrice(menu.getMenuPrice());
        menu2.setCategoryCode(menu.getCategoryCode());
        menu2.setOrderableStatus(menu.getOrderableStatus());
        System.out.println(menu2);

        // then
        assertThat(menu).isNotSameAs(menu2);
        assertThat(entityManager.contains(menu)).isTrue(); // 영속
        assertThat(entityManager.contains(menu2)).isFalse(); // 비영속
    }

    @Test
    @DisplayName("영속 컨텍스트에 추가")
    void test2() {
        // given
        Menu menu = new Menu();
//        menu.setMenuCode(99L); // 이제 안해도됨
        menu.setMenuName("강심장버거");
        menu.setMenuPrice(13000);
        menu.setCategoryCode(4L);
        menu.setOrderableStatus("Y");
        // menu객체는 여기까지 아직 비영속

        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin(); // 트랜잭션 시작 ~ commit/rollback 까지가 트랜잭션 범위가 됨
        try {
            entityManager.persist(menu); // 🌟실제로 영속하는 부분 (@GeneratedValue(strategy = GenerationType.IDENTITY)
            System.out.println("menu가 영속성 컨텍스트에 저장되었습니다...");
            transaction.commit(); // commit
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
        // then
        assertThat(menu.getMenuCode()).isNotZero(); // auto_increment로 id값을 할당받음
        assertThat(entityManager.contains(menu)).isTrue(); // 영속성 컨텍스트에 menu 객체 저장
    }

    @Test
    @DisplayName("엔티티객체 동일성 보장") //  연속 조회를 해도 동일함
    void test3() { // select 쿼리가 한번만 날아감!!!
        // given
        Long menuCode = 10L;

        // when
        Menu menu1 = entityManager.find(Menu.class, menuCode); // 쿼리가 날아감, menu객체 영속
        Menu menu2 = entityManager.find(Menu.class, menuCode); // 쿼리가 날아가지 않음(쿼리 질의 없음), 영속성ㅇ컨텍스트에서 조회

        // then
        assertThat(menu1).isSameAs(menu2);
        assertThat(entityManager.contains(menu1)).isTrue();
    }
}
