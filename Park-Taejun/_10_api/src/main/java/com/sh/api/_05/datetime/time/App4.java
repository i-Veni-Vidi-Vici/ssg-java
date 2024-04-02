package com.sh.api._05.datetime.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * <pre>
 * 날짜/시간 객체 사이의 연산
 * -isAfter
 * -isBefore
 * -isNow
 * -Duration 클래스
 * -Period 클래스
 *
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime past = LocalDateTime.of(2024, 3,26,14,30,30);
        LocalDateTime future = LocalDateTime.of(2025, 3, 26, 14 , 30);

        System.out.println(now.isAfter(past));
        System.out.println(now.isAfter(future));
//        System.out.println(zoneNow.isEqual(zoneNow2));

        //Period 날짜 사이의 간격

        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2025, 4 , 1);
        Period period = Period.between(localDate, localDate2);
        System.out.println(period); //P1Y5D
        System.out.println("년 차이 : " + period.getYears());
        System.out.println("월 차이 : " + period.getMonths());
        System.out.println("일 차이 : " + period.getDays());

        // Duration 두 시각사이의 간격
        Duration duration = Duration.between(past, now);
        System.out.println("초 차이 : " + duration.getSeconds());

        //ChronoUnit 날짜/시각사이의 간격
        System.out.println("년도 차이 : " + ChronoUnit.YEARS.between(past, future));
        System.out.println("월 차이 : " + ChronoUnit.MONTHS.between(past, future));
        System.out.println("일 차이 : " + ChronoUnit.DAYS.between(past, future));
        System.out.println("시간 차이 : " + ChronoUnit.HOURS.between(past, future));
        System.out.println("분 차이 : " + ChronoUnit.MINUTES.between(past, future));
        System.out.println("초 차이 : " + ChronoUnit.SECONDS.between(past, future));




    }
}
