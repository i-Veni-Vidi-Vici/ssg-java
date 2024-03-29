package com.sh.api._05.datetime.time;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class App4 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime past = LocalDateTime.of(2024,3,26,14,30,30);
        LocalDateTime future = LocalDateTime.of(2025,3,26,14,30,30);
        ZonedDateTime zonedNow = ZonedDateTime.now();
        ZonedDateTime zonedNow2 = ZonedDateTime.now();

        System.out.println(now.isAfter(past));  //true
        System.out.println(now.isBefore(future));   //true
        System.out.println(zonedNow.isEqual(zonedNow2));    //true

        System.out.println("-------------");
        //Period 날짜사이의 간격
        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2025, 4, 1);

        Period period = Period.between(localDate, localDate2);
        System.out.println(period); //P1Y5D
        System.out.println("년도 차이 : " + period.getYears());
        System.out.println("월차이 : " + period.getMonths());
        System.out.println("일차이 : " + period.getDays());    //D-day같은 기능을 구현할때 유용한 기능
        System.out.println("-------------");
        //Duration 두 시각 사이의 간격
        Duration duration = Duration.between(past, now);
        System.out.println("초 차이 : "+duration.getSeconds());
        System.out.println("-------------");
        //chronoUnit 날짜/시각 사이의 간격
        System.out.println("년도 차이 : " + ChronoUnit.YEARS.between(past, future));    //1
        System.out.println("월 차이 : " + ChronoUnit.MONTHS.between(past, future));    //12
        System.out.println("일 차이 : " + ChronoUnit.DAYS.between(past, future));  //365
        System.out.println("시간 차이 : " + ChronoUnit.HOURS.between(past, future));    //8760
        System.out.println("분 차이 : " + ChronoUnit.MINUTES.between(past, future));   //525600
        System.out.println("초 차이 : " + ChronoUnit.SECONDS.between(past, future));   //31536000


    }
}
