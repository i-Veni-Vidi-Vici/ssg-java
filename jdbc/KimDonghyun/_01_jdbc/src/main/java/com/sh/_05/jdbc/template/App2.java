package com.sh._05.jdbc.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.sh.common.JdbcTemplate.*;

/**
 * <pre>
 * JDBC DML 코딩 절차
 * 1. 드라이버클래스 등록 (최초1회만)
 * 2. Connection 객체 생성 (Autocommit false설정(기본값 true))
 * 3. PreparedStatement 쿼리객체 생성
 * 4. 쿼리 실행
 * 5. 결과처리 (int반환) - 정상처리시 commit, 오류발생시 rollback
 * 6. 자원반납
 */
public class App2 {
    public static void main(String[] args) {
        // 2. Connection 객체 생성 (Autocommit false설정(기본값 true))
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        int result = 0; // pstmt#exeucuteUpdate() 실행후 처리된 행수를 반환

        String sql = """
            insert into
                tbl_menu (menu_name, menu_price, category_code, orderable_status)
            values (
                ?, ?, ?, ?
            )""";

        try {
            // 3. PreparedStatement 쿼리객체 생성
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "참기름다시마");
            pstmt.setInt(2, 8800);
            pstmt.setInt(3, 10);
            pstmt.setString(4, "Y");

            // 4. 쿼리 실행
            result = pstmt.executeUpdate();
            System.out.println("쿼리 실행 결과 : " + result); // 1

            // 5. 결과처리 (int반환) - 정상처리시 commit, 오류발생시 rollback
            commit(con);
        } catch (SQLException e) {
            rollback(con);
            throw new RuntimeException(e);
        } finally {
            // 6. 자원반납
            close(pstmt);
            close(con);
        }
    }
}
