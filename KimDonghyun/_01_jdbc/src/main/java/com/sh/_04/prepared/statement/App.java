package com.sh._04.prepared.statement;

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
                menu_code = ?
                and menu_name = ?
            """; // 미완성 쿼리 (값대입이 필요하다)
            // ' or 1 = 1 -- -> \' or 1 \= 1 \-\- 이스케이핑처리된다.

        Connection con = null;
        PreparedStatement pstmt = null;
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
            // 3. PreparedStatement 쿼리객체 생성 (미완성쿼리 전달)
            pstmt = con.prepareStatement(sql);
            // 값대입 (물음표 인덱스는 1부터 시작한다)
            // - 타입별로 setter 사용하기
            // - 문자열 감싸는 따옴표처리는 생략
            pstmt.setInt(1, menuCode);
            pstmt.setString(2, menuName);

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
            try {
                if(rset != null)
                    rset.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if(pstmt != null)
                    pstmt.close();
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
