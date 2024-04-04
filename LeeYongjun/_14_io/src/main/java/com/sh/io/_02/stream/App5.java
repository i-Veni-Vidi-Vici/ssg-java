package com.sh.io._02.stream;

import java.io.*;

/**
 * <pre>
 * 1. copyme.txt 파일을 읽어서 콘솔에 출력하세요.
 * 2. 프로젝트루트에 pasted.txt파일로 출력하세요.
 * </pre>
 */
public class App5 {
    public static final String Root = "C:/Users/TECH5-12/";
    public static void main(String[] args) {
        try(FileReader fr = new FileReader(App5.Root + "copyme.txt");
        FileWriter fw = new FileWriter(App.Root + "pasted.txt");){
            int data = 0;
            while ((data = fr.read()) != -1){
                // 데이터를 콘솔에 출력
                System.out.println(data + " " + (char)data);
                // 데이터를 파일에 출력
                fw.write(data);

            }
//            int len = (int)new File(App5.Root,"copyme.txt").length();
//            String[] strings = new String[len];
//            fr.read(strings);
//            for(String str : strings){
//                System.out.println(str);
//            }

        }
        catch (IOException e){
         e.printStackTrace();
        }
    }
}
