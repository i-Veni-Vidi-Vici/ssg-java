package com.sh.collections._03.map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * <pre>
 * Properties 클래스
 * - 레거시클래스임에도 현재까지 많이 사용되는 맵계열 클래스
 * - Map<K, V>과 달리 Properties는 제네릭클래스가 아님
 * - key/value모두 String으로 한정된 앱 클래스임
 * - 설정정보 관리에 최적화됨
 * - 설정파일 읽기/쓰기 기능 지원
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        // put/get이 아닌 setProperty/getProperty를 사용
        properties.setProperty("driverClass", "oracle.jdbc.driver.OracleDriver");
        properties.setProperty("url", "jdbc:oracle:thin");
        properties.setProperty("user", "hong");

        System.out.println(properties);

        // 파일로 저장 (출력:프로그램 데이터 ---> 외부파일)
        try {
            // 멀티모듈로 관리시에는 루트프로젝트 하위경로를 모두 작성해야 함
            properties.store(new FileWriter("ByeonSeongil/_12_collections_framework/dataSource.properties"), "db");
            properties.storeToXML(new FileOutputStream("ByeonSeongil/_12_collections_framework/dataSource.xml"),  "db configuration");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 설정파일 읽어오기
        Properties properties1 = new Properties();
        try {

            properties1.load(new FileReader("ByeonSeongil/_12_collections_framework/dataSource.properties"));
//            properties1.loadFromXML(new FileInputStream("ByeonSeongil/_12_collections_framework/dataSource.xml"));

            System.out.println("prop1 = "+ properties1);
            String driver = properties1.getProperty("driverClass");
            String url = properties1.getProperty("url");
            System.out.println(driver);
            System.out.println(url);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
