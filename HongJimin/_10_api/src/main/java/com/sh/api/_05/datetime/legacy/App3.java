package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * <pre>
 *     사용자 생일을 입력받아 Calendar 객체로 생성후, 다음 형식으로 출력
 *     - 당신의 생일은 ?년 ?월 ?일 입니다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("당신의 생일은 몇 년입니까? : ");
        int year = sc.nextInt();
        System.out.print("당신의 생일은 몇 월입니까? : ");
        int month = sc.nextInt();
        System.out.print("당신의 생일은 몇 일입니까? : ");
        int day = sc.nextInt();

        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        System.out.println(calendar);

        char[] daysOfWeek = {'일', '월', '화', '수', '목', '금', '토'};
        System.out.printf("당신은 %d년 %d월 %d일 %s요일 생일입니다🎉",
                calendar.get(Calendar.YEAR) ,
                calendar.get(Calendar.MONTH) +1,
                calendar.get(Calendar.DAY_OF_MONTH) ,
                daysOfWeek[calendar.get(Calendar.DAY_OF_WEEK)-1]);
    }
}
