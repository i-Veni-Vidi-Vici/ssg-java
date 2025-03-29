package com.sh.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * <pre>
 * JDBC API 사용간의 공통 코드를 static메서드로 제공하는 클래스
 * - SQLException을 처리하기 위한 try..catch문도 미리 구현해서 호출부에서는 간결하게 코드 작성 가능
 * </pre>
 */
public class JdbcTemplate {
    static String driver ;
    static String url ; // protocol://host:port/db
    static String user ;
    static String password ;

    static {
        // jdbc-config.properties 설정정보 읽어오기
        String fileName = "ByeonSeongil/_02_jdbc__mvc/src/main/resources/config/jdbc-config.properties";
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(fileName));
            System.out.println("설정정보 : "+properties);
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //  드라이버 클래스 등록 (프로그램 최초 1회)
        try {
            Class.forName(driver);
            System.out.println("드라이버 클래스 등록 완료!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            con.setAutoCommit(false); // 수동커밋모드
            return con;
        } catch (SQLException e) {
            // 체크드예외를 언체크드예외로 전환해서 던진다.
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection con) {
        try {
            if (con != null && !con.isClosed())
                con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(PreparedStatement pstmt) {
        try {
            if (pstmt != null && !pstmt.isClosed())
                pstmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(ResultSet rset) {
        try {
            if (rset != null && !rset.isClosed())
                rset.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit(Connection con) {
        try {
            if(con != null && !con.isClosed())
            con.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback (Connection con) {
        try {
            if(con != null && !con.isClosed())
                con.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
