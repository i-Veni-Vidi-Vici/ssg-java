package com.sh.io._02.stream;

import jdk.jfr.Frequency;

import java.io.*;

/**
 * <pre>
 * 문자단위 입력스트림 FileReader
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        FileReader fr = null;
        try
        {
            fr = new FileReader(App1.ROOT + "helloworld.txt");

//            int data= fr.read();
//            System.out.println(data+" "+(char)data);

//            int data=0; //한글 안깨진다
//            while ((data=fr.read())!=-1)
//            {
//                System.out.println(data+" "+(char)data);
//            }

            int len = (int)new File(App1.ROOT, "helloworld.txt").length();// byte
            char[] chars=new char[len];
            int hasReadLen=fr.read(chars);//읽어들인 글자수 //한글은 2바이트이기 때문에 int로 바꾸면 개수로 바뀌어서 뒤에 이상한 글짜가 나온다
            for(char ch:chars)
                System.out.println(ch);


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (fr != null)
                    fr.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
