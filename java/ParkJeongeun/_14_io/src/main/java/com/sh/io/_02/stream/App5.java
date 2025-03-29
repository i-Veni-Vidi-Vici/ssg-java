package com.sh.io._02.stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 1. 외부 폴더에서 만든 copyme.txt 파일을 읽어서 콘솔에 출력하기
 * 2. 1에서 읽어온 파일을 프로젝트루트에 pasted.txt 파일로 출력하기
 */
public class App5 {
    public static void main(String[] args) {
        // try괄호 안에는 "선언"해야 함, 밖에 선언하고 안에서 변수 쓰면 오류, 괄호없이 바로 try{}에는 가능
        try(
            FileReader fr = new FileReader("C:\\Users\\i\\Desktop\\copyme.txt");
            FileWriter fw = new FileWriter(App.ROOT + "pasted.txt")){

            int len = (int) new File("C:\\Users\\i\\Desktop\\copyme.txt").length();
            char[] chars = new char[len];
            fr.read(chars);
            for (char ch : chars){
                // 데이터를 콘솔에 출력
                System.out.println(ch);
            }
            // 데이터를 파일에 출력
            fw.write(chars);
        } catch (IOException e){
            e.printStackTrace();
        }

        // 나(2.)_안됨,,
//        try(FileWriter fw = new FileWriter(App.ROOT + "pasted.txt")){
//            FileReader fr = new FileReader("C:\\Users\\i\\Desktop\\copyme.txt");
//            int len = (int) new File("C:\\Users\\i\\Desktop\\copyme.txt").length();
//            char[] chars = new char[len];
//            for (char ch : chars){
//                fw.write(ch);
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }
}
