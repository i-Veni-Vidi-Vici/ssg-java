package com.sh.api._05.datetime.legacy;

import java.util.Date;

/**
 * <pre>
 * java.util.Date
 * - jdk1.0부터 날짜/시간을 관리하기 위한 클래스
 * - 생성자/메소드 대부분이 deprecated처리되었음.
 * - 기본 생성자, long필드 생성자(unix time) 두개만 사용가능하다.
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // Date객체 생성
        Date now = new Date(); // java.util.Date
        System.out.println(now); // Wed Mar 27 10:34:26 KST 2024
        System.out.println(now.getTime());

        for(int i=0; i<10000000; i++); // 위에서 아래로 실행되는 동안 밀리초가 아주 잠깐 흐름

        // long값으로 Date객체 생성
        // Unix(Epoch) Time: 1970년 1월 1일 자정기준으로 누적된 밀리초
        long millis = System.currentTimeMillis();
        System.out.println(millis);
        Date now2 = new Date(millis);
        System.out.println(now2); // Wed Mar 27 10:34:26 KST 2024

        Date sometime = new Date(1011631186649L);
        System.out.println(sometime); // Tue Jan 22 01:39:46 KST 2002

        // Date#getTime():long
        System.out.println("now : " + now.getTime());
        System.out.println("now2 : " + now2.getTime());
    }
}
