package com.sh.io._02.stream;


import java.io.FileWriter;
import java.io.IOException;

/**
 * 글자 단위 출력스트림 FileWriter
 * - char, String타입의 데이터를 직접쓰기 가능
 *
 */
public class App4 {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter(App.ROOT + "byeworld.txt")) {
            fw.write("안녕\n"); // 개행기능 없어요
            fw.write("aaaz\n");
            fw.write(new char[]{'a','p','p'}); // 문자열임
        } catch (IOException e) {
            // 캐치절 비워두지말어!!!!!!!!!!!!!
            // catch절 안에서는 예외로그르 출력하던, 다시 예외를 던지던 절대 비워둬서는 안된다.
            // 여기서 로그 안찍혀있으면 디버깅할 때 못찾음... 필수임!!
            e.printStackTrace();
        }


    }
}
