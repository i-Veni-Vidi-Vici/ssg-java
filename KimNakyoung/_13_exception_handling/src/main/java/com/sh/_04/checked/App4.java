package com.sh._04.checked;

import java.io.FileReader;
import java.io.IOException;

/**
 * 입출력 프로그램에서 CheckedException제어하기
 *
 */


public class App4 {
    public static void main(String[] args) {
        // helloworld.txt 파일을 읽어오기

        FileReader fr = null;

        try {
            // new FileReader() throws fileNotFoundException
            fr = new FileReader("KimNakyoung/_13_exception_handling/helloworld.txt");
            System.out.println("파일 찾음");

            //읽기

            int data = fr.read();
            System.out.println(data);



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // try..catch 마지막에 한번만 작성 . 예외발생유무와 상관없이 무조건 실행
            // 자원반납
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("프로그램 정상 종료!");

    }
}
