package com.sh._01_spring_mybatis.menu.model.dao;

import com.sh._01_spring_mybatis.menu.model.dto.MenuDto;
import com.sh._01_spring_mybatis.menu.model.dto.OrderableStatus;

import java.util.List;

public interface MenuMapper {
    List<MenuDto> findAll();

    MenuDto findByMenuCode(Long menuCode);

    List<MenuDto> findByCategoryCode(int categoryCode);

//    int insertMenu(Long id, String name, int price, int categoryCode, OrderableStatus orderableStatus);

    int insertMenu(MenuDto menu);
}
