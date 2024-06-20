package com.sh._03_spring_crud.menu.model.dao;

import com.sh._03_spring_crud.menu.model.dto.CategoryDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    List<MenuDto> findAll();
    List<MenuDto2> findAll2();

    MenuDto findByMenuCode(Long menuCode);

    List<MenuDto> findByCategoryCode(Long categoryCode);

    int insertMenu(MenuDto menuDto);

    List<CategoryDto> findAllCategory();

}
