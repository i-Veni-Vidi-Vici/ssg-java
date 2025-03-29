package com.sh.api._05.datetime.legacy;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * <pre>
 * 사용자 생일을 입력받아서 Calendar 객체로 생성후, 다음 형식으로 출력
 * - 당신의 생일은 ?년 ?월 ?일입니다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("> 생일입력 (연도): ");
        int year = sc.nextInt();
        System.out.println("> 생일입력 (월): ");
        int month = sc.nextInt();
        System.out.println("> 생일입력 (일): ");
        int day = sc.nextInt();

        Calendar birth = new GregorianCalendar(year, month - 1, day);
        System.out.println(birth);
        int birthYear = birth.get(Calendar.YEAR);
        int birthMonth = birth.get(Calendar.MONTH);
        int birthDay = birth.get(Calendar.DAY_OF_MONTH);
        int birthDayOfWeek = birth.get(Calendar.DAY_OF_WEEK);

        String birthWeek = switch (birthDayOfWeek){
            case 1 -> "일";
            case 2 -> "월";
            case 3 -> "화";
            case 4 -> "수";
            case 5 -> "목";
            case 6 -> "금";
            case 7 -> "토";
            default -> "";
        };

        System.out.printf("당신의 생일은 %d년 %d월 %d일 %s요일입니다." , birthYear, (birthMonth + 1), birthDay,birthWeek);
    }
}
