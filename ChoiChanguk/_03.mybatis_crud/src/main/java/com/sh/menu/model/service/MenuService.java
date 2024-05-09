package com.sh.menu.model.service;

import com.sh.menu.model.dao.CategoryMapper;
import com.sh.menu.model.dao.MenuMapper;
import com.sh.menu.model.dto.CategoryDto;
import com.sh.menu.model.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class MenuService {

    public List<MenuDto> findAll() {
        SqlSession sqlSession=getSqlSession();
        MenuMapper menuMapper=sqlSession.getMapper(MenuMapper.class);
        List<MenuDto>list=menuMapper.findAll();
        sqlSession.close();// 메모리 해제가 아니라 풀에서 가져온걸 다시 풀로 돌려보내는 과정이다
        return list;
    }

    public MenuDto findByMenuCode(int menuCode) {
        SqlSession sqlSession=getSqlSession();
        MenuMapper menuMapper=sqlSession.getMapper(MenuMapper.class);
        MenuDto menuDto=menuMapper.findByMenuCode(menuCode);
        sqlSession.close();// 메모리 해제가 아니라 풀에서 가져온걸 다시 풀로 돌려보내는 과정이다
        return menuDto;
    }

    public int insertMenu(MenuDto menuDto) {
        SqlSession sqlSession=getSqlSession();
        MenuMapper menuMapper=sqlSession.getMapper(MenuMapper.class);
        try{
            int result=menuMapper.insertMenu(menuDto);
            sqlSession.commit();
            return result;
        }catch (Exception e)
        {
            sqlSession.rollback();
            throw new RuntimeException(e);
        }
        finally {
            sqlSession.close();
        }
    }
    public int updateMenu(MenuDto menuDto)
    {
        SqlSession sqlSession=getSqlSession();
        MenuMapper menuMapper=sqlSession.getMapper(MenuMapper.class);
        try{
            int result=menuMapper.insertMenu(menuDto);
            sqlSession.commit();
            return result;
        }catch (Exception e)
        {
            sqlSession.rollback();
            throw new RuntimeException(e);
        }
        finally {
            sqlSession.close();
        }
    }
    public int deleteMenu(MenuDto menuDto)
    {
        SqlSession sqlSession=getSqlSession();
        MenuMapper menuMapper=sqlSession.getMapper(MenuMapper.class);
        try{
            int result=menuMapper.insertMenu(menuDto);
            sqlSession.commit();
            return result;
        }catch (Exception e)
        {
            sqlSession.rollback();
            throw new RuntimeException(e);
        }
        finally {
            sqlSession.close();
        }
    }

    public List<CategoryDto> findAllCategory() {
        SqlSession sqlSession=getSqlSession();
        CategoryMapper categoryMapper=sqlSession.getMapper(CategoryMapper.class);
        List<CategoryDto> categoryDtos=categoryMapper.findAllCategory();
        return categoryDtos;
    }
    public List<MenuDto> findByCategory(int categoryCode) {
        SqlSession sqlSession =getSqlSession();
        MenuMapper menuMapper=sqlSession.getMapper(MenuMapper.class);
        sqlSession.close();
        return menuMapper.findByCategoryCode(categoryCode);
    }

    public List<MenuDto> findOrderableStatus() {
        SqlSession sqlSession=getSqlSession();
        MenuMapper menuMapper=sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> menuDtos=menuMapper.findOrderableStatus();
        sqlSession.close();
        return menuDtos;
    }

    public List<MenuDto> findByOrderableCategoryCodeMenu(int categoryCode) {
        SqlSession sqlSession=getSqlSession();
        MenuMapper menuMapper=sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> menuDtos=menuMapper.findByOrderableCategoryCodeMenu(categoryCode);
        return menuDtos;
    }
}
