package com.sh.io._02.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <pre>
 *     byte단위 파일 쓰기 스트림
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        //try..with..resource절 : jdk1.7에 추가. ()안에 *선언*된 스트림 객체를 자동으로 close 해줌
        try(FileOutputStream fos = new FileOutputStream(App.ROOT + "byeworld.txt", true)){
            //FileOutputStream(첫번째 인자는 경로, 두번째 인자는 append이다 생략하면 기본으로 false이며 true 하면 이어쓴다
            fos.write(97);
            byte[] bytes = new byte[] {97 , 98, 99, 100 , 101};
            fos.write(bytes);

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
