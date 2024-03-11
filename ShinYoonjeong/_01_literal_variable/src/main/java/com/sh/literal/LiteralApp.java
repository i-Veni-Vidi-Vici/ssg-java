package com.sh.literal;

public class LiteralApp {
    /**
     * (asterisk)
     *
     * Literal (값)
     *
     * @param args
     */
    public static void main(String[] args) {
        //1. 정수
        System.out.println(123);
        System.out.println(-123);
        //2. 실수
        System.out.println(12.345);
        //3. 논리값 (참,거짓)
        System.out.println(true);
        System.out.println(false);
        //4. 문자(1개) - 홑 따옴표
        System.out.println('a');
        //5. 문자열(n개) - 쌍 따옴표
        System.out.println('1'); //숫자여도 ''로 감싸져 있다면 문자처리
        System.out.println("abc");
        //6. 문자열(0 ~ r개) - 쌍따옴표로 감싸서 처리
        System.out.println("안녕");
        System.out.println(""); // 빈 문자열 표현 가능
        System.out.println("a"); // 문자 1개 표현 가능


    }
}