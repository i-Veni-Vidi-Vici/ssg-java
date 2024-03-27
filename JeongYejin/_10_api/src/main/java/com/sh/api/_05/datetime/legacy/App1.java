package com.sh.api._05.datetime.legacy;

import java.util.Date;

/**
 * <pre>
 * java.util.Date
 * - jdk1.0 부터 날짜/시간을 관리하기 위한 클래스
 * - 생성자/메소드 대부분이 deprecated처리 되었음
 * - 기본생성자, long필드 생성자(unix time) 두개만 사용가능하다
 *
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        // Date객체 생성
        Date now = new Date(); // java.util.Date // java.sql.Date(x)
        System.out.println("new Date() : " + now);

        // long값으로 Date 객체 생성
        // Unix(Epoch) Time: 1970년 1월 1일 자정기준으로 누적된 밀리초
        long millis = System.currentTimeMillis();
        System.out.println(millis);
        Date now2 = new Date(millis);
        System.out.println(now2);

        // Date#getTime() : long
        System.out.println("now : " + now.getTime());
        System.out.println("now2 : " + now2.getTime());
    }
}
