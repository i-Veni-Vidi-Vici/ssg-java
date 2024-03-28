package com.sh.api._05.datetime.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 1. 날짜/시간 객체 -> 특정 형식 문자열 2024/03/27, 2024년 3월 27일
 * 2. 특정 형식 문자열 -> 날짜/시각객체 (java)
 */
public class App5 {
    public static void main(String[] args) {
        // 1. 날짜/시간 출력
        LocalDate today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy/MM/d")));
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy/M/d")));
        System.out.println(today.format(DateTimeFormatter.ofPattern("yy/M/d")));
        System.out.println(today.format(DateTimeFormatter.ofPattern("yy년 M월 d일")));

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd/(E)'T'hh:mm:ss")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd/(E)'T'HH:mm:ss")));

        String data1 = "2024-01-01";
        // LocalDate date1 = LocalDate.parse(data1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate date1 = LocalDate.parse(data1);
        System.out.println(date1);

        String data2 = "2024-01-02T03:04:05";
        LocalDateTime date2 = LocalDateTime.parse(data2, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        System.out.println(date2);
    }

}
