package com.ssg.api.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalcYourDays {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("년도 입력 : ");
        int year = scanner.nextInt();
        System.out.println("월 입력 : ");
        int month = scanner.nextInt();
        System.out.println("일 입력 : ");
        int day = scanner.nextInt();
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(year,month,day);

        System.out.println("오늘이 태어난지 " + ChronoUnit.DAYS.between(localDate1,localDate) + "됐습니다. ");

    }
}
