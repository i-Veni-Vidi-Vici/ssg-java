package com.sh.io._02.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <pre>
 * 입출력 스트림 구분
 * - JVM 에서 외부데이터를 읽거나, 쓰기 위한 클래스를 스트림클래스라 한다.
 * - OS 의 자원을 할당받아 읽기/쓰기 작업을 수행하고, 사용후에는 반드시 자원반납을 해야 한다.
 *
 * - 읽기전용 스트림 : XXXInputStream, XXXReader
 * - 쓰기전용 스트림 : XXXOutputStream, XXXWriter
 *
 * - byte 기반 스트림 : XXXInputStream, XXXOutputStream
 * - 문자기반 스트림 : XXXReader, XXXWriter
 *
 * - 주스트림 : 실제대상과 직접 연결
 * - 보조(필터)스트림 : 기능향상, 부가기능제공. 주스트림을 반드시 필요로 한다.
 * </pre>
 */
public class App {
    public static final String ROOT = "_14_io/";
    public static void main(String[] args) {
        // 파일을 1byte 기반으로 읽어오기 File?InputStream
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(ROOT + "helloworld.txt");
            System.out.println("helloworld.txt와 연결된 FileInputStream 객체를 생성했습니다.");

//            int data = fis.read(); // byte 단위(0~ 255)로 읽어서 int로 반환(-1 다 읽었음 신호까지 표현)
            int data = 0;
            while ((data = fis.read()) != -1) {
                System.out.println(data + " " + (char) data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 자원반납
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
