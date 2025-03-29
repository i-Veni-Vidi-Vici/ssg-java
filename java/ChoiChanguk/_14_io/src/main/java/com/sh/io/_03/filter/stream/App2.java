package com.sh.io._03.filter.stream;

import java.io.*;

/**
 * <pre>
 * BufferedReader 보조스트림
 * InputStreamReader 브릿지(형변환) 스트림
 *   - system.in 표준입력(키보드)
 *
 * Scanner jdk1.5에 추가되전에는 사용자 입력을 위와같이 처리 했다.
 * 표준입출력 스트림을 사용후에는 절대 close하지 않는다.
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        BufferedReader br=null;
        try {
            br=new BufferedReader(new InputStreamReader(System.in));//안에 System.in 이거 안됨 이것도 스트림임
            System.out.print("아무말 입력 : ");
            String data=br.readLine();

            System.out.println("문자열 : "+data);
            int n=Integer.parseInt(data);

            System.out.println("더하기 : " +(n+15));

        }catch (IOException e)
        {
            e.printStackTrace();
            //close하면 주 입력까지 닫혀서 재시작을 해야 한다
        }

        BufferedWriter bw=null;
        try {
            //이건 거의 안씀
            bw=new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write("BufferWriter입니다");//콘솔에 내부버퍼를 이용해 출력
            bw.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
