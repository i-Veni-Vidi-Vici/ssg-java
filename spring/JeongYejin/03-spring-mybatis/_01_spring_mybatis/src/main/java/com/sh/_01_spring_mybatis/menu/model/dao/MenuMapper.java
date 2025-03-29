package com.sh._01_spring_mybatis.menu.model.dao;

import com.sh._01_spring_mybatis.menu.model.dto.MenuDto;

import java.util.List;

public interface MenuMapper {
    List<MenuDto> findAll();

    MenuDto findByMenuCode(Long menuCode);

    int insertMenu(MenuDto menuDto);

    List<MenuDto> findByCategoryCode(int categoryCode);
}
