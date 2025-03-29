package com.sh.collections._03.map;

import java.io.*;
import java.util.Properties;

/**
 * <pre>
 *  Properties 클래스
 *  - 레거시 클래스임에도 현재까지 많이 사용되는 맵계열 클래스
 *  - Map<K, V>과 달리 Properties는 제네릭 클래스가 아니다.
 *  key/value 모두 String으로 한정된 맵 클래스이다.
 *  - 설정정보에 최적화 되어있다.
 *  - 설정 파일 읽기/쓰기 기능 지원
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        Properties properties = new Properties();
        // put/get이 아닌 setProperty/getPropery를 사용한다.
        properties.setProperty("driverClass", "oracle.jdbc.driver.OracleDriver");
        properties.setProperty("url", "jdbc:oracle:thin:@localhost:1521");
        properties.setProperty("user", "hongggd");
        System.out.println(properties);

        //파일로 저장(출력 : 프로그램 데이터 ---> 외부파일)
        try{
            //멀티 모듈로 관리시에는 루트 프로젝트 하위 경로를 모두 작성해야합니다.
            properties.store(new FileWriter("OhHyungDong/_12_collections_framework/datasource.properties"), "db configuration");
            properties.storeToXML(new FileOutputStream("OhHyungDong/_12_collections_framework/datasource.xml"), "db configuration");

        }catch(IOException e){
            e.printStackTrace();
        }

        //설정 파일 읽어오기
        Properties prop2 = new Properties();
        try {
//            prop2.load(new FileReader("OhHyungDong/_12_collections_framework/datasource.properties"));
            prop2.loadFromXML(new FileInputStream("OhHyungDong/_12_collections_framework/datasource.xml"));
            System.out.println("prop2 = " + prop2);
            String driver = prop2.getProperty(("driver"));
            String url = prop2.getProperty("url");
            String user = prop2.getProperty("user");
            String password = prop2.getProperty("password");

            System.out.println("driver = " + driver);
            System.out.println("url = " + url);
            System.out.println("user = " + user);
            System.out.println("password = " + password);

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
