package com.sh.literal;

public class LiteralApp {
    /**
     * (asterisk)
     *
     * Literal(값)
     *
     * @param args
     */
    public static void main(String[] args){
        //1. 정수
        System.out.println(123);
        System.out.println(-123);

        //2. 실수
        System.out.println(12.345);

        //3. 논리값(참/거짓)
        System.out.println(true);
        System.out.println(false);

        //4. 문자 - '홑따옴표'
        System.out.println('A');
        //System.out.println('ab'); - compile error - 자바 문법 오류
        //System.out.println(''); - 문자 0개 오류
        //5. 문자열 - "쌍따옴표"
        System.out.println("ABC");
        System.out.println(""); //빈 문자열 표현 가능
    }
}
