package com.sh.api._04_wrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper Class
 * - 기본형 값을 감싸기 클래스
 * - 기본형이 아닌 참조형으로써 처리해야 하는 경우. 여러 상수 / 메소드를 제공
 *
 * byte -> Byte
 * short -> Short
 * int -> Integer
 * long -> Long
 * float -> Float
 * double -> Double
 * boolean -> Boolean
 * chara -> Character
 *
 * BOxing/Unboxing
 * -boxing : 기본형 -> wrapper
 * -unboxing : wrappper -> 기본형
 * 기본형과 wapper 객체를 혼용 사용 가능
 *
 *
 * deprecated
 * - 더이상 사용하지 않는 기능. 향 후 삭제 예정. 해당기술은 새로운 기술로 대체 됬다는 의미.
 *
 **
 * xxx
 */
public class App {
    public static void main(String[] args) {
        int i = 20;
        Integer i2 = Integer.valueOf(20);
        System.out.println(i + ", " + i2);

        char ch = 'k';
        Character ch2 = Character.valueOf('k');
        System.out.println(ch + " , " + ch2);

        //기본형 - wrapp형 사이의 연산
        System.out.println(i == i2); //true -> auto-unboxing이 적용 됨.

        System.out.println(i == i2.intValue()); //true
        System.out.println(i + i2); //기본형과 참조형의 연산
        System.out.println(i + i2.intValue()); // -> auto- unboxing이 적용 됨


        Integer i3 = 20;
        System.out.println(i3);

        System.out.println(i2 == i3 );
        System.out.println(i2.intValue() == i3.intValue());
        System.out.println(i2.equals(i3));

        //Wrapper 타입만 사용간으한 경우가 있음 - Generics
        List<Integer> list = new ArrayList<Integer>(); //참조형만 사용 가능함
        // Lixt<int> 는 불가능함
    }
}