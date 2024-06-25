package com.sh._04_paging.menu.model.dao;


import com.sh._04_paging.menu.model.dto.CategoryDto;
import com.sh._04_paging.menu.model.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuDto> findAll();

    MenuDto findByMenuCode(Long menuCode);

    List<MenuDto> findByCategoryCode(int categoryCode);

    int insertMenu(MenuDto menuDto);

    List<CategoryDto> findAllCategory();

    List<MenuDto> findAll(int offset, int limit);

    int count();
}
