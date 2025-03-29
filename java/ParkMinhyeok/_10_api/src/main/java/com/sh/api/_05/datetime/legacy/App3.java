package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 생일 입력 캘린더
 */
public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("년: ");
        int year = sc.nextInt();
        System.out.print("월: ");
        int month = sc.nextInt();
        System.out.print("일: ");
        int day = sc.nextInt();

        Calendar birthDay = new GregorianCalendar(year, month - 1, day);
        year = birthDay.get(Calendar.YEAR);
        month = birthDay.get(Calendar.MONTH);
        day = birthDay.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = birthDay.get(Calendar.DAY_OF_WEEK);

        String weekday = switch (dayOfWeek) {
            case 1 -> "일";
            case 2 -> "월";
            case 3 -> "화";
            case 4 -> "수";
            case 5 -> "목";
            case 6 -> "금";
            case 7 -> "토";
            default -> "";
        };
        System.out.println("당신의 생일은 " + year + "년 " + (month + 1) + "월 " + day + "일 " + weekday + "요일 입니다.");
    }
}