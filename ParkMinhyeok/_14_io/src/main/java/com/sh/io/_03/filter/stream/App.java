package com.sh.io._03.filter.stream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 * BufferedReader, BufferedWriter 보조스트림클래스
 * - 문자기반의 주스트림과 반드시 함께 사용
 * - 주스트림이 대상(파일, 콘솔)과 직접연결되고, 보조스트림이 부가기능을 제공한다.
 * - 주스트림객체를 보조스트림객체로 감싸서 제어하는 형태로써, 이후에는 보조스트림객체만 제어한다.
 *      - 보조스트림.read()
 *      - 보조스트림.writer()
 *      - 보조스트림.close() - 주스트림객체까지 모두 반납한다.
 * </pre>
 */
public class App {
    public static final String ROOT = "_14_io/";
    public static void main(String[] args) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(ROOT + "testBuffered.txt"));
            bw.write("안녕 일어나 밥먹어야지");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null )
                    bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
