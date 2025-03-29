package com.sh.io._02.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//
///**
// * <pre>
//// *문자단위 입력스트림 FileReader
// * </pre>
// */
//public class App2 {
//    public static void main(String[] args) {
//        FileReader fr = null;
//        try {
//             fr = new FileReader(App.ROOT + "helloworld.txt");
//
////             int data = fr.read();
////            System.out.println(data + " " + (char) data);

//            int data = 0;
//            while ((data = fr.read()) != -1){
//                System.out.println(data + " " + (char)data);
//            }
//
//            int len = (int)new File (App.ROOT, "helloworld.txt").length(); // byte 수
//            char[] chars = new char[len];
//            int hasReadLen = fr.read(chars); //읽어들인 글자수
//            for (int i = 0; hasReadLen <){
//                System.out.println(chars[i]);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if(fr != null) fr.close(); //만들면 무조건 반납
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//
//
//    }
//}
