package com.sh.api._05.datetime.time;

import java.time.*;

/**
 * <pre>
 * java.time패키지
 * - 기존의 Date, Calendar의 사용상 불편한 점을 개선한 날짜/시간관련 패키지
 *
 * - LocalDate, LocalTime, LocalDateTime, ZonedDateTime 4가지를 우선적으로 알아야 한다.
 *
 * - java.time.chrono : ISO-8601에 정의된 달력시스템 관련 클래스
 * - java.time.format : 날짜/시각 형식 변환 관련 클래스
 * - java.time.temporal : 날짜/시간 필드 및 단위 관련 클래스
 * - java.time.zone : 지역대 관련대
 *
 *
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // LocalDate 날짜
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2024, 3, 27);
        System.out.println(localDate1); // 2024-03-27
        System.out.println(localDate2); // 2024-03-27

        // LocalTime 시간
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(14, 15, 30);
        System.out.println(localTime1);
        System.out.println(localTime2);

        // LocalDateTime 시간
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(2024, 3, 4, 12, 30, 25);
        // yyyy-MM-ddThh:mm:ss.SSSSSSSSS
        System.out.println(localDateTime); // 2024-03-27T12:22:08.298482300
        System.out.println(localDateTime2); // 2024-03-04T12:30:25

        // ZonedDateTime 지역정보 포함
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZoneId zoneId = ZoneId.of("America/New_York");
        ZonedDateTime zonedDateTime2 =
                ZonedDateTime.of(2024, 3, 4, 12, 30, 10, 0, zoneId);
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(localDateTime, ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime); // 2024-03-27T12:25:56.671734400+09:00[Asia/Seoul]
        System.out.println(zonedDateTime2); // 2024-03-04T12:30:10-05:00[America/New_York]
        System.out.println(zonedDateTime3); // 2024-03-27T12:34:10.978150200+09:00[Asia/Seoul]
    }
}
