package com.sh.collections._03.map;

import java.io.*;
import java.util.Properties;

/**
 * <pre>
 * Properties 클래스
 * - 레거시클래스임에도 현재까지 많이 사용되는 맵계열 클래스
 * - Map<K,V>과 달리 Properties는 제네릭클래스가 아님
 * - key/value 모두 String으로 한정된 맵클래스
 * - 설정정보 관리에 최적화
 * - 설정파일 읽기/쓰기 기능 지원
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        // 값 설정/읽기 setProperty/getProperty 사용
        prop.setProperty("driverClass", "oracle.jdbc.driver.OracleDriver");
        prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521");
        prop.setProperty("user", "honggd");
        System.out.println(prop);

        // 파일로 저장 (출력 : 프로그램 데이터 -> 외부파일)
        try{ // 오류에 대한 처리
            // 멀티모듈로 관리시에는 루트프로젝트 하위 경로를 모두 작성해야 함
            prop.store(new FileWriter("ParkJeongeun/_12_collections_framework/dataSource.properties"), "db configuration");
            prop.storeToXML(new FileOutputStream("ParkJeongeun/_12_collections_framework/dataSource.xml"), "db configuration");
        } catch (IOException e){
            e.printStackTrace();
        }

        // 설정파일 읽어오기
        Properties prop2 = new Properties();
        try{
//            prop2.load(new FileReader("ParkJeongeun/_12_collections_framework/dataSource.properties"));
            prop2.loadFromXML(new FileInputStream("ParkJeongeun/_12_collections_framework/dataSource.xml"));

            System.out.println("prop2 : " + prop2);
            String driverClass = prop2.getProperty("driverClass");
            String url = prop2.getProperty("url");
            String user = prop2.getProperty("user");

            System.out.println("driverClass : " + driverClass);
            System.out.println("url : " + url);
            System.out.println("user : " + user);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
