package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 캘린더 객체에서 '월'에 대한 값을 넣을 때 주의
 * - 값을 넣을때는 1만큼 빼서 대입하고, 값을 출력 할 때는 1만큼 더해서 출력.
 */
public class App3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("년도 : ");
        int year = scanner.nextInt();
        System.out.println("월 : ");
        int month = scanner.nextInt();
        System.out.println("일 : ");
        int day = scanner.nextInt();
        Calendar cal = new GregorianCalendar(year,month - 1,day);
        int dayofweek = cal.get(Calendar.DAY_OF_WEEK);

        String weekday = switch (dayofweek){
            case 1 -> "일";
            case 2 -> "월";
            case 3 -> "화";
            case 4 -> "수";
            case 5 -> "목";
            case 6 -> "금";
            case 7 -> "토";
            default -> ""; //switch expression에서 default 구문은 필수.
        };
        System.out.println("당신의 생일은 " + cal.get(Calendar.YEAR)+ "년 "+cal.get(Calendar.MONTH) + 1 + "월 "+
                            cal.get(Calendar.DATE) + "일 "+ weekday + "요일입니다.");



    }
}
