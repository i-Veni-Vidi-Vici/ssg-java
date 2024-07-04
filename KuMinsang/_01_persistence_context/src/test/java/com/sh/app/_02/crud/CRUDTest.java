package com.sh.app._02.crud;

import jakarta.persistence.*;
import org.junit.jupiter.api.*;
import org.junit.platform.commons.function.Try;

import java.util.List;

import static java.awt.SystemColor.menu;
import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("메뉴 한건 조회")
    @Test
    public void test1() {
        //given
        Long menuCode = 1L;
        //when
        Menu menu = this.entityManager.find(Menu.class, menuCode);
        System.out.println(menu);
        //then
        assertThat(menu).isNotNull()
                .satisfies(
                        (_menu)->assertThat(_menu.getMenuCode()).isEqualTo(menuCode),
                        (_menu)->assertThat(_menu.getMenuName()).isNotNull(),
                        (_menu)->assertThat(_menu.getMenuPrice()).isNotZero(),
                        (_menu)->assertThat(_menu.getOrderableStatus()).satisfiesAnyOf(
                                (orderableStatus)->assertThat(orderableStatus).isEqualTo("Y"),
                                (orderableStatus)->assertThat(orderableStatus).isEqualTo("N")
                        )
                );
    }

    @DisplayName("메뉴 여러건 조회")
    @Test
    public void test2() {
        //given
        //여기서 Menu는 @Entity(name="Menu")에서 name 값이다
        String jpql = "select m from Menu as m";   //jpa안에서만 사용가능한 sql, entity객체에 대한 쿼리
        TypedQuery<Menu> query = entityManager.createQuery(jpql, Menu.class);
        //when
        List<Menu> menus = query.getResultList();
        System.out.println(menus);
        //then
        assertThat(menus)
                .isNotEmpty()
                .allMatch((menu)-> menu != null);   //타입은 레퍼타입으로 사용해야 null 값을 처리할수 있다
    }

    /**
     * <pre>
     *     EntityTransaction 객체를 통해서 트랜잭션 범위 및 commit/rollback 처리를 해줘야 한다
     * </pre>
     */

    @DisplayName("메뉴 신규 등록")
    @Test
    public void test3() {
        //given
        Menu menu = new Menu();
        menu.setMenuName("강심장버거");
        menu.setMenuPrice(13000);
        menu.setCategoryCode(4L);
        menu.setOrderableStatus("Y");
        //when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();    //트랜잭션 시작 ~commit/rollback까지가 트랜잭션 범위가 된다.
        try{
            entityManager.persist(menu);
            System.out.println("menu가 영속성 컨텍스트에 저장되었습니다.");
            transaction.commit();
        } catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        //then
        assertThat(menu.getMenuCode()).isNotZero(); //auto_increment로 id 값을 할당 받음
        assertThat(entityManager.contains(menu)).isTrue();  //영속성 컨텍스트에 menu객체 저장
    }

    @DisplayName("메뉴 정보 수정")
    @Test
    public void test4() {
        //given
        Menu menu = entityManager.find(Menu.class, 1L);
        System.out.println(menu);
        int newMenuPrice = menu.getMenuPrice()+100;
        //when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            menu.setMenuPrice(newMenuPrice);
            System.out.println("영속성 컨텍스트 메뉴 객체의 정보가 변경되었습니다. : " + menu);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        //then
        Menu menu2 = entityManager.find(Menu.class, 1L);
        assertThat(menu2.getMenuPrice()).isEqualTo(newMenuPrice);
    }

    @DisplayName("메뉴객체 삭제")
    @Test
    public void test5() {
        //given
        Menu menu = entityManager.find(Menu.class, 1L);
        //when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
            entityManager.remove(menu);
            System.out.println("영속성 컨텍스트 메뉴 객체가 삭제 되었습니다. : " + menu);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        //then
        Menu menu2 = entityManager.find(Menu.class, 1L);
        assertThat(menu2).isNull();
    }
}
