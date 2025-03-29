package com.sh.api._05.datetime.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * <pre>
 * java.time 패키지의 클래스는 모두 불변객체이다.
 * - Date, Calendar는 모두 가변객체
 * - 멀티스레스 환경에서는 불변객체가 사용하기 안전하다.
 * </pre>
 */

public class App3 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.hashCode());

        LocalDateTime localDateTime2 = localDateTime.plusMinutes(60); // 무조건 새 객체 반환. 기존객체 변경 X
        System.out.println(localDateTime2); //2024-03-27T15:02:54.417495300
        System.out.println(localDateTime); // 2024-03-27T14:02:54.417495300
        System.out.println(localDateTime.hashCode());

        LocalDateTime localDateTime3 = localDateTime.minus(1, ChronoUnit.DAYS);
        System.out.println(localDateTime3); // 2024-03-26T14:02:54.417495300



    }
}
