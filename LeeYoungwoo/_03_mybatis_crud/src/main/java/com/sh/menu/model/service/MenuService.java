package com.sh.menu.model.service;

import com.sh.menu.model.dao.MenuMapper;
import com.sh.menu.model.dto.CategoryDto;
import com.sh.menu.model.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class MenuService {
    public List<MenuDto> findAll() {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.findAll();
        sqlSession.close();
        return list;
    }

    public MenuDto findByMenuCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menuDto = menuMapper.findByMenuCode(menuCode);
        sqlSession.close();
        return menuDto;
    }

    public int insertMenu(MenuDto menuDto) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        try {
            // dao 메세지 전달
            int result = menuMapper.insertMenu(menuDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public List<MenuDto> findByCategoryCode(int categoryCode) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.findByCategoryCode(categoryCode);
        sqlSession.close();
        return list;
    }

    public int updateMenu(MenuDto menuDto) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        try {
            // dao 메세지 전달
            int result = menuMapper.updateMenu(menuDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int deleteMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        try {
            // dao 메세지 전달
            int result = menuMapper.deleteMenu(menuCode);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public List<CategoryDto> findAllCategory() {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<CategoryDto> categoryList = menuMapper.findAllCategory();
        sqlSession.close();
        return categoryList;
    }

    public List<MenuDto> findMenuOrderable() {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.findMenuOrderable();
        sqlSession.close();
        return list;
    }

    public List<MenuDto> findMenuOrderableByCategoryCode(int categoryCode) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.findMenuOrderableByCategoryCode(categoryCode);
        sqlSession.close();
        return list;
    }
}
