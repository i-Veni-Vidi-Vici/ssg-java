package com.sh.api._04.wrapper;

import java.util.ArrayList;

/**
 * <pre>
 * Wrapper Class
 * - 기본형 값을 감싼 클래스
 * - 기본형이 아닌 참조형으로써 처리해야 하는 경우에 사용, 여러 상수/메소드를 제공
 *
 * - byte ->  Byte
 * - short -> Short
 * - int -> Integer
 * - long -> Long
 * - float -> Float
 * - double -> Double
 * - boolean -> Boolean
 * - char -> Character
 *
 * Boxing/Unboxing (Auto 자동으로 발생)
 * - boxing : 기본형 -> wrapper
 * - unboxing : wrapper -> 기본형
 * - 기본형과 wrapper 객체를 혼용해서 사용할 수 있음
 *
 * deprecated
 * - 더이상 사용하지 않는 기능. 향후 삭제 예정인 기능. 해당 기술은 새로운 기술로 대체되었다는 의미.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        int i = 20;
        Integer i2 = Integer.valueOf(20);
        System.out.println(i2);

        char ch = 'k';
        Character ch2 = Character.valueOf('k');
        System.out.println(ch2);

        // 기본형 - wrapper형 사이의 연산
        System.out.println(i == i2); // true -> 기본형과 참조형의 주소값이 다른데 아래와 같이 auto-unboxing 적용되어서 같다고 봄
        System.out.println(i == i2.intValue()); // true -> i2뒤에 intValue()를 안써도 자동으로 붙어서 그 안에 값을 꺼내서 값(기본형)으로 간주
        System.out.println(i + i2); // 40 -> auto-unboxing 적용
        System.out.println(i + i2.intValue());

        Integer i3 = 20; // auto-boxing 처리됨
//        Integer i3 = Integer.valueOf(20);
        System.out.println(i3);

        // wrapper 타입간의 연산 : 값이 같으면 동일하게 처리
        System.out.println(i2 == i3); // true -> 아래와 같이 작성하는 것과 똑같이 나옴 (i2.intValue() == i3.intValue())
        System.out.println(i2.equals(i3)); // true

        // wrapper 타입만 사용가능한 경우가 있음 - Generics
//        List<Integer> list = new ArrayList<Integer>();
//        List<int> list2 = new ArrayList<int>(); // 꺽새(Generics)에는 기본형 쓸 수 없음
    }
}
