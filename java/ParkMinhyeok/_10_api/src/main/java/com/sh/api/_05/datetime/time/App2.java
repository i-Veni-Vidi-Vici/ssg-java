package com.sh.api._05.datetime.time;

import java.time.LocalDateTime;

/**
 * <pre>
 * 'get 필드' 방식의 접근자를 제공
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("년도 : " + localDateTime.getYear());
        System.out.println("월(enum) : " + localDateTime.getMonth());
        System.out.println("월(value) : " + localDateTime.getMonthValue());
        System.out.println("일 : " + localDateTime.getDayOfMonth());

        System.out.println("시 : " + localDateTime.getHour());
        System.out.println("분 : " + localDateTime.getMinute());
        System.out.println("초 : " + localDateTime.getSecond());

        System.out.println("요일(enum) : " + localDateTime.getDayOfWeek());
        System.out.println("요일(value) : " + localDateTime.getDayOfWeek());

//        char[] dayOfWeek = new char['일', '월', '화', '수', '목', '금', '토'];

    }
}
