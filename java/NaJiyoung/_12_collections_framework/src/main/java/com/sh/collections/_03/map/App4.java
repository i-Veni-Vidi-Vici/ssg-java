package com.sh.collections._03.map;

import java.io.*;
import java.util.Properties;

/**
 * <pre>
 * Properties 클래스
 * - 레거시클래스임에도 현재까지 많이 사용되는 맵계열 클래스
 * - Map<K, V>과 달리 Properties는 제네릭클래스가 아니다.
 * - key/value 모두 String으로 한정된 앱 클래스이다.
 * - 설정정보 관리에 최적화되었다.
 * - 설정파일 읽기/쓰기 기능 지원
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        // put/get이 아닌 setProperty/getProperty를 사용한다.
        prop.setProperty("driver", "com.mysql.cj.jdbc.Driver");
        prop.setProperty("url", "jdbc:mysql://localhost:3306/student");
        prop.setProperty("user", "student");
        prop.setProperty("password", "student");
        System.out.println(prop);

        // 파일로 저장 (출력 : 프로그램 데이터 --> 외부파일)
        try {
            // 멀티모듈로 관리시에는 루트프로젝트 하위 경로를 모두 작성해야 한다.
            prop.store(new FileWriter("NaJiyoung/_12_collections_framework/dataSource.properties"), "db configuration");
            prop.storeToXML(new FileOutputStream("NaJiyoung/_12_collections_framework/dataSource.xml"), "db configuration");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 설정파일 읽어오기
        Properties prop2 = new Properties();
        try {
//            prop2.load(new FileReader("NaJiyoung/_12_collections_framework/dataSource.properties"));
            prop2.loadFromXML(new FileInputStream("NaJiyoung/_12_collections_framework/dataSource.xml"));
            System.out.println("prop2 = " + prop2);

            String driver = prop2.getProperty("driver");
            String url = prop2.getProperty("url");
            String user = prop2.getProperty("user");
            String password = prop2.getProperty("password");
            System.out.println("driver = " + driver);
            System.out.println("url = " + url);
            System.out.println("user = " + user);
            System.out.println("password = " + password);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
