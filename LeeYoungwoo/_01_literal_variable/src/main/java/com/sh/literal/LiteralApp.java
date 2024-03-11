package com.sh.literal;

public class LiteralApp {
    /**
     * (asterisk)
     *
     * Literal (값)
     * @param args
     */
    public static void main(String[] args) {
        // 1. 정수
        System.out.println(123);
        System.out.println(-123);

        // 2. 실수
        System.out.println(12.345);

        // 3. 논리값 (참/거짓)
        System.out.println(true);
        System.out.println(false);

        // 4. 문자(1개) - 홑따옴표로 감싸서 표현('')
        System.out.println('a'); // sout -> 단축키
//        System.out.println('ab'); // compile error -> 자바문법을 제대로 작성하지 못한 경우(문자열인데 홑따옴표 사용함)
//        System.out.println(''); 문자가 0개이므로 오류
        System.out.println('1'); // 숫자여도 ''로 감싸져 있다면 문자로 처리
        System.out.println(' '); // 공백문자 1개는 가능

        // 5. 문자열(n개) - 쌍따옴표로 감싸서 처리
        System.out.println("안녕");
        System.out.println(""); // 빈 문자열 표현 가능
        System.out.println("b"); // 문자 1개도 표현 가능

    }
}
