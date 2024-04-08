package com.sh.io._02.stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 * 1. copyme.txt 파일을 읽어서 콘솔에 출력하세요.
 * 2. 프로젝트루트에 pasted.txt파일로 출력하세요.
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        // 내 코드
//        FileReader fr = null;
//        FileWriter fw = null;
//        try{
//            fr = new FileReader("C:\\Users\\TECH5-13\\copyme.txt");
//            fw = new FileWriter(App.ROOT + "pasted.txt", true);
//
//            int data = 0;
//            while((data = fr.read()) != -1) {
//                System.out.print((char) data);
//                fw.write((char) data);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if(fr != null)
//                    fr.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if(fw != null)
//                    fw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        // 강사님 코드
        try(
            FileReader fr = new FileReader("C:/Users/TECH5-13/copyme.txt");
            FileWriter fw = new FileWriter(App.ROOT + "pasted.txt");
        ) {
            int data = 0;
            while((data = fr.read()) != -1) {
                // 데이터를 콘솔에 출력
                System.out.print((char) data);
                // 데이터를 파일에 출력
                fw.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
