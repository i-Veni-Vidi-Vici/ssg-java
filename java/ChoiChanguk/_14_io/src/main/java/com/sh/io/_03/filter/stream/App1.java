package com.sh.io._03.filter.stream;

import java.io.*;

/**
 * <pre>
 * BufferedReader, BufferedWriter 보조스트림클래스
 * - 문자기반의 주스트림과 반드시 함께사용.
 * - 주스트림이 대상(파일, 콘솔)과 직접연결되고, 보조스틀미이 부가기능을 제공한다.
 * - 주스트림객체를 보조스트림객체로 감싸서 제어하는 형태로써, 이 후에는 보조스트림객체만 제어한다.
 *     - 보조스트림.read();
 *     - 보조스트림.write();
 *     - 보조스트림.close(); - 주스트림객체까지 모두 반납한다.
 * </pre>
 */
public class App1 {
    public static final String ROOT="ChoiChanguk/_14_io/";

    public static void main(String[] args) {
        //02.stream은 보기만 하고 여기 있는걸 많이 연습해라
        BufferedWriter bw=null;

        try {
            // 이렇게 하는 이유
            // 파일을 가져와서 버퍼에 채우고 다 차면 담긴다
            // 이거 모양 기억해 많이 쓸꺼야
            // 우리 회원입력 할 때 어떻게 할껀지 생각 해
            bw=new BufferedWriter(new FileWriter(ROOT+"testBuffered.txt"));
            bw.write("내부 버퍼에 써지고 한 번에 기록이 됩니다\n");
            bw.write("내일은 4월3일 수요일입니다");
            bw.flush();//즉시쓰기//close없어도 되긴 하는데 닫기 잘하면 된다//꼭 닫기 해라//거의 잘 안쓴다
            //내부버퍼에 기록, 버퍼가 가득차면, 자동으로 쓰기처리
            //팀과제를 하게 되면 공백으로 기준을 두고 담고, 가져오면 되겟다
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

        finally
        {
                try
                {
                    if(bw!=null)
                    bw.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
        }

        BufferedReader br=null;
        try{
            //이렇게 파일을 가져온다
            br=new BufferedReader(new FileReader(ROOT+"testBuffered.txt"));
            //Buffered#readLine() 한줄씩 읽어서 반환 가능하다
            //개행문자까지 읽어서 개행문자 버리고 반환 = nextLine과 비슷하다
            String data=null;
            while ((data=br.readLine())!=null)
            {
                System.out.println(data);
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
