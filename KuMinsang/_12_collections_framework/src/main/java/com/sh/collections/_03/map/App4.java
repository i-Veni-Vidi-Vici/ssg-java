package com.sh.collections._03.map;

import java.io.*;
import java.util.Properties;

/**
 * <pre>
 *     Properties 클래스
 *     - 레거시클래스임에도 현재까지 많이 사용되는 맵 계열 클래스
 *     - Map<K,V>과 달리 Properties는 제네릭 클래스가 아니다
 *     - Key/value 모두 String으로 한정된 맵 클래스이다
 *     - 설정정보 관리에 최적화 되었다.
 *     - 설정파일 읽기/쓰기 기능 지원
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        //  put/get이 아닌 setProperty/getProperty를 사용한다
        prop.setProperty("드라이버 클래스", "오라클.jdbc.drive.오라클드라이버");
        prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521");
        prop.setProperty("user", "honggd");
        System.out.println("저장전 properties");
        System.out.println(prop);
        //{드라이버 클래스=오라클.jdbc.drive.오라클드라이버, user=honggd, url=jdbc:oracle:thin:@localhost:1521}
        //저장한 순서 관계 없이 저장된다
        try {
            //멀티모듈로 관리시에는 루트프로젝트 하위 경로를 모두 작성해야 한다
            prop.store(new FileWriter("KuMinsang/_12_collections_framework/dataSource.properties"),"db_config");
            prop.storeToXML(new FileOutputStream("KuMinsang/_12_collections_framework/dataSource.xml"), "db_config");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //설정파일 읽어오기
        Properties prop2 = new Properties();
        try{
            System.out.println("파일리더");
            prop2.load(new FileReader("KuMinsang/_12_collections_framework/dataSource.properties"));
            System.out.println("propertie파일 = " + prop2);
            prop2.loadFromXML(new FileInputStream("KuMinsang/_12_collections_framework/dataSource.xml"));
            System.out.println("prop2(xml) = " +prop2);
            String driver = prop2.getProperty("드라이버 클래스");
            String url = prop2.getProperty("url");
            String user = prop2.getProperty("user");
            System.out.println("driver = "+driver);
            System.out.println("url = "+url);
            System.out.println("user =  "+user);


        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
