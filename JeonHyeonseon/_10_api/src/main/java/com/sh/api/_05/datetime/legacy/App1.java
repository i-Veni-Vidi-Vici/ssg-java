package com.sh.api._05.datetime.legacy;

import java.util.Date;

/**
 * <pre>
 * java.util.Date
 *  - jdk1.0부터 날짜/시간을 관리하기 위한 클래스
 *  - 생성자/메소드 대부분이 deprecated처리되었다.
 *  - 기본생성자, long필드 생성자(unix time) 두개만 사용가능하다.
 *
 *
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        // Date객체 생성
        Date now = new Date(); // java.util.Date 선택하기
        System.out.println(now); // Wed Mar 27 10:34:40 KST(korea) 2024
        System.out.println(now.getTime());

        for(int i = 0; i < 1000000; i++);

        // long값으로 Date객체 생성
        // Unix(Epoch) Time : 1970년 1월 1일 자정기준으로 누적된 밀리초
        long millis = System.currentTimeMillis();
        System.out.println(millis);
        Date now2 = new Date(millis);
        System.out.println(now2);

        Date sometime = new Date(101150358454L); // 시간정보 관리할 때 long값으로 할 수도 있다.
        System.out.println(sometime);

        // Date#getTime():long
        System.out.println("now : " + now.getTime());
        System.out.println("now2 : " + now.getTime());

    }
}
