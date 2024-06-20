package com.sh._03_spring_crud.menu.model.service;




import com.sh._03_spring_crud.menu.model.dao.MenuMapper;
import com.sh._03_spring_crud.menu.model.dto.CategoryDto;
import com.sh._03_spring_crud.menu.model.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true) // 하위 메소드에서는 읽기만 가능, 쓰기작업은 불가
public class MenuQueryService {
    // 생성자 의존주입 처리
    private final MenuMapper menuMapper;

    public List<MenuDto> findAll() {
        return menuMapper.findAll();
    }

    public MenuDto findByMenuCode(Long menuCode) {
        return menuMapper.findByMenuCode(menuCode);
    }

    public List<MenuDto> findByCategoryCode(int categoryCode) {
        return menuMapper.findByCategoryCode(categoryCode);
    }

    public List<CategoryDto> findAllCategory() {
        return menuMapper.findAllCategory();
    }
}
