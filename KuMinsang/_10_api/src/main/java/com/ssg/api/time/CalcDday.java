package com.ssg.api.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CalcDday {
    public String print() {
        Scanner sc = new Scanner(System.in);
        System.out.print("D-day를 입력하세요(연 월 일) : ");
        LocalDate dDay = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
        LocalDate now = LocalDate.now();
        int day = (int) ChronoUnit.DAYS.between(now, dDay);
        if(day>0){
            return String.format("%d 일 남았습니다",day);
        }else if(day == 0){
            return String.format("D-day 입니다",day);
        }else{
            return String.format("%d 일 지났습니다",day*-1);
        }
    }
}
