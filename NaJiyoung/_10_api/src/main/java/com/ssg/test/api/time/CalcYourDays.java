package com.ssg.test.api.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import static java.time.LocalDate.now;

public class CalcYourDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 몇 년도에 태어나셨나요? : ");
        int year = sc.nextInt();
        System.out.print("> 몇 월에 태어나셨나요? : ");
        int month = sc.nextInt();
        System.out.print("> 며칠에 태어나셨나요? : ");
        int day = sc.nextInt();

        LocalDate birthday = LocalDate.of(year, month, day);
        long diff = ChronoUnit.DAYS.between(birthday, now());
        System.out.println("당신은 오늘이 태어난지 " + (diff + 1) + "일째 입니다!");
    }
}
