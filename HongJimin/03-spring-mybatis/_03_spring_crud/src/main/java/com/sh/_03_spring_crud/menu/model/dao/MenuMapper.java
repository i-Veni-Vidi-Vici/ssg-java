package com.sh._03_spring_crud.menu.model.dao;

import com.sh._03_spring_crud.menu.model.dto.CategoryDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper // 빈으로 등록해주기 위해서 어노테이션 붙혀야 함 @MapperScan도 짝궁~~ -> 시작하는 application에 넣기
public interface MenuMapper {
    List<MenuDto> findAll();

    MenuDto findByMenuCode(Long menuCode);

    List<CategoryDto> findAllCategoryCode();

    int insertMenu(MenuDto menuDto);
}
