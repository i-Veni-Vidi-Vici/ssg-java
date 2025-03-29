package com.sh.generics._01._class;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <pre>
 * Generics
 * - 사전적의미는 일반화이다.
 * -자바에서 제네릭은 타입을 일반화한다는 의미이다. 타입을 제한하는 용도로 사용하고 있음
 *
 * -클래스 내부의 특정필드, 매개변수, 리턴타입등을 제한할 목적으로 사용한다.
 * - 제네릭클래스, 제네릭메소에 타입을 의미한 타입변수를 사용한다.
 *
 * - 제네릭프로그래밍은 데이터 형식에 의존하지 않고, 하나의 값이 여러타입을 가질 수 있는 기술에 중점을 두고 있다.
 *   재사요성을 높이는 프로그래밍 방식이다
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 제네릭클래스의 객체화

        Box <Integer> intBox = new Box<Integer>();
        intBox.setValue(123);
//        intbox.setValue("ㅋㅋㅋㅋㅋㅋㅋㅋ"); //컴파일 오류 남 , 요구된건 인티전데 string 줌 Integer가 아닌 타입은 사용 불가능 함.
        Integer value = intBox.getValue(); // Integer 외의 타입 사용 불가능함
        System.out.println(value);

        // jdk7부터 타입추론을 통해 생성자쪽 타입은 생략가능하다.

        Box<String> strBox = new Box<String>(); // 다 스트링만 됨
        strBox.setValue("ㅋㅋㅋㅋㅋ");
//        strBox.setValue(123); // Stringdl 아닌 타입을 사용할 수 없음
        String value2 = strBox.getValue();
        System.out.println(value2);

        // 타입제한을 사용하지 않는다면,...

        Box box = new Box();
        box.setValue(true);
        box.setValue("ㅎㅎㅎㅎ");
        box.setValue(LocalDateTime.now());
        // 리터받은 값의 타입이 Objectㅇ미
        Object value3 = box.getValue();
//        value3.format() // 오브젝트 파일에는 포맷 접그 x
        LocalDateTime _value3 = (LocalDateTime)value3;
        System.out.println(_value3.format(DateTimeFormatter.BASIC_ISO_DATE));
    }
}
