package com.sh.io._02.stream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * byte 단위 파일 쓰기 스트림
 * -출력스트림클래스의 생성자 두번째인자는 이어쓰기 여부이다.
 * -false(기본값) 생략하면 false이다. 매번 새로 쓴다.
 * -true 기존 내용의 끝에 새로운 내용을 추가한다.
 */
public class App3 {
    public static void main(String[] args) {
        // try..with.. resource절 : jdk 1.7에 추가 () 안에 선언된 스트림객체를 자동으로 반환해준더,
        try (FileOutputStream fos = new FileOutputStream(App.ROOT + "byeworld.txt", true)) { // true 하면 기존 내용안지우고 추가함
//            fos.write(97);
            byte[] bytes = new byte[]{97, 98, 99, 100, 101};
            fos.write(bytes);

        } catch (IOException e){
            e.printStackTrace();

        }


    }
}
