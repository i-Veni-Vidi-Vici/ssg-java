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
import static org.junit.jupiter.api.Assertions.*;

/**
 * <pre>
 * 우리가 작성한 MenuRepository 인터페이스의 상속구조
 * - jpa는 MenuRepository 인터페이스의 구현객체를 동적으로 생성해서 제공한다.
 * - 이 객체는 MenuRepository의 추상메소드를 구현했을 것이다.
 * - 이 객체는 부모인터페이스인 JpaRepository의 추상메소드를 구현했을 것이다.
 * - 이 객체는 조상인터페이스인 PagingAndSortRepository, CrudRepository, Repository의 추상메소드를 구현했을 것이다.
 * </pre>
 */
@DataJpaTest // jpa관련 빈만 로드 @SpringBootTest 대비 가볍다.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 테스트용 메모리DB사용안하고 실제 DB 사용
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
        System.out.println(menuRepository); // org.springframework.data.jpa.repository.support.SimpleJpaRepository@2b551e7b
    }

    @Test
    @DisplayName("Repository 인터페이스 제공 메소드")
    void test2() {
        // Optional : nullable한 객체를 감싼 객체. 값이 있을 때, 없을 때에 대한 분기처리 제공
        Optional<Menu> optMenu = menuRepository.findById(10L);
        /*
            select
                m1_0.menu_code,
                m1_0.category_code,
                m1_0.menu_name,
                m1_0.menu_price,
                m1_0.orderable_status
            from
                tbl_menu m1_0
            where
                m1_0.menu_code=?
         */
        // Optional API에는 값이 존재할 때와 존재하지 않을 때에 대한 다양한 메소드를 제공
        Menu menu = optMenu.orElse(new Menu()); // optMenu안에 값이 존재하면 반환하고, 없으면 기본값 반환
//        Menu menu = optMenu.orElse(null);
//        Menu menu = optMenu.orElseThrow();
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
        assertThat(menus).isNotEmpty();
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
        menu = menuRepository.save(menu);
        /*
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
        Long menuCode = 10L;
        Optional<Menu> optMenu = menuRepository.findById(menuCode);
        Menu menu = optMenu.orElse(null);
        // when
        String newMenuName = "수박" + menu.getMenuName();
        menu.changeMenuName(newMenuName);
        /*
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
     * 1. delete(T) : T는 엔티티타입
     * 2. deleteById(ID)
     */
    @Test
    @DisplayName("메뉴 삭제")
    @Rollback(false)
    void test6() {
        // given
        Long menuCode = 77L;
        // when
//        Optional<Menu> optMenu = menuRepository.findById(menuCode);
//        Menu menu = optMenu.orElse(null);
//        menuRepository.delete(menu);

        menuRepository.deleteById(menuCode); // 먼저 엔티티를 조회할 필요없이 바로 삭제요청 (내부적으로 조회요청)
        /*
            delete
            from
                tbl_menu
            where
                menu_code=?
         */
//        System.out.println(menu);
        // then
        assertThat(menuRepository.findById(menuCode)).isNotPresent();
    }
}