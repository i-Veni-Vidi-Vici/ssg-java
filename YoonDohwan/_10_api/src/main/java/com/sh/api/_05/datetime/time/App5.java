package com.sh.api._05.datetime.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 날짜/시간객체 -> 특정형식 문자열 2024/03/27, 2024월3월 27일, 03/27/2024
 */
public class App5 {
    public static void main(String[] args) {
        //1. 날짜/시간 출력
        LocalDate today = LocalDate.now();
        System.out.println(today); //2024-03-27
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));//2024/03/27
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy/M/d")));//2024/03/27
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd(E) hh:mm:ss")));

        //문자열(날짜/시각) 데이터를 객체변환 (parsing)
        String data1 = "2024-01-01";
        LocalDate date1 = LocalDate.parse(data1,DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println(date1);
        String data2 = "2024-01-02T03:04:05";
        LocalDateTime date2 = LocalDateTime.parse(data2, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        System.out.println(date2);

    }
}
