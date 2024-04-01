package com.sh.api._04.wrapper;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * <pre>
 * Wrapper Class
 * - 감싸기 클래스, 기본형 값을 감싼 클래스
 * - 기본형이 아닌 참조형으로써 처리해야 하는 경우, 여서 상수/메소들을 제공,
 *
 * - byte -> BYTE
 * - short -> SHORT
 * - int -> Integer 주의
 * - long -> LONG
 * - float -> Float
 * - double -> Double
 * - boolean -> Boolean
 * - char -> Character 주의
 *
 * Auto Boxing / Unboxing
 * - boxing : 기본형 -> wrapper
 * - unboxing : wrapper -> 기본형
 * - 기본형과 wrapper 객체를 혼용해서 사용할 수 있다.
 *
 * deprecated
 * - 더 이상 사용하지 않는 기능. 향후 삭제 예정인 기능. 해당기술은 새로운 기술로 대체되었다는 의미
 * </pre>
 */
public class App {
    public static void main(String[] args) {
        int i=20;
        //작동은 되지만 오류라고 뜬다
        //Integer i2 = new Integer(20); //nteger(int)' is deprecated since version 9 and marked for remova
        Integer i2=Integer.valueOf(20);

        char ch = 'k';
        Character ch2 = Character.valueOf('k');
        System.out.println("Integer : "+i2 + " Character : "+ch2);

        System.out.println(i==i2);// true -> auto-unboxing이 적용되었음.
        System.out.println(i==i2.intValue());//true
        System.out.println(i+i2);//40 -> auto-unboxing이 적용되었음
        System.out.println(i+i2.intValue());//true

        Integer i3=20; // auto-boxing 처리 되었음
        //Integer i3=Integer.valueOf(30);
        System.out.println(i3);

        //wrapper타입간의 연산 값이 같으면 동일하다고 판단
        System.out.println(i2==i3);//true
        System.out.println(i2.intValue()==i3.intValue());//이렇게 처리 했다고 봐야 한다
        System.out.println(i2.equals(i3));

        //wrapper 타입만 사용가능한 경우가 있다.
        List<Integer> list=new ArrayList<Integer>(); //<>안에는 참조형만 들어간다 ex)객체, String같은
        List<String> list1=new ArrayList<String >();// String이니 에러가 없다
    }
}
