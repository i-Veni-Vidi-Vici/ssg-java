package com.sh.io._02.Stream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <pre>
 * byte단위 파일 쓰기 스트림
 *  - 출력스트림클래스의 생성자 두 번째 인자는 이어쓰기 여부이다.
 *  - false(기본값) 생략하면 false이다. 매번 새로 쓴다.
 *  - true는 기존내용의 끝에 새로운 내용을 추가한다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        // try..with..resource절 : jdk1.7에 추가. ()안에 선언된 n개의 스트림객체를 자동으로 반환해준다.
        try(FileOutputStream fos = new FileOutputStream(App.ROOT + "byeworld.txt", true)){
//            fos.write(97);
            byte[] bytes = new byte[] {97, 98, 99, 100, 101};
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
