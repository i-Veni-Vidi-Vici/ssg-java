package com.sh.io._03.filter.stream;

import java.io.*;
import java.nio.Buffer;

/**
 * <pre>
 * BufferredReader, BufferedWriter 보조스트림클래스
 * - 문자기반의 주 스트림과 반드시 함께 사용한다.
 * - 주스트림이 대상(파일, 콘솔)과 직접 연결되고, 보조스트림이 부가기능을 제공한다.
 * - 주스트림객체를 보조스트림객체로 감싸서 제어하는 형태로써, 이후에는 보조스트림객체만 제어
 *      - 보조스트림.read()
 *      - 보조스트림.write()
 *      - 보조스트림.close() - 주스트림 객체까지 모두 반납.
 * </pre>
 */

public class App {
    public static final String ROOT = "ChungSeongYeon/_14_io/";
    public static void main(String[] args) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(ROOT + "/testBuffered.txt")); // 모양 기억하기
            bw.write("HELLO! WakeUp!\n"); // 내부 버퍼에 기록. 버퍼가 가득차면, 자동으로 쓰기처리
            bw.write("BYE! SeeYouSoon!\n"); // 내부 버퍼에 기록. 버퍼가 가득차면, 자동으로 쓰기처리
//            bw.flush(); // 즉시쓰기처리
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bw != null)
                    bw.close(); // close 빼먹고 안하면 안 써질 수 있음. close를 잘하면 안써질 일이 없다!!
            } catch (IOException e){
                throw new RuntimeException(e);
            }
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(ROOT + "testBuffered.txt"));
            // BufferedReader#readLine() 한줄씩 읽어서 반환 (개행문자까지 읽어서 개행문자 버리고 반환)
            String data = null;
            while ((data = br.readLine()) != null){
                System.out.println(data);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
