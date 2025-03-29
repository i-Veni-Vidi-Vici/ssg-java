package com.sh.api._05.datetime.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <pre>
 *     1. 날짜/시간 객체(java) -> 특정 형식 문자열로 바꾸어 출력    ex) 2024/03/27, 2024년 3월 27일, 03/27/2024, 27/03/2024
 *     2. 특정 형식 문자열 -> 날짜/시간 객체(java)
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        // 1. 날짜/시간 출력
        LocalDate today = LocalDate.now();
        System.out.println(today);                                                      // 2024-03-27
        System.out.println(today);                                                      // 2024-03-27
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy/M/d")));      // 2024/03/27
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy년 M월 d일"))); // 2024년 3월 27일

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss")));
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd(E) hh:mm:ss"))); // 요일은 E로 나타낸다.
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd(E) HH:mm:ss"))); // 대문자 HH는 24시간, 소문자 hh는 12시간

        // 2. 문자열 날짜/시각 데이터를 객체 변환 (parsing)
        String data1 = "2024-01-01";    // 날짜 표기 표준 형식(yyyy-MM-dd) 이므로 format하지 않아도 됨
//        LocalDate date1 = LocalDate.parse(data1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate date1 = LocalDate.parse(data1);
        System.out.println(date1);

        String data2 = "2024-01-02T03:04:05";
        LocalDateTime date2 = LocalDateTime.parse(data2, DateTimeFormatter.ofPattern(("yyyy-MM-dd'T'HH:mm:ss")));
//        LocalDateTime date2 = LocalDateTime.parse(data2, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(date2);
    }
}
