package com.sh.generics._01._class;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <pre>
 *  Generics
 *  - 사전적 의미는 일반화
 *  - 자바에서 제네릭은 타입을 일반화한다는 의미이므로, 타입을 제한하는 용도로 사용
 *
 *  - 클래스 내부의 특정 필드, 매개변수, 리턴타입 등을 제한할 목적으로 사용함
 *  - 제네릭 클래스, 제네릭 메소드에 타입을 의미하는 타입 변수를 사용함
 *
 *  - 제네릭 프로그래밍은 데이터 형식에 의존하지 않고, 하나의 값이 여러 타입을 가질 수 있는 기술에 중점을 둠 → 재사용성을 높이는 프로그래밍 방식
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //제네릭 클래스의 객체화
        Box<Integer> intBox = new Box<Integer>(); //객체를 만드는 순간 타입이 결정됨
        intBox.setValue(123);
//        intBox.setValue("ㅋㅋㅋ"); // Integer가 아닌 타입은 사용할 수 없음 - 컴파일 오류
        Integer value = intBox.getValue(); //Integer 외의 타입을 반환할 수 없음
        System.out.println(value);

        //jdk7부터 타입 추론을 통해 생성자쪽 타입은 생략 가능함
//        Box<String> strBox = new Box<String>(); //String만 사용할 수 있는 박스
        Box<String> strBox = new Box<>(); //String만 사용할 수 있는 박스

        strBox.setValue("ㅋㅋㅋ");
//        strBox.setValue(123); //String이 아닌 타입을 사용할 수 없음
        String value2 = strBox.getValue();
        System.out.println(value2);

        //타입 제한을 사용하지 않는다면,
        Box box = new Box();
        //메소드 호출시 모든 타 입을 전달할 수 있어 제어하기 힘듦
        box.setValue(true);
        box.setValue("ㅎㅎㅎㅎ");
        box.setValue(LocalDateTime.now());
        //리턴 받은 값의 타입이 Objcet이므로 다운 캐스팅 이후 사용할 수 있다.
        Object value3 = box.getValue();
        LocalDateTime _value3 = (LocalDateTime) value3;
        System.out.println(_value3.format(DateTimeFormatter.BASIC_ISO_DATE));
    }
}
