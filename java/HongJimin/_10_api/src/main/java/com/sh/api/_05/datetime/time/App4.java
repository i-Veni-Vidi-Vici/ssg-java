package com.sh.api._05.datetime.time;

import java.io.PrintStream;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * <pre>
 *
 * </pre>
 */
public class App4 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime past = LocalDateTime.of(2024, 3, 26, 14, 30, 30);
        LocalDateTime future = LocalDateTime.of(2025, 3, 26, 14, 30, 30);
        ZonedDateTime zonedNow = ZonedDateTime.now();
        ZonedDateTime zonedNow2 = ZonedDateTime.now();

        System.out.println(now.isAfter(past)); //true
        System.out.println(now.isBefore(future)); //true
        System.out.println(zonedNow.isEqual(zonedNow2));//true -> 안의 모든 값이 동일할 대 true를 반환함

        //Period 날짜 사이의 간격
        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2025, 4, 1);
        Period period = Period.between(localDate, localDate2);

        System.out.println(period); //P1Y5D , 1년 5일 차이가 난다!
        System.out.println("년도 차이 : " + period.getYears()); //년도 차이 : 1
        System.out.println("월 차이 : " + period.getMonths()); //월 차이 : 0
        System.out.println("일 차이 : " + period.getDays()); //일 차이 : 5

        //Duration 두 시각 사이의 간격
        Duration duration = Duration.between(past, now);
        System.out.println("초 차이 : "+ duration.getSeconds()); //초 차이 : 85819

        //ChronoUnit 날짜 / 시각 사이의 간격
        System.out.println("년도 차이 : " + ChronoUnit.YEARS.between(now, future)); //년도 차이 : 0
        System.out.println("년도 차이 : " + ChronoUnit.YEARS.between(past, future)); //년도 차이 : 1
        System.out.println("월 차이 : " + ChronoUnit.MONTHS.between(past, future)); //월 차이 : 12
        System.out.println("일 차이 : " + ChronoUnit.DAYS.between(past, future)); //일 차이 : 365
        System.out.println("시간 차이 : " + ChronoUnit.HOURS.between(past, future)); //시간 차이 : 8760
        System.out.println("분 차이 : " + ChronoUnit.MINUTES.between(past, future)); //분 차이 : 525600
        System.out.println("초 차이 : " + ChronoUnit.SECONDS.between(past, future)); //초 차이 : 31536000
    }
}
