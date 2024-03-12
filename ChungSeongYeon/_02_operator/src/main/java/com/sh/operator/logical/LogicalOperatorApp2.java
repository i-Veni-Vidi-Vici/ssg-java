package com.sh.operator.logical;

/**
 * <pre>
 * 논리연산자 진리표
 *
 * - and 연산자는 좌항이 false인 경우 우항 검사를 하지 않는다.
 *
 * - true && true -> true
 * - true && false -> false
 * - false && true -> false (우항 검사 안함)
 * - false && false -> false (우항 검사 안함)
 *
 * - or 연산자는 좌항이 true인 경우 우항 검사를 하지 않는다.
 * - true || true -> true (우항 검사 안함)
 * - true || false -> true (우항 검사 안함)
 * - false || true -> true
 * - false || false -> false
 *
 * </pre>
 */
public class LogicalOperatorApp2 {
    public static void main(String[] args){
        int num = 10;
//        System.out.println(false && num++ > 0); // (우항 검사 안함) F
//        System.out.println(num); // 10
        System.out.println(true && num++ > 0); // T
        System.out.println(num); // 11

        int k = 20;
//        System.out.println(true || k++ > 20); // (우항 검사 안함) T
//        System.out.println(k); // 20
        System.out.println(false || k++ > 20); // F
        System.out.println(k); // 21



    }
}
