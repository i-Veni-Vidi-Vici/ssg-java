package com.sh.api._05.datetime.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * <pre>
 * java.time패키지의 클래스는 모두 불변객체이다.
 * - Date,Calendar는 모두 가변객체
 *
 * </pre>
 *
 */


public class App3 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.hashCode());

//        localDateTime2 = localDateTime.plusMinutes(60); // 무조건 새객체를 반환, 기존객체는 변경하지 않는다.
        System.out.println(localDateTime); // 2024-03-27T14:08:21.684864600
        System.out.println(localDateTime.hashCode()); // 2028415176

        System.out.println(localDateTime.hashCode()); // 2028415176

        LocalDateTime localDataTime3 = localDateTime.minus(1, ChronoUnit.DAYS);// 하루
        System.out.println(localDataTime3); // 2024-03-26T14:08:21.684864600



    }
}
