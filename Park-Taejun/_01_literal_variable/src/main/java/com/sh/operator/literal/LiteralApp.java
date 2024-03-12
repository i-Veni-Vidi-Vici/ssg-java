package com.sh.operator.literal;

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
        System.out.println(123456789);
        System.out.println(-12);
        // 2. 실수
        System.out.println(12.445);
        // 3. 논리값 (참/거짓)
        System.out.println(true);
        System.out.println(false);
        // 4. 문자(1개)
        System.out.println('a');
        System.out.println("abab");
        // 5. 문자열(0 ~ n개) - 쌍따옴표로 감싸서 처리
        System.out.println("안녕");
        System.out.println(""); // 빈 문자열 표현 가능
        System.out.println("a"); // 문자 1개 표현 가능
    }
}
