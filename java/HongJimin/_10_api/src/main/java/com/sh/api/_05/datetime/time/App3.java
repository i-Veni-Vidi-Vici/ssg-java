package com.sh.api._05.datetime.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * <pre>
 *   -java.time패키지의 클래스는 모두 불변객체이다
 *     - Date, Calendar는 모두 가변객체
 *     - 멀티쓰레드 환경에서는 불변객체가 사용하기 안전함
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime); //2024-03-27T12:49:32.691939200
        System.out.println(localDateTime.hashCode()); //1792661157

        LocalDateTime localDateTime2 = localDateTime.plusMinutes(60); //무조건 새 객체를 반환, 기존 객체는 변경하지 않음
        System.out.println(localDateTime2); //2024-03-27T15:06:14.293585600
        System.out.println(localDateTime); //2024-03-27T14:06:14.293585600
        System.out.println(localDateTime2.hashCode()); //-406537975

        LocalDateTime localDateTime3 = localDateTime.minus(1, ChronoUnit.DAYS);
        System.out.println(localDateTime3); //2024-03-26T14:08:18.218288100
    }
}
