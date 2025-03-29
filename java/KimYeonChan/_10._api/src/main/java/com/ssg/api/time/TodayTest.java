package com.ssg.api.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TodayTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today.format(DateTimeFormatter.ofPattern("오늘은 yyyy년 M월 d일 E요일입니다.")));
    }
}
