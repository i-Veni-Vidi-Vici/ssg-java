//package com.sh.collections._03.map;
//
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Properties;
//
///**
// * Properties 클래스
// */
//public class App4 {
//    public static void main(String[] args) {
//        Properties prop = new Properties();
//        //put/get이 아닌
//        prop.setProperty("driverClass", "oracle.jdvc.driver.OracleDriver");
//        prop.setProperty("url", "jdbc:oracle:thin@localhost:1521");
//        prop.setProperty("user", "hongge");
//        System.out.println(prop);
//
//        // 파일로 저장 ( 출력 : 프로그램 데이터 --> 외부파일)
//        try {
//            // 멀티모듈로 관리시에는 루트프로젝트 하위 경로를 모두 작성해야 한다.
//
//            prop.store(new FileWriter("Park-Taejun/_12_collections_framework/dataSource.properties"), "db configuration");
//            prop.storeToXML(new FileOutputStream("Park-Taejun/_12_collections_framework/dataSource.XML"), "db configuration");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        //설정파일 읽어오기
//        Properties prop2 = new Properties();
//        try {
//
//
////            prop2.load(new FileReader("Park-Taejun/_12_collections_framework/dataSource.properties"));
////            prop2.load
//            System.out.println("prpp 2 = " + prop2);
////            String dprop2.getProperty("driver");
//
//
//        }
//    }
//}
