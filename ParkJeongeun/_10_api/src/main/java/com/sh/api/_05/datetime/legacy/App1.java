package com.sh.api._05.datetime.legacy;

import java.util.Date;

/**
 * <pre>
 * java.util.Date
 * - jdk1.0부터 날짜/시간을 관리하기 위한 클래스
 * - 생성자/메소드 대부분이 deprecated 처리되었음
 * - 기본 생성자, long 타입 필드 생성자(unix time)
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        // Date 객체 생성
        Date now = new Date(); // java.util.Date (sql X)
        System.out.println(now); // Wed Mar 27 10:40:20 KST 2024 // KST(Korean Standard Time)

        // long 값으로 Date 객체 생성
        // Unix(Epoch) Time : 1970.01.01 자정기준으로 누적된 밀리초를 인자로 받음 (1초 = 1000밀리초)
        long millis = System.currentTimeMillis();
        System.out.println(millis); // 1711503620698
        Date now2 = new Date(millis);
        System.out.println(now2); // Wed Mar 27 10:40:20 KST 2024

        // Date#getTime():long
        System.out.println(now.getTime());
        System.out.println(now2.getTime());


    }
}
