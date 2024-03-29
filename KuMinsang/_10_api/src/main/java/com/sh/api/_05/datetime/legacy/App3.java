package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * <pre>
 *     사용자 생일을 입력받아서 Calendar 객체로 생성후 , 다음 형식으로 출력
 *     - 당신의 생일은 ?년 ?월?일 입니다
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        int year;
        int month;
        int day;
        Scanner sc = new Scanner(System.in);
        System.out.print("출생년도 : ");
        year = sc.nextInt();
        System.out.print("월 : ");
        month = sc.nextInt();
        System.out.print("일 : ");
        day = sc.nextInt();
        Calendar birthday = new GregorianCalendar(year, month - 1, day);

        //년,월,일,시,분,초 getter
        char[] daysOfWeek = {'일', '월', '화', '수', '목','금','토'};
        birthday.get(Calendar.YEAR);
        birthday.get(Calendar.MONTH);
        birthday.get(Calendar.DAY_OF_MONTH);
        int dayOfWeek = birthday.get(Calendar.DAY_OF_WEEK);//일(1)~토(7)
        System.out.println(birthday.get(Calendar.YEAR) + " " + (birthday.get(Calendar.MONTH)+1)+ " "+ birthday.get(Calendar.DAY_OF_MONTH)+ " "+daysOfWeek[birthday.get(Calendar.DAY_OF_WEEK)]);
    }


}
