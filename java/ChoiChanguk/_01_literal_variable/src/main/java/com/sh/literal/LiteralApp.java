package com.sh.literal;

public class LiteralApp {
    /**
     * (asterick)
     * Literal(값)
     * @param args
     */
    public static void main(String[] args)
    {   //1. 정수
        System.out.println(123456789);
        System.out.println(-23456789);
        //2. 실수
        System.out.println(12345.9);
        //3. 논리값
        System.out.println(true);
        System.out.println(false);
        //4. 문자= 문자 1개를 의미 = 홀따옴표로 감싸서 표현
        //''안에 아무것도 없어서 안됨, 숫자가 들어가면 문자다
        //'ab' 이건 문자열
        System.out.println('1');
        //5. 문자열 = 말그대로 문자열"0~n개" and '와 다르게 빈 문자열을 표시한다.
        System.out.println("이것은 문자열 0~n개를 씁니다");

    }
}
