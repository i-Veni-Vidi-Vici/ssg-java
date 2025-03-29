package com.sh.api._05.datetime.legacy;

import java.util.Date;

/**
 * <pre>
 *     ### java.util.Date
 *
 * - jdk1.0부터 날짜 / 시간을 관리하기 위한 클래스
 * - 생성자 / 메소드 대부분이 deprecated 처리 되었음
 * - 기본생성자, long 필드 생성자(unix time) 두개만 사용가능함
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        //Date 객체
        Date now = new Date();// java.util.Date
        System.out.println(now); //Wed Mar 27 10:34:24 KST 2024
        System.out.println(System.currentTimeMillis()); //1711503650200

        for (int i = 0; i < 10000000; i++);

        //long값으로 Date 객체 생성
        //Unix(Epoch) Time : 1970년 1월 1일 자정 기준으로 누적된 밀리초를 인자로 받음
        long millis = System.currentTimeMillis();
        System.out.println(millis); //1711503512389
        Date now2 = new Date(millis);
        System.out.println(now2); //Wed Mar 27 10:40:02 KST 2024

        Date sometime = new Date(171150587545L);
        System.out.println(sometime); //Thu Jun 05 06:49:47 KST 1975

        //Date#getTime() : long -> 현재 날자가 가진 limit
        System.out.println("now : " + now.getTime());
        System.out.println("now2 : " + now2.getTime());
    }
}
