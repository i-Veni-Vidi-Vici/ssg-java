package com.ssg.api.time;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CalcYourDays {
    int year;
    int month;
    int day;
    public String print(){

        Scanner sc = new Scanner(System.in);
        System.out.print("생일을 입력하세요.\n 연도 : ");
        year = sc.nextInt();
        System.out.print("월 : ");
        month = sc.nextInt();
        System.out.print("일 : ");
        day = sc.nextInt();

        LocalDate now = LocalDate.now();
        LocalDate past = LocalDate.of(year, month, day);
        return String.format("태어난 날로부터 %d 일 지났습니다", ChronoUnit.DAYS.between(past, now));


    }
}
