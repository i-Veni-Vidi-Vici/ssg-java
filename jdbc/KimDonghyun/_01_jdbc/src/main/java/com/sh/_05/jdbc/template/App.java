package com.sh._05.jdbc.template;

import com.sh.common.JdbcTemplate;
import static com.sh.common.JdbcTemplate.*;

import java.sql.*;
import java.util.Scanner;

/**
 * <pre>
 * JDBC 코딩 절차
 * 1. 드라이버클래스 등록 (최초1회만)
 * 2. Connection 객체 생성
 * 3. PreparedStatement 쿼리객체 생성
 * 4. 쿼리 실행
 * 5. 결과처리 (DML:int반환, DQL:ResultSet반환)
 * 6. 자원반납
 *
 * PreparedStatement 개선점
 * - 기존 사용자입력값을 그대로 실행하는 Statement의 보안취약점을 개선
 * - 모든 사용자입력값의 특수문자를 escaping처리
 * - 동일쿼리를 재사용하는 방식으로 성능향상
 * - 사용자입력값을 작성하는 Position Holder(?)를 사용성 개선 
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        String sql = """
            select
                *
            from
                tbl_menu
            where
                menu_code = ?
                and menu_name = ?
            """;

        // 2. Connection 객체 생성
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            // 3. PreparedStatement 쿼리객체 생성 (미완성쿼리 전달)
            pstmt = con.prepareStatement(sql);
            // 값대입 (물음표 인덱스는 1부터 시작한다)
            // - 타입별로 setter 사용하기
            // - 문자열 감싸는 따옴표처리는 생략
            pstmt.setInt(1, 7);
            pstmt.setString(2, "민트미역국");

            // 4. 쿼리 실행
            rset = pstmt.executeQuery();
            // 5. 결과처리 (DML:int반환, DQL:ResultSet반환)
            while(rset.next()) {
                System.out.printf("%s %s\n",
                        rset.getInt("menu_code"),
                        rset.getString("menu_name")
                    );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 6. 자원반납
            close(rset);
            close(pstmt);
            close(con);
        }


    }
}
