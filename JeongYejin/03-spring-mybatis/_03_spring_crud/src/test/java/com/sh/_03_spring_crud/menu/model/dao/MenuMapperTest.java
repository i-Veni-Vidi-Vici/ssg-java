package com.sh._03_spring_crud.menu.model.dao;

import com.sh._03_spring_crud.menu.model.dto.MenuDto;
import com.sh._03_spring_crud.menu.model.dto.OrderableStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuMapperTest {
    @Autowired
    MenuMapper menuMapper;

    @Test
    @DisplayName("메뉴 전체 조회")
    void test1() {
        // given
        // when
        List<MenuDto> menus = menuMapper.findAll();
        System.out.println(menus);
        // then
        assertThat(menus).isNotNull()
                .isNotEmpty()
                .allMatch((menu) -> menu != null); // 모든 요소가 Predicate에 대해 true를 반환해야 한다.
    }

    @Test
    @DisplayName("메뉴 한건 조회")
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
        int categoryCode = 5;
        // when
        List<MenuDto> menus = menuMapper.findByCategoryCode(categoryCode);
        System.out.println(menus);
        // then
        assertThat(menus).isNotNull()
                .isNotEmpty()
                .allMatch((menu) -> menu.getCategoryCode() == 5);
    }

    @Test
    @DisplayName("메뉴 등록")
    void test4() {
        // given
        MenuDto menuDto = new MenuDto(null, "녹차막국수", 11500, 6, OrderableStatus.N);
        // when
        int result = menuMapper.insertMenu(menuDto);
        // then
        assertThat(result).isEqualTo(1);
        assertThat(menuDto.getMenuCode()).isNotZero();
    }
}