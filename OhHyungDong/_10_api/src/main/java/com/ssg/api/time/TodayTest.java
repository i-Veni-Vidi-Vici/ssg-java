package com.ssg.api.time;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class TodayTest
{
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        int dayOfMonth = localDate.getDayOfMonth();
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int value = localDate.getDayOfWeek().getValue();

        String dayofweek = switch (value){
                case 1 -> "월";
                case 2 -> "화";
                case 3 -> "수";
                case 4 -> "목";
                case 5 -> "금";
                case 6 -> "토";
                case 7 -> "일";
                default -> "";
        };


        System.out.println("오늘은 " + year + "년 " + month + "월 " + dayOfMonth +"일 "+ dayofweek + "요일입니다.");
    }
}
