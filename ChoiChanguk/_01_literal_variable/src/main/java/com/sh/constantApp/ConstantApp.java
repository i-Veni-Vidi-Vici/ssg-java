package com.sh.constantApp;

/**
 * <pre>
 * 상수란
 *  - 변하지 않은 값을 보관하는 변수
 *  - 변경되어서는 안되는 값을 위해 사용한다. 수정불가하게 만든다
 *  - 파이와 같은 수학적 값들은 상수로 관리하고 있다.
 *  - 숫자기본형의 범위 상수로 관리하고 있다.
 *  - 선억 - 값대임 - 사용 동일하지만, 다시 값대임 할 수 없다.
 *  - 관례적으로 상수명은 대문자로 작성한다. 합성어인 경우 _로 연결한다.
 *  -
 * </pre>
 */
public class ConstantApp {
    public static void main(String[] args){
        //선언 final
        final int AGE;
        //값 대임
        AGE=20;
        System.out.println(AGE);
        int yourAge= AGE + 10;

        //초기화 가능
        final int value = 100;

        //합성어인 상수
        final double HUNAM_AVG_HEIGHT = 170.33;

        //jdk가 제공하는 상수
        System.out.println(Math.PI);
        System.out.println("byte  : "+Byte.MIN_VALUE+"---"+Byte.MAX_VALUE);
        System.out.println("short : "+Short.MIN_VALUE+"---"+Short.MAX_VALUE);
        System.out.println("int   : "+Integer.MIN_VALUE+"---"+Integer.MAX_VALUE);
        System.out.println("long  : "+Long.MIN_VALUE+"---"+Long.MAX_VALUE);
    }
}
