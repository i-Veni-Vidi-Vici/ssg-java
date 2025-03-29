package com.sh.literal;

import java.util.Arrays;

public class LiteralApp {
    /**
     * Literal: integer(정수), float/double(실수), boolean(논리값), char(문자), String(문자열)
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(123123);
        System.out.println(1.23456);
        System.out.println(true);
        System.out.println(false);
        System.out.println('A');
        System.out.println("ABCD");
        //빈 문자는 컴파일 오류(불가)
        //빈 문자열은 가능
        System.out.println("");
        //한 문자도 가능(문자열)
        System.out.println("A");



    }
}
