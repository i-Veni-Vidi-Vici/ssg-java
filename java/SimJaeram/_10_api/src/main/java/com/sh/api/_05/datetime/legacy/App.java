package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * <pre>
 *     사용자의 생일을 입력 받아서 Calendar 객체로 생성 후, 다음 형식으로 출력
 *     - 당신의 생일은 ?년 ?월 ?일입니다.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("당신의 생일을 입력하세요.");
        System.out.print("년도 입력 >> ");
        int year = sc.nextInt();
        System.out.print("월 입력 >> ");
        int month = sc.nextInt();
        System.out.print("일 입력 >> ");
        int day = sc.nextInt();

        Calendar birthday = new GregorianCalendar(year, month - 1, day);
        System.out.println(birthday);

        char[] daysOfWeek = {'일', '월', '화', '수', '목', '금','토'};

        // 출력
        System.out.printf("당신의 생일은 %d년 %d월 %d일 %s요일입니다.", birthday.get(Calendar.YEAR), (birthday.get(Calendar.MONTH) + 1), birthday.get(Calendar.DAY_OF_MONTH), daysOfWeek[birthday.get(Calendar.DAY_OF_WEEK) - 1]);
    }
}
