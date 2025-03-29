package com.ssg.api.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CalcDday
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        LocalDate planner = LocalDate.of(year, month, day);
        LocalDate completion = LocalDate.of(2024, 9, 4);

        long between = ChronoUnit.DAYS.between(planner, completion);

        if(between > 0){
            System.out.println("D - DAY 전");
            System.out.println(between + "일 남았습니다.");
        }
        else if(between < 0){
            System.out.println("D + DAY ");
            System.out.println(Math.abs(between) + "일 지났습니다. ");
        }
        else System.out.println("D - DAY입니다");

    }
}
