package com.sh.literal;

public class literalApp {
    /**
     * asterisk
     * Literal (값)
     *
     * @param args
     */
    public static void main(String[] args){
        // 1. 정수
        System.out.println(123);
        System.out.println(-123);
        // 2. 실수
        System.out.println(12.3);
        // 3. 논리값(ture/false)
        System.out.println(true);
        System.out.println(false);
        // 4. 문자
        System.out.println('a');
        /*System.out.println('abc'); character가 아니라 문자열이라 오류*/
        // 5. 문자열(0~n개의 문자)
        System.out.println("abcd");
        System.out.println("");
        System.out.println("바로 윗줄에 빈문자열 테스트 했음");

    }
}
