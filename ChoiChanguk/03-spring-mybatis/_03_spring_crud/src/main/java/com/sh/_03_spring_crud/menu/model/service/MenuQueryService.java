package com.sh._03_spring_crud.menu.model.service;

import com.sh._03_spring_crud.menu.model.dao.MenuMapper;
import com.sh._03_spring_crud.menu.model.dto.CategoryDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 하위 메소드에서는 읽기만 가능, 쓰기작업은 에러가 난다
public class MenuQueryService {
    // 생성자 의존주입 처리
    private final MenuMapper menuMapper;


    public List<MenuDto> findAll() {
        // 매퍼(매퍼인터페이스를 구현한 빈) 가져오기
        return menuMapper.findAll();
    }

    public List<MenuDto2> findAll2() {
        return menuMapper.findAll2();
    }

    public MenuDto findByMenuCode(Long menuCode) {
        return menuMapper.findByMenuCode(menuCode);
    }

    public List<MenuDto> findByMenuCategoryCode(Long categoryCode) {
        return menuMapper.findByCategoryCode(categoryCode);
    }

    public int insertMenu(MenuDto menuDto) {
        return menuMapper.insertMenu(menuDto);
    }

    public List<CategoryDto> findAAllCategory()
    {
        return menuMapper.findAllCategory();
    }

}
