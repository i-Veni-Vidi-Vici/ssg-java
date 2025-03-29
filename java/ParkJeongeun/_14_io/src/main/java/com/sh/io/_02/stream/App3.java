package com.sh.io._02.stream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * byte단위 파일 쓰기 스트림
 * - 출력스트림 클래스의 생성자 두번째 인자는 이어쓰기 여부 의미
 * - false(기본값) 생략하면 false. -> 매번 새로 씀
 * - true 기존 내용을 계속 추가
 */
public class App3 {
    public static void main(String[] args) {
        // try..with..resource절 : jdk1.7에 추가, ()안에 선언된 n개의 스트림객체를 자동으로 반환해줌 (finally 안써도 됨)
        try(FileOutputStream fos = new FileOutputStream(App.ROOT + "byeworld.txt", true)){
//            fos.write(97); // byeworld.txt 파일 만들어지고 안에 a 써있음

            byte[] bytes = new byte[] {97, 98, 99, 100, 101};
            fos.write(bytes); // abcde 써있음

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
