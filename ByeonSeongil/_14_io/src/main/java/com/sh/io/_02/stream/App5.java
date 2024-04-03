package com.sh.io._02.stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 * 1. copyme.txt 파일을 읽어서 콘솔에 출력하세요.
 * 2. 프로젝트루트에 pasted.txt파일로 쓰기하세요.
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("C:\\Users\\TECH5-24\\copyme.txt");
             FileWriter fw = new FileWriter(App.ROOT+"pasted.txt");
        ) {
            char[] value = new char[(int) new File("C:\\Users\\TECH5-24\\copyme.txt").length()];
            fr.read(value);
            System.out.println(value);
            fw.write(value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
