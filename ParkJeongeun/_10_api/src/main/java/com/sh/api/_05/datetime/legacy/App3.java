package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * <pre>
 * 사용자 생일을 입력받아서 Calendar 객체로 생성 후, 다음 형식으로 출력
 * - 당신의 생일은 ?년 ?월 ?일입니다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 태어난 년도를 입력하세요 (ex.1990) : ");
        int birthYear = sc.nextInt();
        System.out.print("> 태어난 월을 입력하세요 : ");
        int birthMonth = sc.nextInt();
        System.out.print("> 태어난 일을 입력하세요 : ");
        int birthDay = sc.nextInt();

        Calendar cal = new GregorianCalendar(birthYear, birthMonth - 1, birthDay);
//        System.out.println(cal);
        char[] daysOfWeek = {'일','월','화','수','목','금','토'};

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
//        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
//        daysOfWeek[cal.get(Calendar.DAY_OF_WEEK) - 1];
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

//        System.out.println("당신의 생일은 " + year + "년 " + month + "월 " + dayOfMonth + "일 " + weekday + "요일입니다.");
    }
}
