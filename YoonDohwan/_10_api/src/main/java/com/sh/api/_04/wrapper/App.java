package com.sh.api._04.wrapper;



/**
 * wrapper class
 * 기본형 값을 감싼 클래스
 * 기본형이 아닌 참조형으로써 처리해야 하는 경우, 여러 상수/메소드를 제공
 * byte->Byte
 * short -> Short
 * int - Integer
 * long Long
 * float Float
 * double Double
 * boolean Boolean
 * char Character
 *
 *
 * Boxing/Unboxing
 * -boxing : 기본형 -> wrapper
 * unboxing : wrapper -> 기본형
 * - 기본형과 wrapper객체를 혼용해서 사용할 수 있다.
 *
 * deprecated
 * -더이상 사용하지 않는 기능. 향후 삭제예정. 해당기술은 새로운 기술로 대체되었다는 의미.
 *
 *
 *
 *
 */
public class App {
    public static void main(String[] args) {
        int i = 20;
        Integer i2 = Integer.valueOf(20);
        System.out.println(i+" , " +i2);

        char ch='k';
        Character ch2 = Character.valueOf('k');
        System.out.println(ch+", " +ch2);

        //기본형 -wrapp형 사이의 현산
        System.out.println(i==i2);//true->auto-unboxing 이 적용되었음.
        System.out.println(i==i2.intValue());
        System.out.println(i+i2);
        System.out.println(i+i2.intValue());

        Integer i3=30;
        System.out.println(i3);


    }
}
