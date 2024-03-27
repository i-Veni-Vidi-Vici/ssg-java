package com.ssg.api.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * <pre>
 *
 * [문제2]
 * 패키지 com.api.time.CalcDday.java
 * LocalDate 클래스를 이용해서 D-DAY계산기를 만드세요.
 * 사용자로 부터 D-day를 입력받고, 다음과 같이 출력하세요.
 *
 * ->  193일 남았습니다. (D-DAY 전)
 * ->  D-DAY입니다.(D-DAY)
 * ->  20일 지났습니다.(D-DAY가 지난 경우)
 *
 * </pre>
 *
 * @author shqkel1863
 */
public class CalcDday {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("D-Day를 입력하세요.\n년도(yyyy) : ");
        int yyyy = sc.nextInt();
        System.out.print("월 : ");
        int mm = sc.nextInt();
        System.out.print("일 : ");
        int dd = sc.nextInt();

        LocalDate today = LocalDate.now();
        LocalDate dday = LocalDate.of(yyyy, mm, dd);

        long diff = ChronoUnit.DAYS.between(today, dday);
//		System.out.println(diff);

        if (diff > 0)
            System.out.println("D-" + diff + "일 입니다.");
        else if (diff == 0)
            System.out.println("D-Day입니다");
        else
            System.out.println("D+" + (-diff) + "일 입니다."); // diff가 음수인 경우
    }
}
