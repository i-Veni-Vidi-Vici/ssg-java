package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * <pre>
 * 사용자 생일을 입력받아서 Calendar객체로 생성 후, 다음 형식으로 출력
 * - 당신의 생일은 ?년 ?월 ?일 입니다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("연도는 : ");
        int year = sc.nextInt();
        System.out.print("월은 : ");
        int month = sc.nextInt();
        System.out.print("일은 : ");
        int dayOfMonth = sc.nextInt();

        Calendar userBirth = new GregorianCalendar(year,month -1 ,dayOfMonth);
        year = userBirth.get(Calendar.YEAR);
        month = userBirth.get(Calendar.MONTH);
        dayOfMonth = userBirth.get(Calendar.DAY_OF_MONTH);


        String dayOfWeek = switch (userBirth.get(Calendar.DAY_OF_WEEK)){
            case 1 -> "일";
            case 2 -> "월";
            case 3 -> "화";
            case 4 -> "수";
            case 5 -> "목";
            case 6 -> "금";
            case 7 -> "토";
            default -> ""; // switch expression에서 default구문은 필수이다.
        };

//        char[] dayOfWeek ={'일','월','화','수','목','금','토'};
        System.out.println("당신의 생일은 " + year + "년 " + (month+1) + "월 " + dayOfMonth + "일 " +dayOfWeek + "요일 입니다.");

    }
}
