package com.sh.app._03.persistence.context;

import com.sh.app._02_crud.Menu;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EntityLifecycleTest {

    // request-scope: 웹요청마다 1개씩 생성 (non-thread-safe)
    private EntityManager entityManager;
      private static EntityManagerFactory entityManagerFactory;
    // request-scope: 웹요청마다 1개씩 생성 (non-thread-safe)

    @BeforeAll
    static void beforeAll() {
        // jpa설정정보를 읽어서 EntityManagerFactory를 생성
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
        entityManagerFactory.close();
    }

    @Test
    @DisplayName("비영속성 테스트")
    void test1() {
        // given
        Menu menu =entityManager.find(Menu.class, 10L); // 조회를하면 영속성 컨텍스트에 등록이 됨
        // 그래서 Menu는 영속상태고 , menu2는 내용은 같지만 엄연히 다른객체임
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

        assertThat(menu).isNotSameAs(menu2);
        assertThat(entityManager.contains(menu)).isTrue();//영속
        assertThat(entityManager.contains(menu2)).isFalse(); // 비영속
    }

    @Test
    @DisplayName("영속컨텍스트에추가 ")
    void test2() {
        // given
        Menu menu = new Menu();
        menu.setMenuName("강심장버거");
        menu.setMenuPrice(13000);
        menu.setCategoryCode(4L);
        menu.setOrderableStatus("Y");
        // -> 이때까지 비영속 menu 객체는 아직 비영속
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin(); // 트랜잭션 시작 ~ commit/ rollback 까지가 트랜잭션 범위가 된다.
        try{
            entityManager.persist(menu); // 영속성컨텍스트에 menu 엔티티객체를 저장 (@GeneratedValue 설정시 insert 쿼리는 바로 실행 )
            // PK를 알아야 영속성 컨텍스트에 저장이 가능하다 .
            System.out.println("menu가 영속성 컨텍스트에 저장되었습니다...");
            transaction.commit(); // DB에 쿼리 질의 insert into ....
        }catch (Exception e){
            transaction.rollback();

        }
        // when
        // then
    }

    @Test
    @DisplayName("엔티티객체 동일성 보장 ")
    void test3() {
        // given
        Long menuCode = 10L;
        // when
        Menu menu1 = entityManager.find(Menu.class, menuCode);
        Menu menu2 = entityManager.find(Menu.class, menuCode);
        // then
        assertThat(menu1).isSameAs(menu2);
        assertThat(entityManager.contains(menu1)).isTrue();
    }

}
