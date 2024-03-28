package com.sh.api._05.datetime.time;

import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * 날짜/시간 객체 사이의 연산
 * - isAfter
 * - isBefore
 * - isNow
 * - Duration 클래스
 * - Period 클래스
 */
public class App4 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime past= LocalDateTime.of(2023, 4, 26, 14, 30, 40);
        LocalDateTime future= LocalDateTime.of(2025, 4, 26, 14, 30, 40);
        ZonedDateTime zonedNow1 = ZonedDateTime.now();
        ZonedDateTime zonedNow2 = ZonedDateTime.now();

        System.out.println(now.isAfter(past));
        System.out.println(now.isBefore(future));
        System.out.println(zonedNow1.isEqual(zonedNow2));

        // Period 날짜 사이의 간격
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2045, 5, 5);
        Period period = Period.between(localDate1, localDate2);
        System.out.println(period);

        // Duration 두 시각 사이의 간격
        Duration duration = Duration.between(past, now);
        System.out.println(duration);

        // ChronoUint 날짜/시각 사이의 간격
        System.out.println(ChronoUnit.YEARS.between(past, future));
    }
}
