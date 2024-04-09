package com.sh._03.filter.stream;

import java.io.*;

/**
 * BufferedReader 보조 스트림
 * InputStreamReader 브릿지(형변환) 스트림
 *  -System.in 표준입력 (키보드)
 *
 *  표준 입출력스트림을 사용후에는 절대 close하지 않는다.
 */
public class App2 {
    public static void main(String[] args) {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("아무말 입력 : ");
            String data = br.readLine();
            System.out.println(data);

            int n = Integer.parseInt(data);
            System.out.println(n +  100);
        }catch(IOException e){
            e.printStackTrace();
        }
        BufferedWriter bw = null;
        try{
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write("abcdef"); //콘솔 내부 버퍼를 이용하여 출력
            bw.flush(); //표준ㅊ 출력은 닫지 안으므로, 명시적으로 flush호출하여 내부버퍼를 출력
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
