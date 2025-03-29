package com.sh.menu.controller;

import com.sh.common.SearchCriteria;
import com.sh.menu.model.dao.MenuMapper;
import com.sh.menu.model.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class MenuService {

    public List<MenuDto> searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> menuList = menuMapper.searchMenu(searchCriteria);
        sqlSession.close();
        return menuList;
    }
}
