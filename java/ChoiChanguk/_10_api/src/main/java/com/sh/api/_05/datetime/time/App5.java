package com.sh.api._05.datetime.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * <pre>
 * 1. 날짜/시간객체 -> 특정 형식 문자열 2024/03/27 2024년 3월 27일~~ 다른 형식들의 날짜
 * 2. 특정 형식 문자열 -> 날짜/시각객체(java)
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        // 1. 날짜/시간 출력
        LocalDate today=LocalDate.now();
        System.out.println(today);
        System.out.println(today);
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));//2024 03 24
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy/M/dd")));// 2024 3 24
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy년 M월 dd일")));// 2024 3 24


        LocalDate now=LocalDate.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd(E) hh:mm:ss")));

        //2. 문자열(날짜/시각) 데이터를 객체변환 (parsing)
        String data1="2024-01-01";

    }
}
