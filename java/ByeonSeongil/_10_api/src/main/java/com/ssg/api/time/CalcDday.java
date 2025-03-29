package com.ssg.api.time;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class CalcDday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("년도:");
        int year = sc.nextInt();

        System.out.print("월:");
        int month = sc.nextInt();

        System.out.print("일:");
        int day = sc.nextInt();
        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(year, month, day);

        Period period = Period.between(localDate2,localDate);
        if (period.getDays() > 0) {
            System.out.println(period.getDays() + "일 남았습니다.()");
        }

        else if (period.getDays()== 0) {
            System.out.println("D-DAY입니다");
        } else {
            System.out.println(Math.abs(period.getDays()) + "이 지났습니다.");
        }

    }
}
