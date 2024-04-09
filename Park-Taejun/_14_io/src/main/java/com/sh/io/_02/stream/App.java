package com.sh.io._02.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <pre>
 * 입출력 스트림 구분
 * - JVM에서 외부데이터를 읽거나, 쓰기 위한 클래스를 스트림클래스라고 함.
 * - OS의 자원을 할당받아 읽기/쓰기 작업을 수행하고, 사용 후에는 반드시 자원반납을 해야 한다.
 *
 * - 읽기전용 스트림 : XXXInputStream, XXXReader
 * - 쓰기전용 스트림 : XXXOutputStream, XXXWriter
 *
 * - byte 기반 스트림 : XXXInputStream, XXXOutputStream
 * - 문자기반 스트림 : XXXReader, XXXWriter
 *
 * - 주스트림 : 실제대상과 직접 연결
 * - 보조(필터)스트림 : 기능향상, 부가기능 제공. 주스트림을 반드시 필요로한다.
 *
 * </pre>
 */
public class App {
    public static final String ROOT = "Park-Taejun/_14_io/";
    public static void main(String[] args) {
        FileInputStream fis= null;
        // 파일을 1byte 기반으로 읽어오기 FileInputStream
        try {
            fis = new FileInputStream(ROOT + "helloworld.txt");
            System.out.println("hellowrld.txt와 연결된 FileInputStream 객체를 생성했습니다"); // 존재하므로

//            int data = fis.read(); // byte단위로 읽어서 int로 반환(-1 다 읽었음 신호까지 표현)
//            System.out.println((char) data); //txt의 첫글자
//            int data = 0;
//            while ((data = fis.read()) != -1){
//                System.out.println(data + " " + (char) data); // utf-8 한글 저장시 3byte
//            }
            // byte[]로 한번에 읽어오기
            int len = (int) new File(ROOT, "helloworld.txt").length();
            byte[] bytes = new byte[len];

            fis.read(bytes); //한방

            for (int i = 0 ; i < bytes.length; i++){
                System.out.println(bytes[i] + " " + (char)bytes[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally { //자원 반납 finally class
            try {
                if(fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
