package com.sh._03_spring_crud.menu.model.dao;

import com.sh._03_spring_crud.menu.model.dto.CategoryDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto;
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
    private MenuMapper menuMapper; // 의존 주입 받움

    @Test
    @DisplayName("메뉴 전체 조회")
    void test1() {
        // given
        // when
        List<MenuDto> menus = menuMapper.findAll();
        System.out.println(menus);
        // then
        assertThat(menus)
                .isNotNull()
                .isNotEmpty()
                .allMatch((menu) -> menu != null ); // 모든 요소가 Predicate 에  대해 true를 반환해줌
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
                        (_menu) -> assertThat(_menu.getMenuPrice()).isPositive(), // 양수인지 확인
                        (_menu) -> assertThat(_menu.getOrderableStatus()).satisfiesAnyOf(
                                (orderableStatus) -> assertThat(orderableStatus).isEqualTo(OrderableStatus.Y),
                                (orderableStatus) -> assertThat(orderableStatus).isEqualTo(OrderableStatus.N)
                        )
                );
    }
    @Test
    @DisplayName("전체 카테고리 조회")
    void test3() {
        // given

        // when
        List<CategoryDto> categoryDtos = menuMapper.findAllCategoryCode();
        System.out.println(categoryDtos);

        // then
        assertThat(categoryDtos)
                .isNotNull()
                .isNotEmpty()
                .allMatch((categoryDto) -> categoryDto != null)
                .allSatisfy((category) -> {
                    assertThat(category.getCategoryCode()).isNotZero();
                    assertThat(category.getCategoryName()).isNotNull();
                    assertThat(category.getRefCategoryCode()).isNotNull();
                });
    }

    @Test
    @DisplayName("메뉴 등록")
    void test4() {
        // given
        String menuName = "녹차막국수";
        int menuPrice = 3000;
        int categoryCode = 4;
        OrderableStatus orderableStatus = OrderableStatus.Y;
        MenuDto menuDto = new MenuDto(null, menuName, menuPrice, categoryCode, orderableStatus);

        // when
        int result = menuMapper.insertMenu(menuDto);

        // then
        assertThat(result).isEqualTo(1);
        assertThat(menuDto.getMenuCode()).isNotZero();
    }
}