package com.sh._04.prepared.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * <pre>
 * JDBC DML 코딩 절차
 * 1. 드라이버클래스 등록 (최초1회만)
 * 2. Connection 객체 생성 (Autocommit false설정(기본값 true))
 * 3. PreparedStatement 쿼리객체 생성
 * 4. 쿼리 실행
 * 5. 결과 처리 (int 반환) - 정상처리시 commit, 오류발샐시 rollback
 * 6. 자원반납
 */

public class App2 {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb"; // protocol://host:port/db
        String user = "sh";
        String password = "sh";

        Connection con = null;
        PreparedStatement pstmt = null;
        int result = 0; // pstmt#executeUpdate() 실행후 처리된 행수를 반환

        String sql = """
                insert into
                tbl_menu (menu_name, menu_price, category_code, orderable_status)
                values (?,?,?,?)
                """;
        // 1. 드라이버클래스 등록 (최초1회만)
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // 2. Connection 객체 생성 (Autocommit false설정(기본값 true))
        try {
            con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false); // 수동커밋모드
            // 3. PreparedStatement 쿼리객체 생성
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "간장다시마");
            pstmt.setInt(2, 9900);
            pstmt.setInt(3, 10);
            pstmt.setString(4, "Y");
            // 4. 쿼리 실행
            result = pstmt.executeUpdate();
            System.out.println("쿼리 실행 결과 : "+ result);
            // 5. 결과 처리 (int 반환) - 정상처리시 commit, 오류발샐시 rollback
            con.commit(); // 명시적 커밋
        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            // 6. 자원반납
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
