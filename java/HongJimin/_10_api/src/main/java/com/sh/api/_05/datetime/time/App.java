package com.sh.api._05.datetime.time;

import java.time.*;

/**
 * <pre>
 *     ### java.time 패키지
 * - 기존의 Date, Calendar의 사용상 불편한 점을 개선한 날짜/시간 관련 패키지
 *
 * - LocalDate, LocalTime, LocalDateTime, ZonedDateTime 4가지를 우선적으로 알아야 함
 * - java.time.chrono  : ISO - 8601에 정의된 달력 시스템 관련 클래스
 * - java.time.format : 날짜 / 시각 형식 변환 관련 클래스
 * - java.time.temporal :날짜 / 시간 필드 및 단위 관련 클래스
 * - java.time.zone : 지역대 관련대
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //LocalDate 날짜
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2024, 3, 27);
        System.out.println(localDate1); //2024-03-27 -> 현재 날짜 정보
        System.out.println(localDate2); //직접 직는 년, 월, 일 나옴!

        //LocalTime 시간
        LocalTime localTime1 = LocalTime.now();
        LocalTime localTime2 = LocalTime.of(12, 34, 2);
        System.out.println(localTime1); //12:18:53.153727400 -> 현재 시간을 얘기해줌 뒤에 주렁주렁 달린 것은 세자리 단위로 내려감 / 153 밀리초, 727 마이크로초, 400 나노초
        System.out.println(localTime2); //12:34:02 -> 24시간제

        //LocalDateTime 날짜 / 시간
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(2024, 3, 4, 12, 30, 25);

        //yyyy-MM-dd-Thh:mm:ss.SSSSSSSSS
        System.out.println(localDateTime); //2024-03-27T12:22:10.448828700
        System.out.println(localDateTime2); //2024-03-04T12:30:25

        //ZonedDateTime 지역정보 포함
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(2024, 3, 4, 12, 30, 10,  0, ZoneId.of("Asia/Seoul"));

        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(localDateTime, ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime); //2024-03-27T12:25:54.739968700+09:00[Asia/Seoul] -> 자바 프로그램은 OS 기준으로 돌아가기 때문에 Os에 설정된 지역정보를 사용함!!!!!!!!
        System.out.println(zonedDateTime2); //2024-03-04T12:30:10+09:00[Asia/Seoul]
        System.out.println(zonedDateTime3); //2024-03-27T12:33:57.111797400+09:00[Asia/Seoul]


    }
}
