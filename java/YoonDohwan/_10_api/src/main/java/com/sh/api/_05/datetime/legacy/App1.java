package com.sh.api._05.datetime.legacy;

import java.util.Date;

/**
 * java.util.Date
 * -jdk1.0부터 날짜/시간을 관리하기 클라스
 * -생성자/메소드 대부분이 deprecated 처리되었음.
 * -기본생성자,long 필드 생성자(unix time)두개만 사용가능하다.
 *
 *
 *
 */
public class App1 {
    public static void main(String[] args) {
        //Date 객체 생성
        Date now = new Date(); // java.util.date
        System.out.println(now);

        //Long 값으로 Date 객체 생성
        //1970년 1월1일 자정기준으로 누적된 밀리초
        long millis = System.currentTimeMillis();
        System.out.println(millis);
        Date now2 = new Date();
        System.out.println(now2);

        Date sometime = new Date(171150387545L);
        System.out.println(sometime);
        System.out.println("now : " +now.getTime());
        System.out.println("now2 : "+now2.getTime());
    }
}
