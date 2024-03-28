package com.sh.api._05.datetime.time;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * <pre>
 *     'get필드' 방식의 getter를 제공
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

        System.out.println("요일(enum) : " + localDateTime.getDayOfWeek());               // WEDNESDAY
        System.out.println("요일(value) : " + localDateTime.getDayOfWeek().getValue());   // 3
        int value = localDateTime.getDayOfWeek().getValue();
        String dayOfWeek = switch(value) {
            case 1 -> "월";
            case 2 -> "화";
            case 3 -> "수";
            case 4 -> "목";
            case 5 -> "금";
            case 6 -> "토";
            case 7 -> "일";
            default -> "";
        };
        System.out.println("요일(한글) : " + dayOfWeek);

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("지역대 : " + zonedDateTime.getZone());                         // ZoneId.of("Asia/Seoul")
        System.out.println("시차 : " + zonedDateTime.getOffset());
        // getZone()으로 지역대 정보로 zoneDateTime 생성해야 한다.
        // 가로로 넓은 나라는 시차 정보로 객체 생성 시 변경되고 번거롭다.
    }
}
