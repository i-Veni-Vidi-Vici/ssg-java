package com.ssg.api.time;

import java.time.LocalDate;

public class TodayTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();

        int value = localDate.getDayOfWeek().getValue();
        String dayOfWeek = switch (value) {
            case 1 -> "월";
            case 2 -> "화";
            case 3 -> "수";
            case 4 -> "목";
            case 5 -> "금";
            case 6 -> "토";
            case 7 -> "일";
            default -> "";
        };

        System.out.println(localDate.getMonthValue());
        System.out.printf("오늘은 %d년 %s월 %d일 %s요일입니다.", localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth(), dayOfWeek);
    }
}