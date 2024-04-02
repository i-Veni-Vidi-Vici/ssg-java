package com.sh._04.checked;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * <pre>
 * 입출력 프로그램에서 CheckedException제어하기
 * checked, unchecked = 예외화를 강제로 한다
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        //helloworld.txt 파일을 읽어오기
        //입출력클래스의 사용이 끝나면 close를 호출해서 메모리를 반환해야 한다.
        FileReader fr=null;
        try
        {
            //new FileReader() throws FileNotFoundException
            fr = new FileReader("ChoiChanguk/_13_exception_handling/helloworld.txt");
            System.out.println("파일을 찾았습니다");

            //읽기
            int date = fr.read();
            System.out.println(date);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally
        {
            //try..catch 마지막에 한 번만 작성. 예외발생 유무와 상관없이 무조건 실행
            //자원 반납
            try
            {
                fr.close();
                System.out.println("파일이 종료되었습니다");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("프로그램 정상 종료");
    }
}
