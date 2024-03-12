package com.sh.operator.ternary;

/**
 * <pre>
 * 삼항연산자
 * - 조건식 ? 참일때 값 : 거짓일때 값
 * - 조건식에는 논리값 또는 논리값을 반환하는 연산식을 작성해야 한다.
 * </pre>
 */
public class TernaryOperatorApp {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("a는 b보다 " + (a > b ? "크다" : "작다"));

        // 양수/음수/0 여부 출력
        int x = -50;
//        System.out.println("x는 " + (x > 0 ? "양수다" : "양수가 아니다"));
        System.out.println("x는 " + (x > 0 ? "양수다" : (x == 0 ? "0이다" : "음수다") )); // 중첩해서 사용가능

        // 삼항연산자 결과값을 대입
        int k = 40;
        int m = 35;
        int max = (k > m) ? k : m;
        System.out.println(max);

    }
}
