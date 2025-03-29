package com.sh.api._04.wrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Wrapper Class
 * - 기본형 값을 감싼 클래스
 * - 기본형이 아닌 참조형으로써 처리해야 하는 경우. 여러 상수/메소드를 제공.
 *
 * - byte -> Byte
 * - short -> Short
 * - int -> Integer
 * - long -> Long
 * - float -> Float
 * - double -> Double
 * - boolean -> Boolean
 * - char -> Character
 *
 * Boxing/Unboxing
 * - boxing : 기본형 -> wrapper
 * - unboxing : wrapper -> 기본형
 * - 기본형과 wrapper 객체를 혼용해서 사용할 수 있다.
 *
 * deprecated
 * - 더이상 사용하지 않는 기능. 향후 삭제 예정. 해당 기술은 새로운 기술로 대체되었다는 의미.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        int i = 20;
        Integer i2 = Integer.valueOf(20);
        System.out.println();

        char ch = 'k';
        Character ch2 = Character.valueOf('k');
        System.out.println(ch + ", " + ch2);

        // 기본형 - wrapper형 사이의 연산
        System.out.println(i==i2); // true -> auto-unboxing이 적용되었음.
        System.out.println(i==i2.intValue()); // true
        System.out.println(i+i2); // 40 -> auto-unboxing이 적용되었음.
        System.out.println(i+i2.intValue()); // 40
        Integer i3 =30; // auto-boxing 처리 되었음.
        System.out.println(i3);

        // wrapper타입간의 연산 - 값이 같으면 동일하게 처리된다.
        System.out.println(i2==i3); // true
        System.out.println(i2.intValue() == i3.intValue()); // true
        System.out.println(i2.equals(i3)); // true

        // Wrapper 타입만 사용 가능한 경우가 있다. - Generics
        List<Integer> list = new ArrayList<>();
        // List<int> list2 = new ArrayList<int>();
    }
}
