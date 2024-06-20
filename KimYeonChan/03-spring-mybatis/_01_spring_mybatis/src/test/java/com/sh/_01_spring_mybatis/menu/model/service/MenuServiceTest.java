package com.sh._01_spring_mybatis.menu.model.service;

import com.sh._01_spring_mybatis.menu.model.dto.MenuDto;
import com.sh._01_spring_mybatis.menu.model.dto.OrderableStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 테스트에 필요한 ApplicationContext 구성을 자동화해준다.
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
        // then
        assertThat(menus)
                .isNotNull()
                .isNotEmpty()
                .allMatch((menu) -> menu != null); // 모든 요소가 Predicate 에 대해 true 를 반환
    }

    @Test
    @DisplayName("메뉴 한건 조회")
    void test2() {
        Long menuCode = 1L;
        MenuDto menu = menuService.findByMenuCode(menuCode);
        assertThat(menu)
                .isNotNull()
                .satisfies(
                        (_menu) -> assertThat(_menu.getMenuCode()).isNotNull().isNotZero(),
                        (_menu) -> assertThat(_menu.getMenuName()).isNotNull(),
                        (_menu) -> assertThat(_menu.getMenuPrice()).isPositive(),
                        (_menu) -> assertThat(_menu.getOrderableStatus()).isNotNull().satisfiesAnyOf(
                                (orderableStatus) -> assertThat(orderableStatus).isEqualTo(OrderableStatus.Y),
                                (orderableStatus) -> assertThat(orderableStatus).isEqualTo(OrderableStatus.N)
                        )
                );
    }


    @Test
    @DisplayName("카테고리별 메뉴 조회")
    void test3() {
        // given
        // when
        int categoryCode = 9;
        List<MenuDto> menus = menuService.findByCategoryCode(categoryCode);
        // then
        assertThat(menus)
                .allMatch((menu) -> menu != null);
    }

    @Test
    @DisplayName("메뉴 등록")
    void test4() {
        // given
        Long menuCode = 100L;
        String menuName = "이태리부대찌개";
        int menuPrice = 10_000;
        int categoryCode = 4;
        OrderableStatus orderableStatus = OrderableStatus.Y;
        MenuDto menu = new MenuDto(menuCode, menuName, menuPrice, categoryCode, orderableStatus);
        // when
        int result = menuService.insertMenu(menu);
        // then
        assertThat(result)
                .isPositive();
        assertThat(menu.getMenuCode())
                .isNotNull();
    }
}