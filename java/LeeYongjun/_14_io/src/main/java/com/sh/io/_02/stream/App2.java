package com.sh.io._02.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * <pre>
 * 문자단위 입력스트림 FileReader
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader(App.Root + "helloworld.txt");
//            int data = fr.read();
//            System.out.println(data + " " + (char)data);
//            int data = 0;
//            while ((data = fr.read()) != -1){
//                System.out.println(data + " " + (char)data);
//            }
            int len = (int)new File(App.Root,"helloworld.txt").length();
            char[] chars = new char[len];
            int hasReadLen = fr.read(chars);
            for(char ch : chars){
                System.out.println(ch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 자원반납
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
