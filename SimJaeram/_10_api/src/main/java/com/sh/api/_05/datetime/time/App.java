package com.sh.api._05.datetime.time;

import java.time.*;

/**
 * <pre>
 *     java.time 패키지
 *     - 기존의 Date, Calendar의 사용상의 불편한 점을 개선한 날짜/시간 관련 패키지
 *
 *     - LocalDate, LocalTime, LocalDateTime, ZonedDateTime 4가지를 우선적으로 알아야 한다.
 *                                          지역 정보를 가지고 있는 날짜 시간 객체
 *     - java.time.chrono   // ISO-8601에 정의된 달력 시스템 관련 클래스
 *     - java.time.format   // 날짜/시각 형식 변환 관련 클래스
 *     - java.time.temporal // 날짜/시간 필드 및 단위 관련 클래스
 *     - java.time.zone     // 지역대 관련 클래스
 *
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // LocalDate 날짜 정보만 있는 객체
        // 현재
        LocalDate localDate1 = LocalDate.now();
        // 특정 시간
        LocalDate localDate2 = LocalDate.of(2024, 3,27);
        System.out.println(localDate1);             // 2024-03-27
        System.out.println(localDate2);             // 2024-03-27

        // LocalTime 시간
        // 현재
        LocalTime localTime1 = LocalTime.now();
        // 특정 시간
        LocalTime localTime2 = LocalTime.of(14, 15, 30);
        System.out.println(localTime1);             // 12:20:58.464861900
        System.out.println(localTime2);             // 14:15:30

        // LocalDateTime 날짜/시간
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(2024, 3, 4, 12, 30, 25);
        // yyyy-MM-ddThh:mm:ss.SSSSSSSSS            // T는 구분자, 분과 월 구분하기 위해 대소문자 구분으로 표기
        System.out.println(localDateTime);         // 2024-03-27T12:22:03.896627800
        System.out.println(localDateTime2);         // 2024-03-04T12:30:25

        // ZonedDateTime 지역 정보 포함
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(
                2024, 3, 4,
                12, 30, 10, 0,
                ZoneId.of("America/New_York"));
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(localDateTime, ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime1);          // 2024-03-27T12:25:42.074862400+09:00[Asia/Seoul]
                                                    // UTC 대비 9시간 빠르다. 아시아 서울 지역
        System.out.println(zonedDateTime2);          // 2024-03-27T12:25:42.074862400+09:00[Asia/Seoul]
    }
}
