package com.ssg.api.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/*
사용자로부터 생일(년, 월, 일)을 입력받고, 오늘이 태어난지 몇일 되었는지 출력하세요.
 */

public class CalYourDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("생일 입력");
        System.out.print("년도 > ");
        int year = sc.nextInt();
        System.out.print("월 > ");
        int month = sc.nextInt();
        System.out.print("일 > ");
        int day = sc.nextInt();

        LocalDate birth = LocalDate.of(year,month,day);
        System.out.println("입력한 생일 " + birth);
        LocalDate now = LocalDate.now();

        System.out.println("오늘 " + now + "로 부터 태어난지 " + ChronoUnit.DAYS.between(birth,now) + "일 되었습니다.");
    }
}
