package com.sh.api._05.datetime.legacy.time;

import java.time.*;

/**
 * <pre>
 *  java.time 패키지
 *  - 기존의 Date, Calendar의 사용상 불편한 점을 개선한 날짜 / 시간 관련 패키지
 *
 *  -LocalDate, LocalTime, LocalDateTime, ZondedDateTime : 4가지를 우선적으로 알아야 한다.
 *
 *  -java.time.chrono : ISO - 8601에 정의된 달력 시스템 관련 클래스
 *  -java.time.format : 날짜 / 시각 형식 변화 관련 클래스
 *  -java.time.temporal : 날짜 / 시간  ? 필드 및 단위 관련 클래스
 *  -java.time.zone : 지역대 관련대 클래스
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //LocalDate 날짜
        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2024, 3, 27);
        System.out.println(localDate); //2024-03-27
        System.out.println(localDate2);//2024-03-27

        //LocalTime 시간
        LocalTime localTime = LocalTime.now(); //12:21:18.52751
        LocalTime localTime2 = LocalTime.of(14,15,30);//14:15:30

        System.out.println(localTime);
        System.out.println(localTime2);

        //LocalDateTime  : 날짜  / 시간 정보
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(2024,3,4,12,30,25);
        // yyyy - mm -- ddThh:mm:ss.SSSSS
        System.out.println(localDateTime); //2024-03-27T12:22:26.727422

        //ZonedDateTime 지역 정보 포함
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZoneId zondeID = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTim2 = ZonedDateTime.of(2024,3,4,12,30,10,0,zondeID);
        System.out.println(zonedDateTime);//2024-03-27T12:26:01.446182+09:00[Asia/Seoul]

    }
}
