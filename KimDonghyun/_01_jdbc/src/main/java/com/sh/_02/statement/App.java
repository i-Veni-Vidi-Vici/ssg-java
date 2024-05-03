package com.sh._02.statement;

import java.sql.*;

/**
 * <pre>
 * JDBC 코딩 절차
 * 1. 드라이버클래스 등록 (최초1회만)
 * 2. Connection 객체 생성
 * 3. Statement | PreparedStatement 쿼리객체 생성
 * 4. 쿼리 실행
 * 5. 결과처리 (DML:int반환, DQL:ResultSet반환)
 * 6. 자원반납
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb"; // protocol://host:port/db
        String user = "sh";
        String password = "sh";

        // 1. 드라이버 클래스 등록
        try {
            Class.forName(driver);
            System.out.println("드라이버 클래스 등록 성공!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 2. Connection객체 생성
        Connection con = null;
        Statement stmt = null;
        ResultSet rset = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection 객체 생성 성공! " + con); // com.mysql.cj.jdbc.ConnectionImpl@7817fd62

            // 3. Statement 쿼리객체 생성
            stmt = con.createStatement();
            System.out.println("Statement 객체 생성 성공! " + stmt); // com.mysql.cj.jdbc.StatementImpl@69453e37
            // 4. 쿼리 실행
            String sql = """
                select
                    *
                from
                    tbl_menu
                where
                    category_code = 4
                """;
            rset = stmt.executeQuery(sql); // DQL:executeQuery, DML:executeUpdate
            System.out.println("ResultSet 객체 반환 성공! " + rset); // com.mysql.cj.jdbc.result.ResultSetImpl@7b02881e
            
            // 5. 결과처리 (ResultSet은 반복적으로 행을 처리)
            // ResultSet#next() : 처리할 다음행이 있으면, 포인터를 다음행으로 이동시키고, true반환
            while(rset.next()) {
                // 이번 행 처리
                // - 컬럼명은 대소문자 구분없이 작성 가능
                // - 컬럼 자료형에 맞는 getter를 사용할 것.
                //      - int -> getInt, double/decimal -> getDouble, varchar/char -> getString
                //      - date -> getDate, time -> getTime, datetime/timestamp -> getTimestamp
                System.out.printf("%s %s %s %s %s\n",
                            rset.getInt("menu_code"),
                            rset.getString("menu_name"),
                            rset.getInt("menu_price"),
                            rset.getInt("category_code"),
                            rset.getString("orderable_status")
                        );
            }
            
        } catch (SQLException e) {
            // JDBC 관련 최상위 예외클래스 (체크드 예외)
            throw new RuntimeException(e);
        } finally {
            // 6.자원반납 (생성 역순)
            try {
                if(rset != null)
                    rset.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if(con != null)
                    con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
