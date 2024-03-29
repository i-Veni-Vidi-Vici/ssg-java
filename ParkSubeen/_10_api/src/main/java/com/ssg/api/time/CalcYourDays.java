package com.ssg.api.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalcYourDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 태어난 년도 : ");
        int year = sc.nextInt();
        System.out.print("> 태어난 월 : ");
        int month = sc.nextInt();
        System.out.print("> 태어난 일 : ");
        int day = sc.nextInt();
        LocalDate today = LocalDate.now();
        LocalDate birth = LocalDate.of(year, month, day);

        System.out.println("오늘은 태어난지 " + ChronoUnit.DAYS.between(birth, today) + "일 입니다.");
    }
}
