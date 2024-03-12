package com.sh.operator.logical;

public class LogicalOperatorApp2 {

    /**
     * <pre>
     * 논리연산자 진리표
     *
     * - and연산자는 좌항이 false인 경우 우항 검사를 하지 않는다.
     * - true && true -> true
     * - true && false -> false
     * - false && true -> false (우항 검사 안함)
     * - false && false -> false(우항 검사 안함)
     *
     * - or연산자는 좌항이 true인 경우 우항 검사를 하지 않는다.
     * - true || true -> true   (우항 검사 안함)
     * - true || false -> true  (우항 검사 안함)
     * - false || true -> true
     * - false || false -> false
     * </pre>
     * @param args
     */
    public static void main(String[] args) {
        int num = 10;
        System.out.println(false && num++ > 0);     // 우항 검사 안함
        System.out.println(num);                    // 따라서, 10

        int k = 20;
        System.out.println(true || k++ > 20);       // 우항 검사 안함
        System.out.println(k);                      // 따라서, 20
    }
}
