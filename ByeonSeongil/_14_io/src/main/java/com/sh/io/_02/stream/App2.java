package com.sh.io._02.stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * <pre>
 * 문자단위 입력스트림 FileReader
 * </pre>
 */
public class App2 {
    public static final String ROOT = "ByeonSeongil/_14_io/";

    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader(App.ROOT + "helloworld.txt");


//            int data = fr.read();
//            System.out.println(data +" "+ (char)data);

//            int data = 0;
//            while ((data = fr.read()) != -1) {
//                System.out.println(data + " "+ (char)data);
//            }

            int len = (int) new File(ROOT, "helloworld.txt").length();
            char[] value = new char[len];
            int hasReadLen = fr.read(value);
            for (int i = 0; i < hasReadLen; i++) {
                System.out.println(value[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
