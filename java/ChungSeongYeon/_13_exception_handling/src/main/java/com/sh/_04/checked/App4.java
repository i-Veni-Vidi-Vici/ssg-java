package com.sh._04.checked;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 입출력 프로그램에서 CheckedException제어하기
 */
public class App4 {
    public static void main(String[] args) {
        // helloworld.txt 파일을 읽어오기
        // 입출력클래스의 사용이 끝나면 close를 호출해서 메모리를 반환해야 한다.

        FileReader fr = null;

        try {
            // new FileReader() throws FileNotFoundException
            fr = new FileReader("ChungSeongYeon/_13_exception_handling/helloworld.txt");
            System.out.println("파일을 찾았습니다.");

            // 읽기
            int data = fr.read();
            System.out.println(data);

        }catch (IOException e) {
            e.printStackTrace();

        } finally { // 위의 try..catch와 엄연히 다른 공간이라서 이 안에서 다시 try catch
            // try..catch 마지막에 한번만 작성. 예외발생 유무와 상관없이 무조건 실행됨.
            // 자원반납 => try에 쓰면 안된다. 예외 발생 시 건너뛰기 때문에

            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("프로그램 정상 종료!");
    }
}
