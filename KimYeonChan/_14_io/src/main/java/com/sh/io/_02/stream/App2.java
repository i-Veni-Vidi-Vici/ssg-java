package com.sh.io._02.stream;

import com.sh.io._01.file.App;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * <pre>
 *     문자단위 입력 스트림 FileReader
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader(App.ROOT + "helloworld.txt");

//            int data = 0;
//            while ((data = fr.read()) != -1) {
//                System.out.println(data + " " + (char) data);
//            }

            int len = (int) new File(App.ROOT, "helloworld.txt").length();
            char[] chars = new char[len];
            int readLen = fr.read(chars);
            for (int i = 0; i < readLen; i++) {
                System.out.println(chars[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
