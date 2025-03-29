package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * <pre>
 * 사용자 생일을 입력받아서 Calendar객체로 생성 후, 다음 형식으로 출력
 * - 당신의 생일은 ?년 ?월 ?일 ?요일 입니다.
 * </pre>
 */

public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("당신의 생일은 몇년입니까? ");
        int year = sc.nextInt();
        System.out.println("당신의 생일은 몇월입니까? ");
        int month = sc.nextInt();
        System.out.println("당신의 생일은 몇일입니까? ");
        int dayOfMonth = sc.nextInt();

        Calendar birthday = new GregorianCalendar(year, month - 1, dayOfMonth);
        System.out.println(birthday);

        char[] daysOfWeek = {'일', '월', '화', '수', '목', '금', '토'};

        System.out.printf("> 당신의 생일은 %d년 %d월 %d일 %s요일 입니다.",
                birthday.get(Calendar.YEAR),
                birthday.get(Calendar.MONTH) + 1,
                birthday.get(Calendar.DAY_OF_MONTH),
                daysOfWeek[birthday.get(Calendar.DAY_OF_WEEK) - 1]);

        //        String weekday = switch (dayOfWeek){
//            case 1 -> "일";
//            case 2 -> "월";
//            case 3 -> "화";
//            case 4 -> "수";
//            case 5 -> "목";
//            case 6 -> "금";
//            case 7 -> "토";
//            default -> "";
//        };

    }
}
