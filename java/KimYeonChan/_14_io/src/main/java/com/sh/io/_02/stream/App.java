package com.sh.io._02.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <pre>
 *     입출력 스트림 구분
 *      - JVM 에서 외부 데이터를 읽거나, 쓰기 위한 클래스를 스트림클래스라 한다.
 *      - OS의 자원을 할당 받아 읽기/쓰기 작업을 수해하고, 사용 후에는 반드시 자원 반납을 해야한다.
 *      - 읽기 전용 스트림: XXXInputStream, XXXReader
 *      - 쓰기 전용 스트림: XXXOutputStream, XXXWriter
 *      - byte 기반 스트림: XXXInputSteam, XXXOutputStream
 *      - 문자 기반 스트림: XXXReader, XXXWriter
 *      - 주스트림: 실제 대상과 직정 연결
 *      - 보조(필터)스트림: 기능 향상, 부가기능 제공. 주스트림을 반드시 필요로 한다.
 * </pre>
 */
public class App {
    public static final String ROOT = "KimYeonChan/_14_io/";
    public static void main(String[] args) {
        // 파일 1byte 기반을 읽어오기 FileInputStream
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(ROOT + "helloworld.txt");
            System.out.println("helloworld.txt와 연결된 FileInputSteam 객체를 생성했습니다.");

//            int data = fis.read(); // byte 단위로 읽어서 int 로 반환 (-1 다 읽었음 신호까지 표기)
//            int data = 0;
//            while ((data = fis.read()) != -1) {
//                System.out.println(data + " " + (char)data); // utf-8 한글 저장시 3byte
//            }
            int len = (int) new File(ROOT, "helloworld.txt").length();
            byte[] bytes = new byte[len];
            fis.read(bytes);
            for (int i = 0; i < bytes.length; i++) {
                System.out.println(bytes[i] + " " + (char) bytes[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 자원 반납
            try {
                fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
