package com.sh.io._03.filter.stream;

import java.io.*;

/**
 * <pre>
 * BufferedReader 보조스트림
 * - InputStreamReader 브릿지(형변환)스트림
 *   - System.in 표준입력(키보드)
 *
 * Scanner가 jdk1.5에 추가되기전에는 사용자 입력을 위와 같이 처리했음
 * 표준입출력스트림을 사용 후에는 절대 close하지 않음
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        // Scanner 이전에 사용자 입력값 받고 출력하는 방법
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("아무말 입력 : ");
            String data = br.readLine();
            System.out.println(data);
//            int n = Integer.parseInt(data); // 정수 받으려면 이 코드 추가
        } catch (IOException e){
            e.printStackTrace();
        }

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write("abcdef"); //콘솔에 내부버퍼를 이용해 출력
            bw.flush(); // 표준출력은 닫지 않으므로, 명시적으로 flush 호출해서 내부버퍼 출력
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
