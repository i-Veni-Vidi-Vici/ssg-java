package com.sh._04.checked;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 입출력 프로그램에서 CheckedException 제어하기
 * -
 */
public class App4 {
    public static void main(String[] args) {
        // helloworld.txt 파일을 읽어오기
        // 입출력 클래스의 사용이 끝나면 close를 호출해서 ✨반드시✨ 메모리를 반환해야 함!
        //
        FileReader fr = null;
        try {
            //new FileReader () throws FileNotFoundException
            fr = new FileReader("Hongjimin/_13_exception_handling/helloworld.txt");
            System.out.println("파일을 찾았습니다.");

            //읽기
            int data = fr.read();
            System.out.println(data);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //try..catch 마지막에 한번만 작성하는 구문, 예외 발생 유무와 상관없이 무조건 실행!
            //자원 반납
            try {
                fr.close(); //위에서 exception발생하면 하위의 코드는 실행하지 않기 때문에 실행이 안되지만,
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("프로그램 정상 종료!");
    }
}
