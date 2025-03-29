package com.sh.literal;

public class LiteralApp {
    /**
     * (asterisk)
     *
     * Literal(값)
     * */
    public static void main(String[] args){
        //1.정수
        System.out.println(123);
        System.out.println(-123);
        //2.실수
        System.out.println(12.345);
        //3.논리값 (참/거짓)
        System.out.println(true);
        System.out.println(false);
        //4.문자(1개) - 홑따옴표로 감싸서 표현
        System.out.println('a');
//        System.out.println('ab'); // compile error - Java 문법을 제대로 작성하지 못한 경우
//        System.out.println(''); // 문자 0개 오류
//        System.out.println('1'); // 숫자여도 '' 로 감싸져 있다면 문자로 처리
        System.out.println(' '); //하나의 공백도 가능

        //5.문자열(0~n개) - 쌍따옴표로 감싸서 처리
        System.out.println("안녕");
        System.out.println(""); // 빈 문자열 표현 가능
        System.out.println("a"); // 문자 1개도 표현 가능


    }
}
