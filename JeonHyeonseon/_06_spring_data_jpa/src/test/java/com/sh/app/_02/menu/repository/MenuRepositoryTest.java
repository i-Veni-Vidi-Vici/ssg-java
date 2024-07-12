package com.sh.app._02.menu.repository;

import com.sh.app.menu.entity.Menu;
import com.sh.app.menu.entity.OrderableStatus;
import com.sh.app.menu.repository.MenuRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <pre>
 * 우리가 작성한 MenuRepository 인터페이스의 상속구조
 *  - jpa는 MenuRepository 인터페이스의 구현객체를 동적으로 생성해서 제공한다. (그래서 의존주입을 받을 수 있었음)
 *  - 이 객체는 MenuRepository의 추상메소드를 구현했을 것이다.
 *  - 이 객체는 부모인터페이스인 JpaRepository의 추상메소드를 구현했을 것이다.
 *  - 이 객체는 조상인터페이스인 PagingAndSortRepository, CrudRepository, Repository의 추상메소드를 구현했을 것이다.
 * </pre>
 */

@DataJpaTest // 기본적으로 jpa관련 빈만 로드해서 @SpringBootTestd 대비 가볍다. 실제 db를 사용하겠다는 어노테이션 필요.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 테스트용 메모리 DB를 사용하지 않고 실제 db에 붙어서 사용하겠다는 어노테이션
class MenuRepositoryTest {
    @Autowired
    private MenuRepository menuRepository;

    @Test
    @DisplayName("MenuRepository 구현클래스의 빈을 의존주입 받는다.")
    void test1() {
        // given
        // when
        // then
        assertThat(menuRepository).isNotNull();
        System.out.println(menuRepository); // org.springframework.data.jpa.repository.support.SimpleJpaRepository@2aac60b
    }

    @Test
    @DisplayName("Repository 인터페이스 제공 메소드 - findById")
    void test2() {
        // nullable한 객체를 감싼 객체. 값이 있을때, 없을때에 대한 분기처리 제공
        Optional<Menu> optMenu = menuRepository.findById(10L);
        // Optional API
        Menu menu = optMenu.orElse(null); // optMenu안에 값이 존재하면 반환하고, 존재하지 않으면 기본값 반환(null, other부분에 작성하면 된다)한다.
//        Menu menu = optMenu.orElseThrow(); // optMenu안에 값이 존재하면 반환하고, 없으면 예외 던지기
        System.out.println(menu);
        assertThat(menu).isNotNull();
    }

    @Test
    @DisplayName("메뉴 전체 조회")
    void test3() {
        // given
        // when
        List<Menu> menus = menuRepository.findAll();
        menus.forEach(System.out::println);
        // then
        assertThat(menus).isNotNull();
    }

    @Test
    @DisplayName("메뉴 등록")
    void test4() {
        // given
        Menu menu = Menu.builder()
                .menuName("우유맛소고기덮밥")
                .menuPrice(30_000)
                .categoryCode(4L)
                .orderableStatus(OrderableStatus.Y)
                .build();
        // when
        // save = 영속객체 자체를 반환해준다
        menu = menuRepository.save(menu); // persist가 아닌 save를 사용하면 된다.
        /*
        Hibernate:
            insert
            into
                tbl_menu
                (category_code, menu_name, menu_price, orderable_status)
            values
                (?, ?, ?, ?)
         */
        System.out.println(menu);
        // then
        assertThat(menu.getMenuCode()).isNotZero();
    }

    @Test
    @DisplayName("메뉴 수정")
    @Rollback(false)
    void test5() {
        // given
        // 수정할 때는 수정할 엔티티를 조회해야 한다.
        Long menuCode = 10L;
//        Menu menu = menuRepository.findById(menuCode); 오류 발생. menu가 존재하지 않을수도 있기 때문에 먼저 Optional로 받는다
        Optional<Menu> optMenu = menuRepository.findById(menuCode);
        Menu menu = optMenu.orElse(null);
        // when
        String newMenuName = "수박" + menu.getMenuName();
        menu.changeMenuName(newMenuName); // 메뉴야. 나 이 이름으로 바꾸고 싶다고 넘겨줘야한다. 직접 바꿀 수 없음. setter때문
        /*
        Hibernate:
            update
                tbl_menu
            set
                category_code=?,
                menu_name=?,
                menu_price=?,
                orderable_status=?
            where
                menu_code=?
         */
        System.out.println(menu);
        // then
        assertThat(menu.getMenuName()).isEqualTo(newMenuName);
    }

    /**
     * 삭제 메소드
     *  1. delete(T) T는 타입을 의미. delete엔티티를 전달
     *  2. deleteById(ID) id값은 전달
     */
    @Test
    @DisplayName("메뉴 삭제")
    @Rollback(false) // 커밋 시점은 then부분이 끝나고 나서 쿼리가 날아온다. 따라서 delete쿼리가 마지막에 나오는 것이다.
    void test6() {
        // given
        Long menuCode = 103L;
        // when
//        Optional<Menu> optMenu = menuRepository.findById(menuCode);
//        Menu menu = optMenu.orElse(null);
        // 왜 마지막에 delete쿼리가 찍히는가? 영속성컨텍스트 안에 메뉴 객체는 지워졌다고 하지만 쿼리가 날아가지 않는다. 날아갈 때는 commit될 때 날라가고 flush.commit일 때 날라간다.
//        menuRepository.delete(menu);

        menuRepository.deleteById(menuCode); // 먼저 엔티티를 조회할 필요없이 바로 삭제요청 (내부적으로 조회요청)
        /*
        Hibernate:
            delete
            from
                tbl_menu
            where
                menu_code=?

          // 존재하지 않는 것을 삭제할 때 delet문이 나오지 않는다.
         */
        // then
        assertThat(menuRepository.findById(menuCode)).isNotPresent(); // optional타입이다. optional객체 안에 값이 없음을 의미한다.
    }
}