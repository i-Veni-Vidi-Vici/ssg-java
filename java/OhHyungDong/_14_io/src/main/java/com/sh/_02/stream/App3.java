package com.sh._02.stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <pre>
 *  byte단위 파일 쓰기 스트림
 *  - 출력스트림 클래스의 생성자 두번째 인자는 이어쓰기 여부이다.
 *  - false(기본값) 생략은 false이다. false이면 이어쓰지 않고 매번 새로쓴다
 *  - true 기조 내용의 끝에 새로운 내용을 추가한다.
 *
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        //try..with..resource절 : jdk 1.7에 추가. ()안에 선언된 n개의 스트림 객체를 자동으로 반환해준다.

        //apend : false 기본값 true로 변경하면 -> 이어쓰도록 도와줌
        try(FileOutputStream fos = new FileOutputStream(App.ROOT + "byeworld.txt",true))
        {
//            fos.write(97);
            byte[] bytes = new byte[]{97, 98, 99, 100};
            fos.write(bytes);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
