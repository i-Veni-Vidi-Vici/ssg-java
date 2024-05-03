package com.sh._03.sql.injection;

import java.sql.*;
import java.util.Scanner;

/**
 * <pre>
 * JDBC 코딩 절차
 * 1. 드라이버클래스 등록 (최초1회만)
 * 2. Connection 객체 생성
 * 3. Statement | PreparedStatement 쿼리객체 생성
 * 4. 쿼리 실행
 * 5. 결과처리 (DML:int반환, DQL:ResultSet반환)
 * 6. 자원반납
 * 
 * SQL Injection 
 * - 해킹공격법 중의 하나.
 * - 사용자입력값부분을 임의로 조작해 보안취약점을 악용하거나 사용자 정보를 탈취하는 기법
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
        // 메뉴코드, 메뉴이름을 모두 정확히 입력해야 해당 레코드를 조회 가능한 상황
        // (id, password를 통해 로그인해야 하는 상황과 유사하게 테스트)
        Scanner sc = new Scanner(System.in);
        System.out.println("메뉴 코드 : ");
        int menuCode = sc.nextInt();
        sc.nextLine(); // 개행 날리기
        System.out.println("메뉴 이름 : ");
        String menuName = sc.nextLine();
        
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
                menu_code = %d
                and menu_name = '%s'
            """.formatted(menuCode, menuName);
        // 아무숫자
        // ' or 1=1 --
        // Sql Injection 공격이 성공해서 모든 메뉴정보를 탈취했다.

        Connection con = null;
        Statement stmt = null;
        ResultSet rset = null;

        // 1. 드라이버클래스 등록 (프로그램 실행 최초1회만)
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            // 2. Connection 객체 생성
            con = DriverManager.getConnection(url, user, password);
            // 3. Statement | PreparedStatement 쿼리객체 생성
            stmt = con.createStatement();
            // 4. 쿼리 실행
            rset = stmt.executeQuery(sql);
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
