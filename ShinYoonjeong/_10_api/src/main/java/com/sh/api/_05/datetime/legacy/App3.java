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
        Calendar cal = Calendar.getInstance();
        System.out.println("당신의 생일을 입력하시오.");
        System.out.println("년도 : ");
        int year = sc.nextInt();
        System.out.println("월 : ");
        int month = sc.nextInt();
        System.out.println("일 : ");
        int day = sc.nextInt();
        Calendar bday = new GregorianCalendar(year, month-1,day);
        int dayofweek = bday.get(Calendar.DAY_OF_WEEK);
        System.out.printf("%d %d %d %d %s",
                bday.get(Calendar.YEAR), bday.get(Calendar.MONTH)+1,bday.get(Calendar.DAY_OF_MONTH), bday.get(Calendar.DAY_OF_WEEK));



    }
}
