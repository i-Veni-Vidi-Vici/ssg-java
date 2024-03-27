package com.sh.api._05.datetime.time;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * <pree>
 *     'get필드' 방식의 접근자 제공
 * </pree>
 */
public class App2 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("년도 : " + localDateTime.getYear());
        System.out.println("월(enum) : " + localDateTime.getMonth());
        System.out.println("월(value) : " + localDateTime.getMonthValue());
        System.out.println("일 : "+ localDateTime.getDayOfMonth());

        System.out.println("시 : " + localDateTime.getHour());
        System.out.println("분 : "+ localDateTime.getMinute());
        System.out.println("초 : "+ localDateTime.getSecond());

        System.out.println("요일(enum) : "+ localDateTime.getDayOfWeek());
        System.out.println("요일(value) : "+ localDateTime.getDayOfWeek().getValue());
        int value = localDateTime.getDayOfWeek().getValue();

        String dayOfWeek = switch(value){
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
        System.out.println("지역대 : " + zonedDateTime.getZone()); //Asia/Seoul
        System.out.println("시차 : " + zonedDateTime.getOffset());    //+09:00
        //Offset보다는 Zone을 사용항 프로그래밍 하는것이 좋다

    }
}
