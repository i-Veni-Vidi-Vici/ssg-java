package com.sh.generics._01._class;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <pre>
 *  Generics
 *  - 사전적 의미는 일반화이다.
 *  - 자바에서 제네릭은 타입을 일반화한다는 의미, 타입을 제한하는 용도로 사용한다
 *
 *  - 클래스 내부의 특정 필드, 매개변수, 리턴타입 등을 제한할 목적으로 사용한다.
 *  - 제네릭 클래스, 제네릭 메소드에 타입을 의미한 타입 변수를 사용한다.
 *
 *  - 제네릭 프로그래밍은 데이터 형식에 의존하지 않고, 하나의 값이 여러 타입을 가질 수 있는 기술에 중점을 뒀다.
 *  - 재사용성을 높이는 프로그래밍 방식이다.
 *
 *  Box<T> : 여기서 T는 참조타입만 올 수 있고, 기본형은 올 수 없다.
 *  - 참조타입으로 올 수 있는 것 : 참조형 변수, 자신이 만든 클래스 이름
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        //제네릭 클래스 객체화
        Box<Integer> intBox = new Box<Integer>();
        intBox.setValue(123);
        Integer value = intBox.getValue(); //Integer가 아닌 타입은 사용할 수 없다.
//        intBox.setValue("123"); Integer가 아닌 타입은 사용할 수 없다 -> 타입 제한
        System.out.println(value);

        //Box.<K>of(K value)
        Box<Integer> box = Box.of(123);



        //jdk7부터 타입 추론을 통해 생성자쪽 타입은 생략 가능하다.
        Box<String> stringbox = new Box<String>();
        stringbox.setValue("안녕하세요 ");
        String value1 = stringbox.getValue();
//        stringbox.setValue(123); String이 아닌 타입은 사용할 수 없음.
        System.out.println(value1);


        //타입제한을 사용하지 않는다면 - 다양한 자료형이 올 수 있기 때문에 좋은 코드가 아님
        //메소드 호출시 모든 타입을 전달 할 수 있어 제어하기 힘들다.
        Box box = new Box();
        box.setValue(true);
        box.setValue("gg");
        box.setValue(LocalDateTime.now());
        //리턴 받은 값의 타입이 Object이므로 다운 캐스팅 이후 사용할 수 있다.
        Object value3 = box.getValue();
        LocalDateTime _value3 = (LocalDateTime) value3;
//        System.out.println(_value3.format());
    }

}
