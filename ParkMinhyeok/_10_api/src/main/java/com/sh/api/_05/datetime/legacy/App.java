package com.sh.api._05.datetime.legacy;

import java.util.Date;

/**
 * <pre>
 * java.util.Date
 * - jdk1.0 부터 날짜 / 시간을 관리하기 위한 클래스
 * - 생성자 / 메소드 대부분이 deprecated 처리되었음.
 * - 기본 생성자, long 필드 생성자(unix time) 두 개만 사용 가능하다.
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // Date 객체 생성
        Date now = new Date();
        System.out.println(now);

        // long 값으로 Date 객체 생성
        // Unix(Epoch) time: 1970년 1월 1일 자정기준으로 누적된 밀리초
        long millis = System.currentTimeMillis();
        System.out.println(millis);
        Date now2 = new Date(millis);
        System.out.println(now2);
    }
}
