package com.sh.operator.logical;

/**
 * <pre>
 *     논리연산자 진리표
 *     - and 연산자는 좌항이 false인 경우, 우항 검사를 하지 않는다.
 *     - true && true -> true
 *     - true && false -> false
 *     - false && true -> false (우항 검사 안함)
 *     - false && false -> false (우항 검사 안함)
 *
 *     - or 연산자는 좌항이 true인 경우, 우항 검사를 하지 않는다.
 *     - true || true -> true (우항 검사 안함)
 *     - true || false -> true (우항 검사 안함)
 *     - false || true -> true
 *     - false || false -> false
 *
 * </pre>
 */
public class LogicalOperatorApp2 {
    public static void main(String[] args) {
        int num = 10;
//        System.out.println(true && num++ > 0);  // 좌항이 true이면서, num++ > 0이 true인지 10 > 0은 true, num은 11
        System.out.println(false && num++ > 0); // 우항 검사 안함, num은 10
        System.out.println(num);                // 10

        int k = 20;
//        System.out.println(true || k++ > 20);   // 우항 검사 안함, k는 20
        System.out.println(false || k++ > 20);   // k는 21
        System.out.println(k);


    }
}
