package com.sh.io._02.stream;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 글자 단위 출력스트림 FileWriter
 * - char, String 타입의 데이터를 직접쓰기 가능
 */

public class App4 {
    public static void main(String[] args) {


        try
                (FileWriter  fw = new FileWriter(App.ROOT + "byeworld.txt"))
        {
             fw.write("안녕!!");
             fw.write("ㅋㅋㅋ!!");
             fw.write(new char[]{'a'});
        } catch (IOException e) {
           // catch절안에서는 예외로그를 출력하던, 다시 예외를 던지건 절대 비워둬서는 안된다. 곤장맞을일!!
            e.printStackTrace();
            //필요에 따라 throw new 던질 수
        }

    }
}
