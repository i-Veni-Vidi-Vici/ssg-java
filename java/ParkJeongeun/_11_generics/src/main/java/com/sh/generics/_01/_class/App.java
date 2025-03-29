package com.sh.generics._01._class;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <pre>
 * Generics
 * - 사전적 의미 : 일반화
 * - 자바에서 제네릭은 타입을 일반화한다는 의미, 타입을 제한하는 용도
 *
 * - 클래스 내부의 특정 필드, 매개변수, 리턴타입 등을 제한할 목적으로 사용
 * - 제네릭클래스, 제네릭메소드에 타입을 의미하는 타입변수를 사용
 *
 * - 제네릭 프로그래밍
 *   - 데이터 형식에 의존하지 않고 하나의 값이 여러 타입을 가질 수 있는 기술에 중점을 둠
 *   - 재사용성을 높이는 프로그래밍 방식
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        // 제네릭 클래스의 객체화
        Box<Integer> intbox = new Box<Integer>();
        intbox.setValue(123);
//        intbox.setValue("ㅋㅋㅋ"); // Integer가 아닌 타입은 사용불가
        Integer value = intbox.getValue(); // Integer외의 타입은 반환불가
        System.out.println(value);

        // jdk7부터 타입추론을 통해 생성자쪽 타입은 생략가능
//        Box<String> strbox = new Box<String>(); // 원래
        Box<String> strbox = new Box<>(); // 생략 버전
        strbox.setValue("ㅋㅋㅋ");
//        strbox.setValue(123); // String이 아닌 타입은 사용불가
        String value1 = strbox.getValue();
        System.out.println(value1);

        // 타입제한을 사용하지 않으면
        Box box = new Box();
        // 메소드 호출시 모든 타입을 전달할 수 있어 제어하기 힘듦
        box.setValue(true);
        box.setValue("ㅎㅎㅎ");
        box.setValue(LocalDateTime.now());
        //리턴받은 값의 타입이 Object이므로 다운캐스팅 이후 사용 가능
        Object value2 = box.getValue();
        LocalDateTime _value3 = (LocalDateTime) value2;
        System.out.println(_value3.format(DateTimeFormatter.BASIC_ISO_DATE));
    }
}
