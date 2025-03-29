package com.sh.collections._03.map;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * <pre>
 * Properties 클래스
 * - 레거시클래스임에도 현재까지 많이 사용되는 맵계열 클래스
 * - Map<K, V>과 달리 Properties는 제네릭클래스가 아니다.
 * - key/value모두 String으로 한정된 맵 클래스이다.
 * - 설정보 관리에 최적화
 * - 설정파일 읽기/쓰기 기능 지원
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        // put/get이 아닌 setProperty/getProperty를 사용한다.
        prop.setProperty("driverClass", "oracle.jdbc.driver.OracleDriver");
        prop.setProperty("url", "jdbc:oracle:than:@localhost:1521");
        prop.setProperty("user", "honggd");
        System.out.println(prop);

        // 파일로 저장(출력 : 프로그램 데이터 --> 외부파일)
//        try{
//            // 멀티모듈로 관리시에는 루트프로젝트 하위 경로를 모두 작성해야 한다.
//            prop.store(new FileWriter("LeeYoungwoo/_12_collections_framework/dataSource.properties"),
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // 설정파일 읽어오기
//        Properties prop2 = new Properties();
//        try {
//            prop2.load(new FileReader("LeeYongwoo/_12_collections_framework/dataSource.properties"))
//
//        }
    }
}
