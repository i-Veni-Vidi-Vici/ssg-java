package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * <pre>
 * 사용자 생일을 입력받아서 Calendar객체로 생성후, 다음 형식으로 출력
 * - 당신의 생일은 ?년 ?월 ?일입니다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("> 태어난 년 : ");
        int year = sc.nextInt();
        System.out.print("> 태어난 월 : ");
        int month = sc.nextInt();
        System.out.print("> 태어난 일 : ");
        int day = sc.nextInt();
        Calendar birth = new GregorianCalendar(year, month - 1, day);
        int newYear = birth.get(Calendar.YEAR);
        int newMonth = birth.get(Calendar.MONTH);
        int newDay = birth.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = birth.get(Calendar.DAY_OF_WEEK);
        String dayWeek = switch(dayOfWeek) {
            case 1 -> "일";
            case 2 -> "월";
            case 3 -> "화";
            case 4 -> "수";
            case 5 -> "목";
            case 6 -> "금";
            case 7 -> "토";
            default -> "";
        };
        System.out.println("당신의 생일은 " + newYear + "년 " + (newMonth + 1) + "월 " + newDay + "일(" + dayWeek + ")입니다.");


        // 강사님 코드
//        Scanner sc = new Scanner(System.in);
//        System.out.println("생년 입력 : ");
//        int year = sc.nextInt();
//        System.out.println("생월 입력 : ");
//        int month = sc.nextInt();
//        System.out.println("생일 입력 : ");
//        int day = sc.nextInt();
//
//        Calendar birthday = new GregorianCalendar(year, month - 1, day);
//        System.out.println(birthday);
//
//        char[] daysOfWeek = {'일', '월', '화', '수', '목', '금', '토'}; // 일(0) ~ 토(6) 배열인덱스
//        // 일(1) ~ 토(7)
//        System.out.printf("당신은 %d년 %d월 %d일 %s요일에 태어나셨네요...",
//                birthday.get(Calendar.YEAR),
//                birthday.get(Calendar.MONTH) + 1,
//                birthday.get(Calendar.DAY_OF_MONTH),
//                daysOfWeek[birthday.get(Calendar.DAY_OF_WEEK) - 1]);
    }
}
