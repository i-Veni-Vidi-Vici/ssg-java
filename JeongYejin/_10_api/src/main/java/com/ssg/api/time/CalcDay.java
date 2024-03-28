package com.ssg.api.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CalcDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalDate localDate = LocalDate.now();
        System.out.print("D-DAY 를 입력하세요 (ex.19990101) : ");
        String theDay = sc.next();
        LocalDate dDay = LocalDate.parse(theDay, DateTimeFormatter.ofPattern("yyyyMMdd"));
        long difference = ChronoUnit.DAYS.between(localDate, dDay);
        if (difference == 0) {
            System.out.println("D-DAY입니다.");
        } else if (difference > 0) {
            System.out.printf("%d일 남았습니다.", difference);
        } else {
            System.out.printf("%d일 지났습니다.", difference * (-1));
        }
    }
}
