package com.sh.io._03.filter.stream;

import java.io.*;

/**
 * <pre>
 * DataInputStream / DataOutputStream 보조 스트림
 * - 자료형 단위로 읽기/쓰기 기능 지원
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        try (DataOutputStream dos=new DataOutputStream(new FileOutputStream(App1.ROOT+"dataTypes.dat")))//확장자는 크게 상관이 없다
        {
            dos.writeInt(100);
            dos.writeChar('k');
            dos.writeDouble(123.45);
            dos.writeUTF("helloworld");


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        //같은 파일에 대해서는 위에꺼 끝나고 다시 시작한다
        try (DataInputStream dis=new DataInputStream(new FileInputStream(App1.ROOT+"dataTypes.dat"))){
            //쓰기 순서대로 자료형 별로 읽어와야 한다
            //
            int n=dis.readInt();
            char ch= dis.readChar();
            double n1= dis.readDouble();
            String str=dis.readUTF();
            System.out.println(n +", "+ch+", "+n1+", "+str);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
