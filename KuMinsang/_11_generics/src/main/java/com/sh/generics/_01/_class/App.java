package com.sh.generics._01._class;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <pre>
 *     Generics
 *     - 사전적의미는 일반화 이다
 *     - 자바에서 제네릭은 타입을 일반화한다는 의미이다. 실제로는 타입을 제한하는 용도로 사용한다
 *     -
 *     - 클래스 내부의 특정필드, 매개변수, 리턴타입등을 제한할 목적으로 사용한다
 *     - 제네릭클래스, 제네릭메소드에 타입을 의미하는 타입변수를 사용한다.
 *
 *     - 제네릭프로그래밍 : 데이터 형식에 의존하지 않고
 *     - 하나의 값이 여러타입을 가질수 있는 기술에 중점을 둠
 *     - 재사용성을 높이는 프로그래밍방식이다.
 *
 * </pre>
 */
public class App {
    public static void main(String[] args) {
       //제네릭클래스의 객체화
        Box<Integer> intBox = new Box<Integer>();
        intBox.setValue(123);
//        intBox.setValue("1234");  //Integer가 아니므로 compile 에러남
        System.out.println(intBox.getValue());  //Integer외의 타입을 반환할수 없다

        //jdk7부터 타입추론을 통해 생성자쪽 타입은 생략가능하다
        //Box<String> strBox = new Box();   //생성자의 타입 생략
        Box<String> strBox = new Box<String>();
        strBox.setValue("lollololo");
//        strBox.setValue(123); //string이 아닌 타입을 사용할수 없다
        String value2 = strBox.getValue();
        System.out.println(value2);

        //타입제한을 사용하지 않는다면...
        Box box= new Box(); //안써도 오류가 나지는 않는다
        box.setValue(true); //각종 데이터를 다 입력 가능
        box.setValue("abababab");
        box.setValue(LocalDateTime.now());

        //리턴받은 값의 타입이 Object이므로 다운캐스팅 이후 사용할 수 있다
        Object value3 = box.getValue();
        LocalDateTime _value3 = (LocalDateTime) value3;
        System.out.println(_value3.format(DateTimeFormatter.BASIC_ISO_DATE));

    }
}
