package com.ssg.api.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * [문제1]
 * 패키지 com.api.time.CalcYourDays.java
 * 사용자로부터 생일(년, 월, 일)을 입력받고, 오늘이 태어난지 몇일째 되었는지 출력하세요.
 *
 * @author shqkel1863
 */
public class CalcYourDays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("생일을 입력하세요.\n년도(yyyy) : ");
        int yyyy = sc.nextInt();
        System.out.print("월 : ");
        int mm = sc.nextInt();
        System.out.print("일 : ");
        int dd = sc.nextInt();

        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(yyyy, mm, dd);

        long diff = ChronoUnit.DAYS.between(birthday, today); // 몇일차를 표현.
        System.out.println("오늘이 태어난지 " + (diff + 1) + "일째입니다.");
    }
}
