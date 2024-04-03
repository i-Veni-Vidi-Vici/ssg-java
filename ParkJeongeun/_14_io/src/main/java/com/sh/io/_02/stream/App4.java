package com.sh.io._02.stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 글자 단위 출력스트림 FileWriter
 * - char, String 타입의 데이터를 직접 쓰기 가능
 */
public class App4 {
    public static void main(String[] args) {

        try(FileWriter fw = new FileWriter(App.ROOT + "byeworld.txt")){
            fw.write("안녕\n");
            fw.write("ㅋㅋ\n");
            fw.write(new char[]{'a', 'p', 'p', 'l', 'e'});

        }catch (IOException e){
            // catch절은 비워두면 안됨 (예외로그 출력, 다시 예외 던지기 등 작성)
            e.printStackTrace();
        }
    }
}
