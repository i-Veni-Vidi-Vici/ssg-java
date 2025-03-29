package com.sh.constant;


/**
 * <pre>
 *     상수란
 * </pre>
 *
 */
public class constantApp {
    public static void main(String[] args) {
        //선언  final
        final int AGE;

        //값대입
        AGE = 20;
//        AGE = 21; //다시 값 대입할 수 없다.

        System.out.println(AGE);
        //피연산자로 사용할 수 있다.
        int yourAge = AGE + 3;

        //초기화
        final int VALUE = 123;

        //합성어인 상수
        final double HUMAN_HEIGHT = 158;

        //jdk가 제공하는 상수
        System.out.println(Math.PI);
        System.out.println("byte : " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
        System.out.println("short : " + Short.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
        System.out.println("int : " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
        System.out.println("long : " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);

    }
}
