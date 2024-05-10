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
        SqlSession sqlSession= getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.findAll();
        sqlSession.close();
        return list;
    }

    public MenuDto findByMenuCode(int menuCode) {
        SqlSession sqlSession= getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menuDto = menuMapper.findByMenuCode(menuCode);
        sqlSession.close();
        return menuDto;
    }

    public List<MenuDto> findByCategoryCode(int categoryCode) {
        SqlSession sqlSession= getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.findByCategoryCode(categoryCode);
        sqlSession.close();
        return list;
    }

    public int updateMenu(MenuDto menuDto) {
        SqlSession sqlSession= getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        try {
            int result = menuMapper.updateMenu(menuDto);
            sqlSession.commit();
            return result;
        } catch(Exception e){
            sqlSession.rollback();
            throw new RuntimeException(e);
        }finally {
            sqlSession.close();
        }
    }

    public int insertMenu(MenuDto menuDto) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        try {
            int result = menuMapper.insertMenu(menuDto);
            sqlSession.commit();
            return result;
        } catch(Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int deleteMenuByCode(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        try {
            int result = menuMapper.deleteMenu(menuCode);
            sqlSession.commit();
            return result;
        } catch(Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public List<CategoryDto> displayAllCategory(){
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<CategoryDto> categoryList = menuMapper.displayAllCategory();
        sqlSession.close();
        return categoryList;
    }

    public int insertCategoryAndMenu(CategoryDto categoryDto, MenuDto menuDto) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        try{
            int result = menuMapper.insertCategory(categoryDto);
            result = menuMapper.insertMenu(menuDto);
            sqlSession.commit();
            return result;
        }catch (Exception e){
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
        return 0;
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
