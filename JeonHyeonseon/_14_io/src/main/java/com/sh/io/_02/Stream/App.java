package com.sh.io._02.Stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <pre>
 * 입출력 스트림 구분
 *  - JVM에서 외부데이터를 읽거나, 쓰기 위한 클래스를 스트림클래스라고 한다.
 *  - OS의 자원을 할당받아 읽기/쓰기 작업을 수행하고, 사용후에는 반드시 자원반납을 해야 한다.
 *
 *  - 읽기전용 스트림 : XXXInputStream, XXXReader
 *  - 쓰기전용 스틑림 : XXXOutputStream, XXXWriter -> XXX는 대상을 가리킨다
 *
 *   (단위)
 *  - byte기반 스트림 : XXXInputStream, XXXOutputStream -> 1byte 씩 읽어냄
 *  - 문자기반 스트림 : XXXReader, XXXWriter -> 한 글자씩 읽어냄
 *
 *  - 주스트림 : 실제대상과 직접 연결
 *  - 보조(필터)스트림 : 기능향상, 부가기능제공, 주스트림을 반드시 필요로 한다.
 *
 * </pre>
 */
public class App {
    public static final String ROOT = "JeonHyeonseon/_14_io/";
    public static void main(String[] args) {
        // 파일을 1byte기반을 읽어오기 FileInputStream
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(ROOT + "helloworld.txt");
            System.out.println("helloworld.txt와 연결된 FileInputStream객체를 생성했습니다.");

//            int data = fis.read(); // byte단위(0~255)로 읽어서 int로 반환(-1, 다 읽었음
//            신호까지 표현하기 위해서)
//            System.out.println((char)data);

//            int data = 0;
//            while((data = fis.read()) != -1){
//                System.out.println(data + " " + (char)data);
//            }

            // byte[]로 한번에 읽어오기
            int len = (int) new File(ROOT, "helloworld.txt").length();
            byte[] bytes = new byte[len];

            fis.read(bytes);

            for (int i = 0; i < bytes.length; i++) {
                System.out.println(bytes[i] + " " + (char) bytes[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 자원반납
            try {
                if(fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
