package com.sh.api._05.datetime.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * <pre>
 * java.time 패키지의 클래스는 모두 불변객체
 * - Date, Calendar는 모두 가변객체
 * - 멀티스레드 환경에서는 불변객체가 사용하기에 안전함
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime); // 2024-03-27T12:49:25.334211800
        System.out.println(localDateTime.hashCode()); // -1268263425

        LocalDateTime localDateTime1 = localDateTime.plusMinutes(60); // 무조건 새객체 반환, 기존 객체는 변경하지 않음
        System.out.println(localDateTime);
        System.out.println(localDateTime.hashCode());

        LocalDateTime localDateTime2 = localDateTime.minus(1, ChronoUnit.DAYS); // 앞에 쓴 숫자가 뭘 의미하는지 ChronoUnit으로 정함
        System.out.println(localDateTime2); //2024-03-26T14:08:23.384866100 (하루 전의 날짜/시간)
    }
}
