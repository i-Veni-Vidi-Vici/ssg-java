package com.sh._03_spring_crud.menu.model.dao;

import com.sh._03_spring_crud.menu.model.dto.CategoryDto;
import com.sh._03_spring_crud.menu.model.dto.MenuCategoryDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuDto> findAll();

    MenuDto findByMenuCode(Long menuCode);

    int insertMenu(MenuDto menuDto);

    List<MenuDto> findByCategoryCode(int categoryCode);

    List<MenuCategoryDto> findAll2(); // 카테고리 이름으로 보여주기
}
