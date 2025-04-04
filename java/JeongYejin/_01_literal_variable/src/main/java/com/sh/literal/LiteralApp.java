package com.sh.literal;

public class LiteralApp {
    /**
     * (asterisk)
     *
     * Literal(값)
     *
     * @param args
     */
    public static void main(String[] args) {
        // 1. 정수
        System.out.println(123);
        System.out.println(-123);

        // 2. 실수
        System.out.println(12.345);

        // 3. 논리값
        System.out.println(true);
        System.out.println(false);

        // 4. 문자(1개) - 홑따옴표로 감싸서 표현
        System.out.println('a');
//        System.out.println('ab'); // compile error! - 자바 문법
//        System.out.println(''); // 문자 0개 오류
        System.out.println('1'); // 문자 1개 표현 가능
        System.out.println(' '); //공백도 문자에 포함

        // 5. 문자열(0 ~ n개) - 쌍따옴표로 감싸서 처리
        System.out.println(""); // 빈 문자열 표현 가능
        System.out.println("안녕");
        System.out.println("a"); // 문자 1개 표현 가능
    }
}
