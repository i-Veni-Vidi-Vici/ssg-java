package com.sh.api._05.datetime.lagacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * <pre>
 * 사용자 생일을 입력받아서 Calendar 객체로 생성 훈
 * - 당신의 생일은 ?년 ?월? ?이 입니다
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Calendar cal= GregorianCalendar.getInstance();
        Scanner sc = new Scanner(System.in);
        System.out.printf("태어난 년도 : ");
        int year=cal.get(sc.nextInt());
        System.out.printf("태어난 월 : ");
        int month=cal.get(sc.nextInt());
        System.out.printf("태어난 날 : ");
        int day=cal.get(sc.nextInt());
//        int hour=cal.get(sc.nextInt());
//        int min=cal.get(sc.nextInt());
//        int sec=cal.get(sc.nextInt());


        System.out.printf("%d년, %d월, %d요일",year,month-1,day);
    }



}
