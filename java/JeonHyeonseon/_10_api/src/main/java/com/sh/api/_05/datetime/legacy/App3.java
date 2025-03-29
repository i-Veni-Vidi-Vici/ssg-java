package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * <pre>
 * 사용자 생일을 입력받아서 Calendar객체를 생성후, 다음 형식으로 출력하기
 * - 당신의 생일은 ?년 ?월 ?일입니다.
 *
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("생년입력 : ");
        int year = sc.nextInt();
        System.out.print("생월입력 : ");
        int month = sc.nextInt();
        System.out.print("생일입력 : ");
        int day = sc.nextInt();

        Calendar birthday = new GregorianCalendar(year, month-1, day); // Calendar 객체 생성
        System.out.println(birthday);

//        System.out.println("당신은 %d년 %d월 %d일 %s요일에 태어났어요",
//                birthday.get(Calendar.YEAR),
//                birthday.get(Calendar.MONTH) + 1,
//                birthday.get(Calendar.DAY_OF_MONTH),
//                birthday.get(Calendar.DAY_OF_WEEK) - 1]);

        int dayOfWeek = birthday.get(Calendar.DAY_OF_WEEK);

        String weekday = switch(dayOfWeek) {
            case 1 -> "일요일";
            case 2 -> "월요일";
            case 3 -> "화요일";
            case 4 -> "수요일";
            case 5 -> "목요일";
            case 6 -> "금요일";
            case 7 -> "토요일";
            default -> "";
        };

        System.out.print("당신의 생일은 " + year + "년 " + month + "월" + day + "일" + dayOfWeek + "입니다.");

    }
}
