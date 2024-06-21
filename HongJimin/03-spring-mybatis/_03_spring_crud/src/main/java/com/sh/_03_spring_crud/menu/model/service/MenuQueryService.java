package com.sh._03_spring_crud.menu.model.service;


import com.sh._03_spring_crud.menu.model.dao.MenuMapper;
import com.sh._03_spring_crud.menu.model.dto.CategoryDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor // final로 만들면 값이 무조건 있어야 하기 때문에 얘를 써줌
@Transactional(readOnly = true) // 하위 메소드에서는 읽기만 가능, 쓰기 작업은 불가능!! -> 읽기 전용으로 connection이 열림
public class MenuQueryService {
    // 생성자 의존 주입 처리
    private final MenuMapper menuMapper;

    public MenuDto findByMenuCode(Long menuCode){
        return menuMapper.findByMenuCode(menuCode);
    };


    public List<MenuDto> findAll() {
        return menuMapper.findAll();
    }


    public List<CategoryDto> findAllCategory() {
        return menuMapper.findAllCategoryCode();
    }
}
