package com.ssg.test.api.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import static java.time.LocalDate.now;

public class CalcDday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 연도를 입력하세요 : ");
        int year = sc.nextInt();
        System.out.print("> 월을 입력하세요 : ");
        int month = sc.nextInt();
        System.out.print("> 일을 입력하세요 : ");
        int day = sc.nextInt();

        LocalDate dDay = LocalDate.of(year, month, day);
        long diff = ChronoUnit.DAYS.between(now(), dDay);

        if (diff > 0)
            System.out.println(diff + "일 남았습니다. (D-DAY 전)");
        else if (diff == 0)
            System.out.println("D-DAY입니다. (D-DAY)");
        else
            System.out.println(-diff + "일 지났습니다. (D-DAY가 지난 경우)");

    }
}
