package com.sh.io._02.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <pre>
 *  입출력 스트림 구분
 *  - JVM에서 외부 데이터를 읽거나, 쓰기 위한 클래스를 스트림 클래스라 한다.
 *  - OS의 자원을 할당받아 읽기/쓰기 작업을 수행하고, 사용 후에는 반드시 자원 반납을 해야 한다
 *
 *  - 읽기 전용 스트림 : XXXXInputStream , XXXReader
 *  - 쓰기 전용 스트림 : XXXXOutputStream, XXXXWriter
 *
 *  - byte기반 스트림 : XXXInputStream , XXXOutputStream
 *  - 문자기반 스트림 : XXXXReader , XXXXWriter
 *
 *  - 메인스트림 : 실제 대상과 직접 연결
 *  - 보조스트림 : 기능향상, 부가기능제공
 * </pre>
 */
public class App {
    public static final String ROOT = "KuMinsang/_14_io/";
    public static void main(String[] args) {
        // 파일을 1byte기반으로 읽어오기 FileInputStream
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(ROOT+"helloworld.txt");
            System.out.println("helloworld.txt와 연결된 FileInputStream객체를 생성했습니다");
            int data = 0;
            /*
            while((data = fis.read())!= -1){
                System.out.println(data+ " " + (char)data);
            }
            */
            //byte[]로 한번에 읽어오기
            int len =(int) new File(ROOT, "helloworld.txt").length();
            byte[] bytes = new byte[len];

            fis.read(bytes);    //bytes 길이만큼 한번에 읽어와서 bytes에 저장함
            for(int i =0 ; i<bytes.length; i++){
                System.out.println(bytes[i] + " " + (char) bytes[i]);
            }

        } catch(IOException e){
            e.printStackTrace();
        } finally{
            try {
                if(fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
