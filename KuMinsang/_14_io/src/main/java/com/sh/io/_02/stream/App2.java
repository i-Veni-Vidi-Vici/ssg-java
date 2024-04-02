package com.sh.io._02.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * <pre>
 *     문자단위 입력 스트림 FileReader
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader(App.ROOT + "helloworld.txt");

//            int data = fr.read();
//            System.out.println(data + " " + (char) data);
//            int data = 0;
//            while((data = fr.read()) != -1){
//                System.out.println(data + " " + (char) data);
//            }

            int len = (int) new File(App.ROOT, "helloworld.txt").length();
            char[] chars = new char[len];
            int hasReadLen = fr.read(chars);    //쓰레기값 출력방지
            for(char ch : chars){
                System.out.println(ch);
            }
            for(int i = 0 ; i<chars.length; i++){
                System.out.println(chars[i]);
            }

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
