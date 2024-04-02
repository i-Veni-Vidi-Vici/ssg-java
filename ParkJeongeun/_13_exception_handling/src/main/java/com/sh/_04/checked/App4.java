package com.sh._04.checked;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * <pre>
 * 입출력 프로그램에서 CheckedException 제어하기
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        // helloworld.txt 파일 읽어오기
        // 입출력클래스의 사용이 끝나면 close를 호출해서 메모리 반환해야 함

        FileReader fr = null; // try와 finally에 둘다 쓰려면 밖에 선언해야함
        try {
            // new FileReader() throws FileNotFoundException
            fr = new FileReader("ParkJeongeun/_13_exception_handling/helloworld.txt");
            System.out.println("파일 찾았음");

            // 읽기
            int data = fr.read(); // read도 IOException 필요
            System.out.println(data); // 97 (helloworld.txt 의 첫글자가 a여서)

            // 자원반납
            // 이자리에 쓰면 int data = fr.read();에서 예외발생했을때 건너띄고 catch문으로 이동해서 실행안됨

        } catch (IOException e){ // FileNotFoundException e 의 부모 Exception으로 다형성
            e.printStackTrace();
        } finally {
            // 자원반납 : try-catch 마지막에 한번만 작성, 예외발생유무와 상관없이 무조건 실행됨
            try {
                fr.close(); // close도 IOException 필요
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("프로그램 정상 종료");
    }
}
