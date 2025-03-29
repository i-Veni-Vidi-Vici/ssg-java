package com.sh.api._04.wrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *    Wrapper Class
 *    - 기본형 감싼 클래스
 *    - 기본형이 아닌 참조형으로써 처리해야 하는 경우, 여러 상수 / 메소드를 제공
 *
 *    - byte -> Byte
 *    - short -> Short
 *    - int ->  Integer
 *    - long -> Long
 *    - float -> Float
 *    - double -> Double
 *    - boolean -> Boolean
 *    - char -> Character
 *
 *   Auto Boxing / Unbxoing
 *    - boxing : 기본형 -> wrapper 타입으로
 *    - unboxing : wrapper -> 기본형
 *
 *
 *    deprecated
 *    - 더 이상 사용하지 않는 기능, 향후 삭제 에정 -> 해당 기술은 새로운 기술로 대체되었다는 의미.
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        int i = 20;
        Integer i2 = Integer.valueOf(20);

        System.out.println(i + "," +i2);
        char ch = 'k';
        Character ch2 = Character.valueOf('k');

        //기본형 - wrapper형 사이의 연산
        System.out.println(i == i2);//true -> auot - unboxing이 적용됨.
        System.out.println(i == i2.intValue());


        Integer i3 = 30;
        //Integer i3 = Integer.valueOf(30)
        System.out.println(i3);
        System.out.println(i2 == i3);

        //wrapper 타입 간의 연산 - 값이 같으면 동일하게 처리 된다.
        System.out.println(i2 == i3);
        System.out.println(i2.intValue() == i3.intValue());
        System.out.println(i2.equals(i3));

        //Wrapper 타입만 사용가능한 경우가 있다. - Generics
        List<Integer> list = new ArrayList<Integer>();
    }
}
