package com.sh.constant;

/**
 * <h3>상수</h3>
 * <pre>
 *     - 변하지 않는 값을 보관하는 변수
 *     - 변경되어서는 안되는 값을 위해 사용한다. ( 수정 x )
 *     - Ex) pi = 3.141592....
 *     - 숫자 기본형의 범위 상수로 관리하고 있다.
 *
 *     - 선언 -> 값 대입 -> 사용 으로 동일하지만, 다시 값 대입을 할 수 없다.
 *     - 관례적으로 상수명은 대문자로 작성한다.
 *     - 합성어인 경우 _로 연결한다.
 * </pre>
 */
public class ConstantApp {
    public static void main(String[] args){
        // 선언 final
        final int AGE;
        // 값 대입
        AGE = 20;
//        AGE = 21; // 다시 값 대입을 하려고하면 오류가 발생한다.
        // 피연산자로 사용할 수 있다.
        int yourAge = AGE + 3;

        // 초기화
        final int VALUE = 123;

        // 합성어인 상수
        final double HUMAN_HEIGHT = 170.5; // 합성어인 경우 _로 연결한다.

        // jdk가 제공하는 상수
        System.out.println("PI : " + Math.PI); // PI
        System.out.println("byte : " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
        System.out.println("int : " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
        System.out.println("short : " + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
        System.out.println("long : " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);

    }
}