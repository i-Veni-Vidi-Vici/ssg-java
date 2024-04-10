package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * <pre>
 * 사용자 생일을 입력받아서 Calendar객체로 생성후, 다음 형식으로 출력
 * - 당신의 생일은 ?년?월??일 ??요일 입니다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("시용자 생일 입력");
        System.out.print("년도 입력 : ");
        int year = sc.nextInt();
        System.out.print("월 입력 : ");
        int month = sc.nextInt();
        System.out.print("일 입력 : ");
        int dayofMonth = sc.nextInt();

        Calendar birthday =  new GregorianCalendar(year, month-1, dayofMonth);
        char[] daysofWeek = {'일', '월', '화', '수', '목', '금', '토'};

        System.out.printf("당신의 생일은 %d년 %d월 %d일 %s요일에 태어나셨어요",
            birthday.get(Calendar.YEAR),
            birthday.get(Calendar.MONTH)+1,
            birthday.get(Calendar.DAY_OF_MONTH),
            daysofWeek[birthday.get(Calendar.DAY_OF_WEEK)]-1);
        // 당신의 생일은 1999년 10월 4일 금요일에 태어나셨어요
    }
}
