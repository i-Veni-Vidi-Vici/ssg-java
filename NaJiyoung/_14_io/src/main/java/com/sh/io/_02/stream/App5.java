package com.sh.io._02.stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 * 1. copyme.txt 파일을 읽어서 콘솔에 출력하세요.
 * 2. 프로젝트루트에 pasted.txt파일로 출력하세요.
 *
 * "C:\Users\jyna1\copyme.txt"
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        try(
                FileReader fr = new FileReader("C:/Users/jyna1/copyme.txt");
                FileWriter fw = new FileWriter(App.ROOT + "pasted.txt");
        ) {
            int data = 0;
            while((data = fr.read()) != -1) {
                // 데이터를 콘솔에 출력
                System.out.print((char) data);
                // 데이터를 파일에 출력
                fw.write(data);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void test() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("읽어올 파일");
            fw = new FileWriter("쓸 파일");
            // 입출력 .....

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
