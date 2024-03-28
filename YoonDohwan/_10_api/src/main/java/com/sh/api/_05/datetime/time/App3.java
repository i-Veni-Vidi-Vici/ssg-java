package com.sh.api._05.datetime.time;

import java.time.LocalDateTime;

/**
 * java.time패키지의 클래스는 모두 불변객체이다.
 * -Date,Calendar는 모두 가변객체이다.
 *
 */
public class App3 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.hashCode());

        LocalDateTime localDateTime2 = localDateTime.plusMinutes(60);
        System.out.println(localDateTime2);
        System.out.println(localDateTime2.hashCode());

    }

}
