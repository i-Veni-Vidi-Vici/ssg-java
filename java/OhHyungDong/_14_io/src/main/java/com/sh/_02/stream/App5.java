package com.sh._02.stream;

import java.io.*;

/**
 * 1. copyme.txt 파일을 읽어서 콘솔에 출력
 * 2. 프로젝트 루트에 pasted.txt파일로 출력하세요
 */
public class App5 {
    public static final String ROOT1= "OhHyungDong/_14_io/";
    public static final String ROOT = "/Users/ohyeongdong/Desktop/";
    public static void main(String[] args) {

        try(FileReader fr = new FileReader(ROOT + "copyme.txt");
            FileWriter fw = new FileWriter(App.ROOT + "pasted.txt")
        ){
            int data;
            while ((data = fr.read()) != -1){
                    System.out.print((char) data);
                    fw.write(data);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
