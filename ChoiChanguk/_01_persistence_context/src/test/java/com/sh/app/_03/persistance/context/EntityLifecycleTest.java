package com.sh.app._03.persistance.context;

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

public class EntityLifecycleTest {

    // application-scope: 1개만 만들어서 재사용 (thread-safe)
    private static EntityManagerFactory entityManagerFactory; // 이건 무조건 1개

    // request-scope: 웹요청마다 1개씩 생성 (non-thread-safe)
    private EntityManager entityManager; // 이건 테스트마다 1개씩, 그리고 persistance는 매니저마다 한개씩

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
        //given
        Menu menu = entityManager.find(Menu.class, 10L); // 얘는 영속 함, 영속컨텍스트에 등록
        System.out.println("menu = " + menu);

        //when
        // 여기는 영속하지 않음
        Menu menu1=new Menu(); // manager가 없네?? 그럼 그냥 메모리에 있는 객체임
        menu1.setMenuCode(menu.getMenuCode());
        menu1.setMenuName(menu.getMenuName());
        menu1.setMenuPrice(menu.getMenuPrice());
        menu1.setCategoryCode(menu.getCategoryCode());
        menu1.setOrderableStatus(menu.getOrderableStatus());
        System.out.println("menu1 = " + menu1);

        assertThat(menu).isNotSameAs(menu1);


    }

    @Test
    @DisplayName("영속컨텍스트에 추가")
    void test2() {
        Menu menu=new Menu();
        menu.setMenuCode(99L);
        menu.setMenuName("강심장버거");
        menu.setMenuPrice(13000);
        menu.setCategoryCode(4L);
        menu.setOrderableStatus("Y");
//menu객체는 여기까지 비영속

        //when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin(); // 트랜잭션 시작이다 commit / rollback 까지가 트랜잭션 범위, 하나로 묶어서 처리

        try {
            //여기부터 딱 영속하는 순간이다
            entityManager.persist(menu); // 영속성컨텍스트의 menu 엔티티 객체를 저장하는 놈// @GeneratedValue 설정시 insert쿼리는 바로 실행, PK를 알아야 영속성컨텍스트에 저장가능하다.
            System.out.println("menu가 영속성 컨텍스트에 저장되었습니다");
            transaction.commit(); // DB에 쿼리 질의 insert가 날라감 // 여기서 @Generator 어노테이션 때문에 순서에 조금 차이가 생겻다
        }catch (Exception e)
        {
            transaction.rollback();
            e.printStackTrace();
        }

        // then
        assertThat(menu.getMenuCode()).isNotZero(); // auto_increment로 id값을 할당받음
        assertThat(entityManager.contains(menu)).isTrue();
    }

    @Test
    @DisplayName("엔티티객체 동일성 보장")
    void test3() {
        //given
        Long menuCode=10L;

        //when
        // 우선 영속성컨텍스트를 먼저 찾아본다
        Menu menu1=entityManager.find(Menu.class,menuCode); // 쿼리 질의, menu 객체 영속
        Menu menu2=entityManager.find(Menu.class,menuCode); // 질의 없이 , 영속성컨텍스트에서 조회

        assertThat(menu1).isSameAs(menu2);

    }

}
