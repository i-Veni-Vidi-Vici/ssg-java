package com.sh.io._02.stream;

import java.io.*;

import static com.sh.io._02.stream.App.ROOT;

/**
 * <pre>
 * 1. copyme.txt 파일을 읽어서 콘솔에 출력하세요.
 * 2. 프로젝트루트에 pasted.txt파일로 출력하세요.
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
//        FileReader fr= null;
//        FileWriter fw = null;
//        try {
//            fr = new FileReader("C:/Users/TECH5-15/copyme.txt");
//            int len = (int) new File("C:/Users/TECH5-15/copyme.txt").length();
//            char[] chars = new char[len];
//            int hasReadLen = fr.read(chars);
//            fw = new FileWriter(ROOT + "/pasted.txt");
//            for (int i = 0; i < hasReadLen; i++) {
//                System.out.print(chars[i]);
//                fw.write(chars[i]);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (fr != null)
//                    fr.close();
//                // 만약 여기서 오류가 발생하면 fw도 실행되지 않는다.
//            } catch(IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                if (fw != null)
//                    fw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        Second();
    }

    public static void Second() {
        try (
            FileReader fr = new FileReader("C:/Users/TECH5-15/copyme.txt");
            FileWriter fw = new FileWriter(ROOT + "/pasted.txt");
        ) {
            int len = (int) new File("C:/Users/TECH5-15/copyme.txt").length();
            char[] chars = new char[len];
            int hasReadLen = fr.read(chars);
            for (int i = 0; i < hasReadLen; i++) {
                System.out.print(chars[i]);
                fw.write(chars[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } // fr.close() fw.close() 할 필요없음! 블럭이 끝남과 동시에 닫힘!
    }
}