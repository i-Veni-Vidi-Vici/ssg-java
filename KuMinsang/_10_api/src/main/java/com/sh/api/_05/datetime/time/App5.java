package com.sh.api._05.datetime.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <pre>
 *     날짜/시간객체(java) -> 특정 형식 문자열   2024/03/27, 2024월 3월 27일, 03/27/2024, 27/03/2024
 *     특정 형식 문자열 -> 특정/시각개체(java)
 * </pre>
 */
public class App5 {
    public static void main(String[] args) {
        //1.날짜 /시간 출력
        LocalDate today = LocalDate.now();
        System.out.println(today); //2024-03-27
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));    // 2024/03/27 월이 대문자 M인것을 기억할것
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy/M/d")));  //2024/3/27
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy년 M월 d일")));   //2024년 3월 27일

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss"))); //2024/03/27 02:34:53
        System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy/MM/dd(E) HH:mm:ss")));  //2024/03/27(수) 14:34:53

        //2. 문자열(날짜/시각) 데이터를 객체변환 (parsing)
        String data1 = "2024-01-02";
        LocalDate date1 = LocalDate.parse(data1); //형식 생략 가능 표준형식 (yyyy-MM-dd)
        System.out.println(data1);
        date1 = LocalDate.parse(data1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));    //문자열 데이터와 데이터의 형식을 인자로 넣음
        System.out.println(data1);  //2024-01-02

        String data2 = "2024-01-02T03:04:05";
        LocalDateTime date2 = LocalDateTime.parse(data2, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        //date2 = LocalDateTime.parse(data2, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(date2);

    }
}
