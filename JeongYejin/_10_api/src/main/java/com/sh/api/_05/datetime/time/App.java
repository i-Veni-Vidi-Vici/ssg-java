package com.sh.api._05.datetime.time;

import java.time.*;
import java.time.zone.ZoneRules;

/**
 * <pre>
 * java.time 패키지
 * - 기존의 Date, Calendar의 사용상 불편한 점을 개선한 날짜/시간관련 패키지
 *
 * - LocalDate, LocalTime, LocalDateTime, ZonedDateTime 4가지를 우선적으로 알아야 한다.
 *
 * - java.time.chrono : ISO-8601에 정의된 달력시스템 관련 클래스
 * - java.time.format : 날짜/시각 형신 변환 관련 클래스
 * - java.time.temporal : 날짜/시간필드 및 단위 관련 클래스
 * - java.time.zone : 지역대 관련대
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // LocalDate 날짜
        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate1);
        LocalDate localDate2 = LocalDate.of(2024, 3, 27);
        System.out.println(localDate2);

        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(14, 15, 30);
        LocalTime localTime3 = LocalTime.of(14, 15, 30,123456789);
        System.out.println(localTime1); // 12:19:02.393695900 소수점세자리단위로 milli, micro, nano
        System.out.println(localTime2);
        System.out.println(localTime3);


        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(2024, 3, 4, 12, 30, 25);
        System.out.println(localDateTime1); // 2024-03-27T12:24:46.358572800
        System.out.println(localDateTime2); // 2024-03-04T12:30:25

        // ZonedDateTime 지역정보 포함
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        System.out.println(zonedDateTime1); // 2024-03-27T12:25:53.603601300+09:00[Asia/Seoul]
        ZoneId zoneId = ZoneId.of("Europe/Paris");
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(2024,3,4,12,30,10, 30, zoneId);
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(localDateTime1, ZoneId.of("America/Los_Angeles"));
        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime3);
    }
}
