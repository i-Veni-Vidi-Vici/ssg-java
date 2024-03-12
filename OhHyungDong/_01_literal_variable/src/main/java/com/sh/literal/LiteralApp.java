package com.sh.literal;

public class LiteralApp {

    /**
     * (asterisk)
     *
     * Literal -> r값을 의미함
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(-123);
        System.out.println(123);
        System.out.println(12.345);
        System.out.println(true);
        System.out.println(false);

        // 문자 (1개) - 홀따옴표로 감싸서 표현
        System.out.println('a');
        // 문자 (0~n개) -> 문자열, 빈 문자열 표현 가능
        System.out.println("abc");
        System.out.println("");
        System.out.println("a");
        //컴파일 에러 발생 : 자바 문법을 제대로 작성하지 못한 경우 컴파일 에러 발생.
    }
}
