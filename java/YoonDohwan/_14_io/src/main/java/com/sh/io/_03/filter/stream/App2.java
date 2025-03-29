package com.sh.io._03.filter.stream;

import java.io.*;

/**
 * BufferedReader 보조스트림
 * inputStreamReader 브릿지(형변환)스트림
 *-System.in 표준입력(키보드)
 *
 * 표준입출력스트림을 사용후에는 절대 close 하지 않는다.
 */
public class App2 {
    public static void main(String[] args) {
        BufferedReader br =null;
        try{
            br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("아무말 입력 : ");
            String data = br.readLine();
            System.out.println(data);
        }catch(IOException e){
            e.printStackTrace();
        }
        BufferedWriter bw = null;
        try{
            bw=new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write("abcdef");
            bw.flush();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
