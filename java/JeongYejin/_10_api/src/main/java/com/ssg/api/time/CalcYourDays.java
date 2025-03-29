package com.ssg.api.time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CalcYourDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("생일을 입력하세요 (ex.19990101) : ");
        String birthday = sc.next();
        LocalDate localDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDate localDate2 = LocalDate.now();
        System.out.println("태어난 지 " + ChronoUnit.DAYS.between(localDate, localDate2) + "일 되었습니다!");
    }
}
