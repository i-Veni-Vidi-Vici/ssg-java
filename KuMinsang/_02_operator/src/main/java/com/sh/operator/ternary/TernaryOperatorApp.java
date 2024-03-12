package com.sh.operator.ternary;

/**
 * 삼항 연산자
 *
 */
public class TernaryOperatorApp {
    public static void main(String[] args) {
        int a = 30;
        int b = 20;
        System.out.println("a는 b보다 " + (a > b ? "크다" : "작다"));
        //a가 b보다 크다면 "크다" 문자열을 출열 작다면 "작다" 문자열을 출열

        // 양수/음수/0 여부 출력
        int x = 50;
        System.out.println("x는 "+ (x>0 ? "양수다" : "양수가 아니다."));

    }
}
