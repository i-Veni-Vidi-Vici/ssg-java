package com.sh.constant;

import com.sh.Main;

/**
 *  <pre>
 *      상수란
 * - 변하지않는 값을 보관
 * - 변경 불가
 * - 파이와 같은 수학적 값
 * - 숫자 기본형 범위 상수로 보관
 * - 대문자와 _ 로 작성
 *  </pre>
 */
public class ConstantApp {

    public static void main(String[] args) {

        final int AGE;
        AGE = 20;
//     AGE = 21;

        System.out.println(AGE);
        int yourAge = AGE + 3;

        // 초기화
        final int VALUE = 123;

        // 합성어인 상수
        final double HUMAN_AVG_HEIGHT = 170.2342;

        // jdk가 제공하는 상수

        System.out.println(Math.PI);
        System.out.println("byte : " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
        System.out.println("short : " + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);

    }
}
