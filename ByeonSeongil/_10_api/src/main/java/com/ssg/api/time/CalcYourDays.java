package com.ssg.api.time;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class CalcYourDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("생년:");
        int year = sc.nextInt();

        System.out.print("생월:");
        int month = sc.nextInt();

        System.out.print("생일:");
        int day = sc.nextInt();
        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(year, month, day);

        Period period = Period.between(localDate2, localDate);

        System.out.println(period.getDays());

    }

}
