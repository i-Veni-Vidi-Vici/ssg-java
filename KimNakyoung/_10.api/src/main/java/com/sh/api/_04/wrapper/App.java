package com.sh.api._04.wrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Wrapper class
 * - 기본형 값을 감싼 클래스 wrap 감싸다
 * - 기본형이 아닌 참조형으로써 처리해야 하는 경우, 여러 상수/메소드를 제공
 *
 * - btye -> Btye 대문자 시작 왜냐? 참조형이니까
 * - short -> Short
 * - int -> Integer
 * - long -> Long
 * - float -> Float
 * - double -> Double
 * - boolean -> Boolean
 * - char -> Character
 *
 *
 * Auto Boxing / unboxing (용어만 알아두세요 코드 작성할 때는 그냥 자동임)
 * - boxing : 기본형 -> wrapper 타입으로 변경
 * - unboxing : wrapper -> 기본형으로 바꾸는거
 * - 기본형과 wrapper객체를 혼용해서 사용할 수 있다.
 *
 *
 * deprecated
 * - 더이상 사용하지 않는 기능. 향후 삭제 예정. 해당기술은 새로운 기술로 대체되었다는 의미
 * </pre>
 *
 *
 */


public class App {

    public static void main(String[] args) {
        int i = 20;
//        Integer i2 = new Integer(20); // 버전 9부터 ㄷ데프리케이드 됐어요 더이상 사용 x 새로운 기술로
        Integer i2 = Integer.valueOf(20);

        char ch = 'k';
        Character ch2 = Character.valueOf('k'); // 참조형.벨류오프();
        System.out.println(ch + ", " + ch2);

        // 기본형 -wrapp형 사이의 연산
        System.out.println( i == i2);// true 근데 i는 값이 들어있고 i2는 힙영역에 객체의 주솟값이 있는데 왜 같을까?
        // auto 언박싱이 적용되었음
        System.out.println( i == i2.intValue()); //true
        System.out.println(i + i2); // 40 // auto- unboxing이 적용
        System.out.println(i + i2.intValue()); // 40

        Integer i3 = 30; // auto-boxing 처리 되있음
//        Integer i3 = Integer.valueOf(30);
        System.out.println(i3); //


        //wrapper 타입간의 연산 - 값이 같으면 동일하게 처리된다.
        System.out.println(i2 == i3); // true
        System.out.println(i2.intValue() == i3.intValue()); // true
        System.out.println(i2.equals(i3)); // true

        //Wrapper타입만 사용가능한 경우가 있다. - Generics(타입체크) 할 때 기본형 쓰면 안됨!!
        List<Integer> list = new ArrayList<Integer>();
//        List<int> list2 = new ArrayList<int>();

    }
}
