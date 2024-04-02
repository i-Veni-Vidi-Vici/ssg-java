package com.sh.api._05.datetime.time;

import java.time.LocalDateTime;

/**
 * <pre>
 * java.time패키지의 클래스는 모두 불볍객체이다.
 * - Date, Calendar는 모두 가변객체이다
 * - 멀티쓰레드 환경에서는 불변객체가 사용하기 안전하다
 * </pre>
 */

public class App3 {
    public static void main(String[] args) {
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime.hashCode());

        localDateTime.plusMinutes(60);// 무조건 새객체를 반환. 기존객체는 변경하지 않는다
        System.out.println(localDateTime);
        System.out.println(localDateTime.hashCode());


    }
}
