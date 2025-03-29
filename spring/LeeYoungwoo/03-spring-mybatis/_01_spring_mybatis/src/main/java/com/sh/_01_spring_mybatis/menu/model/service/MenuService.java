package com.sh._01_spring_mybatis.menu.model.service;

import com.sh._01_spring_mybatis.menu.model.dao.MenuMapper;
import com.sh._01_spring_mybatis.menu.model.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {
    // 생성자 의존주입 처리
    private final SqlSessionTemplate sqlSession;

    public List<MenuDto> findAll() {
        // 매퍼(매퍼인터페이스를 구현한 빈) 가져오기
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
