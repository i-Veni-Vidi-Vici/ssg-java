package com.sh.api._05.datetime.time;

import java.time.*;

/**
 * java.time 패키지
 * - 기조의 Date, Calendar 의 사용상 불편한 점을 개선한 날짜/시간 관련 패키지
 * - LocalDate, LocalTime, LocalDateTime, ZonedDateTime 4가지를 우선적으로 알아야 한다.
 * - java.time.chrono: ISO-8601에 정의된 달력 시스템 관련 클래스
 * - java.time.format: 날짜/시각 형식 변환 관련 클래스
 * - java.time.temporal: 날짜/시간 필드 및 단위 관련 클래스
 * - java.time.zone: 지역대 관련
 */
public class App {
    public static void main(String[] args) {
        // LocalDate 날짜
        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate1);
        LocalDate localDate2 = LocalDate.of(2024, 3, 27);
        System.out.println(localDate2);

        // LocalTime 시간
        LocalTime localTime1 = LocalTime.now();
        System.out.println(localTime1); // 12:20:00.651345
        LocalTime localTime2 = LocalTime.of(14, 15, 30);
        System.out.println(localTime2); // 14:15:30

        // LocalDateTime 날짜/시간
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);
        LocalDateTime localDateTime2 = LocalDateTime.of(2024, 3, 17, 12, 22, 10);
        System.out.println(localDateTime2);

        // ZonedDateTime 지역정보 포함
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        ZoneId zoneId = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(2024, 1,3, 12, 12, 33, 10, zoneId);
        System.out.println(zonedDateTime2);
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(localDateTime1, zoneId);
        System.out.println(zonedDateTime3);

    }
}
