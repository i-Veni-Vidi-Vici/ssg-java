package com.sh.api._05.datetime.time;

import java.time.*;

/**
 * java.time 패키지
 * -기존의 date, calendar의 사용상 불편한 점을 개선한 날짜/시간관련 패키지
 *
 * -LocalDate. LocalTime, LocalDateTime,ZoneDateTime 4가지를 우선적으로 알아야 한다.
 *
 * -java.time.chrono   : ISO-8601에 정의된 달력시스템 관련 클래스
 * -java.time.format : 날짜/시각 형식 변환 관련 클래스
 * -java.time.temporal : 날짜/시간/필드 및 단위관련 클래스
 * -java.time.zone : 지역대 관련대
 *
 *
 */
public class App {
    public static void main(String[] args) {
        LocalDate localDate1= LocalDate.now();
        LocalDate localDate2= LocalDate.of(2024,3,27);
        System.out.println(localDate1);
        System.out.println(localDate2);

        //LocalTime 시간
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2= LocalTime.of(14,15,30);
        System.out.println(localTime1);
        System.out.println(localTime2);

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(2024,3,4,12,20);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        //ZonedDateTime 지역정보 포함
        ZonedDateTime zonedDateTime=ZonedDateTime.now();
        ZonedDateTime zonedDateTime2=ZonedDateTime.of(2024,3,12,12,30,10,0, ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime);
        System.out.println();

    }
}
