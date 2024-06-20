package com.sh._03_spring_crud.menu.model.dao;

import com.sh._03_spring_crud.menu.model.dto.CategoryDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto2;
import com.sh._03_spring_crud.menu.model.dto.OrderableStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MenuMapperTest {
    @Autowired
    private MenuMapper menuMapper;

    @Test
    @DisplayName("메뉴 전체 조회")
    void test1() {
        // given
        // when
        List<MenuDto2> menus= menuMapper.findAll2();
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
        MenuDto menu = menuMapper.findByMenuCode(menuCode);
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
        Long categoryCode=4L;

        // when
        List<MenuDto> menu=menuMapper.findByCategoryCode(categoryCode);

        System.out.println("menu = " + menu);
        for(MenuDto menuDto:menu)
        {
            System.out.println("menuDto.getMenuName() = " + menuDto.getMenuName());
            System.out.println("menuDto.getMenuCode() = " + menuDto.getMenuCode());
            System.out.println("menuDto.getMenuPrice() = " + menuDto.getMenuPrice());
            System.out.println("menuDto.getCategoryCode() = " + menuDto.getCategoryCode());
            System.out.println("menuDto.getOrderableStatus() = " + menuDto.getOrderableStatus());
        }

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
        OrderableStatus orderableStatus= OrderableStatus.Y;
        MenuDto menuDto=new MenuDto(null,menuName,menuPrice,categoryCode,orderableStatus);

        int result=menuMapper.insertMenu(menuDto);
        // when
        assertThat(result).isEqualTo(1);
        // then
    }

    @Test
    @DisplayName("카테고리 코드 출력")
    void test5() {
        // given
        // when
        List<CategoryDto> categories= menuMapper.findAllCategory();
        for(CategoryDto category:categories)
            System.out.println("category = " + category);
        assertThat(categories).isNotNull();
        // then
    }

}