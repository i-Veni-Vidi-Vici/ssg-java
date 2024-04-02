package com.sh.api._05.datetime.legacy.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * <pre>
 *
 *  java.time패키지의 클래스는 모두 불변 객체이다.
 *  - Date, Calendar는 모두 가변 객체이다 .
 *  - 멀티스레드 환경에서는 불변객체가 사용하기 안전하다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.hashCode());

        LocalDateTime localDateTime2 = localDateTime.plusMinutes(60); // 무조건 새 객체를 반환. 기존 객체는 변경하지 않는다.
        System.out.println(localDateTime2);
        System.out.println(localDateTime2.hashCode());

        LocalDateTime localDateTime3 = localDateTime.minus(1, ChronoUnit.DAYS);
        System.out.println(localDateTime3);
    }
}
