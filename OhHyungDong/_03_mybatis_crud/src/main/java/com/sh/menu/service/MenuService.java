package com.sh.menu.service;

import com.sh.menu.dao.MenuMapper;
import com.sh.menu.dto.CategoryDto;
import com.sh.menu.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class MenuService {

    public List<MenuDto> findAll() {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list =menuMapper.findAll();
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
            //dao 메세지 전달
            int result = menuMapper.insertMenu(menuDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        }finally {
            sqlSession.close();
        }

    }

    public List<MenuDto> findByCategoryCode(int categoryCode) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list =menuMapper.findByCategoryCode(categoryCode);
        return list;
    }

    public int updateMenu(MenuDto menuDto) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        try {
            //dao 메세지 전달
            int result = menuMapper.updateMenu(menuDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        }finally {
            sqlSession.close();
        }
    }

    public int deleteMenu(int menuCode) {
        SqlSession sqlSession = getSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        try {

            //dao 메세지 전달
            int result = menuMapper.deleteMenu(menuCode);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        }finally {
            sqlSession.close();
        }
    }

   public List<CategoryDto> findAllCatgory() {
       return List.of(
               new CategoryDto(4,"한식",1),
               new CategoryDto(5,"중식",1)
       );
   }
}
