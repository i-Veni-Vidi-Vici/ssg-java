package com.sh.io._03.filter.stream;

import java.io.*;

/**
 * <pre>
 *     BufferedReader, BufferedWriter 보조스트림 클래스
 *     -
 * </pre>
 */
public class App {
    public static final String ROOT = "HongJimin/_14_io/";

    public static void main(String[] args) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(ROOT + "testBuffered.txt"));//Filewriter를 BufferWriter에 적용하는 것
            bw.write("안녕~ 일어나 밥먹어야지~\n"); //내부 버퍼에 기록. 버퍼가 가득 다 차면, 자동으로 쓰기 처리 함
            bw.write("잘가~ 내일봐~\n");
//            bw.flush(); //즉시 쓰기 처리
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(ROOT + "testBuffered.txt"));
            //BufferedReader#readLine() 한줄씩 읽어서 반환(개행문자까지 읽어서 개행문자 버리고 반환)
            String data = null;
            while ((data = br.readLine()) != null){
                System.out.println(data);
            }
        } catch (IOException e) {
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
