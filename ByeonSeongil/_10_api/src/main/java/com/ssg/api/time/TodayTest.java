package com.ssg.api.time;

import java.time.LocalDate;

public class TodayTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        String dayOfWeek = switch (localDate.getMonth().getValue()) {
            case 1 -> "월";
            case 2 -> "화";
            case 3 -> "수";
            case 4 -> "목";
            case 5 -> "금";
            case 6 -> "토";
            case 7 -> "일";
            default -> "";
        };
        System.out.println("오늘은"+ localDate.getYear()+ "년"+ localDate.getMonth().getValue() + "월"+ localDate.getDayOfMonth()+ "일"
        +dayOfWeek+ "요일입니다.");
    }
}
