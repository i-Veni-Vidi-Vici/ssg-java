package com.sh.api._05.datetime.time;

import java.time.*;

/**
 * <pre>
 * java.time 패키지
 * - 기존의 Data, Calendar의 사용상의 불편함을 개선한 날짜/시간 관련 패키지
 *
 * - LocalDate, LocalTime, LocalDateTime, ZonedDateTime 4가지를 우선적으로 알아야 함
 *
 * - java.time.chrono : ISO-8601에 정의된 달력 시스템 관련 클래스
 * - java.time.format : 날짜/시각 형식 변환 관련 클래스
 * - java.time.temporal : 날짜/시간 필드 및 단위 관련 클래스
 * - java.time.zone : 지역대 관련
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //LocalDate 날짜
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2024,3,27);

        System.out.println(localDate1); // 2024-03-27
        System.out.println(localDate2); // 2024-03-27

        //LocalTime 시간 (24시간제)
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(14,15,30);
        System.out.println(localTime1); // 12:19:04.857847400 (맨마지막에는 밀리초 3자리, 마이크로초 3자리, 나노초 3자리)
        System.out.println(localTime2); // 14:15:30

        //LocalDateTime 날짜/시간
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2024,3,4,12,30,25);
        // yyyy-MM-ddThh:mm:ss.SSSSSSSSS(T는 구분자, 월은 대문자 M, 분은 소문자 m)
        System.out.println(localDateTime); // 2024-03-27T12:22:11.818785200
        System.out.println(localDateTime1); // 2024-03-04T12:30:25

        // ZonedDateTime 지역정보 포함
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(2024,3,4,12,30,10, 0, ZoneId.of("Asia/Seoul"));
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(localDateTime, ZoneId.of("Asia/Seoul"));

        System.out.println(zonedDateTime); //2024-03-27T12:25:52.556300400+09:00[Asia/Seoul]
        System.out.println(zonedDateTime1); //2024-03-04T12:30:10+09:00[Asia/Seoul]
        System.out.println(zonedDateTime2); //2024-03-27T12:33:56.446846900+09:00[Asia/Seoul]
    }
}
