package com.sh.api._05.datetime.time;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDateTime;

/**
 * <pre>
 *     java.time패키지의 클래스는 모두 불변객체이다.
 *     - Date, Calendar는 모두 가변객체이다
 *     - 멀티스레드 환경에서는 불변객체가 안전하다
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);  //2024-03-27T12:49:43.076677200
        System.out.println(localDateTime.hashCode());   //-706859893

        LocalDateTime localDateTime2 = localDateTime.plusMinutes(60);  //무조건 새 객체 반환, 기존격체는 반환하지 않는다
        System.out.println(localDateTime);  //2024-03-27T12:49:43.076677200
        System.out.println(localDateTime.hashCode());   //-706859893
    }
}
