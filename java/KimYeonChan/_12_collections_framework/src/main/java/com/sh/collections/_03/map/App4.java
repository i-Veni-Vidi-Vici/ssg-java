package com.sh.collections._03.map;

import java.io.*;
import java.util.Properties;

/**
 * Properties 클래스
 * - 레거시클래스임에도 현재까지 많이 사용되는 맵계열 클래스
 * - Map<k, V> 과 달리 Properties 는 제네릭 클래스가 아니다.
 * - key/value 모두 String 으로 한정된 맵 클래스이다.
 * - 설정 정보 관리에 최적화되었다.
 * - 설정 파일 읽기/쓰기 기능 지원
 */
public class App4 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        // put/get 이 아닌 setProperty/getProperty 를 사용한다.
        prop.setProperty("driver", "com.mysql.cj.jdbc.Driver");
        prop.setProperty("url", "jdbc:mysql://localhost:3306/student");
        prop.setProperty("user", "student");
        prop.setProperty("password", "student");
        System.out.println(prop);

        // 멀티 모듈로 관리시에는 루트프로젝트 하위 경로를 모두 작섣해야 한다.
        try {
            prop.store(new FileWriter("KimYeonChan/_12_collections_framework/dataSource.properties"), "db configuration");
            prop.storeToXML(new FileOutputStream("KimYeonChan/_12_collections_framework/dataSource.xml"), "db configuration");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // 설정파일 읽어오기
        Properties prop2 = new Properties();
        try {
            prop2.load(new FileReader("KimYeonChan/_12_collections_framework/dataSource.properties"));
            System.out.println(prop2);

            prop2.loadFromXML(new FileInputStream("KimYeonChan/_12_collections_framework/dataSource.xml"));
            System.out.println(prop2);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
