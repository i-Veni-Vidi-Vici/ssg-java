package com.sh._04_paging.menu.model.dao;

import com.sh._04_paging.menu.model.dto.CategoryDto;
import com.sh._04_paging.menu.model.dto.MenuCategoryDto;
import com.sh._04_paging.menu.model.dto.MenuCategoryNameDto;
import com.sh._04_paging.menu.model.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuDto> findAll();

    MenuDto findByMenuCode(Long menuCode);

    List<MenuDto> findByCategoryCode(int categoryCode);

    int insertMenu(MenuDto menuDto);

    List<CategoryDto> findAllCategory();

    // 조인쿼리로 카테고리명 가져오기
    List<MenuCategoryDto> findAll2(@Param("offset") int offset, @Param("limit") int limit);

    // 스칼라서브쿼리로 카테고리명 가져오기
    List<MenuCategoryNameDto> findAll3();

    // 주문 가능한 전체 메뉴 수 조회
    int count();
}
