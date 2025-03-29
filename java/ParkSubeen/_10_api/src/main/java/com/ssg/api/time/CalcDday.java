package com.ssg.api.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalcDday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("날짜를 입력하세요.");
        System.out.print("> 년도 : ");
        int year = sc.nextInt();
        System.out.print("> 월 : ");
        int month = sc.nextInt();
        System.out.print("> 일 : ");
        int day = sc.nextInt();
        LocalDate today = LocalDate.now();
        LocalDate localDate = LocalDate.of(year, month, day);

        long dDay = ChronoUnit.DAYS.between(today, localDate);
        if(dDay == 0) {
            System.out.println("D-DAY입니다.   (D-DAY)");
        }else if(dDay > 0) {
            System.out.println(dDay + "일 남았습니다.     (D-DAY 전)");
        }else {
            dDay = dDay * -1;
            System.out.println(dDay + "일 지났습니다.     (D-DAY가 지난 경우)");
        }

    }
}
