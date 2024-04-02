package com.sh.api._05.datetime.lagacy;

import java.util.Date;

/**
 * <pre>
 * java.util.Date
 * - jdk1.0부터 날짜/시간을 관리하기 클래스
 * - 생성자/메소드 대부분이 deprecated처리되었음
 * - 기본 생성자, long필드 생성자(unix time) 두 개만 사용가능하다.
 * </pre>
 */
public class App1 {
    public static void main(String[] args) {
        Date now=new Date();// java.util.date 꼭 보고 써라
        System.out.println(now);

        // long값으로 date객체 생성
        // 1970 년 1월 1일 자정기준으로 누적된 밀리초
        Date now2=new Date();
        System.out.println(now2);
        long millis=System.currentTimeMillis();
        System.out.println(millis);

        //Date#getTime():long
        System.out.println("now : "+now.getTime());
        System.out.println("now : "+now2.getTime());


    }
}
