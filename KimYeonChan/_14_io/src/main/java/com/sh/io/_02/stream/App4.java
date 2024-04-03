package com.sh.io._02.stream;

import com.sh.io._01.file.App;

import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 *     글자 단위 츨력스트림 FileWriter
 *      - char, String 타입의 데이터를 직접 쓰기 가능
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter(App.ROOT + "byeworld.txt")) {
            fw.write("안녕");
            fw.write("ㅋㅋㅋ");
            fw.write(new char[] {'a', 'b', 'c', 'd', 'e', });
        } catch (IOException e) {
            // catch 절안에서 예외로그를 출력하던, 다시 예외를 던지건 절대 비워둬서는 안된다.
            e.printStackTrace();
        }
    }
}
