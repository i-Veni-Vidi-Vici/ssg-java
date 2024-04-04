package com.sh.io._03.filter.stream;


import java.io.*;

/**
 * <pre>
 *  BufferedReader 보조스트림
 *  InputStreamReader 브릿지(형변환)스트림
 *      - System.in 표준입력(키보드)
 * Scanner jdk 1.5에 추가되지 전에는 사용자 입력을 위와 같이 처리했다.
 * 표준입출력스트림을 사용후에는 절대 close 하지 않는다.
 * </pre>
 *
 *
 */
public class App2 {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in)); // System.in도 스트림이다.
            System.out.println("아무말 입력 : ");
            String data = br.readLine(); // 받아들이고
            System.out.println(data);
            int n = Integer.parseInt(data); // 직접 변수로 변환 해야했음.... 지금은 Scanner 씀 !
            System.out.println(n + 100);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(("abcdf")); // 콘솔에 내부 버퍼 이용해 출력
            bw.flush(); // 닫으면 안됩니다~ // 표준출력은 닫지않으므로, 명시적으로 flush호출해서 내부버퍼를 출력
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
