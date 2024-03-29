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
//        Scanner sc = new Scanner(System.in);
//        System.out.print("생년 입력:");
//        int year = sc.nextInt();
//        System.out.print("생월 입력:");
//        int month = sc.nextInt();
//        System.out.print("생일 입력 :");
//        int day = sc.nextInt();

//        char[] daysOfWeek = {'일', '월', '화', '수', '목', '금', '토'};
//        Calendar calendar = new GregorianCalendar(year,month-1,day);
//        System.out.println(calendar);
//        System.out.printf("당신은 %d년 %d월 %d일 %s요일에 태어나셨네요...",
//                calendar.get(Calendar.YEAR),
//                calendar.get(Calendar.MONTH) + 1,
//                calendar.get(Calendar.DAY_OF_MONTH),
//                daysOfWeek[calendar.get(Calendar.DAY_OF_WEEK) - 1]
//        );

        // 날짜 차이 (long타입으로 변환)
        // 월(d-5) 토(d-day)
        Calendar today = new GregorianCalendar();
        Calendar thisWeekend = new GregorianCalendar(2024, 3 - 1, 30);
//        long diff = thisWeekend.get(Calendar.DAY_OF_MONTH)- today.get(Calendar.DAY_OF_MONTH) ;
//        System.out.println(diff);

        // (미래 long - 과거long) /1000 /60/60/24 -> 일
        double diff = thisWeekend.getTimeInMillis() - today.getTimeInMillis();
        System.out.println(diff);
        diff = diff / 1000 / 60 / 60 / 24;
        System.out.println(diff);
        diff = Math.ceil(diff);
        System.out.println("주말은"+ (int)diff +"일 남았습니다.");

    }
}
