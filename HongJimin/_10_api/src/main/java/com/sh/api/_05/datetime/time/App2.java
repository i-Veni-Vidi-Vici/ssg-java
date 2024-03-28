package com.sh.api._05.datetime.time;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * <pre>
 * 'get필드' 방식의 접근자를 제공
 * </pre>
 */
public class App2 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("년도 : " + localDateTime.getYear()); //년도 : 2024
        System.out.println("월(enum) : " + localDateTime.getMonth()); //월(enum) : MARCH
        System.out.println("월(value) : " + localDateTime.getMonthValue()); //월(value) : 3
        System.out.println("일 : " + localDateTime.getDayOfMonth()); //일 : 27

        System.out.println("시 : " + localDateTime.getHour());//시 : 12
        System.out.println("분 : " + localDateTime.getMinute()); //분 : 39
        System.out.println("초 : " + localDateTime.getSecond()); //초 : 22

        System.out.println("요일(enum) : " + localDateTime.getDayOfWeek()); //요일(enum) : WEDNESDAY
        System.out.println("요일(value) : " + localDateTime.getDayOfWeek().getValue()); // 요일(value) : 3

        int value = localDateTime.getDayOfWeek().getValue();
        String datOfWeek = switch (value) {
            case 1 -> "월";
            case 2 -> "화";
            case 3 -> "수";
            case 4 -> "목";
            case 5 -> "금";
            case 6 -> "토";
            case 7 -> "일";
            default -> "";
        };
        System.out.println("요일(한글) : " + datOfWeek); // 요일(한글) : 수

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("지역대 : " + zonedDateTime.getZone()); //ZoneId.of("Asia/Seoul") , 출력값 : 지역대 : Asia/Seoul
        System.out.println("시차 : " + zonedDateTime.getOffset()); //시차 : +09:00, 값이 바뀌기 때문에 안쓰는 것이 좋음!
    }
}
