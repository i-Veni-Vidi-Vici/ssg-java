package com.sh._01_spring_mybatis.menu.model.service;

import com.sh._01_spring_mybatis.menu.model.dao.MenuMapper;
import com.sh._01_spring_mybatis.menu.model.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // final로 만들면 값이 무조건 있어야 하기 때문에 얘를 써줌
public class MenuService {
    // 생성자 의존 주입 처리
    private final SqlSessionTemplate sqlSession; // 의존 주입 받으려고 만든 것

    public List<MenuDto> findAll() {
        // 매퍼(매퍼 인터페이스를 구현한 빈) 가져오기
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        return menuMapper.findAll();
    }

    public MenuDto findByMenuCode(Long menuCode) {
        return sqlSession.getMapper(MenuMapper.class).findByMenuCode(menuCode);
    }

    public List<MenuDto> findByCategoryCode(int categoryCode) {
        return sqlSession.getMapper(MenuMapper.class).findByCategoryCode(categoryCode);
    }

    public int insertMenu(MenuDto menuDto) {
        return sqlSession.getMapper(MenuMapper.class).insertMenu(menuDto);
    }
}
