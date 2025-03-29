package com.sh.io._03.filter.stream;

import java.io.*;

/**
 * <pre>
 * BufferedReader, BufferedWriter 보조스트림클래스
 * - 문자 기반의 주스트림과 반드시 함께 사용
 * - 주스트림이 대상(파일,콘솔)과 직접 연결되고, 보조스트림이 부가기능 제공
 * - 주스트림 객체를 보조스트림 객체로 감싸서 제어하는 형태로써, 이후에는 보조스트림 객체만 제어
 *   - 보조스트림.read()
 *   - 보조스트림.write()
 *   - 보조스트림.close() 주스트림 객체까지 모두 반납
 * </pre>
 */
public class App {
    public static final String ROOT = "ParkJeongeun/_14_io/";
    public static void main(String[] args) {
        BufferedWriter bw = null;
        try {
            // 주스트림을 괄호안에 담은 보조스트림을 변수에 담아 사용(주스트림을 변수로 따로 선언X)
            bw = new BufferedWriter(new FileWriter(ROOT + "testBuffered.txt"));
            bw.write("안녕\n"); // 내부버퍼에 기록, 버퍼가 다 차면 자동으로 쓰기 처리
            bw.write("잘가\n");
            bw.flush(); // 버퍼가 다 안차도 쓰기 처리
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                if(bw != null)
                    bw.close(); // close 안하면 testBuffered.txt에 "안녕"안써짐(close하면 버퍼 다 안차도 쓰기 처리됨)
            } catch (IOException e){
                throw new RuntimeException(e);
            }
        }

        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(ROOT + "testBuffered.txt"));
            // BufferedReader#readLine() 한줄씩 읽어서 반환(개행문자까지 읽고 개행문자는 버리고 반환)
            String data = null;
            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
