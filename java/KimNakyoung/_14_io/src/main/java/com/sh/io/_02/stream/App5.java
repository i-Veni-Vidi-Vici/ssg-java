package com.sh.io._02.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 * 1. copyme.txt 파일을 읽어서 콘솔에 출력하세요.
 * 2. 프로젝트루트에 pasted.txt파일로 출력하세요.
 *
 * "C:\Users\TECH5-30\copyme.txt"
 * </pre>
 */

// stream 한번에 한 대상 읽기

// ctrl + c ctrl + v 한거임
public class App5 {
    public static void main(String[] args) {
        try (
                FileReader fr = new FileReader("C:/Users/i/copyme.txt");
                FileWriter fw = new FileWriter(App.ROOT + "pasted.txt");
                //입출력/.....
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

    // 레거시 파일 st
    public void test() {
        FileReader fr= null;
        FileWriter fw = null;
        try {
            fr = new FileReader("읽어올 파일");
            fw = new FileWriter("쓸 파일");
            // 입출력 ....

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }


}
