package com.sh.io._02.stream;

import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 * 글자 단위 출력 스트림 FileWriter
 * - char, String 타입의 데이터를 직접쓰기 가능
 *
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        try (FileWriter fw=new FileWriter(App1.ROOT+"byworld.txt")){

            fw.write("안녕하세요");
            fw.write("\n화요일입니다");
            fw.write(new char[]{'a','b','e','h'});
        } catch (IOException e) {
            //여기에 아무것도 없이 비워두면 처맞는다
            //catch절안에서는 예외로그를 출력 or 다시 예외를 던지건 해야한다 = 절대 비워두면 안된다
            e.printStackTrace();
        }
    }
}
