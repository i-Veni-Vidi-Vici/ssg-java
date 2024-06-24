package com.sh._03_spring_crud.menu.model.dao;

import com.sh._03_spring_crud.menu.model.dto.CategoryDto;
import com.sh._03_spring_crud.menu.model.dto.MenuCategoryDto;
import com.sh._03_spring_crud.menu.model.dto.MenuCategoryNameDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuDto> findAll();

    MenuDto findByMenuCode(Long menuCode);

    List<MenuDto> findByCategoryCode(int categoryCode);

    int insertMenu(MenuDto menuDto);

    List<CategoryDto> findAllCategory();

    // 조인쿼리로 카테고리명 가져오기
    List<MenuCategoryDto> findAll2();

    // 스칼라서브쿼리로 카테고리명 가져오기
    List<MenuCategoryNameDto> findAll3();
}
