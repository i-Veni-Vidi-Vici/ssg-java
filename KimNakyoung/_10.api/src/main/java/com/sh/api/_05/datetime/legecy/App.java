package com.sh.api._05.datetime.legecy;


import java.util.Date;

/**
 * <pre>
 * java.util.Date
 * - jdk1.0부터 날짜/시간을 관리하기 클래스
 * - 생성자/메소드 대부분이 deprecated처리되었음
 * - 기본 생성자, long 필드 생성자(unix time) 두개만 사용가능하다.
 *
 * </pre>
 *
 *
 */

public class App {
    public static void main(String[] args) {
        //Date 객체
        Date now = new Date(); // java.util.Date !! 이거 해야돼
        System.out.println(now); // Wed Mar 27 10:34:31 KST 2024
        System.out.println(System.currentTimeMillis());


        for (int i = 0; i < 10000000; i++);

        //long값으로 Date 객체 생성
        // Unix(Epoch) Time : 1970년 1월 1일 자정기준을 누적된 밀리초
        long millis = System.currentTimeMillis(); // 커랜트타임밀리스
        System.out.println(millis);
        Date now2 = new Date(millis);
        System.out.println(now2);

        Date sometime = new Date(1711503857545L);
        System.out.println(sometime);

        
        //Date#getTimw() : long
        System.out.println("now : " + now.getTime());
        System.out.println("now2 : " + now2.getTime());



    }
}
