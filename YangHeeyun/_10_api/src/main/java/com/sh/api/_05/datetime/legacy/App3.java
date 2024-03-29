package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * <pre>
 * 사용자 생일을 입력받아서 Calendar객체로 생성후, 다음 형식으로 출력
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("사용자 생일 입력 ");
        System.out.print("년도 입력 >");
        int year = sc.nextInt();
        System.out.print("달 입력 >");
        int month = sc.nextInt();
        System.out.print("일 입력 >");
        int dayOfMonth = sc.nextInt();

        Calendar birthday = new GregorianCalendar(year,month-1,dayOfMonth);
        char[] daysOfWeek = {'일', '월', '화', '수', '목', '금', '토'};

        System.out.printf("당신의 생일은 %d년 %d월 %d일 %s요일에 태어나셨어요",
                birthday.get(Calendar.YEAR),
                birthday.get(Calendar.MONTH),
                birthday.get(Calendar.DAY_OF_MONTH),
                daysOfWeek[birthday.get(Calendar.DAY_OF_WEEK) - 1]);

    }
}
