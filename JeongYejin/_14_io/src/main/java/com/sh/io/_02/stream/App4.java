package com.sh.io._02.stream;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 * 글자 단위 출력스트림 FileWriter
 * - char, String 타입의 데이터를 직접쓰기 가능
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter(App.ROOT + "byeworld.txt")) {
            fw.write("안녕\n"); // char배열, 문자열
            fw.write("ㅋㅋㅋ"); // 개행기능이 없기 때문에 직접 개행문자를 추가해주어야 한다.
            fw.write(new char[]{'a', 'p', 'p', 'l', 'e'});
        } catch (IOException e) {
            // 비워놓지 마세요❗❗❗❗❗❗
            // catch절 안에서는 예외로그를 출력하든, 다시 예외를 던지든 절대 비워둬서는 안된다.
            // 디버깅할 때 큰 단서를 제공하기 때문에 오류 파악을 위해 반드시! 작성한다.
            e.printStackTrace();
        }
    }
}
