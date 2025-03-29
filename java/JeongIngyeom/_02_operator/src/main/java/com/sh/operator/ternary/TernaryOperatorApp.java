package com.sh.operator.ternary;

public class TernaryOperatorApp {

    /**
     * <pre>
     * 삼항연산자
     * - 조건식 ? 참일 때 값 : 거짓일 때 값
     * - 조건식에는 논리값 또는 논리값을 반환하는 연산식을 작성해야 한다.
     * </pre>
     * @param args
     */
    public static void main(String[] args) {
        int a = 20;
        int b = 30;
        System.out.println(a > b ? "크다" : "작다");

        // 양수/음수/0 여부 출력
        int x = -50;
        System.out.println(x > 0 ? "양수" : (x == 0 ? "0이다" : "음수다"));

        //삼항연산자 결과값을 대입
        int k = 20;
        int m = 35;
        int max = k > m ? k : m;
        System.out.println(max);
    }
}
