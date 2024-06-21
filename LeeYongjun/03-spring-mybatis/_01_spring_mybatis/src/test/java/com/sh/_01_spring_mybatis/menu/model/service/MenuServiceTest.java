package com.sh._01_spring_mybatis.menu.model.service;

import com.sh._01_spring_mybatis.menu.model.dto.MenuDto;
import com.sh._01_spring_mybatis.menu.model.dto.OrderableStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;




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
                .allMatch((menu) -> menu != null);
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
                (_menu) -> assertThat(_menu.getMenuCode()).isNotNull().isNotZero(),
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
        int categoryCode = 4;
        // when
        List<MenuDto> catMenu = menuService.findByCategoryCode();
        System.out.println(catMenu);
        // then
        assertThat(catMenu)
                .isNotNull()
                .isNotEmpty()
                .allMatch((menu) -> menu.getCategoryCode() == categoryCode);
    }

    @Test
    @DisplayName("메뉴 등록")
    void test4() {
        // given
        String menuName = "녹차막국수";
        int categoryCode = 4;
        OrderableStatus orderableStatus = OrderableStatus.Y;
        int menuPrice = 3000;
        MenuDto menuDto = new MenuDto(null,menuName,menuPrice,categoryCode,orderableStatus);
        // when
        int result = menuService.insertMenu(menuDto);
        // then
        assertThat(result).isEqualTo(1);
    }
}