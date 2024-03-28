package com.ssg.api.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodayTest {
    public static void main(String[] args) {
        //오늘 날짜를 오늘은~년~월~5일 목요일입니다
        LocalDate localDate=LocalDate.now();
        String day=LocalDate.parse(LocalDate.now().toString()).getDayOfWeek().toString();
        System.out.print(localDate.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 ")));

        switch (day)
        {
            case "SUNDAY":
                System.out.println("일요일입니다");
                break;
            case "MONDAY":
                System.out.println("월요일입니다");
                break;
            case "TUESDAY":
                System.out.println("화요일입니다");
                break;
            case "WEDNESDAY":
                System.out.println("목요일입니다");
                break;
            case "FRIDAY":
                System.out.println("금요일입니다");
                break;
            case "SATURDAY":
                System.out.println("토요일입니다");
                break;
        }

    }


}
