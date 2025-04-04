package com.sh.menu.model.service;

import com.sh.menu.model.dao.MenuMapper;
import com.sh.menu.model.dto.CategoryDto;
import com.sh.menu.model.dto.MenuDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sh.common.MyBatisTemplate.getSqlSession;

public class MenuService {
    public List<MenuDto> findAll() {
        SqlSession sqlSession = getSqlSession(); // 일단 세션 가져와
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class); // 맵퍼 가져와
        List<MenuDto> list = menuMapper.findAll();
        sqlSession.close(); //세션 닫아
        return list;
    }

    public MenuDto findByMenuCode(int menuCode) {
        SqlSession sqlSession = getSqlSession(); // 일단 세션 가져와
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDto menuDto = menuMapper.findByMenuCode(menuCode);
        sqlSession.close(); //세션 닫아
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
            sqlSession.close(); // 반드시 닫아야돼 그래서 finally에다가 넣기 !
        }
    }

    public List<MenuDto> findByCategoryCode(int categoryCode) {
        SqlSession sqlSession = getSqlSession(); // 일단 세션 가져와
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDto> list = menuMapper.findByCategoryCode(categoryCode);
        sqlSession.close(); //세션 닫아
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
        return List.of(
                new CategoryDto(4, "한식", 1),
                new CategoryDto(5, "중식", 1)
        ); // 가상 데이터
    }
}
