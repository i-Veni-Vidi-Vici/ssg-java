package com.sh.io._02.stream;

import java.io.*;

/**
 * copyme.txt 파일을 읽어서 콘솔에 출력합니다.
 * 프로젝트루트에 pasted.txt파일로 출력하세요
 */
public class App5 {

    public static void main(String[] args) {

        try(
                FileReader fr = new FileReader("C:/Park-Taejun/copyme.txt");
                FileWriter fw = new FileWriter(App.ROOT + "pasted.txt");
        ){
             int data = 0;
            while ((data=fr.read()) != -1){
                // 데이터를 콘솔에 출력
                System.out.println((char) data);
                // 데이터를 파일에 출력
                fw.write(data);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
