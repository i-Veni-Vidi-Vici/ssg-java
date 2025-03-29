package com.sh.literal;

public class LiteralApp {

    /**(asterisk 2개)
     *
     * Literal 값자체
     *
     *
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
        // 4. 문자(1개) - 홑따옴표로 감싸서 표현
        System.out.println('a');
        // System.out.println('ab'); ab는 문자열이므로 홑따옴표로 감싸려고 한다면 compile error 발생
        // - 자바 문법을 제대로 작성하지 못한 경우
        // System.out.println(''); 문자 0개는 오류
        System.out.println('1'); // 정수 숫자가 아닌 문자
        // 숫자여도 ''로 감싸져 있다면 문자로 처리
        // 5. 문자열(n개)
        System.out.println("안녕");
        System.out.println(""); // 빈 문자열도 표현 가능, 문자 0개와 달리
        System.out.println("a"); // 문자 갯수가 1개라도, ""로 둘러싸면 문자열로 취급

    }
}
