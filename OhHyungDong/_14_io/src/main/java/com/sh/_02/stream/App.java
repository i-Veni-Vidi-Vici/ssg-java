package com.sh._02.stream;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <pre>
 * 입출력 스트림 구분
 * - JVM에서 외부데이터를 읽거나, 쓰기 위한 클래스를 스트림 클래스라 한다.
 * - OS의 자원을 할당 받아 읽기 /쓰기 작업을 수행하고, 사용 후에는 반드시 자원 반납을 해야한다.
 *
 * 스트림 구분
 * - 읽기 전용 스트림 : XXXInputSTream, XXXReader
 * - 쓰기 전용 스트림 : XXXOutputSTream, XXXWriter
 *
 * 단위 기반
 * - byte기반 스트림 : XXXInputStream, OutPutStream;
 * - 문자 기반 스트림 : XXXReader, XXXWriter
 *
 * - 주스트림 클래스 : 실제 대상과 직접 연결
 * - 보조(필터)스트림 : 기능향상, 부가기능 제공, 주스트림을 반드시 필요로 한다.
 * </pre>
 */
public class App {
    public static final String ROOT = "OhHyungDong/_14_io/"; // 프로젝트 루트(상대경로)
    public static void main(String[] args)
    {
        FileInputStream fis = null;
        //파일을 1바이트 기반으로 읽어오기 FileInputSTream
        try {
            fis = new FileInputStream(ROOT + "helloworld.txt");
            System.out.println("helloworld.txt와 연결된 FileInputStream객체를 생성했습니다.");

//            int data = fis.read();// byte단위(0 ~ 255)로 읽어서 int로 반환 (-1 다 읽었음 신호까지 표현)
//          int data = 0;
//          while((data = fis.read()) != -1){
//              System.out.println(data + " " + (char)data);
//              //10 => 개행처리 문자를 나타냄
//          }


            //byte[]로 한번에 읽어오기
            int len =(int)new File(ROOT, "helloworld.txt").length();
            byte[] bytes = new byte[len];

            fis.read(bytes);
            for(int i = 0; i< bytes.length; i++){
                System.out.println(bytes[i] + " " + (char) bytes[i]);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //자원 반납
            try
            {
                if(fis !=null) fis.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
