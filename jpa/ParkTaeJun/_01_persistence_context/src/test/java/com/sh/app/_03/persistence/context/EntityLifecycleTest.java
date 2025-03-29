package com.sh.app._03.persistence.context;

import com.sh.app._02_crud.Menu;
import jakarta.persistence.*;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

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

    /**
     *이런거 있다 정도로만 알고 있으면 됨
     * 영속상태의 entity객체를 더 이상 영속 컨텍스트에서 관리하지 않도록하는 것임.
     *
     */
    @Test
    @DisplayName("준영속 detach")
    void test4() {
        // given
        Menu menu = entityManager.find(Menu.class, 10L);
        // when
        entityManager.detach(menu);
        // then
        assertThat(entityManager.contains(menu)).isFalse();
    }

    @Test
    @DisplayName("제거")
    public void test() throws Exception{
        // given
        Menu menu10 = entityManager.find(Menu.class, 10L);
        Menu menu11 = entityManager.find(Menu.class, 11L);
        assertThat(entityManager.contains(menu10)).isTrue();
        assertThat(entityManager.contains(menu11)).isTrue();
        // when

        entityManager.clear(); // 모든 영속객체 제거

        // 영속성컨텍스트 1차캐시 안에 존재하지 않으므로 DB 질의를 다시하게 된다.
        Menu menu10_2 = entityManager.find(Menu.class, 10L);
        // then
        assertThat(entityManager.contains(menu10)).isFalse();
        assertThat(entityManager.contains(menu11)).isFalse();
    }

    /**
     * remove를 호출하면 , 단순히 영속성 컨텍스트에서 제거 뿐 아니라 db로 delete 요청까지 질의한다.
     *
     * flush : 영속성컨텍스트의 변경사항으로 실제 DB에 동기화하는 작업
     *  - 트랜잭션 커밋시에 flush처리된다.
     *
     */
    @Test
    @DisplayName("삭제 remove")
    void test6() {
        // given
        Menu menu2 = entityManager.find(Menu.class, 2L);
        System.out.println(menu2);
        // when
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            entityManager.remove(menu2); // 영속성컨텍스트에서 삭제처리
            entityManager.flush(); // 원래라면 쿼리 질의 , 명시적으로도 호출할 수 있지만 명시적으로 호출하지 않아도 커밋할 때 같이 쿼리 날라감
            transaction.commit(); // delete 질의 , 실제 커밋
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }


        // then
        assertThat(entityManager.contains(menu2)).isFalse();
    }

    /**
     * 준영속객체를 다시 영속성컨텍스트에 포함시킬 수 있다.
     * - 동일한 PK를 가진 엔티티객체가 없다면 우선 DB에서 조회 후, 변경사항을 업데이트
     * - 동일한 PK를 가진 엔티티객체가 있다면 수정(갱신)
     */
    @Test
    @DisplayName("다시 영속시키기 merge")
    void test7() {
        // given
        Menu menu10 = entityManager.find(Menu.class,10L);
        System.out.println(menu10);
        entityManager.detach(menu10);
        assertThat(entityManager.contains(menu10)).isFalse();
        // when
        String newMenuName = "희망이죽";
        menu10.setMenuName(newMenuName); // 코다리마늘빵 -> 희망이 죽
        // PK가 10인 Menu 객체를 다시 DB에서 조회후에 menu10 객체와 병합을 시도한다.
        entityManager.merge(menu10); // select 지릐
        System.out.println("병합완료");
        // then
        Menu menu10_2 = entityManager.find(Menu.class, 10L);
        assertThat(menu10_2.getMenuName()).isEqualTo(newMenuName);

        // 단순히 DB반영 목적이라면
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
    }


    @Test
    @DisplayName("영속성컨텍스트 종료 close")
    void test8() {
        // given
        Menu menu = entityManager.find(Menu.class, 10L);
        // when
        entityManager.close();
        // then
        assertThatThrownBy(() -> {
            entityManager.find(Menu.class, 10L);
        }).isInstanceOf(IllegalStateException.class); // 예외가 던져져야 함
    }

}
