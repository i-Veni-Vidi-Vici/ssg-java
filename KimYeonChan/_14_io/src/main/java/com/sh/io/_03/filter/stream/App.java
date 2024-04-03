package com.sh.io._03.filter.stream;

import java.io.*;

/**
 * <pre>
 *     BufferedReader, BufferedWriter 보조 스트림 클래스
 *      - 문자 기반의 주스트림과 반드시 함께 사용한다.
 *      - 주스트림이 대상(파일, 콘솔)과 직접 연결되고, 보조스트림이 부가기능을 제공한다.
 *      - 주스트림 객체를 보조스트림 객체로 감싸서 제어하는 형태로써, 이후에는 보조스트림만 제어한다.
 *          - 보조스트림.read()
 *          - 보조스트림.writer()
 *          - 보조스트림.close()
 * </pre>
 */
public class App {
    public static final String ROOT = "KimYeonChan/_14_io/";

    public static void main(String[] args) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(ROOT + "testBuffered.txt"));
            bw.write("밥밥밥\n");
            bw.write("바바바\n");
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

            // BufferedReader#readLine() 한 줄씩 읽어서 반환 (개행문자까지 읽어서 개행문자 버리고 반환)
            String data = null;
            while ((data = br.readLine()) != null) {
                System.out.println(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
