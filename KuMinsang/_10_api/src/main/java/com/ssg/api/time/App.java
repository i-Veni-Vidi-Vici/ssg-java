package com.ssg.api.time;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String str = """
                =====================
                1. 오늘 날짜
                2. 태어난 이후 날짜 세기
                3. D-Day 계산기
                0. 종료
                =====================
                """;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println(str);
            switch (sc.next()) {
                case "1":
                    TodayTest todayTest = new TodayTest();
                    System.out.println(todayTest.print());
                    break;
                case "2":
                    CalcYourDays calcYourDays = new CalcYourDays();
                    System.out.println(calcYourDays.print());
                    break;
                case "3":
                    CalcDday calcDday = new CalcDday();
                    System.out.println(calcDday.print());
                    break;
                default:
                    return;
            }
        }
    }
}
