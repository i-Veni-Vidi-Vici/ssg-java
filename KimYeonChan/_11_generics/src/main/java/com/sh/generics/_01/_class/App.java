package com.sh.generics._01._class;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Generics
 * - 사전적 의미는 일반화이다.
 * - 자바에서 제네릭은 타입을 일반화한다는 의미, 타입을 제한하는 용도로 사용한다.
 * - 클래스 내부의 특정필드, 매개변수, 리턴 타입등을 제한할 목적으로 사용한다.
 * - 제네릭클래스, 제네릭메소드에 타입을 의미한 타입 변수를 사용한다.
 * - 제네릭프로그래밍은 데이터 형식에 의존하지 않고, 하나의 값이 여러 타입을 가질 수 있는 기술에 중점을 두고 있다.
 * - 재사용성으로 높이는 프로그래밍이다.
 */
public class App {
    public static void main(String[] args) {
        // 제네릭클래스의 객체화
        Box<Integer> intBox = new Box<Integer>();
        intBox.setValue(123); // Integer 가 아닌 타입은 사용할 수 없다.
        int i = intBox.getValue(); // Integer 이외의 타입을 반환할 수 없다.

        // jdk7 부터 타입추론을 통해 생성자쪽 타입은 생략 가능하다.
        Box<String> strBox = new Box<>();
        strBox.setValue("Zzz");
        System.out.println(strBox.getValue());

        // 타입제한을 사용하지 않는다면...
        Box box = new Box();
        // 메소드 호출시 모든 타입을 전달할 수 있어 제어하기 힘들다.
        box.setValue(true);
        box.setValue("qqq");
        box.setValue(123);
        box.setValue(LocalDateTime.now());
        // 리턴받은 값의 타입이 Object 이므로 다운캐스팅 이후 사용할 수 있다.
        LocalDateTime now = (LocalDateTime)box.getValue();
        System.out.println(now.format(DateTimeFormatter.BASIC_ISO_DATE));

    }
}
