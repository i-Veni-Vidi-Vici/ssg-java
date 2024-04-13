package com.sh.io._02.stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 * 1. copyme.txt 파일을 읽어서 콘솔에 출력
 * 2. 프로젝트루트에 pasted.txt 파일로 출력
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("/Users/minja/workspace/inc/" + "copyme.txt");
             FileWriter fw = new FileWriter("/Users/minja/workspace/inc/" + "pasted.txt");
        ) {
//            int len = (int) new File("/Users/minja/workspace/inc/" + "copyme.txt").length();
//            char[] chars = new char[len];
            int data = 0;
            while ((data = fr.read()) != -1) {
                System.out.println((char) data);
                fw.write(data);
            }
//            fr.read(chars);
//            int hasReadLen = fr.read(chars);

//            for (char ch : chars) {
//                System.out.println(ch);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
