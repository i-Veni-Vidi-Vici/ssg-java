package com.sh.api._05.datetime.time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * <pre>
 *     java.time 패키지의 클래스는 모두 불변 객체이다.
 *     - Date, Clendar는 모두 가변 객체이다. 객체를 생성하고 그 안에 필드 값을 변경할 수 있다.
 *     // 이 경우 멀티 스레드 환경에서 문제가 발생될 수 있으므로, 불변 객체로 만들고 값 변경이 필요한 경우 새로운 객체를 생성하는 방식을 사용한다.
 *     - 멀티 스레드 환경에서는 불변객체가 사용하기 안전하다.
 * </pre>
 */
public class App3 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);                      // 2024-03-27T12:49:22.086339
        System.out.println(localDateTime.hashCode());           // -218281832

        LocalDateTime localDateTime2 = localDateTime.plusMinutes(60);   // 무조건 새 객체를 반환, 기존 객체를 변경하지 않는다.
        System.out.println(localDateTime);                      // 2024-03-27T12:49:22.086339
        System.out.println(localDateTime2);                      // 2024-03-27T12:49:22.086339
        System.out.println(localDateTime.hashCode());           // -218281832

        LocalDateTime localDateTime3 = localDateTime.minus(1, ChronoUnit.DAYS);    // 하루다. 한시간이다.
        System.out.println(localDateTime3);                     // 2024-03-26T14:08:16.812850500

    }
}
