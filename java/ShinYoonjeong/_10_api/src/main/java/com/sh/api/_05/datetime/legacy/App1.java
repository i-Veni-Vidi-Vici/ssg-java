package com.sh.api._05.datetime.legacy;

import org.w3c.dom.ls.LSOutput;

import java.util.Date;

/**
 * <pre>
 * java.util.date
 * - jdk1.0부터 날짜/시간을 관리하기 클래스
 * - 생성자/메소드 대부분이 deprecated처리되었음.
 * - 기본 생성자, long필드 생성자(unix time) 두개만 사용 가능하다.
 *
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        // Date객체 생성
        Date now = new Date(); // java.util.date
        System.out.println(now);

        // long 값으로 Date객체 생성
        // 1970년 1월 1일 자정 기준으로 누적된 밀리초
        long millis = System.currentTimeMillis();
        System.out.println(millis);
        Date now2 = new Date(millis);
        System.out.println(now2);

        Date sometime = new Date(10102048657L);
        System.out.println(sometime);

        // Date now2 = new Date();
        // Date#getTime():long
        System.out.println("now : " + now.getTime());
        System.out.println("now2 : " + now2.getTime());

    }
}
