package com.sh.io._02.stream;

import java.io.File;
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
            fr = new FileReader(App.ROOT + "helloworld.txt");

//            int data = fr.read();
//            System.out.println(data + " " + (char)data); // 한글자 읽기

//            int data = 0;
//            while((data = fr.read()) != -1) {
//                System.out.println(data + " " + (char) data);
//            }
            int len = (int) new File(App.ROOT, "helloworld.txt").length(); // byte수
            char[] chars = new char[len];
//            fr.read(chars);
//            for(char ch : chars) {
//                System.out.println(ch); // 한글을 읽을 시 뒤에 공백 문자가 같이 출력됨
//            }
            int hasReadLen = fr.read(chars); // 읽어들인 글자수
            for(int i=0; i<hasReadLen; i++) {
                System.out.println(chars[i]); // 한글 뒤 공백 문자 없어짐
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null)
                    fr.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
