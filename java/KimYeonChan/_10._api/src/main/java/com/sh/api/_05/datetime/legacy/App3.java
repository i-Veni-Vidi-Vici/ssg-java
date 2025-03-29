package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * 사용자의 생일을 입력 받아서 Calendar 객체로 생성 후, 다음 형식으로 출력
 * - 당신의 생일은 ?년 ?월 ?일입니다.
 */
public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("생년월일을 입력해주세요...");
        System.out.print("년: ");
        int year = sc.nextInt();
        System.out.print("월: ");
        int month = sc.nextInt();
        System.out.print("일: ");
        int dayOfMonth = sc.nextInt();
        Calendar birthday = new GregorianCalendar(year, month - 1, dayOfMonth);
        String dayOfWeek = switch (birthday.get(Calendar.DAY_OF_WEEK)){
            case 1 -> "일";
            case 2 -> "월";
            case 3 -> "화";
            case 4 -> "수";
            case 5 -> "목";
            case 6 -> "금";
            case 7 -> "토";
            default -> "";
        };
        System.out.printf("당신의 생일은 %d년 %d월 %d일 %s요일 입니다.\n", birthday.get(Calendar.YEAR), birthday.get(Calendar.MONTH) + 1, birthday.get(Calendar.DAY_OF_MONTH), dayOfWeek);
    }
}
