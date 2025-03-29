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
 *   우리가 작성한 MenuRepository 인터페이스의 상속구조 - 🙉알아야 함🙉
 * - jpa는 MenuRepository 인터페이스의 구현 객체를 동적으로 생성해서 제공한다. -> 그래서 의존주입 받을 수 잇었음
 * - 이 객체는 MenuRepository의 추상메소드를 구현했을 것이다.
 * - 이 객체는 부모인터페이스인 JpaRepository의 추상메소드를 구현했을 것이다.
 * - 이 객체는 조상인터페이스인 PagingAndSortRepository, CrudRepository, Repository의 추상메소드를 구현했을 것이다.
 */
@DataJpaTest // 🙉jpa 관련 빈만 로드 @SpringBootTest 대비 가벼움 -> @SpringBootTest가 살짝 무거워서 모든 빈을 로드할 필요없고, 레포지토리에 관련된 빈만 로드하는 어노테이션, 얘 안에 transacional이 있음
//@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 테스트용 메모리 db 안쓰고 실제 db 사용하겠다는 의미
class MenuRepositoryTest {
    @Autowired // 의존 주입
    private MenuRepository menuRepository;

    @Test
    @DisplayName("MenuRepository 구현 클래스의 빈을 의존 주입 받는다.")
    void test1() {
        // given

        // when

        // then
        assertThat(menuRepository).isNotNull();
        System.out.println(menuRepository); // org.springframework.data.jpa.repository.support.SimpleJpaRepository@3431cb1f -> 🙉 이런게 하나 넘어와버려꾼~SimpleJpaRepository는 메뉴 리포지토리 인터페이스를 구현 한 것
        //어떤 entity마다 id가 있는데 걔를 조회할 때 findById()를 씀 -> extends JpaRepository<Menu, Long>이라고 지정을 해둿기 대문에 Long건으로 조회를 할 수 있음!
        // persist 대신에 save
        // flush -> 지금 바로 쿼리 날려주세요!

    }

    @Test
    @DisplayName("Repository 인터페이스 제공 메소드")
    void test2() {
        // nullable한 객체를 감싼 객체, 값이 있을 때, 없을 때에 대한 분기 처리를 제공
        Long menuCode = 10L;
        Optional<Menu> optMenu = menuRepository.findById(menuCode);
        // Optional API에는 값이 존재할 때와 존재하지 않을 때에 다양한 메소드를 제공한다.
        Menu menu = optMenu.orElse(null); // optMenu안에 값이 존재하면 반환하고, 없으면 기본값 반환
//        Menu menu = optMenu.orElseThrow(null); // optMenu안에 값이 존재하면 반환하고, 없으면 예외던지기
        System.out.println(menu);
        assertThat(menu).isNotNull();
    }

    @Test
    @DisplayName("메뉴 전체 조회")
    void test3() {
        // given

        // when
        List<Menu> menus = menuRepository.findAll();
        /**
         * Hibernate:
         *     select
         *         m1_0.menu_code,
         *         m1_0.category_code,
         *         m1_0.menu_name,
         *         m1_0.menu_price,
         *         m1_0.orderable_status
         *     from
         *         tbl_menu m1_0
         */
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
        /**
         * Hibernate:
         *     insert
         *     into
         *         tbl_menu
         *         (category_code, menu_name, menu_price, orderable_status)
         *     values
         *         (?, ?, ?, ?)
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
        //        Menu menu = optMenu.get(); // get은 위험한 것이, 값이 없으면 예외가 던져짐

        // when
        String newMenuName = "수박" + menu.getMenuName();
        menu.changeMenuName(newMenuName);
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
     * 1. delete(T) -> 🙉T는 타입을 의미함 !
     * 2. deleteById(ID)
     */
    @Test
    @DisplayName("메뉴 삭제")
    void test6() {
        // given
        Long menuCode = 101L;

        // when
//        Optional<Menu> optMenu = menuRepository.findById(menuCode);
//        Menu menu = optMenu.orElse(null);
//        menuRepository.delete(menu);

        menuRepository.deleteById(menuCode); // 먼저 엔티티를 조회할 필요 없이 바로 삭제 요청(내부적으로 조회 요청)
        /*
            Hibernate:
                delete
                from
                    tbl_menu
                where
                    menu_code=?
         */
        // then
        assertThat(menuRepository.findById(menuCode)).isNotPresent(); //optional 객체 안에 값이 없음을 확신? 하는 것
    }
}