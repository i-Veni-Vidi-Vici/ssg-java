package com.sh.io._02.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <pre>
 *    입출력 스트림 구분
 * - JVM에서 외부데이터를 읽거나, 쓰기 위한 클래스를 스트림 클래스라고 함
 * - OS의 자원을 할당 받아 읽기/쓰기 작업을 수행하고, 사용후에는 반드시 자원 반납을 해야 함
 *
 * - 읽기 전용 stream : XXXInputStream, XXXReader
 * - 쓰기 전용 stream : XXXOutputStream, XXXWriter
 *
 * - byte 기반 stream : XXXInputStream, XXXOutputStream
 * - 문자 기반 stream : XXXReader, XXXWriter
 *
 * - 주 stream : 실제 대상과 직접 연결
 * - 보조(필터) 스트림 : 기능 향상, 부가기능 제공 / 주 스트림을 반드시 필요로 한다.
 * </pre>
 */
public class App {
    public static final String ROOT = "HongJimin/_14_io/";

    public static void main(String[] args) {
        //파일을 1byte 기반으로 읽어오기 FileInputStream
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(ROOT + "helloworld.txt");
            System.out.println("helloworld.txt와 연결된 FileInputStream 객체를 생성했습니다.");

//            int data = fis.read(); //byte 단위(0~255)로 읽어서 int로 반환(-1 다 읽었음 신호까지 표현해주기 위해 int로 반환함)
//            int data = 0;
//            while ((data = fis.read()) != -1) {
//                System.out.println(data + " " + (char)data);
//            }

            //byte []로 한번에 읽어오기
            int len = (int) new File(ROOT, "helloworld.txt").length();
            byte[] bytes = new byte[len];

            fis.read(bytes);

            for(int i = 0; i < bytes.length; i++){
                System.out.println(bytes[i] + " " + (char) bytes[i]); // ⛔출력 안되는거 확인하기⛔
            }

        } catch (IOException e) { //IOException의 자식 exception
            e.printStackTrace();
        } finally {
            //자원 반납
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
