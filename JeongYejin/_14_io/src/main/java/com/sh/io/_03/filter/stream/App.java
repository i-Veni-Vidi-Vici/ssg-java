package com.sh.io._03.filter.stream;

import java.io.*;

/**
 * <pre>
 * BufferedReader, BufferedWriter 보조스트림클래스
 * - 문자기반의 주스트림과 반드시 함께 사용한다.
 * - 주스트림이 대상(파일, 콘솔)과 직접 연결되고, 보조스트림이 부가기능을 제공한다.
 * - 주스트림 객체를 보조스트림 객체로 감싸서 제어하는 형태로써, 이후에는 보조스트림객체만 제어한다.
 *      - 보조스트림.read()
 *      - 보조스트림.write()
 *      - 보조스트림.close() - 주스트림객체까지 모두 반납한다.
 * </pre>
 */
public class App {
    public static final String ROOT = "JeongYejin/_14_io/";
    public static void main(String[] args) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(ROOT + "/testBuffered.txt"));
            // FileWriter객체에 직접 접근할 일이 없기 때문에 생성자를 변수에 대입하지 않고, 보조스트림 안에 주스트림을 전달하고, 보조스트림만 제어한다.
            bw.write("안녕~ 일어나~ 밥먹어야지~\n"); // 내부버퍼에 기록. 버퍼가 가득차면 자동으로 쓰기처리
            bw.write("잘가~ 내일봐~\n"); // 내부버퍼에 기록. 버퍼가 가득차면 자동으로 쓰기처리
//            bw.flush(); //즉시쓰기처리 // 그래도 닫으세요. 버퍼가 안차면 기록이 안됩니다 !!!
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(ROOT + "testBuffered.txt"));
            // BufferedReader#readLine() 한줄씩 읽어서 반환 (개행문자까지 읽어서 개행문자 버리고 반환)
            String data = null;
            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
