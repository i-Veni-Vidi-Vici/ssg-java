package com.sh.api._05.datetime.legacy;

import java.util.Date;

/**
 * <pre>
 * java.util.Date
 * - jdk1.0부터 날짜/시간을 관리하기 클래스
 * - 생성자/메소드 대부분이 deprecated 처리되었음.
 * - 기본 생성자, long필드 생성자(unix time) 두개만 사용가능.
 *
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        // Date 객체 생성
        Date now = new Date(); // java.util.Date
        System.out.println(now); //Wed Mar 27 10:34:40 KST 2024
        System.out.println(System.currentTimeMillis());

        for(int i = 0; i < 10000000; i++);

        // long 값으로 Date 객체 생성
        // Unix(Epoch) Time: 1970.1.1 자정 기준으로 누적된 밀리초를 인자로 받는다.
        long millis = System.currentTimeMillis();
        System.out.println(millis);
        Date now2 = new Date(millis);
        System.out.println(now2);

        Date sometime  = new Date(1011503857545L);
        System.out.println(sometime);

        // Date#getTime();long
        System.out.println("now : " + now.getTime());
        System.out.println("now2 : " + now2.getTime());


    }
}
