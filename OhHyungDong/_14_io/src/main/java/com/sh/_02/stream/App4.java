package com.sh._02.stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 글자 단위 출력 스트림 : FileWriter
 * - char, String타입의 데이터를 직접 쓰기 가능
 */
public class App4 {
    public static void main(String[] args) {
        try(FileWriter fw = new FileWriter(App.ROOT + "byeworld.txt")){
            //개행 기능 없음, 개행기능이 없ㄷ어서 나중에 직접 추가해야함.
            fw.write("안녕\n");
            fw.write("ㅋㅋㅋㅋㅋㅋㅋㅋㅋ");

        }catch(IOException e){
            // catch절 안에서는 예외로그를 출력하던, 다시 예외를 던지건 절대 비워둬서는 안됨.
            e.printStackTrace();
        }

    }
}
