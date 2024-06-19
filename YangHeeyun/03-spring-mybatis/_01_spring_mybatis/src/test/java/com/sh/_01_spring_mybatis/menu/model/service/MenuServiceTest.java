package com.sh._01_spring_mybatis.menu.model.service;

import com.sh._01_spring_mybatis.menu.model.dto.MenuDto;
import com.sh._01_spring_mybatis.menu.model.dto.OrderableStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 테스트에 필요한 ApplicationContext구성을 자동화해준다.
 */
@SpringBootTest
class MenuServiceTest {
    @Autowired
    MenuService menuService;

    @Test
    @DisplayName("메뉴 전체 조회")
    void test1() {
        // given
        // when
        List<MenuDto> menus = menuService.findAll();
        System.out.println(menus);
        // then
        assertThat(menus)
                .isNotNull()
                .isNotEmpty()
                .allMatch((menu) -> menu != null); // 모든 요소가 Predicate에 대해 true를 반환해야 한다.
    }

    @Test
    @DisplayName("메뉴 한건 조회")
    void test2() {
        // given
        Long menuCode = 1L;
        // when
        MenuDto menu = menuService.findByMenuCode(menuCode);
        // then
        assertThat(menu)
                .isNotNull()
                .satisfies(
                        (_menu) -> assertThat(_menu.getMenuCode()).isEqualTo(menuCode),
                        (_menu) -> assertThat(_menu.getMenuName()).isNotNull(),
                        (_menu) -> assertThat(_menu.getMenuPrice()).isPositive(),
                        (_menu) -> assertThat(_menu.getOrderableStatus()).satisfiesAnyOf(
                                (orderableStatus) -> assertThat(orderableStatus).isEqualTo(OrderableStatus.Y),
                                (orderableStatus) -> assertThat(orderableStatus).isEqualTo(OrderableStatus.N)
                        )
                );
    }

    @Test
    @DisplayName("카테고리별 메뉴 조회")
    void test3() {
        // given
        int categoryCode = 4; // 한식
        // when
        List<MenuDto> menus = menuService.findMenuByCategoryCode(categoryCode);
        System.out.println(menus);
        // then
        assertThat(menus)
                .isNotNull()
                .isNotEmpty()
                .allMatch((menu) -> menu != null); // 모든 요소가 Predicate에 대해 true를 반환해야 한다.
    }

    @Test
    @DisplayName("메뉴 등록")
    void test4() {
        // given
        String menuName = "녹차막국수";
        int menuPrice = 3000;
        int categoryCode = 4;
        OrderableStatus orderableStatus = OrderableStatus.N;
        MenuDto menuDto = new MenuDto(null,menuName, menuPrice, categoryCode, orderableStatus);
        // when
        int result = menuService.insertMenu(menuDto);

        // then
        assertThat(result).isEqualTo(1); // insert성공하면 1, 실패하면 0 반환하므로 성공한지 확인
        assertThat(menuDto.getMenuCode()).isNotZero();
    }
}