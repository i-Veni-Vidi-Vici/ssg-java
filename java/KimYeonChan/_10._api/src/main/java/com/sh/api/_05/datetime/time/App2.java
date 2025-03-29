package com.sh.api._05.datetime.time;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;

/**
 * 'get 필드' 방식의 접근자를 제공
 */
public class App2 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("년도: " + localDateTime.getYear());
        System.out.println("월: " + localDateTime.getMonth());
        System.out.println("일: " + localDateTime.getDayOfMonth());

        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());

        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfWeek().getValue());
        String dayOfWeek = switch (localDateTime.getDayOfWeek().getValue()){
            case 1 -> "월";
            case 2 -> "화";
            case 3 -> "수";
            case 4 -> "목";
            case 5 -> "금";
            case 6 -> "토";
            case 7 -> "일";
            default -> "";
        };
        System.out.println(dayOfWeek);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime.getZone());
    }
}
