package com.sh.operator.logical;

/**
 * <pre>
 * 논리연산자 진리표
 * - true && true -> true
 * - true && false -> false
 * - false && true -> false (우항 검사 안함)
 * - false && false -> false (우항 검사 안함)
 *
 * - true || true -> true (좌항 검사 안함)
 * - true || false -> true (좌항 검사 안함)
 * - false || true -> true
 * - false || false -> false
 * </pre>
 */
public class LogicalOperatorApp2 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(false && num++ > 0);
        System.out.println(num);

        System.out.println(true && false && num++ > 0);
        System.out.println(num);
    }
}
