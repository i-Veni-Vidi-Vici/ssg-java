package com.sh.app._02.crud;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setRemoveAssertJRelatedElementsFromStackTrace;

public class CRUDTest {
    // application-scope: 1개만 만들어서 재사용 (thread-safe)
    private static EntityManagerFactory entityManagerFactory;

    // request-scope: 웹요청마다 1개씩 생성 (non-thread-safe)
    private EntityManager entityManager;

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
    @DisplayName("메뉴 한건 조회")
    void test1() {
        // given
        Long menuCode=1L;

        // when
        Menu menu=this.entityManager.find(Menu.class,menuCode);
        System.out.println("menu = " + menu);

        // then
        assertThat(menu).isNotNull();
    }

    @Test
    @DisplayName("메뉴 여러 건 조회")
    void testRead2() {
        // given
        String jpql="select m from Menu as m"; // jpa안에서만 사용가능한 sql 대소문자 구분해야 함

        TypedQuery<Menu> query= entityManager.createQuery(jpql, Menu.class);

        //when
        List<Menu> menus = query.getResultList();
        System.out.println("menus = " + menus);

    }

    /**
     * <pre>
     * EntityTransaction객체를 통해서 트랜잭션 범위 및 commit/rollback 처리를 해줘야 한다
     * </pre>
     */
    @Test
    @DisplayName("메뉴 신규 등록")
    void testInsert3() {
        Menu menu=new Menu();

        menu.setMenuName("강심장버거");
        menu.setMenuPrice(13000);
        menu.setCategoryCode(4L);
        menu.setOrderableStatus("Y");

        //when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin(); // 트랜잭션 시작이다 commit / rollback 까지가 트랜잭션 범위, 하나로 묶어서 처리

        try {
            entityManager.persist(menu); // 영속성컨텍스트의 menu 엔티티 객체를 저장하는 놈// @GeneratedValue 설정시 insert쿼리는 바로 실행, PK를 알아야 영속성컨텍스트에 저장가능하다.
            System.out.println("menu가 영속성 컨텍스트에 저장되었습니다");
            transaction.commit(); // DB에 쿼리 질의 insert into가 날라감 // 여기서 @Generator 어노테이션 때문에 순서에 조금 차이가 생겻다
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
    @DisplayName("메뉴 정보 수정")
    void updateMenu() {
        // given (엔티티 조회 먼저한 후, 수정을 진행한다

        Menu menu=entityManager.find(Menu.class,1L); // menu에서 메뉴코드 1번님놈들 가져온다
        System.out.println(menu);

        int newMenuPrice=menu.getMenuPrice()+100;

        //when
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        try{
            // 등록/수정/삭제 코드
            menu.setMenuPrice(newMenuPrice);
            System.out.println("영속선컨텍스트 메뉴 객체의 정보가 변경되었습니다");
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }

        Menu menu1=entityManager.find(Menu.class,1L);
        System.out.println("menu1 = " + menu1);

    }

    @Test
    @DisplayName("메뉴 정보 삭제")
    void deleteMenu() {
        // 수정이랑 삭제하려면 무조건 해야되는 걸 가져와야함
        Menu menu=entityManager.find(Menu.class,1L);
        System.out.println(menu);


        //when
        EntityTransaction transaction=entityManager.getTransaction();
        transaction.begin();
        try{
            // 등록/수정/삭제 코드
            entityManager.remove(menu);
            System.out.println("영속선컨텍스트 메뉴 객체의 정보가 삭제되었습니다"+ menu);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }

        Menu menu1=entityManager.find(Menu.class,1L);
        assertThat(menu1).isNull();

    }

}
