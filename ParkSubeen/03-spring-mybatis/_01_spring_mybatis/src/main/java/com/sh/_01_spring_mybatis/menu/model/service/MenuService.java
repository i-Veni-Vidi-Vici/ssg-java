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

    // @RequiredArgsConstructor 대신 사용할 수 있는 방법 (다음 방법을 사용할 땐 final을 제거)
//    @Autowired
//    public MenuService(SqlSessionTemplate sqlSession) {
//        this.sqlSession = sqlSession;
//    }

    public List<MenuDto> findAll() {
        // 매퍼(매퍼인터페이스를 구현한 빈) 가져오기
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
         return menuMapper.findAll();
    }

    public MenuDto findByMenuCode(Long menuCode) {
        return sqlSession.getMapper(MenuMapper.class).findByMenuCode(menuCode);
    }

    public List<MenuDto> findByCategoryCode(int categoryCode) {
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        return menuMapper.findByCategoryCode(categoryCode);
    }

    public int insertMenu(MenuDto menuDto) {
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        return menuMapper.insertMenu(menuDto);
    }
}
