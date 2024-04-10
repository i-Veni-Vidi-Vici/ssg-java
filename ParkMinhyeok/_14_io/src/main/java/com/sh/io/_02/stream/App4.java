package com.sh.io._02.stream;

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

        try (FileWriter fw = new FileWriter(App.ROOT + "byeworld.txt");) {
            fw.write("안녕\n");
            fw.write("ㅋㅋㅋ\n");
            fw.write(new char[]{'a', 'p', 'p', 'l', 'e'});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
