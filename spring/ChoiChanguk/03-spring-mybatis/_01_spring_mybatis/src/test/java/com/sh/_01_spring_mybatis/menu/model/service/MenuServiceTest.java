package com.sh._01_spring_mybatis.menu.model.service;

import com.sh._01_spring_mybatis.menu.model.dto.MenuDto;
import com.sh._01_spring_mybatis.menu.model.dto.OrderableStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * 테스트에 필요한 ApplicationContext 구성을 자동화해준다
 */

@SpringBootTest //
class MenuServiceTest {
    @Autowired
    MenuService menuService;
    @Autowired
    private DataSourceTransactionManagerAutoConfiguration dataSourceTransactionManagerAutoConfiguration;
    @Autowired
    private ProjectInfoAutoConfiguration projectInfoAutoConfiguration;

    @Test
    @DisplayName("메뉴 전체 조회")
    void test1() {
        // given
        // when
        List<MenuDto> menus= menuService.findAll();
        System.out.println(menus);

        // then
        assertThat(menus)
                .isNotNull()
                .isNotEmpty()
                .allMatch((menu)->menu!=null);
    }

    @Test
    @DisplayName("메뉴 한 건 조회")
    void test2() {
        // given
        Long menuCode = 1L;
        // when
        MenuDto menu = menuService.findByMenuCode(menuCode);
        // then
//        assertThat(menu)
//                .isNotNull()
//                .satisfies(
//                        (_menu) -> assertThat(_menu.getMenuCode()).isEqualTo(menuCode),
//                        (_menu) -> assertThat(_menu.getMenuName()).isNotNull(),
//                        (_menu) -> assertThat(_menu.getMenuPrice()).isPositive(),
//                        (_menu) -> assertThat(_menu.getOrderableStatus()).satisfiesAnyOf(
//                                (orderableStatus) -> assertThat(orderableStatus).isEqualTo(OrderableStatus.Y),
//                                (orderableStatus) -> assertThat(orderableStatus).isEqualTo(OrderableStatus.N)
//                        )
//                );

    }

    @Test
    @DisplayName("카테고리별 메뉴 조회")
    void test3() {
        // given
        Long categoryCode=4L;

        // when
        List<MenuDto> menu=menuService.findByMenuCategoryCode(categoryCode);

        System.out.println("menu = " + menu);
//        for(MenuDto menuDto:menu)
//        {
//            System.out.println("menuDto.getMenuName() = " + menuDto.getMenuName());
//            System.out.println("menuDto.getMenuCode() = " + menuDto.getMenuCode());
//            System.out.println("menuDto.getMenuPrice() = " + menuDto.getMenuPrice());
//            System.out.println("menuDto.getCategoryCode() = " + menuDto.getCategoryCode());
//            System.out.println("menuDto.getOrderableStatus() = " + menuDto.getOrderableStatus());
//        }

        // then
        assertThat(menu).isNotNull();
    }
    @Test
    @DisplayName("메뉴 등록")
    void test4() {
        // given
        String menuName = "녹차막국수";
        int menuPrice=3000;
        int categoryCode=4;
        OrderableStatus orderableStatus=OrderableStatus.Y;
        MenuDto menuDto=new MenuDto(null,menuName,menuPrice,categoryCode,orderableStatus);

        int result=menuService.insertMenu(menuDto);
        // when
        assertThat(result).isEqualTo(1);
        // then
    }
}




















