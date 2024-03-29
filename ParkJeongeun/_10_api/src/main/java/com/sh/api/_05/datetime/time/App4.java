package com.sh.api._05.datetime.time;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * <pre>
 * 날짜/시간 객체 사이의 연산
 * - isAfter
 * - isBefore
 * - ifNow
 * - Duration클래스
 * - Period 클래스
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime past = LocalDateTime.of(2024, 3, 26, 14, 30, 30);
        LocalDateTime future = LocalDateTime.of(2025, 3, 26, 14, 30, 30);
        ZonedDateTime zonedNow = ZonedDateTime.now();
        ZonedDateTime zonedNow1 = ZonedDateTime.now();

        System.out.println(now.isAfter(past)); // true (now가 past보다 나중이냐)
        System.out.println(now.isBefore(future)); // true (now가 future보다 전이냐)
        System.out.println(zonedNow.isEqual(zonedNow1)); // true

        // Period 날짜 사이의 간격
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2025,4,1);

        Period period = Period.between(localDate, localDate1);
        System.out.println(period); // P1Y5D (P는 Period, 1년 5일 차이)
        System.out.println("년 차이 : " + period.getYears()); // 1
        System.out.println("월 차이 : " + period.getMonths()); // 0
        System.out.println("일 차이 : " + period.getDays()); // 5

        // Duration 두 시각사이의 간격
        Duration duration = Duration.between(past, now);
        System.out.println("초 차이 : " + duration.getSeconds());

        // ChronoUnit 날짜/시각 사이의 간격
        System.out.println("년 차이 : " + ChronoUnit.YEARS.between(now, future)); // 딱 1년차이는 0으로 나옴
        System.out.println("년 차이 : " + ChronoUnit.YEARS.between(past, future)); // 1
        System.out.println("년 차이 : " + ChronoUnit.MONTHS.between(past, future)); // 12
        System.out.println("년 차이 : " + ChronoUnit.DAYS.between(past, future)); // 365
        System.out.println("시간 차이 : " + ChronoUnit.HOURS.between(past, future));
        System.out.println("분 차이 : " + ChronoUnit.MINUTES.between(past, future));
        System.out.println("초 차이 : " + ChronoUnit.SECONDS.between(past, future));
    }
}
