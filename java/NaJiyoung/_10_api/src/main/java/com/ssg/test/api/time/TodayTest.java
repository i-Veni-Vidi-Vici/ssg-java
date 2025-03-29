package com.ssg.test.api.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodayTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        String today = now.format(DateTimeFormatter.ofPattern("yyyy년 M월 d일 E요일"));

        System.out.println("오늘은 " + today + "입니다.");
    }
}
