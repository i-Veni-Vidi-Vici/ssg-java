package com.sh._04.checked;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 입출력 프로그램에서 CheckedException제어하기
 * - RuntimeException의 후손이 아님!
 */
public class App4 {
    public static void main(String[] args) {
        // helloworld.txt 파일을 읽어오기
        // 입출력클래스의 사용이 끝나면 close를 호출해서 반드시!! 메모리를 반환해야 한다.
        FileReader fr = null;
        try {
            // new FileReader() throws FileNotFoundException
            fr = new FileReader("JeongYejin/_13_exception_handling/helloworld.txt");
            System.out.println("파일을 찾았습니다.");

            // 읽기
            int data = fr.read(); // 예외처리를 강제화
            System.out.println(data);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) { // FileNotFoundException의 부모 클래스
            e.printStackTrace();
        } finally {
            // try..catch 마지막에 한번만 작성할 수 있다.
            // 예외발생 유무와 상관없이 무조건 실행
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