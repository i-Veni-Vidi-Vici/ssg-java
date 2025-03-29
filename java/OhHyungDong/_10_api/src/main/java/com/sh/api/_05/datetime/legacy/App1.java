package com.sh.api._05.datetime.legacy;

import java.util.Date;

/**
 * <pre>
 *  java.util.Date
 *  - jdk 1.0부터 날짜 / 시간을 관리하는 클래스
 *  - 생성자 / 메소드 대부분이 deprecated 처리 되었음.
 *  - 기본 생성자, long 필드 생성자 (unix time) 두개만 사용 가능
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now);

        //long값으로 Date 객체 생성
        // 1970년 1월 1일 기준으로 누적된 밀리초
        long millis = System.currentTimeMillis();
        System.out.println(millis);
//        Date now2 = new Date()
    }
}
