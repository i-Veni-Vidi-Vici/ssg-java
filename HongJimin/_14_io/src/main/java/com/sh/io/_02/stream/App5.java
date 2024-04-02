package com.sh.io._02.stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 *     1. copyme.txt 파일을 읽어서 콘솔에 출력하세요.
 *     2. 프로젝트 루트에 pasted.txt 파일로 출력하세요.
 *
 *     "C:\Users\TECH5-05\copyme.txt"
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {

        try (
                FileReader fr = new FileReader("C:\\Users\\TECH5-05\\copyme.txt");
                FileWriter fw = new FileWriter(App.ROOT+ "pasted.txt");) {
            int data = 0;
            while ((data = fr.read()) != -1) {
                //읽은 데이터를 콘솔에 출력
                System.out.print((char) data);

                //데이터를 파일에 출력
                fw.write(data);
            }
            fr.read();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
