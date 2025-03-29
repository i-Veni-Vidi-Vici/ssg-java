package com.ssg.api.time;

import java.time.LocalDate;
import java.util.GregorianCalendar;

public class TodayTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        String today = localDate.toString();
        String year = today.substring(0, 4);
        String month = Integer.parseInt(today.substring(5, 7)) > 9 ? today.substring(5, 7) : today.substring(6, 7);
        String day = Integer.parseInt(today.substring(8, 10)) > 9 ? today.substring(8, 10) : today.substring(9, 10);
        String dayOfWeek = switch(localDate.getDayOfWeek().getValue()) {
            case 0 -> "일요일";
            case 1 -> "월요일";
            case 2 -> "화요일";
            case 3 -> "수요일";
            case 4 -> "목요일";
            case 5 -> "금요일";
            case 6 -> "토요일";
            default -> "";
        };
        System.out.println("오늘은 " + year + "년 " + month + "월 " + day + "일 " + dayOfWeek + "입니다.");
    }
}
