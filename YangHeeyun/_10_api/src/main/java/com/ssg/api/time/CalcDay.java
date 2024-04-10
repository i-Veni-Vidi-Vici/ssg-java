package com.ssg.api.time;

/*
LocalDate클래스를 이용해서 D-DAY계산기를 만드세요.
출력예시
    193일 남았습니다.	(D-DAY 전)

    D-DAY입니다.	(D-DAY)

    20일 지났습니다.	(D-DAY가 지난 경우)
 */

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalcDay {
    public static void main(String[] args) {
        LocalDate dDay = LocalDate.of(2024,4,11);
        long diff = ChronoUnit.DAYS.between(LocalDate.now(),dDay);

        if(diff>0)
            System.out.println(diff +"일 남았습니다.");
        else if(diff == 0)
            System.out.println("D-DAY입니다.");
        else
            System.out.println(-diff + "일 지났습니다.");
    }
}
