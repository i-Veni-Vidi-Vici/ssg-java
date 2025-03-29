package com.sh.constant;

import com.sh.Main;

/**
 * 상수란
 * - 변하지 않는 값을 보관하는 변수
 * - 변경되어서는 안되는 데이터를 표현할때 사용한다 -> 수정불가
 * - 파이와 같은 수학적 값들은 상수로 관리하고 있다
 * - 숫자의 기본형의 범위 상수를 관리하고 있다
 * - 선언 - 값 대입 - 사용 동일 하지만, 다시 값 대입을 할 수 있다.
 * - 관례적으로 상수명은 대문자로 작성한다. 합성어일 경우 _로 연결한다.
 *
 */


public class ConstantApp {
    public static void main(String[] args) {
        //선언 final
        final int AGE;
        //값 대입
        AGE = 20;
        //AGE = 21; //재대입으로 인해 에러가 발생한다
        System.out.println(AGE);
        //피연산자로 사용할 수 있다.
        int yourAge = AGE +3;

        final int VALUE = 123; //선언과 동시에 초기화

        //합성어인 상수
        final double HUMAN_AVG_HEIGHT = 176.1;

        //jdk가 제공하는 상수
        System.out.println(Math.PI);
        System.out.println("Byte size = "+Byte.SIZE);
        System.out.println("Byte = "+Byte.MIN_VALUE+ " ~ "+Byte.MAX_VALUE);
        System.out.println("integer size = "+Integer.SIZE);
        System.out.println("short size = "+Short.SIZE);

    }
}
