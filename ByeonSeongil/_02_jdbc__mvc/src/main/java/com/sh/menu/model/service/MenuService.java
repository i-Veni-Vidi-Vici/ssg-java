package com.sh.menu.model.service;

import com.sh.menu.model.dao.MenuDao;
import com.sh.menu.model.dto.CategoryDto;
import com.sh.menu.model.dto.MenuDto;

import java.sql.Connection;
import java.util.List;

import static com.sh.common.JdbcTemplate.*;

/**
 * <pre>
 * Service
 * - 업무로직 담당 클래스
 * - DB Connection객체 생성/반환
 * - Dao 클래스에 세부처리 요청
 * - **DML 처리인 경우, 트랜잭션(commit/rollback) 담당**
 * </pre>
 */
public class MenuService {
    private MenuDao menuDao = new MenuDao();

    public List<MenuDto> findAll() {
        // Connection 생성
        Connection con = getConnection();
        // Dao 메시지 전달
        List<MenuDto> list = menuDao.findAll(con);
        // Connection 반환
        close(con);
        // 응답메세지를 controller에 반환
        return list;

    }

    public MenuDto findByMenuCode(int menuCode) {
        // Connection 생성
        Connection con = getConnection();
        // Dao 메시지 전달
        MenuDto menuDto = menuDao.findByMenuCode(con, menuCode);
        // Connection 반환
        close(con);
        // 응답메세지를 controller에 반환
        return menuDto;
    }

    public int insertMenu(MenuDto menuDto) {
        // Connection 생성
        Connection con = getConnection();
        // Dao 메시지 전달
        try {
            int result = menuDao.insertMenu(con, menuDto);
            // 트랜잭션 처리(DML)
            commit(con);
            // 응답메세지를 controller에 반환
            return result;
        } catch (Exception e) {
            rollback(con);
            throw new RuntimeException(e); // controller에 예외 전달
        } finally {
            // Connection 반환
            close(con);
        }
    }

    public int insertCategoryAndMenu(CategoryDto categoryDto, MenuDto menuDto) {
        // Connection 생성
        Connection con = getConnection();
        try {
            // Dao 메시지 전달
            // 카테고리 등록
            int result = menuDao.insertCategory(con, categoryDto);

            // 카테고리 PK(auto_increment) 가져오기
            int categroyCode = menuDao.selectLastInsertId(con);
            System.out.println("발급된 카테고리 코드 : "+categroyCode);
            // 메뉴 등록
            menuDto.setCategoryCode(categroyCode);
            result = menuDao.insertMenu(con, menuDto);
            // 트랜잭션 처리(DML)
            commit(con);
            // 응답메세지를 controller에 반환
            return result;
        } catch (Exception e) {
            rollback(con);
            throw new RuntimeException(e); // controller에 예외 전달
        } finally {
            // Connection 반환
            close(con);
        }
    }
}
