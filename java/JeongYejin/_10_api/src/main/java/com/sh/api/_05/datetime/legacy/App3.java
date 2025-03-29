package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * <pre>
 * 사용자 생일을 입력받아서 Calendar 객체로 생성 후, 다음 형식으로 출력
 * - 당신의 생일은 ? 년 ? 월 ? 일 입니다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("태어난 연도 : ");
        int year = sc.nextInt();
        System.out.print("태어난 달 : ");
        int month = sc.nextInt();
        System.out.print("태어난 날짜 : ");
        int day = sc.nextInt();
        Calendar sometime = new GregorianCalendar(year, month - 1, day);
        System.out.println(sometime);
        int dayOfWeek = sometime.get(Calendar.DAY_OF_WEEK);

//        String weekday = switch (dayOfWeek) {
//            case 1 -> "일";
//            case 2 -> "월";
//            case 3 -> "화";
//            case 4 -> "수";
//            case 5 -> "목";
//            case 6 -> "금";
//            case 7 -> "토";
//            default -> "";
//        };

        System.out.println(sometime.get(Calendar.DAY_OF_WEEK) - 1);
        char[] daysOfWeek = {'일', '월', '화', '수', '목', '금', '토'};
        // 0 1 2 3
        char weekday = daysOfWeek[dayOfWeek - 1];

        System.out.printf("당신의 생일은 %d년 %d월 %d일 %s요일입니다.", sometime.get(Calendar.YEAR), sometime.get(Calendar.MONTH) + 1, sometime.get(Calendar.DAY_OF_MONTH), weekday);
    }
}
