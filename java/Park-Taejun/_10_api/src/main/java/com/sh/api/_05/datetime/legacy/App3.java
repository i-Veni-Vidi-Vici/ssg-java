package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * <pre>
 * 사용자 생일을 입력받아서 Calendar 객체로 생성 후, 다음 형식으로 출력
 * - 당신의 생일은 ?년 ?월 ?일 입니다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.println("생년 입력 : ");
        int year = sc.nextInt();

        System.out.println("생월 입력 : ");
        int month = sc.nextInt();

        System.out.println("생일 입력 : ");
        int day = sc.nextInt();

        Calendar birthday = new GregorianCalendar(year, month - 1, day);
        System.out.println(birthday);

        char[] daysOfWeek = {'일', '월', '화', '수', '목', '금', '토'};
        System.out.printf("당신은 %d년 %d월 %d일 %d요일에 태어나셨네요 ");
//        birthday.get(Calendar.YEAR),
//        birthday.get(Calendar.MONTH) + 1
//        birthday.get(Calendar.DAY_OF_MONTH)







    }
}
