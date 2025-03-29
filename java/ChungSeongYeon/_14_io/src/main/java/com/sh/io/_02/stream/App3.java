package com.sh.io._02.stream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <pre>
 * byte 단위 파일 쓰기 스트림
 * - 출력스트림클래스의 생성자 두번째 인자는 이어쓰기 여부이다.
 * - false(기본값) 생략 시 false. 매번 새로 씀.
 * - true 기존 내용의 끝에 새로운 내용 추가.
 * </pre>
 */

public class App3 {
    public static void main(String[] args) {
        // try..with..resource 절 : jdk1.7에 추가. ()안에 선언된 스트림객체를 자동으로 반환
        try(FileOutputStream fos = new FileOutputStream(App.ROOT + "byeworld.txt", true)) {
//            fos.write(97);
            byte[] bytes = new byte[]{97, 98, 99, 100, 101};
            fos.write(bytes);
        }catch (IOException e){
            e.printStackTrace();

        }

    }
}
