package com.sh.operator.logical;

/**
 * <pre>
 * 논리연산자 진리표
 *
 * and 연산자는 좌항이 false인 경우 우항 검사를 하지 않음
 * - true && true -> true
 * - true && false -> false
 * - false && true -> false (우항 검사 X)
 * - false && false -> false (우항 검사 X)
 *
 * or 연산자는 좌항이 true인 경우 우항 검사를 하지 않음
 * - true || true -> true (우항 검사 X)
 * - true || false -> true (우항 검사 X)
 * - false || true -> true
 * - false || false -> false
 *
 * </pre>
 */
public class LogicalOperatorApp2 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(true && num++ > 0); // 다음줄에서 num=11
        System.out.println(false && num++ > 0); // 다음줄에서 num=10 우항검사 안함

        int k = 20;
        System.out.println(true || k++ > 20); // 다음줄에서 k=20 우항검사 안함
        System.out.println(false || k++ > 20); // 다음줄에서 k=21
    }
}
