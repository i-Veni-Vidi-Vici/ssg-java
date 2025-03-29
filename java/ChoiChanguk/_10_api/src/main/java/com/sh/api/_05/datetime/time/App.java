package com.sh.api._05.datetime.time;

import java.time.*;

/**
 * <pre>
 * java.time패키지
 * - 기존의 date, Calendaar의 사용상 불편한 점을 개선한 날짜/시간 관련 패키지
 *
 * - LocalDate, LocalTIme, LocalTimeDateTime, ZoneDateTime 4가지를 우선적으로 알야아 함
 *
 * - java.time.chrono : ISO-8601에 정의된 달력시스템 관련 클래스
 * - jvaa.time.format : 날짜/시간 형식 변환 관련 클래스
 * - java.time.tempral : 날짜/시간 필드 및 단위 관련 클래스
 * - java.time.zone : 지역대 관련대
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // LocalDate 날짜
        LocalDate localDate1=LocalDate.now();
        LocalDate localDate2=LocalDate.of(2024,3,27);
        System.out.println("now : "+localDate1);
        System.out.println("now : "+localDate2);

        //LocalTime 시간
        LocalTime localTime1=LocalTime.now();
        LocalTime localTime2=LocalTime.of(14,20,30);//24시간
        System.out.println("time : "+localTime1);
        System.out.println("time : "+localTime2);

        //LocalDateTime 날짜/시간
        LocalDateTime localDateTime1=LocalDateTime.now();
        LocalDateTime localDateTime2=LocalDateTime.of(2024,3,4,12,24,30);
        //yyyy-MM-ddThh:mm:ss.SSSSSSSSS
        System.out.println("time : "+localDateTime1);
        System.out.println("time : "+localDateTime2);

        //zonedDateTime 지역정보 포함
        ZonedDateTime zonedDateTime1= ZonedDateTime.now();
        //ZonedDateTime zonedDateTime2= ZonedDateTime.of(2024,3,4,12,30,10, 10,ZoneId);
        ZonedDateTime zonedDateTime3= ZonedDateTime.of(localDateTime1,ZoneId.of("Asis/Seoul"));
        System.out.println("zoneDateTime : "+zonedDateTime1);

    }
}
