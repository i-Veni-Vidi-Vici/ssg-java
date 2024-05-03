package com.sh._05.jdbc.template;

import static com.sh._05.jdbc.template.common.JdbcTemplate.close;
import static com.sh._05.jdbc.template.common.JdbcTemplate.getConnection;

import java.sql.*;



public class App {
    public static void main(String[] args) {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb"; // protocol://host:port/db
        String user = "sh";
        String password = "sh";
        String sql = """
            select
                *
            from
                tbl_menu
            where
                menu_code = ?
                and menu_name = ?
            """; // 미완성 쿼리 (값대입이 필요함)
        // 2. Connection 객체 생성
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try {
            // 3. PreparedStatement 쿼리객체 생성 (미완성쿼리 전달)
            pstmt = con.prepareStatement(sql);
            // 값대입 (물음표 인덱스는 1부터 시작한다.
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
            close(con);
            close(pstmt);
            close(rset);
        }
    }
}
