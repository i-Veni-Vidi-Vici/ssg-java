package com.sh._01.connection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * <pre>
 * JDBC 코딩 절차
 * 1. 드라이버클래스 등록 (최초1회만)
 * 2. Connection 객체 생성
 * 3. Statement | PreparedStatement 쿼리객체 생성
 * 4. 쿼리 실행
 * 5. 결과 처리 (DML:int반환, DQL:ResultSet반환)
 * 6. 자원반납
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 1. 드라이버 클래스 등록
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
            System.out.println("드라이버 클래스 등록 성공!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // 2. Connection객체 생성
        String url = "jdbc:mysql://localhost:3306/menudb"; // protocol://host:port/db
        String user = "sh";
        String password = "sh";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection 객체 생성 성공!");
            System.out.println(con);
            // JDBC 관련 최상의 예외클래스 (체크드 예외)
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 6. 자원반납
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
