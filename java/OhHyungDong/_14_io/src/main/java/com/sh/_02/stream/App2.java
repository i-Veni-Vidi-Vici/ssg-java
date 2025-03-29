package com.sh._02.stream;

import java.io.*;

/**
 * <pre>
 *  문자 단위 입력스트림 FileReader
 * </pre>
 */
public class App2 {

    public static void main(String[] args) {
        FileInputStream fis = null;
        FileReader fr = null;
        try {
//            fis = new FileInputStream(App.ROOT + "helloworld.txt");
            fr = new FileReader(App.ROOT + "helloworld.txt");
            //한글자만 읽는 것
//            int data = fr.read();
//            System.out.println(data + " " +(char) data);

            //모든 문자열을 while문을 통해서 읽는 것
//            int data = 0;
//            while((data = fr.read()) != -1){
//                System.out.println(data + " " +(char) data);
//            }
            //한방에 읽기
            int len = (int)new File(App.ROOT,"hellowolrd.txt").length(); //byte 수
            char[] chars = new char[len];
            int hasReadlen = fr.read(chars);
            for(int i = 0; i<hasReadlen; i++){
                System.out.println(chars[i] + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fr != null) fr.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
