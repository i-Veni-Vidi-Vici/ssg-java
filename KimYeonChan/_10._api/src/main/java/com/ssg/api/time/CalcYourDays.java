package com.ssg.api.time;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CalcYourDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("생년월일을 입력해주세요...");
        System.out.print("년도: ");
        int year = sc.nextInt();
        System.out.print("월: ");
        int month = sc.nextInt();
        System.out.print("일: ");
        int dayOfMonth = sc.nextInt();

        LocalDate birthDate = LocalDate.of(year, month, dayOfMonth);
        long days = ChronoUnit.DAYS.between(birthDate, LocalDate.now());
        System.out.println("태어난지 " + days + "일 되었습니다.");
    }
}
