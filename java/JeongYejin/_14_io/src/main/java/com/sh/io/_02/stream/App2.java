package com.sh.io._02.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static com.sh.io._02.stream.App.ROOT;

/**
 * <pre>
 * 문자단위 입력스트림 FileReader
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader(ROOT + "helloworld.txt");

            int data = 0;
            while ((data = fr.read()) != -1) {
                System.out.println(data + " " + (char) data);
            };

            int len = (int) new File(ROOT, "helloworld.txt").length();
            char[] chars = new char[len];
//            System.out.println(data + " " + (char) data);
            fr.read(chars);
            for (char ch : chars) {
                System.out.println(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
