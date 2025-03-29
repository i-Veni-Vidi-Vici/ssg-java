package com.sh._04.checked;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 입출력 프로그램에서 CheckedException 제어하기
 *
 */
public class App4 {
    public static void main(String[] args) {
        FileReader fr = null;
        // helloworld.txt 파일을 읽어오기
        // 입출력 클래스의 사용이 끝나면 close를 호출해서 반드시 메모리를 반환해야 한다.
        try{
            fr = new FileReader("ShinYoonjeong/_13_exception_handling/helloworld.txt");
            System.out.println("파일은 찾았습니다.");
            // 읽기
            int data = fr.read();
            System.out.println(data);

        }catch (FileNotFoundException e){
            e.printStackTrace();

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // try..catch 마지막에 한번만 작성. 예외 발생 유무와 상관 없이 무조건 실행
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
