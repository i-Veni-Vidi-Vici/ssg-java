package com.sh.api._05.datetime.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * <pre>
 * java.time패키지의 클래스는 모두 불변객체이다.
 * - Date, Calendar는 모두 가변객체이다.
 * - 멀티스레드 환경에서는 불변객체가 사용하기 안전하다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.hashCode());

        // 무조건 새객체를 반환, 기존 객체는 변경하지 않음
        LocalDateTime localDateTime2 = localDateTime.plusMinutes(60);
        System.out.println(localDateTime2);
        System.out.println(localDateTime2.hashCode());

        LocalDateTime localDateTime3 = localDateTime.minus(1, ChronoUnit.DAYS);
        System.out.println(localDateTime3);
        System.out.println(localDateTime3.hashCode());

    }
}
