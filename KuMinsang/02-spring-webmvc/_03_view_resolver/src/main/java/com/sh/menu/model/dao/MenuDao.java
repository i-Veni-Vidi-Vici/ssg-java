package com.sh.menu.model.dao;

import com.sh.menu.model.dto.CategoryDto;
import com.sh.menu.model.dto.MenuDto;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.sh.common.JdbcTemplate.close;

/**
 * <pre>
 * DAO Data Access Object 
 * - Service로 부터의 요청을 DB에 접근해서 처리하는 객체
 * - 전달받은 Connection객체로 PreparedStatement를 생성
 * - 위치홀더의 값대입
 * - 쿼리 실행
 * - DQL인 경우, ResultSet을 DTO객체로 내용이전
 * - 생성한 PreparedStatement, ResultSet만 반환 (Connection은 반환하지 않는다)
 * </pre>
 */
public class MenuDao {
    private Properties prop = new Properties();

    /**
     * MenuDao객체 생성시 query.xml파일을 필드 Properties객체에 로드한다.
     */
    public MenuDao() {
        String fileName = "KimDonghyun/_02_jdbc_mvc/src/main/resources/sql/menu/menu-query.xml";
        try {
            prop.loadFromXML(new FileInputStream(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private MenuDto handleMenuResultSet(ResultSet rset) throws SQLException {
        int menuCode = rset.getInt("menu_code");
        String menuName = rset.getString("menu_name");
        int menuPrice = rset.getInt("menu_price");
        int categoryCode = rset.getInt("category_code");
        String orderableStatus = rset.getString("orderable_status");
        return new MenuDto(menuCode, menuName, menuPrice, categoryCode, orderableStatus);
    }

    public List<MenuDto> findAll(Connection con) {
        String sql = prop.getProperty("findAll");
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<MenuDto> list = new ArrayList<>(); // list객체 미리 생성
        try {
            // PreparedStatement생성 (미완성쿼리 전달)
            pstmt = con.prepareStatement(sql);
            // 위치홀더 값대입
            // 쿼리 실행 (ResultSet반환)
            rset = pstmt.executeQuery(); // DQL - executeQuery
            // ResultSet -> DTO객체 전환
            while(rset.next()) {
                // 행 -> MenuDto객체 변환
                MenuDto menuDto = handleMenuResultSet(rset);
                // List에 추가
                list.add(menuDto);
            }
            // DTO객체 service로 반환
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // ResultSet, PreparedStatement 자원반환(close)
            close(rset);
            close(pstmt);
        }
    }

    public MenuDto findByMenuCode(Connection con, int menuCode) {
        String sql = prop.getProperty("findByMenuCode");
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        MenuDto menuDto = null;
        try {
            // PreparedStatment 객체 생성 (미완성 쿼리 전달)
            pstmt = con.prepareStatement(sql);
            // ? 값대입
            pstmt.setInt(1, menuCode);
            // 쿼리실행 (ResultSet반환)
            rset = pstmt.executeQuery();
            // ResultSet -> Dto객체 이전
            while(rset.next()) {
                // 한행 -> MenuDto
                menuDto = handleMenuResultSet(rset);
            }
            return menuDto;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // close (pstmt, rset)
            close(rset);
            close(pstmt);
        }
    }

    public int insertMenu(Connection con, MenuDto menuDto) {
        String sql = prop.getProperty("insertMenu");
        PreparedStatement pstmt = null;
        try {
            // PreparedStatement 생성(미완성쿼리 전달)
            pstmt = con.prepareStatement(sql);
            // ? 값대입
            pstmt.setString(1, menuDto.getMenuName());
            pstmt.setInt(2, menuDto.getMenuPrice());
            pstmt.setInt(3, menuDto.getCategoryCode());
            pstmt.setString(4, menuDto.getOrderableStatus());
            // 쿼리 실행 (int 반환) & service단에 result 반환
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
    }

    public int insertCategory(Connection con, CategoryDto categoryDto) {
        String sql = prop.getProperty("insertCategory");
        PreparedStatement pstmt = null;
        try {
            // PreparedStatement 생성(미완성쿼리 전달)
            pstmt = con.prepareStatement(sql);
            // ? 값대입
            pstmt.setString(1, categoryDto.getCategoryName());
            pstmt.setInt(2, categoryDto.getRefCategoryCode());
            // 쿼리 실행 (int 반환) & service단에 result 반환
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }
    }

    public int selectLastInsertId(Connection con) {
        String sql = prop.getProperty("selectLastInsertId");
        int id = 0;
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            // ? 값대입
            try (ResultSet rset = pstmt.executeQuery()) {
                while(rset.next()) {
                    id = rset.getInt("id");
                }
                return id;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
