package com.sh.io._02.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <pre>
 * 입출력 스트림 구분
 * - JVM에서 외부데이터를 읽거나, 쓰기 위한 클래스를 스트림클래스라 한다.
 * - OS의 자우너을 할당받아 읽기/쓰기 작업 수행, 사용후에는 자원반납을 해야 한다(close)
 *
 * - 읽기전용 스트림 : XXXInputStream, XXXReader
 * - 쓰기전용 스트림 : XXXOutputStream, XXXWriter
 *
 * - byte기반 스트림 : XXXInputStream, XXXOutputStream
 * - 문자기반 스트림 : XXXReader, XXXWriter
 *
 * - 주스스트림 : 실제대상과 직접 연결
 * - 보조(필터)스트림 : 기능향상, 부가기능제공. 주스트림을 반드시 필요로 한다. 단독사용 불가
 *
 * </pre>
 */
public class App1 {
    public static final String ROOT="ChoiChanguk/_14_io/";

    public static void main(String[] args) {
        FileInputStream fis = null;
        // 파일을 1byte기반으로 읽어오기 FileInputStream
        try {
            //checked라서 예외처리 하라고 빨간줄이 뜬다
            fis = new FileInputStream(ROOT + "helloworld.txt");
            System.out.println("helloworld.txt와 연결된 FileInputstream객체를 생성했습니다");

//            int data = fis.read();// byte단위로 읽어서 int로 반환한다(-1 = 다 읽었음 신호까지 표현)
//            System.out.println(data);//
//            System.out.println((char) data);

//            int data=0;
//            while((data=fis.read())!=-1)
//            {
//                System.out.println(data +" "+(char)data);
//            }

            //byte[]로 한번에 읽어오기
            int len=(int)new File(ROOT,"helloworld.txt").length();
            byte[] bytes=new byte[len];

            fis.read(bytes);
            for(int i=0;i<bytes.length;i++)
                System.out.println(bytes[i]+" "+(char)bytes[i]);
        }
        // FileNotFoundException이놈은 IOException 하위라, fis.data 는 못잡는다
        catch (IOException e) {

            e.printStackTrace();// fis.read에 대한 catch문
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
