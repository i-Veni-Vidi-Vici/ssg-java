package com.sh.io._02.stream;

import java.io.FileWriter;
import java.io.IOException;

/**
 * <pre>
 *     글자 단위 출력 스트림 FileWriter
 *     - char, String 타입의 데이터를 직접 쓰기 가능
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter(App.ROOT + "byeworld.txt");){
               fw.write("안녕"); //개행 기능이 없어서 옆으로 주르륵 출력됨
               fw.write("ㅋㅋㅋ");
            fw.write(new char[]{'a', 'p', 'p', 'l', 'e'});

        } catch (IOException e) {
            e.printStackTrace(); //예외 로그를 출력하던, 다시 예외를 던지건 ✨catch절을 절대 비워두면 안됨!!✨
        }

    }
}
