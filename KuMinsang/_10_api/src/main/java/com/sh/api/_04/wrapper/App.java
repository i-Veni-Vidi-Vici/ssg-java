package com.sh.api._04.wrapper;

/**
 * <pre>
 *     Wrapper Class
 *     -기본형 값을 감싼 클래스
 *     - 기본형이 아닌 참조형으로써 처리해야 하는 경우 여러 상수/메소드 제공
 *     - byte -> Byte
 *     - short -> Short
 *     - int -> Integer
 *     - long -> Long
 *     - float -> Float
 *     - double -> Double
 *     - boolean -> Boolean
 *     - char -> Character
 *
 *     Boxing/Unboxing
 *     - boxing : 기본형 -> wrapper
 *     - unboxing : wrapper -> 기본형
 *     - 기본형과 wrapper 객체를 혼용해서 사용할수 있다
 *
 *     deprecated
 *     -더 이상 사용하지 않는 기능으로 향후 삭제 예정이며 해당 기술은 새로운 기술로 대체되었음을 의미
 * </pre>
 */

public class App {
    public static void main(String[] args) {
        int i = 20;
        //Integer i2 = new Integer(20);   // 'Integer(int)' is deprecated since version9...
        Integer i2 = Integer.valueOf(20 );

        char ch = 'k';
        Character ch2 = Character.valueOf('k');
        System.out.println(ch+ " , " +ch2);

        //기본형 - wrapp형 사이의 연산
        System.out.println(i== i2); //true --> auto-unboxing이 적용
        System.out.println(i==i2.intValue()); //true
        System.out.println(i + i2); //48

        Integer i3 = 30;    //auto-boxing 처리 되었음
//        Integer i3 = Integer.valueOf(30);
        System.out.println(i3);

        //wrapper 타입간의 연산 = 값이 같으면 동일하게 처리된다
        System.out.println(i2 == i3);//true
        System.out.println(i2.intValue() == i3.intValue());//true
        System.out.println(i2.equals(i3)); //true
        Integer num1 = 50;
        test1(num1);
        System.out.println(num1);



    }
    public static void test1(Integer num1){
        num1 = 100;
        System.out.println(num1);
    }
}
