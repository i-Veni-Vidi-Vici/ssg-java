package com.sh.literal;

/**
 * (asterisk)
 * Literal (값)
 *
 * @parm args
 */

// ctrl + / 하면 // 나옴

public class LiteralApp {
    public static void main(String[] args) {
        // 1. 정수
        System.out.println(123);
        System.out.println(-123);
        // 2. 실수
        System.out.println(12.345);
        // 3. 논리값(참/거짓)
        System.out.println(true);
        System.out.println(false);
        // 4. 문자(1개) - ''
        System.out.println('a');
//        System.out.println('ab'); // 문자인데 문자열이라서 x
//        System.out.println(''); // 문자 아무것도없으면 xx 오류
        System.out.println('1'); // 숫자여도 ''면 문자처리
        // 5. 문자열(0~n개) - ""
        System.out.println("안녕");
        System.out.println(""); // 빈문자열 표현 가능
        System.out.println("a"); // 문자 1개도 표현 가능


    }
}
