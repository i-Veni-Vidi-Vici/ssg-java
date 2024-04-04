package com.sh.io._02.stream;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;


// 이거 다시 파일 보기
/**
 * <pre>
 * 문자단위 입력스트림 FileReader
 * </pre>
 *
 */
public class App2 {
    public static void main(String[] args) {

        FileReader fr = null;
        try {
            fr = new FileReader(App.ROOT + "helloworld.txt");

//            int data = fr.read(); // read면 IOException 예외
//            System.out.println(data + " " + (char) data); //

//            int data = 0;
//            // 다읽으면 -1
//            // 이렇게 하면 한글 안 깨짐
//            while (((data = fr.read()) != -1)) {
//                System.out.println(data + " " + (char) data);
//            }


            int len =(int) new File(App.ROOT,"helloworld.txt").length(); // byte수
            char[] chars = new char[len]; // 이걸 가지고 char배열 만들면 한글2byte라서 안맞음.....
            int hasReadLen = fr.read(chars); // 읽어들인 글자수 반환
            for (int i = 0; i < hasReadLen; i++) {
                System.out.println(chars[i]);
            }
//            for (int i = 0; i < chars.length; i++) {
//                System.out.println(chars);
//            }
//            byte[] bytes = new byte[len];

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 무조건 !! 자원반납
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
