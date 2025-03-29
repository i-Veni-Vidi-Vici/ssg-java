package com.sh._04_paging.menu.model.dao;

import com.sh._04_paging.menu.model.dto.CategoryDto;
import com.sh._04_paging.menu.model.dto.MenuCategoryDto;
import com.sh._04_paging.menu.model.dto.MenuCategoryNameDto;
import com.sh._04_paging.menu.model.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuDto> findAll();

    MenuDto findByMenuCode(Long menuCode);

    List<MenuDto> findByCategoryCode(int categoryCode);

    int insertMenu(MenuDto menuDto);

    List<CategoryDto> findAllCategory();

    List<MenuCategoryDto> findAll2(@Param("offset") int offset, @Param("limit") int limit);

    List<MenuCategoryNameDto> findAll3();

    int count();
}
